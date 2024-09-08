(ns aidbox-sdk.generator.typescript
  (:require
   [aidbox-sdk.generator :as generator]
   [aidbox-sdk.generator.helpers :refer [->pascal-case uppercase-first-letter]]
   [aidbox-sdk.generator.utils :as u]
   [clojure.java.io :as io]
   [clojure.string :as str])
  (:import
   [aidbox_sdk.generator CodeGenerator]))

(defn package->directory
  "Generates directory name from package name.

  Example:
  hl7.fhir.r4.core -> hl7-fhir-r4-core"
  [x]
  (str/replace x #"[\.#]" "-"))

(defn url->resource-name [reference]
  (last (str/split (str reference) #"/")))

(defn datatypes-file-path []
  (io/file "datatypes.ts"))

(defn resource-file-path [ir-schema]
  (io/file (package->directory (:package ir-schema))
           (str (->pascal-case (:name ir-schema)) ".ts")))

(defn constraint-file-path [ir-schema name]
  (io/file (package->directory (:package ir-schema))
           (str (->pascal-case (url->resource-name name)) ".ts")))

(defn search-param-filepath [ir-schema]
  (io/file "search" (str (:name ir-schema) "SearchParameters.ts")))

(defn ->lang-type [fhir-type]
  (case fhir-type
    ;; Primitive Types
    "boolean"      "boolean"
    "instant"      "string"
    "time"         "string"
    "date"         "string"
    "dateTime"     "string"
    "decimal"      "number"

    "integer"      "number"
    "unsignedInt"  "number"
    "positiveInt"  "number"

    "integer64"    "number"
    "base64Binary" "string"

    "uri"          "string"
    "url"          "string"
    "canonical"    "string"
    "oid"          "string"
    "uuid"         "string"

    "string"       "string"
    "code"         "string"
    "markdown"     "string"
    "id"           "string"
    "xhtml"        "string"

    ;; hardcoded just in case
    "Meta"         "Meta"
    ;; else
    fhir-type))

(defn class-name
  "Generate class name from schema url."
  [url]
  (uppercase-first-letter (url->resource-name url)))

(defn generate-polymorphic-property [{:keys [name required choices]}]
  (let [type (->> choices
                  (map :type)
                  (map ->lang-type)
                  distinct
                  (str/join " | "))]
    (str name (when-not required "?") ": " type ";")))

(defn generate-property [{:keys [name array required type choices] :as element}]
  (if choices
    (generate-polymorphic-property element)
    (let [lang-type (->lang-type type)]
      (str name (when-not required "?") ": " lang-type (when array "[]") ";"))))

(defn generate-class
  "Generates TypeScript type from IR (intermediate representation) schema."
  [ir-schema & [inner-classes]]
  (let [base-class (url->resource-name (:base ir-schema))
        schema-name (or (:url ir-schema) (:name ir-schema))
        class-name' (class-name schema-name)
        properties (->> (:elements ir-schema)
                        (remove #(:choice-option %))
                        (map generate-property)
                        (remove nil?)
                        (map u/add-indent)
                        (str/join "\n"))]
    (str
     (when (seq inner-classes)
       (str (str/join "\n\n" inner-classes) "\n\n"))

     "export type " class-name' " = "
     (when-not (str/blank? base-class)
       (if (seq properties)
         (str base-class " & ")
         base-class))
     (when (seq properties) (str "{\n" properties "\n}"))
     ";")))

(defn generate-deps [deps]
  (->> deps
       (map (fn [{:keys [module members]}]
              (if (seq members)
                (str "import { " (str/join ", " members) " } from '" module "';")
                (str "import " module ";"))))
       (str/join "\n")))

(defn generate-module
  [& {:keys [deps classes]
      :or {classes []}}]
  (->> (conj []
             (generate-deps deps)
             classes)
       (flatten)
       (str/join "\n\n")))

(defrecord TypeScriptCodeGenerator []
  CodeGenerator
  (generate-datatypes [_ ir-schemas]
    [{:path (datatypes-file-path)
      :content (generate-module
                :deps []
                :classes (->> ir-schemas
                              (sort-by :base)
                              (map (fn [ir-schema]
                                     (generate-class ir-schema
                                                     (map generate-class (:backbone-elements ir-schema)))))))}])
  (generate-resource-module [_ ir-schema]
    {:path (resource-file-path ir-schema)
     :content (generate-module
               {:deps [{:module "../datatypes" :members (:deps ir-schema)}]
                :classes [(generate-class ir-schema
                                          (map generate-class (:backbone-elements ir-schema)))]})})

  (generate-search-params [_ ir-schemas] []
    (map (fn [ir-schema]
           {:path (search-param-filepath ir-schema)
            :content (generate-module
                      :deps []
                      :classes [(generate-class
                                 {:name (format "%sSearchParameters" (:name ir-schema))
                                  :base (when (:base ir-schema)
                                          (format "%sSearchParameters" (:base ir-schema)))
                                  :elements (:elements ir-schema)})])})
         ir-schemas))

  (generate-constraints [_ ir-schemas]
    (mapv (fn [[constraint-name schema]]
            {:path (constraint-file-path schema constraint-name)
             :content (generate-module
                       :deps [{:module "../datatypes" :members (:deps schema)}]
                       :classes (generate-class (assoc schema :url constraint-name)
                                                (map generate-class (:backbone-elements schema))))})
          ir-schemas))
  (generate-sdk-files [this] (generator/prepare-sdk-files :typescript)))

(def generator (->TypeScriptCodeGenerator))
