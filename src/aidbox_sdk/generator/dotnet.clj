(ns aidbox-sdk.generator.dotnet
  (:require
   [clojure.string :as str]
   [aidbox-sdk.generator.utils :as u]
   [aidbox-sdk.generator :as gen]
   [clojure.java.io :as io]
   [aidbox-sdk.generator.helpers :refer [->pascal-case uppercase-first-letter]]))

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

(defn url->resource-type [reference]
  (last (str/split (str reference) #"/")))

(defn generate-property
  "Generate class property from schema element."
  [element]
  (let [type (str
              ;; TODO this is not enough
              ;; In order to properly put "new" modifier we must know if
              ;; there is a same property in ancestor classes
              (when (:meta element)
                "new ")
              (when (and (:required element)
                         (not (:meta element))) "required ")
              (:value element)
              (:generic element)
              (when (:array element) "[]")
              (when (and (not (:required element))
                         (not (:literal element))) "?"))
        name     (uppercase-first-letter (:name element))
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
           (url->resource-type url))]
    (cond
      (= n "Expression")  "ResourceExpression"
      (= n "Reference")   "ResourceReference"
      :else n)))

(defn generate-class [schema & [inner-classes]]
  (let [base-class (url->resource-type (:base schema))
        schema-name (or (:url schema) (:name schema))
        generic (when (= (:type schema) "Bundle") "<T>")
        class-name' (class-name (str schema-name generic))
        elements (->> (:elements schema)
                      (map #(if (and (= (:base %) "Bundle_Entry")
                                     (= (:name %) "resource"))
                              (assoc % :value "T")
                              %)))

        properties (try (->> elements
                             (map generate-property)
                             (map u/add-indent)
                             (str/join "\n"))
                        (catch Exception _
                          (prn schema)))

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

(defmethod gen/generate-resource-module :dotnet [_ ir-schema]
  (let [file-name (str (:name ir-schema) ".cs")
        file-path (io/file (package->directory (:package ir-schema))
                           file-name)
        module (generate-module
                :name (package->module-name (:package ir-schema))
                :deps [{:module "Aidbox.FHIR.Base" :members []}
                       {:module "Aidbox.FHIR.Utils" :members []}]
                :classes [(generate-class ir-schema (->> (ir-schema :backbone-elements)
                                                         (map #(assoc % :base "BackboneElement"))
                                                         (map generate-class)))])]
    {:path file-path
     :content module}))
