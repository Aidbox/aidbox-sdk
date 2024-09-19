(ns aidbox-sdk.generator.dotnet
  (:require
   [aidbox-sdk.generator :as generator]
   [aidbox-sdk.generator.helpers :refer [->pascal-case uppercase-first-letter]]
   [aidbox-sdk.generator.utils :as u]
   [clojure.java.io :as io]
   [clojure.string :as str])
  (:import
   [aidbox_sdk.generator CodeGenerator]))

(defn polymorphic-element->property [element]
  (str "public object?"
       " "
       (uppercase-first-letter (:name element))
       (->> (str
             "\n"
             "{"
             "\n"
             u/indent
             "get"
             "\n"
             u/indent
             "{\n"
             (->> (:choices element)
                  (map (fn [choice]
                         (str (u/x2 u/indent)
                              "if (" (->pascal-case (:name choice)) " is not null)\n"
                              (u/x2 u/indent)
                              "{"
                              "\n"
                              (u/x2 u/indent)
                              u/indent
                              "return " (->pascal-case (:name choice)) ";"
                              "\n"
                              (u/x2 u/indent)
                              "}")))
                  (str/join "\n\n"))
             "\n\n"
             (u/x2 u/indent)
             "return null;"
             "\n"
             u/indent
             "}"
             "\n"
             "\n"
             u/indent
             "set"
             "\n"
             u/indent
             "{"
             "\n"
             (->> (:choices element)
                  (map (fn [choice]
                         (str (u/x2 u/indent)
                              "if (value?.GetType() == typeof(" (:value choice) "))\n"
                              (u/x2 u/indent)
                              "{"
                              "\n"
                              u/indent
                              (u/x2 u/indent)
                              (->pascal-case (:name choice)) " = (" (:value choice) ")value;"
                              "\n"
                              (u/x3 u/indent)
                              "return;"
                              "\n"
                              (u/x2 u/indent)
                              "}")))
                  (str/join "\n\n"))
             "\n\n"
             (u/x2 u/indent)
             "throw new ArgumentException(\"Invalid type provided\");"
             "\n"
             u/indent
             "}"
             "\n"
             "}")
            ((fn [s] (str/split s #"\n")))
            (map #(str u/indent %))
            (str/join "\n"))))

(defn url->resource-name [url]
  (last (str/split (str url) #"/")))

(defn generate-property
  "Generates class property from schema element."
  [element]
  (let [name (uppercase-first-letter (:name element))
        type (str
              ;; TODO this is not enough
              ;; In order to properly put "new" modifier we must know if
              ;; there is a same property in ancestor classes
              (when (:meta element)
                "new ")
              (when (and (:required element)
                         (not (:meta element))) "required ")
              (or (:value element) (:type element))
              (:generic element)
              (when (:array element) "[]")
              (when (and (not (:required element))
                         (not (:literal element))) "?"))
        accessor (if (or (:meta element)
                         (:codeable-concept-pattern element))
                   "{ get; }"
                   "{ get; set; }")]
    (if (contains? element :choices)
      (polymorphic-element->property element)
      (str "public " type " " name " " accessor
           (when (and (:required element)
                      (:codeable-concept-pattern element)) " = new()")
           (:meta element)))))

(defn class-name
  "Generate class name from schema url."
  [url]
  (let [n (uppercase-first-letter
           (url->resource-name url))]
    (cond
      (= n "Expression")  "ResourceExpression"
      (= n "Reference")   "ResourceReference"
      :else n)))

(defn generate-class [schema & [inner-classes]]
  (let [base-class (url->resource-name (:base schema))
        schema-name (or (:url schema) (:name schema))
        generic (when (= (:type schema) "Bundle") "<T>")
        class-name' (class-name (str schema-name generic))
        elements (->> (:elements schema)
                      (map #(if (and (= (:base %) "Bundle_Entry")
                                     (= (:name %) "resource"))
                              (assoc % :value "T")
                              %)))

        properties (->> elements
                        (map generate-property)
                        (map u/add-indent)
                        (str/join "\n"))

        base-class (cond (= base-class "Resource") "Base.Resource"
                         (= base-class "DomainResource") "DomainResource, IResource"
                         :else base-class)
        base-class-name (when-not (str/blank? base-class)
                          (str " : " (uppercase-first-letter base-class)))]

    (str "public class " class-name' base-class-name "\n{"
         (when-not (str/blank? properties)
           "\n")
         properties
         (when (and inner-classes
                    (seq inner-classes))
           "\n\n")
         (str/join "\n\n" (map #(->> % str/split-lines (map u/add-indent) (str/join "\n")) inner-classes))
         "\n}")))

(defn generate-module
  [& {name' :name
      :keys [deps classes interfaces structs enums delegates]
      :or {classes []
           interfaces []
           structs []
           enums []
           delegates []}}]
  (->> (conj []
             (if deps
               (apply u/using (map :module deps))
               [])
             (u/namespace name')
             classes
             interfaces
             structs
             enums
             delegates)
       (flatten)
       (str/join "\n\n")))

(defn package->directory
  "Generate directory name from package name.
  hl7.fhir.r4.core#4.0.1 -> hl7-fhir-r4-core"
  [x]
  (-> x
      (str/replace #"[\.#]" "-")))

(defn package->module-name
  "Convert package name to namespace.
  hl7.fhir.r4.core#4.0.1 -> Aidbox.FHIR.R4.Core"
  [x]
  (str "Aidbox.FHIR."
       (->> (-> x
                (str/replace #"hl7.fhir." "")
                (str/split #"\."))
            (map ->pascal-case)
            (str/join "."))))

;;
;; Constraints
;;

(defn generate-constraint-module [schema]
  (generate-module
   :name (package->module-name (:package schema))
   :deps [{:module "Aidbox.FHIR.Base" :members []}
          {:module "Aidbox.FHIR.Utils" :members []}]
   :classes (generate-class schema (map generate-class schema))))

;;
;; main
;;

(defn datatypes-file-path []
  (io/file "Base.cs"))

(defn resource-file-path [ir-schema]
  (io/file (package->directory (:package ir-schema))
           (str (:name ir-schema) ".cs")))

(defn constraint-file-path [ir-schema name]
  (io/file (package->directory (:package ir-schema))
           (str (->pascal-case (url->resource-name name)) ".cs")))

(defrecord DotNetCodeGenerator []
  CodeGenerator
  (generate-datatypes [_ ir-schemas]
    [{:path (datatypes-file-path)
      :content (generate-module
                :name "Aidbox.FHIR.Base"
                :classes (map (fn [ir-schema]
                                (generate-class ir-schema
                                                (map generate-class (:backbone-elements ir-schema))))
                              ir-schemas))}])

  (generate-resource-module [_ ir-schema]
    {:path (resource-file-path ir-schema)
     :content (generate-module
               :name (package->module-name (:package ir-schema))
               :deps [{:module "Aidbox.FHIR.Base" :members []}
                      {:module "Aidbox.FHIR.Utils" :members []}]
               :classes [(generate-class ir-schema
                                         (map generate-class (:backbone-elements ir-schema)))])})

  (generate-search-params [_ ir-schemas]
    (map (fn [ir-schema]
           {:path (io/file "search" (str (:name ir-schema) "SearchParameters.cs"))
            :content
            (generate-module
             :name "Aidbox.FHIR.Search"
             :classes (generate-class
                       {:name (str (:name ir-schema) "SearchParameters")
                        :base (when (:base ir-schema)
                                (str (:base ir-schema) "SearchParameters"))
                        :elements (map (fn [el] (update el :name ->pascal-case))
                                       (:elements ir-schema))}))})
         ir-schemas))

  (generate-constraints [_ constraint-ir-schemas]
    (mapv (fn [[name' schema]]
            {:path (constraint-file-path schema name')
             :content (generate-constraint-module
                       (assoc schema :url name'))})
          constraint-ir-schemas))

  (generate-sdk-files [_] (generator/prepare-sdk-files :dotnet)))

(def generator (->DotNetCodeGenerator))
