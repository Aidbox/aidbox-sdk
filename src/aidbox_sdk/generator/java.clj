(ns aidbox-sdk.generator.java
  (:require
   [aidbox-sdk.generator.helpers :refer [->pascal-case uppercase-first-letter]]
   [aidbox-sdk.generator.utils :as u]
   [clojure.java.io :as io]
   [clojure.string :as str])
  (:import
   [aidbox_sdk.generator CodeGenerator]))

(defn datatypes-file-path []
  (io/file "datatypes.java"))

(defn package->directory
  "Generates directory name from package name.

  Example:
  hl7.fhir.r4.core -> hl7-fhir-r4-core"
  [x]
  (str/replace x #"[\.#]" "-"))

(defn url->resource-name [reference]
  (last (str/split (str reference) #"/")))

(defn class-name
  "Generate class name from schema url."
  [url]
  (uppercase-first-letter (url->resource-name url)))

(defn resource-file-path [ir-schema]
  (io/file (package->directory (:package ir-schema))
           (str (->pascal-case (:name ir-schema)) ".java")))

(defn ->lang-type [fhir-type]
  (case fhir-type
    ;; Primitive Types
    "boolean"      "boolean"
    "instant"      "String"
    "time"         "String"
    "date"         "String"
    "dateTime"     "String"
    "decimal"      "float"

    "integer"      "int"
    "unsignedInt"  "int"
    "positiveInt"  "int"

    "integer64"    "int"
    "base64Binary" "String"

    "uri"          "String"
    "url"          "String"
    "canonical"    "String"
    "oid"          "String"
    "uuid"         "String"

    "string"       "String"
    "code"         "String"
    "markdown"     "String"
    "id"           "String"

    ;; hardcoded just in case
    "Meta"         "Meta"
    ;; else
    fhir-type))

(defn generate-accessor [{:keys [name array required type base]}]
  (let [lang-type (->lang-type type)]
    (str
     (str "public " lang-type " get" (uppercase-first-letter name) "() {\n"
          u/indent "return " name ";"
          "\n}")
     "\n\n"
     (str "public void set" (uppercase-first-letter name) "(" lang-type " " name ") {\n"
            "this." name " = " name ";"
          "\n}"))))

(defn generate-property [{:keys [name array required type base]}]
  (let [lang-type (->lang-type type)
        type (if array
               (format "List<%s>" lang-type)
               lang-type)]
    (str "private " type " " name ";")))

(defn generate-class [ir-schema & [inner-classes]]
  (let [base-class (url->resource-name (:base ir-schema))
        schema-name (or (:url ir-schema) (:name ir-schema))
        class-name' (class-name schema-name)
        properties (->> (:elements ir-schema)
                        (map generate-property)
                        (remove nil?)
                        (map u/add-indent)
                        (str/join "\n"))

        accessors (->> (:elements ir-schema)
                       (map generate-accessor)
                       (remove nil?)
                       (map u/add-indent)
                       (str/join "\n"))]
    (str "public class " class-name' " extends " base-class " {\n"
         (when (and inner-classes
                    (seq inner-classes))
           "\n")
         (str/join "\n\n" (map #(->> % str/split-lines (map u/add-indent) (str/join "\n")) inner-classes))
         (when (and inner-classes
                    (seq inner-classes))
           "\n")

         properties
         "\n"
         accessors
         "\n}")))

(defn generate-deps [deps]
  (->> deps
       (map (fn [{:keys [module members]}]
              (if (seq members)
                (str "import { " (str/join ", " members) " } from '" module "';")
                (str "import " module ";"))))
       (str/join "\n")))

(defn generate-module
  [& {name' :name
      :keys [deps classes interfaces structs enums delegates]
      :or {classes []
           interfaces []
           structs []
           enums []
           delegates []}}]
  (->> (conj []
             (str "package " name' ";")
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

(defrecord JavaCodeGenerator []
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
               {:name "aidbox.fhir.r4"
                :deps [{:module "aidbox.fhir.datatypes.*" :members []}
                       {:module "java.util.List" :members []}]
                :classes [(generate-class ir-schema
                                          (generate-backbone-classes ir-schema))]})})
  (generate-search-params [_ ir-schemas] [])
  (generate-constraints [_ ir-schemas] [])
  (generate-sdk-files [_ _] []))

(def generator (->JavaCodeGenerator))
