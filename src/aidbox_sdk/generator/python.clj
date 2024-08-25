(ns aidbox-sdk.generator.python
  (:require
   [aidbox-sdk.generator.helpers :refer [->pascal-case ->snake-case uppercase-first-letter]]
   [aidbox-sdk.generator.utils :as u]
   [clojure.java.io :as io]
   [clojure.string :as str])
  (:import
   [aidbox_sdk.generator CodeGenerator]))

(defn ->lang-type [fhir-type]
  (case fhir-type
    ;; Primitive Types
    "boolean"      "bool"
    "instant"      "str"
    "time"         "str"
    "date"         "str"
    "dateTime"     "str"
    "decimal"      "float"

    "integer"      "integer"
    "unsignedInt"  "integer"
    "positiveInt"  "integer"

    "integer64"    "integer"
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

(defn url->resource-name [reference]
  (last (str/split (str reference) #"/")))

(defn class-name
  "Generate class name from schema url."
  [url]
  (uppercase-first-letter (url->resource-name url)))

(defn generate-deps [deps]
  (->> deps
       (map (fn [{:keys [module members]}]
              (if (seq members)
                (str "from " module " import " (str/join ", " members))
                (str "import " module))))
       (str/join "\n")))

(defn package->directory
  "Generates directory name from package name.

  Example:
  hl7.fhir.r4.core -> hl7-fhir-r4-core"
  [x]
  (str/replace x #"[\.#]" "-"))

(defn resource-file-path [ir-schema]
  (io/file (package->directory (:package ir-schema))
           (str (->pascal-case (:name ir-schema)) ".py")))

(defn generate-polymorphic-property [element]
  "")

(defn generate-property
  "Generates class property from schema element."
  [element]
  (let [name (->snake-case (:name element))
        lang-type (->lang-type (:type element))
        type      (str
                   (cond
                     ;; required and array
                     (and (:required element)
                          (:array element))
                     (format "List[%s]" lang-type)

                     ;; not required and array
                     (and (not (:required element))
                          (:array element))
                     (format "Optional[List[%s]]" lang-type)

                     ;; required and not array
                     (and (:required element)
                          (not (:array element)))
                     lang-type

                     ;; not required and not array
                     (and (not (:required element))
                          (not (:array element)))
                     (format "Optional[%s]" lang-type)))

        default-value (cond
                        (not (:required element))
                        "None"

                        (and (:required element)
                             (:array element))
                        "[]"

                        :else nil)]

    (if (contains? element :choices)
      (generate-polymorphic-property element)
      (str name ": " type (when default-value (str " = " default-value))))))

(defn generate-class
  "Generates Python class from IR (intermediate representation) schema."
  [ir-schema & [inner-classes]]
  (let [base-class (url->resource-name (:base ir-schema))
        schema-name (or (:url ir-schema) (:name ir-schema))
        generic (when (= (:type ir-schema) "Bundle") "<T>")
        class-name' (class-name (str schema-name generic))
        elements (->> (:elements ir-schema)
                      (map #(if (and (= (:base %) "Bundle_Entry")
                                     (= (:name %) "resource"))
                              (assoc % :value "T")
                              %)))
        properties (->> elements
                        (sort-by :name)
                        (map generate-property)
                        (map u/add-indent)
                        (str/join "\n"))
        base-class-name (when-not (str/blank? base-class)
                          (uppercase-first-letter base-class))]
    (str
     (when (and inner-classes
                (seq inner-classes))
       (str
        (str/join "\n\n" inner-classes)
        "\n\n"))

     "class " class-name' "(" base-class-name "):"
     (when-not (str/blank? properties)
       "\n")
     properties
     )))

(defn generate-module
  [& {:keys [deps classes]
      :or {classes []}}]
  (->> (conj []
             (generate-deps deps)
             classes)
       (flatten)
       (str/join "\n")))

(defn generate-backbone-classes
  "Generates classes from schema's backbone elements."
  [ir-schema]
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
               :deps [{:module "pydantic" :members ["*"]}
                      {:module "typing" :members ["Optional" "List"]}
                      {:module "..base" :members ["*"]}]
               :classes [(generate-class ir-schema
                                         (generate-backbone-classes ir-schema))])})
  (generate-search-params [_ search-schemas fhir-schemas])
  (generate-constraints [_ _schemas all-schemas] "")
  (generate-sdk-files [this] ""))

(def generator (->PythonCodeGenerator))
