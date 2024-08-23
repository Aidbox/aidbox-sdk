(ns aidbox-sdk.generator.python
  (:require
   [aidbox-sdk.generator.helpers :refer [->pascal-case ->snake-case uppercase-first-letter]]
   [aidbox-sdk.generator.utils :as u]
   [clojure.java.io :as io]
   [clojure.string :as str])
  (:import
   [aidbox_sdk.generator CodeGenerator]))

(defn fhir-type->lang-type [fhir-type]
  (case fhir-type
    ;; Primitive Types
    "boolean"      "bool"
    "instant"      "str"
    "time"         "str"
    "date"         "str"
    "dateTime"     "str"
    "decimal"      "str"

    "integer"      "integer"
    "unsignedInt"  "integer"
    "positiveInt"  "integer"

    "integer64"    "str"
    "base64Binary" "str"

    "uri"          "str"
    "url"          "str"
    "canonical"    "str"
    "oid"          "str"
    "uuid"         "str"

    "string"       "str"
    "code"         "str"
    "markdown"     "str"
    "id"           "str"

    ;; else
    fhir-type))

(defn url->resource-type [reference]
  (last (str/split (str reference) #"/")))

(defn class-name
  "Generate class name from schema url."
  [url]
  (uppercase-first-letter (url->resource-type url)))

(defn generate-deps [deps]
  (->> deps
       (map (fn [{:keys [module members]}]
              (if (seq members)
                (str "from " module " import " (str/join ", " members))
                (str "import " module))))
       (str/join "\n")))

(defn package->directory
  "Generate directory name from package name.
  hl7.fhir.r4.core#4.0.1 -> hl7-fhir-r4-core"
  [x]
  (-> x
      (str/replace #"[\.#]" "-")))

(defn resource-file-path [ir-schema]
  (io/file (package->directory (:package ir-schema))
           (str (->pascal-case (:name ir-schema)) ".py")))

(defn generate-polymorphic-property [element]
  "")

(defn generate-property
  "Generate class property from schema element."
  [element]
  (let [type (str
              ()
              (fhir-type->lang-type
               (:original-type element))
              (when (:array element) "[]")
              (when (and (not (:required element))
                         (not (:literal element))) "?"))
        name     (->snake-case (:name element))]
    (if (contains? element :choices)
      (generate-polymorphic-property element)
      (str name ": " type (when-not (:required element) " = None")))))

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
        properties (->> elements
                        (map generate-property)
                        (map u/add-indent)
                        (str/join "\n"))
        base-class (cond
                     (= base-class "DomainResource") "DomainResource, IResource"
                     :else base-class)
        base-class-name (when-not (str/blank? base-class)
                          (uppercase-first-letter base-class))]

    (str "class " class-name' "(" base-class-name "):"
         (when-not (str/blank? properties)
           "\n")
         properties
         (when (and inner-classes
                    (seq inner-classes))
           "\n\n")
         (str/join "\n\n" (map #(->> % str/split-lines (map u/add-indent) (str/join "\n")) inner-classes))
         "\n}")))

(defn generate-module
  [& {:keys [deps classes]
      :or {classes []}}]
  (->> (conj []
             (generate-deps deps)
             classes)
       (flatten)
       (str/join "\n")))

(defn generate-backbone-classes [ir-schema]
  (->> (ir-schema :backbone-elements)
       (map #(assoc % :base "BackboneElement"))
       (map generate-class)))

(defrecord PythonCodeGenerator []
  CodeGenerator
  (generate-datatypes [_ ir-schemas]
    (let [file-name "__init__.py"
          file-path (io/file "base" file-name)
          module (generate-module
                  :name ""
                  :deps [{:module "..base" :members []}]
                  :classes [(map (fn [ir-schema]
                                   (generate-class ir-schema
                                                   (generate-backbone-classes ir-schema)))
                                 ir-schemas)])]

      [:path file-path
       :content module]))

  (generate-resource-module [_ ir-schema]
    {:path (resource-file-path ir-schema)
     :content (generate-module
               :deps [{:module "..base" :members ["*"]}]
               :classes [(generate-class ir-schema
                                         (generate-backbone-classes ir-schema))])})
  (generate-search-params [_ search-schemas fhir-schemas])
  (generate-constraints [_ _schemas all-schemas] "")
  (generate-sdk-files [this] ""))

(def generator (->PythonCodeGenerator))
