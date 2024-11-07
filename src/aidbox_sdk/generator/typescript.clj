(ns aidbox-sdk.generator.typescript
  (:require
   [aidbox-sdk.generator :as generator]
   [aidbox-sdk.generator.helpers :refer [->pascal-case ->camel-case]]
   [aidbox-sdk.generator.utils :as u]
   [clojure.java.io :as io]
   [clojure.string :as str]
   [aidbox-sdk.fhir :as fhir])
  (:import
   [aidbox_sdk.generator CodeGenerator]))

(def reserved-names #{"RequestPriority"})
(def valuset-exception #{"SubscriptionStatus"})

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
                        (remove #(:choices %))
                        (map #(assoc % :fhir-version (:fhir-version ir-schema)))
                        (map generate-property)
                        (flatten)
                        (remove nil?)
                        ((fn [props] (if (or
                                          (fhir/base-type? ir-schema)
                                          (not (fhir/resource? ir-schema))
                                          (contains? (set (map :name (:elements ir-schema))) "resourceType"))
                                       props
                                       (conj props (format "resourceType: '%s'" class-name')))))
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
        valueset-deps (when
                       (seq (:valueset-deps ir-schema))
                        (format "import { %s } from '%svaluesets';"
                                (->> (:valueset-deps ir-schema)
                                     (map valueset-name)
                                     (str/join ", "))
                                relative-path))]
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

(defn index-exports [schemas]
  (let [names (->> schemas
                   (remove fhir/primitive-type?)
                   (remove fhir/extension?)
                   (remove fhir/logical?)
                   (map (fn [schema] (class-name (:resource-name schema))))
                   sort)]
    (conj (mapv (fn [class-name']
                  (format "import { %s } from './%s';" class-name' class-name'))
                names)
          (format "export { %s };" (str/join ", " names)))))

(defn resource-list [schemas]
  (let [names (->> schemas
                   (remove fhir/primitive-type?)
                   (remove fhir/extension?)
                   (remove fhir/logical?)
                   (map (fn [schema] (class-name (:resource-name schema))))
                   sort)]
    (flatten ["export const resourceList: readonly ResourceType[] = ["
              (map #(str u/indent "'" % "',") names)
              "];"])))

(defn resource-type-map [schemas]
  (flatten ["export type ResourceTypeMap = {"
            (u/add-indent "User: Record<string, any>;")
            (->> schemas
                 (remove fhir/primitive-type?)
                 (remove fhir/extension?)
                 (remove fhir/logical?)
                 (map (fn [schema] (class-name (:resource-name schema))))
                 sort
                 (map (fn [name']
                        (format "%s: %s;" name' name')))
                 (map u/add-indent))
            "};"
            "export type ResourceType = keyof ResourceTypeMap;"]))

(defn generate-types-index [packages]
  (into (into ["export * from './workflow';"
               "export * from './task';"]
              (for [pkg packages]
                (str/join
                 "\n"
                 [(format "export * from './%s';" (package->directory pkg))
                  (format "export * from './%s/search-params';" (package->directory pkg))])))

        ["export interface SubsSubscription {"
         "  status: \"active\" | \"off\";"
         "  trigger: { event: Array<\"all\" | \"create\" | \"update\" | \"delete\">; filter?: unknown };"
         "  channel: { type: \"rest-hook\" };"
         "}"
         ""
         "export type TaskDefinitionsMap = {"
         "  \"placeholder-1\": { params: {}; result: {} };"
         "  \"placeholder-2\": { params: {}; result: {} };"
         "};"
         ""
         "export type WorkflowDefinitionsMap = {"
         "  \"placeholder-1\": { params: {}; result: {} };"
         "  \"placeholder-2\": { params: {}; result: {} };"
         "};"
         ""
         "export const TaskDefinitionsNameMap: Record<keyof TaskDefinitionsMap, string> = {"
         "  \"placeholder-1\": \"my-workflows/placeholder-1\","
         "  \"placeholder-2\": \"my-workflows/placeholder-2\","
         "};"
         ""
         "export const WorkflowDefinitionsNameMap: Record<keyof WorkflowDefinitionsMap, string> = {"
         "  \"placeholder-1\": \"my-workflows/placeholder-1\","
         "  \"placeholder-2\": \"my-workflows/placeholder-2\","
         "};"]))

(defn generate-search-params' [schemas]
  (->> (group-by :package schemas)
       (map (fn [[pkg-name pkg-schemas]]
              {:path (io/file "types" (package->directory pkg-name) "search-params.ts")
               :content (generate-module
                         :deps "import { type ResourceType } from './index';"
                         :classes
                         (->> ["export interface SearchParams extends Record<ResourceType, unknown> {"
                               (->> pkg-schemas
                                    (map (fn [schema]
                                           [(format "'%s': {" (:name schema))
                                            (->> (:elements schema)
                                                 (map (fn [el]
                                                        (if (:target el)
                                                          (format "'%s': `${ResourceType}/${%s}`" (:name el) (:type el))
                                                          (format "'%s': %s" (:name el) (:type el)))))
                                                 (mapv u/add-indent))
                                            "}"]))
                                    flatten
                                    (mapv u/add-indent))
                               "}"]
                              flatten
                              (str/join "\n")))}))))

(defrecord TypeScriptCodeGenerator []
  CodeGenerator
  (generate-datatypes [_ ir-schemas]
    (let [ir-schemas (sort-by :base ir-schemas)]
      (map (fn [ir-schema]
             {:path (resource-file-path ir-schema)
              :content (generate-module
                        :deps (generate-deps ir-schema)
                        :classes [(generate-class ir-schema
                                                  (map generate-class (:backbone-elements ir-schema)))])})
           ir-schemas)))

  (generate-resource-module [_ ir-schema]
    {:path (resource-file-path ir-schema)
     :content (generate-module
               {:deps (generate-deps ir-schema)
                :classes [(generate-class ir-schema
                                          (map generate-class (:backbone-elements ir-schema)))]})})

  (generate-search-params [_ ir-schemas]
    (generate-search-params' ir-schemas))

  (generate-constraints [_ ir-schemas]
    (map (fn [ir-schema]
           {:path (resource-file-path ir-schema)
            :content (generate-module
                      {:deps (generate-deps ir-schema)
                       :classes [(generate-class ir-schema
                                                 (map generate-class (:backbone-elements ir-schema)))]})})
         ir-schemas))

  (generate-sdk-files [_ ir-schemas]
    (let [packages (group-by :package (filter fhir/base-package? ir-schemas))
          package-indexes (for [[package schemas] packages]
                            {:path (io/file "types" (package->directory package) "index.ts")
                             :content (str/join "\n" (into (into (index-exports schemas)
                                                                 (resource-list schemas))
                                                           (resource-type-map schemas)))})
          types-index      [{:path (io/file "types" "index.ts")
                             :content (str/join "\n" (generate-types-index (keys packages)))}]
          common-sdk-files (generator/prepare-sdk-files
                            :typescript
                            ["index.ts"
                             "eslint.config.mjs"
                             "http-client.ts"
                             "package.json"
                             "package-lock.json"
                             "tsconfig.json"
                             "types/workflow/SystemCheckOutWorkflow.ts"
                             "types/workflow/index.ts"
                             "types/task/SystemSendMessage.ts"
                             "types/task/index.ts"])]
      (into (into common-sdk-files package-indexes) types-index)))

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
