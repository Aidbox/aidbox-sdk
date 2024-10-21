(ns aidbox-sdk.generator.typescript
  (:require
   [aidbox-sdk.generator :as generator]
   [aidbox-sdk.generator.helpers :refer [->pascal-case uppercase-first-letter
                                         ->camel-case]]
   [aidbox-sdk.generator.utils :as u]
   [clojure.java.io :as io]
   [clojure.string :as str]
   [aidbox-sdk.fhir :as fhir])
  (:import
   [aidbox_sdk.generator CodeGenerator]))

(def reserved-names #{"RequestPriority"})
(def valuset-exception #{"SubscriptionStatus"})
(def reserved-name-suffix "_")

(defn package->directory
  "Generates directory name from package name.
  Example:
  hl7.fhir.r4.core -> hl7-fhir-r4-core"
  [x]
  (str/replace x #"[\.#]" "-"))

(defn resource-file-path [ir-schema]
  (io/file "types"
           (package->directory (:package ir-schema))
           (str (->pascal-case (:resource-name ir-schema)) ".ts")))

(defn search-param-filepath [ir-schema]
  (io/file "types" "search" (str (:name ir-schema) "SearchParameters.ts")))

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
  (let [name' (->pascal-case resource-name)]
    (if (contains? reserved-names name')
      (str name' "_")
      name')))

(defn valueset-name [type-name]
  (let [name' (class-name type-name)]
    (if (contains? valuset-exception name')
      (str name' "VS")
      name')))

(defn generate-polymorphic-property [{:keys [name required choices]}]
  (let [type (->> choices
                  (map :type)
                  (map ->lang-type)
                  distinct
                  (str/join " | "))]
    (str name (when-not required "?") ": " type ";")))

(defn ->backbone-type [element]
  (str/replace (str (:base element) (->pascal-case (:name element))) #"[_-]" ""))

(defn generate-property [{:keys [name array required type choices profile fhir-version] :as element}]
  (let [optional (if required "" "?")]
    (cond choices
          (generate-polymorphic-property element)

          (= type "Meta")
          (if profile
            (format "%s%s: Meta & { profile: [\"%s\"] };" name optional profile)
            (format "%s%s: Meta;" name optional))

          :else
          (let [type' (cond
                        (= "BackboneElement" type)
                        (->backbone-type element)

                        (:valueset element)
                        (valueset-name (:valueset element))

                        :else
                        (->lang-type (:type element)))
                primitive-type? (fhir/primitive-element? fhir-version element)]
            (str (str (->camel-case name) optional ": " type' (when array "[]") ";")
                 (when primitive-type?
                   (str "\n" u/indent "_" (->camel-case name) "?: Element;")))))))

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
                        (map #(assoc % :fhir-version (:fhir-version ir-schema)))
                        (map generate-property)
                        (flatten)
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
  "Takes an IR schema generates import declarations."
  [ir-schema]
  (let [relative-path (if (fhir/base-package? ir-schema)
                        "./"
                        (str "../" (package->directory (:fhir-version ir-schema)) "/"))
        valueset-deps (when (and (fhir/base-package? ir-schema)
                                 (seq (:valueset-deps ir-schema)))
                        (format "import { %s } from \"./valuesets\""
                                (->> (:valueset-deps ir-schema)
                                     (map valueset-name)
                                     (str/join ", "))))]
    (str (->> (:deps ir-schema)
              (map class-name)
              (map (fn [d] {:module (str relative-path d) :members [d]}))
              (map (fn [{:keys [module members]}]
                     (if (seq members)
                       (format "import { %s } from \"%s\";"
                               (str/join ", " members)
                               module)
                       (format "import * as %s from \"%s\";"
                               (path->name module)
                               module))))
              (str/join "\n"))
         (when valueset-deps
           (str
            "\n"
            valueset-deps)))))

(defn generate-module
  [& {:keys [deps classes]
      :or {classes []}}]
  (->> (conj []
             deps
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
                        :deps (generate-deps ir-schema)
                        :classes [(generate-class ir-schema (map generate-class (:backbone-elements ir-schema)))])})
           ir-schemas)))

  (generate-resource-module [_ ir-schema]
    {:path (resource-file-path ir-schema)
     :content (generate-module
               {:deps (generate-deps ir-schema)
                :classes [(generate-class ir-schema
                                          (map generate-class (:backbone-elements ir-schema)))]})})

  (generate-search-params [_ ir-schemas]
    (map (fn [ir-schema]
           {:path (search-param-filepath ir-schema)
            :content (generate-module
                      :deps (generate-deps {:package "hl7.fhir.r4.core" :deps (map #(format "%sSearchParameters" %) (:deps ir-schema))})
                      :classes [(generate-class
                                 {:name (format "%sSearchParameters" (:name ir-schema))
                                  :base (when (:base ir-schema)
                                          (format "%sSearchParameters" (:base ir-schema)))
                                  :elements (:elements ir-schema)})])})
         ir-schemas))

  (generate-constraints [_ ir-schemas]
    (map (fn [ir-schema]
           {:path (resource-file-path ir-schema)
            :content (generate-module
                      {:deps (generate-deps ir-schema)
                       :classes [(generate-class ir-schema
                                                 (map generate-class (:backbone-elements ir-schema)))]})})
         ir-schemas))

  (generate-sdk-files [_ _]
    (generator/prepare-sdk-files
     :typescript
     ["index.ts" "eslint.config.mjs" "http-client.ts" "package.json"
      "package-lock.json" "tsconfig.json" "types/index.ts"
      "types/workflow/SystemCheckOutWorkflow.ts" "types/workflow/index.ts"
      "types/task/SystemSendMessage.ts" "types/task/index.ts"]))

  (generate-valuesets [_ vs-schemas]
    (->> vs-schemas
         (map (fn [[fhir-version schemas]]
                {:path (io/file "types" (package->directory fhir-version) "valuesets.ts")
                 :content
                 (->> schemas
                      (mapv (fn [vs]
                              (let [type-name (valueset-name (:name vs))
                                    values (->> (:values vs)
                                                (map #(format "\"%s\"" %))
                                                (str/join " | "))]
                                (str "export type " type-name " = " values ";"))))
                      (str/join "\n"))})))))

(def generator (->TypeScriptCodeGenerator))
