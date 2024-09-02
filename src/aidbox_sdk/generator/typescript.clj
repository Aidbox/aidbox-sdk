(ns aidbox-sdk.generator.typescript
  (:require
   [aidbox-sdk.generator.helpers :refer [uppercase-first-letter ->pascal-case]]
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
                        (map generate-property)
                        (remove nil?)
                        (map u/add-indent)
                        (str/join "\n"))]
    (str
     (when (seq inner-classes)
       (str (str/join "\n\n" inner-classes) "\n\n"))

     "export type " class-name' " = " base-class " & {\n"
     properties
     "\n};")))

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

(defn generate-backbone-classes
  "Generates classes from schema's backbone elements."
  [ir-schema]
  (->> (ir-schema :backbone-elements)
       (map #(assoc % :base "BackboneElement"))
       (map generate-class)))

(defrecord TypeScriptCodeGenerator []
  CodeGenerator
  (generate-datatypes [_ ir-schemas]
    [{:path (datatypes-file-path)
      :content (generate-module
                :deps []
                :classes (map (fn [ir-schema]
                                (generate-class ir-schema
                                                (generate-backbone-classes ir-schema)))
                              ir-schemas))}])
  (generate-resource-module [_ ir-schema]
    {:path (resource-file-path ir-schema)
     :content (generate-module
               {:deps [{:module "../datatypes" :members ["Address" "Attachment" "BackboneElement" "CodeableConcept" "ContactPoint" "HumanName" "Identifier" "Period" "Reference"]}]
                :classes [(generate-class ir-schema
                                          (generate-backbone-classes ir-schema))]})})

  (generate-search-params [_ ir-schemas] [])
  (generate-constraints [_ ir-schemas] [])
  (generate-sdk-files [this] []))

(def generator (->TypeScriptCodeGenerator))
