(ns aidbox-sdk.generator.dotnet
  (:require
   [aidbox-sdk.generator :as generator]
   [aidbox-sdk.generator.helpers :refer [->pascal-case uppercase-first-letter]]
   [aidbox-sdk.generator.utils :as u]
   [clojure.java.io :as io]
   [clojure.string :as str]
   [aidbox-sdk.fhir :as fhir])
  (:import
   [aidbox_sdk.generator CodeGenerator]))

(def base-namespace "Aidbox.FHIR.Base")
(def utils-namespace "Aidbox.FHIR.Utils")

(def fhir-type->lang-type
  {"boolean"      "bool"
   "instant"      "string"
   "time"         "string"
   "date"         "string"
   "dateTime"     "string"

   "decimal"      "decimal"
   "integer"      "int"
   "unsignedInt"  "long"
   "positiveInt"  "long"
   "integer64"    "long"
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
   "xhtml"        "string"})

(defn ->lang-type [fhir-type]
  (get fhir-type->lang-type fhir-type fhir-type))

(defn get-type [{:keys [type service-type] :as _element}]
  (cond
    (= type "Expression") "Base.ResourceExpression"
    (= type "Reference")  "Base.ResourceReference"
    :else (if service-type
            (str "Base." type)
            (->lang-type type))))

(defn generate-polymorphic-property [element]
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
                              "if (value?.GetType() == typeof(" (get-type choice) "))\n"
                              (u/x2 u/indent)
                              "{"
                              "\n"
                              u/indent
                              (u/x2 u/indent)
                              (->pascal-case (:name choice)) " = (" (get-type choice) ")value;"
                              "\n"
                              (u/x3 u/indent)
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

(defn generate-property
  "Generates class property from schema element."
  [{:keys [name array required type choices service-type] :as element}]
  (let [name'     (->pascal-case name)
        type'     (get-type element)
        lang-type (str/replace (or type' "") #"[_-]" "")
        required' (if required "required " "")
        nullable  (if required "" "?")
        type      (str required'
                       lang-type
                       (:generic element)
                       (when array "[]")
                       (when (and (not required)
                                  (not (:literal element))) "?"))]
    (cond
      choices
      #_(generate-polymorphic-property element)
      nil

      (= (:type element) "Meta")
      (if (:profile element)
        (format "public new Meta Meta { get; } = new() { Profile = [\"%s\"] };" (:profile element))
        (format "public %sMeta%s %s { get; set; }" required' nullable name'))

      :else
      (str "public " type " " name' " { get; set; }"
           (when (and (:required element)
                      (:codeable-concept-pattern element)) " = new()")
           (:meta element)))))

(defn url->resource-name [url]
  (last (str/split (str url) #"/")))

(defn class-name
  "Generate class name from schema url."
  [resource-name]
  (let [n (->pascal-case resource-name)]
    (cond
      (= n "Expression") "ResourceExpression"
      (= n "Reference")  "ResourceReference"
      :else n)))

(defn generate-class [schema & [inner-classes]]
  (let [base-class  (url->resource-name (:base schema))
        class-name' (if (= (:type schema) "Bundle")
                      "Bundle<T>"
                      (class-name (:resource-name schema)))
        elements    (->> (:elements schema)
                         ;; NOTE: this is a hack for Bundle since it's a generic
                         ;; class and currently we do not have a solution for
                         ;; generating generic classes
                         (map #(if (and (= (:base %) "Bundle_Entry")
                                        (= (:name %) "resource"))
                                 (-> %
                                     (assoc :type "T")
                                     (assoc :service-type false))
                                 %)))
        properties  (->> elements
                         (map generate-property)
                         (remove nil?)
                         (map u/add-indent)
                         (str/join "\n"))
        base-class-name (when-not (str/blank? base-class)
                          (str " : " (class-name base-class)))]
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
             (if deps (apply u/using (map :module deps)) [])
             (u/namespace name')
             classes
             interfaces
             structs
             enums
             delegates)
       (flatten)
       (remove str/blank?)
       (str/join "\n\n")))

(defn package->directory
  "Generate directory name from package name.
  hl7.fhir.r4.core#4.0.1 -> hl7-fhir-r4-core"
  [x]
  (str/replace x #"[\.#]" "-"))

(defn package->module-name
  "Convert package name to namespace.
  hl7.fhir.r4.core#4.0.1 -> Aidbox.FHIR.R4.Core"
  [x]
  (str "Aidbox.FHIR."
       (->> (str/split
             (str/replace x #"hl7.fhir." "")
             #"\.")
            (map ->pascal-case)
            (str/join "."))))

;;
;; main
;;

(defn datatypes-file-path []
  (io/file "Base.cs"))

(defn resource-file-path [ir-schema]
  (io/file (package->directory (:package ir-schema))
           (str (->pascal-case (:resource-name ir-schema)) ".cs")))

(defn generate-resource-map [schemas]
  (->> schemas
       (remove fhir/primitive-type?)
       (remove fhir/extension?)
       (remove fhir/logical?)
       (remove :service-type?)
       (sort-by :resource-name)
       (map (fn [schema]
              (let [class-name' (class-name (:resource-name schema))
                    module-name (package->module-name (:package schema))]
                (format "{ typeof(%s.%s), \"%s\"}"
                        module-name
                        class-name'
                        class-name'))))))

(defn generate-utils-namespace [ir-schemas]
  (str/join "\n" ["using System.Text.Json;"
                  "using System.Text.Json.Serialization;"
                  ""
                  "namespace Aidbox.FHIR.Utils;"
                  ""
                  "public interface IResource { string? Id { get; set; } }"
                  ""
                  "public class LowercaseNamingPolicy : JsonNamingPolicy"
                  "{"
                  "    public override string ConvertName(string name) => name.ToLower();"
                  "}"
                  ""
                  "public class Config"
                  "{"
                  "    public static readonly JsonSerializerOptions JsonSerializerOptions = new()"
                  "    {"
                  "        DefaultIgnoreCondition = JsonIgnoreCondition.WhenWritingNull,"
                  "        PropertyNamingPolicy = JsonNamingPolicy.CamelCase,"
                  "        Converters = { new JsonStringEnumConverter(new LowercaseNamingPolicy()) },"
                  "        WriteIndented = true"
                  "    };"
                  ""
                  "    public static readonly Dictionary<Type, string> ResourceMap = new()"
                  "    {"
                  (->> (generate-resource-map ir-schemas)
                       (map u/add-indent)
                       (map u/add-indent)
                       (str/join ",\n"))
                  "    };"
                  "}"]))

(defrecord DotNetCodeGenerator []
  CodeGenerator
  (generate-datatypes [_ ir-schemas]
    [{:path (datatypes-file-path)
      :content (generate-module
                :name base-namespace
                :deps []
                :classes (map #(generate-class % (map generate-class (:backbone-elements %))) ir-schemas))}])

  (generate-resource-module [_ ir-schema]
    {:path (resource-file-path ir-schema)
     :content (generate-module
               :name (package->module-name (:package ir-schema))
               :deps [{:module base-namespace :members []}
                      {:module utils-namespace :members []}]
               :classes [(generate-class ir-schema
                                         (map generate-class (:backbone-elements ir-schema)))])})

  (generate-search-params [_ ir-schemas]
    (map (fn [ir-schema]
           {:path (io/file "search" (str (:name ir-schema) "SearchParameters.cs"))
            :content
            (generate-module
             :name "Aidbox.FHIR.Search"
             :classes (generate-class
                       {:name (str (:name ir-schema) "SearchParameters")
                        :resource-name (str (:name ir-schema) "SearchParameters")
                        :base (when (:base ir-schema)
                                (str (:base ir-schema) "SearchParameters"))
                        :elements (map (fn [el] (update el :name ->pascal-case))
                                       (:elements ir-schema))}))})
         ir-schemas))

  (generate-constraints [_ constrained-ir-schemas]
    (map (fn [ir-schema]
           {:path (resource-file-path ir-schema)
            :content (generate-module
                      :name (package->module-name (:package ir-schema))
                      :deps [{:module base-namespace :members []}
                             {:module utils-namespace :members []}]
                      :classes (generate-class
                                ir-schema
                                (map generate-class (:backbone-elements ir-schema))))})
         constrained-ir-schemas))

  (generate-sdk-files [_ ir-schemas]
    (let [common-sdk-files (generator/prepare-sdk-files :dotnet)
          utils (generate-utils-namespace ir-schemas)]
      (conj common-sdk-files {:path (io/file "Utils.cs") :content utils})))

  (generate-valuesets [_ vs-schemas]))

(def generator (->DotNetCodeGenerator))
