(ns aidbox-sdk.generator.typescript
  (:require
   [aidbox-sdk.generator :as generator]
   [aidbox-sdk.generator.helpers :refer [->pascal-case uppercase-first-letter
                                         ->camel-case]]
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

(defn resource-name->class-name [rn]
  (->pascal-case rn))

(defn datatypes-file-path []
  (io/file "datatypes.ts"))

(defn resource-file-path [ir-schema]
  (io/file (package->directory (:package ir-schema))
           (str (->pascal-case (:resource-name ir-schema)) ".ts")))

(defn constraint-file-path [ir-schema name]
  (io/file (package->directory (:package ir-schema))
           (str (->pascal-case (:resource-name ir-schema)) ".ts")))

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
  "Generate class name from schema resource name."
  [resource-name]
  (->pascal-case resource-name))

(defn generate-polymorphic-property [{:keys [name required choices]}]
  (let [type (->> choices
                  (map :type)
                  (map ->lang-type)
                  distinct
                  (str/join " | "))]
    (str name (when-not required "?") ": " type ";")))

(defn ->backbone-type [element]
  (str/replace (str (:base element) (uppercase-first-letter (:name element))) #"[_-]" ""))

(defn generate-property [{:keys [name array required type choices profile] :as element}]
  (cond choices
        (generate-polymorphic-property element)

        (= type "Meta")
        (if profile
          (format "%s: Meta & { profile: [\"%s\"] };" name profile)
          (format "%s: Meta;" name))

        :else
        (let [type' (if (= "BackboneElement" type)
                      (->backbone-type element)
                      (->lang-type (:type element)))]
          (str (->camel-case name) (when-not required "?") ": " type' (when array "[]") ";"))))

(defn generate-class
  "Generates TypeScript type from IR (intermediate representation) schema."
  [ir-schema & [inner-classes]]
  (let [base-class (class-name (or (:base-resource-name ir-schema)
                                   ;; need for BackboneElement
                                   (:base ir-schema)
                                   ""))
        class-name' (class-name (or (:resource-name ir-schema)
                                    ;; need for BackboneElement
                                    (:name ir-schema)
                                    ""))
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
     (cond
       ;; base class and properties
       (and (seq properties)
            (not (str/blank? base-class)))
       (str base-class " & {\n" properties "\n}")

       ;; no base class / yes properties
       ;; export type Something = { ... }
       (and (seq properties)
            (str/blank? base-class))
       (str "{\n" properties "\n}")

       ;; yes base class / no properties
       ;; export type DataType = Element;
       (and (empty? properties)
            (not (str/blank? base-class)))
       base-class

       ;; no base class / no propeties
       ;; export type Base = {};
       (and (empty? properties)
            (str/blank? base-class))
       "{}")

     ";")))

(defn- path->name [path]
  (str/replace path #"(\.ts)|[\.\/]" ""))

(defn generate-deps
  "Takes a list of resource names and generates import declarations."
  [deps]
  (->> deps
       (map (fn [{:keys [module members]}]
              (if (seq members)
                (format "import { %s } from \"%s\";" (str/join ", " members) module)
                (format "import * as %s from \"%s\";" (path->name module) module))))
       (str/join "\n")))

(defn generate-module
  [& {:keys [deps classes]
      :or {classes []}}]
  (->> (conj []
             (->> deps
                  (map class-name)
                  (map (fn [d] {:module (str "./" d) :members [d]}))
                  generate-deps)

             classes)
       (flatten)
       (str/join "\n\n")))

(defrecord TypeScriptCodeGenerator []
  CodeGenerator
  (generate-datatypes [_ ir-schemas]
    (let [ir-schemas (sort-by :base ir-schemas)]
      (map (fn [ir-schema]
             {:path (resource-file-path ir-schema)
              :content (generate-module
                        :deps (:deps ir-schema)
                        :classes [(generate-class ir-schema (map generate-class (:backbone-elements ir-schema)))])})
           ir-schemas)))

  (generate-resource-module [_ ir-schema]
    {:path (resource-file-path ir-schema)
     :content (generate-module
               {:deps (:deps ir-schema)
                :classes [(generate-class ir-schema
                                          (map generate-class (:backbone-elements ir-schema)))]})})

  (generate-search-params [_ ir-schemas]
    (map (fn [ir-schema]
           {:path (search-param-filepath ir-schema)
            :content (generate-module
                      :deps (map #(format "%sSearchParameters" %) (:deps ir-schema))
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
                       :deps (:deps schema)
                       :classes (generate-class (assoc schema :url constraint-name)
                                                (map generate-class (:backbone-elements schema))))})
          ir-schemas))

  (generate-sdk-files [_] (generator/prepare-sdk-files :typescript)))

(def generator (->TypeScriptCodeGenerator))
