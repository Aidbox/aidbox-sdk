(ns aidbox-sdk.generator.python
  (:require
   [aidbox-sdk.generator :as generator]
   [aidbox-sdk.generator.helpers :refer [->pascal-case ->snake-case
                                         uppercase-first-letter]]
   [aidbox-sdk.generator.python.templates :as templates]
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
  nil)

(defn generate-property
  "Generates class property from schema element."
  [element]
  (let [name (->snake-case (:name element))
        lang-type (->lang-type (:type element))
        type      (cond
                    ;; required and array
                    (and (:required element)
                         (:array element))
                    (format "list[%s]" lang-type)

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
                    (format "Optional[%s]" lang-type))

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
        class-name' (class-name schema-name)
        elements (->> (:elements ir-schema)
                      (map #(if (and (= (:base %) "Bundle_Entry")
                                     (= (:name %) "resource"))
                              (assoc % :value "T")
                              %)))
        properties (->> elements
                        (sort-by :name)
                        (map generate-property)
                        (remove nil?)
                        (map u/add-indent)
                        (str/join "\n"))
        base-class-name (when-not (str/blank? base-class)
                          (uppercase-first-letter base-class))]
    (str
     (when (seq inner-classes)
       (str (str/join "\n\n" inner-classes) "\n\n"))

     "class " class-name' "(" base-class-name "):"
     (when-not (str/blank? properties)
       "\n")
     properties)))

(defn generate-module
  [& {:keys [deps classes]
      :or {classes []}}]
  (->> (conj []
             (generate-deps deps)
             classes)
       (flatten)
       (str/join "\n\n")))

(defn generate-backbone-classes
  "Generates classes from schema's backbone elements."
  [ir-schema]
  (->> (ir-schema :backbone-elements)
       (map #(assoc % :base "BackboneElement"))
       (map generate-class)))

;;
;; Search Params
;;

(defn search-param-class [class-name elements parent & [inner-classes]]
  (let [properties (->> elements
                        (map generate-property)
                        (map #(str u/indent %))
                        (str/join "\n"))
        base-class-name (uppercase-first-letter parent)]
    (str "class " class-name "(" base-class-name "):"
         (when-not (str/blank? properties)
           "\n")
         properties
         (when (and inner-classes
                    (seq inner-classes))
           "\n\n")
         (str/join "\n\n" inner-classes))))


(defrecord PythonCodeGenerator []
  CodeGenerator
  (generate-datatypes [_ ir-schemas]
    {:path (io/file "base" "__init__.py")
     :content (generate-module
               :deps [{:module "pydantic" :members ["*"]}
                      {:module "typing" :members ["Optional" "List"]}]
               :classes (map (fn [ir-schema]
                               (generate-class ir-schema
                                               (generate-backbone-classes ir-schema)))
                             ir-schemas))})

  (generate-resource-module [_ ir-schema]
    {:path (resource-file-path ir-schema)
     :content (generate-module
               :deps [{:module "pydantic" :members ["*"]}
                      {:module "typing" :members ["Optional" "List"]}
                      {:module "..base" :members ["*"]}]
               :classes [(generate-class ir-schema
                                         (generate-backbone-classes ir-schema))])})

  (generate-search-params [_ search-schemas fhir-schemas]
    (for [{:keys [name base elements]}
          (generator/search-parameters-structures search-schemas fhir-schemas)]
      {:path (io/file "search" (str name "SearchParameters.py"))
       :content
       (generate-module
        :deps [{:module "typing" :members ["Optional"]}]
        :classes (search-param-class
                  (str name "SearchParameters")
                  (map #(hash-map :type "string" :name %) elements)
                  (when base
                    (str base "SearchParameters"))))}))

  (generate-constraints [_ _schemas all-schemas] "")
  (generate-sdk-files [this] templates/files))

(def generator (->PythonCodeGenerator))
