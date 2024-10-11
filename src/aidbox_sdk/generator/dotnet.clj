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

(defn ->lang-type [fhir-type]
  (case fhir-type
    ;; Primitive Types
    "boolean"      "bool"
    "instant"      "string"
    "time"         "string"
    "date"         "string"
    "dateTime"     "string"
    "decimal"      "number"

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
    "xhtml"        "string"

    ;; else
    fhir-type))

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
                              "if (value?.GetType() == typeof(" (:value choice) "))\n"
                              (u/x2 u/indent)
                              "{"
                              "\n"
                              u/indent
                              (u/x2 u/indent)
                              (->pascal-case (:name choice)) " = (" (:value choice) ")value;"
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

(defn url->resource-name [url]
  (last (str/split (str url) #"/")))

(defn ->backbone-type [element]
  (str/replace (str (:base element) (uppercase-first-letter (:name element))) "[-_]" ""))

(defn generate-property
  "Generates class property from schema element."
  [{:keys [name array required value type choices] :as element}]
  (let [name'     (->pascal-case name)
        lang-type (str/replace (or value type "") #"[_-]" "")
        required' (if required "required " "")
        type      (str
                   required'
                   lang-type
                   (:generic element)
                   (when array "[]")
                   (when (and (not required)
                              (not (:literal element))) "?"))]
    (cond choices
          (generate-polymorphic-property element)

          (= (:type element) "Meta")
          (if (:profile element)
            (format "public new Meta Meta { get; } = new() { Profile = [\"%s\"] };" (:profile element))
            (format "public %s%s Meta { get; set; }" required' name'))

          :else
          (str "public " type " " name' " { get; set; }"
               (when (and (:required element)
                          (:codeable-concept-pattern element)) " = new()")
               (:meta element)))))

(defn class-name
  "Generate class name from schema url."
  [resource-name]
  (let [n (->pascal-case resource-name)]
    (cond
      (= n "Expression")  "ResourceExpression"
      (= n "Reference")   "ResourceReference"
      :else n)))

(defn generate-class [schema & [inner-classes]]
  (let [base-class (url->resource-name (:base schema))
        schema-name (or (:url schema) (:name schema))
        generic (when (= (:type schema) "Bundle") "<T>")
        class-name' (class-name (str (or (:resource-name schema)
                                     ;; need for BackboneElement
                                         (:name schema)
                                         "") generic))
        elements (->> (:elements schema)
                      (map #(if (and (= (:base %) "Bundle_Entry")
                                     (= (:name %) "resource"))
                              (assoc % :value "T")
                              %)))

        properties (->> elements
                        (map generate-property)
                        (map u/add-indent)
                        (str/join "\n"))

        base-class-name (when-not (str/blank? base-class)
                          (str " : " (uppercase-first-letter base-class)))]

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
  (-> x
      (str/replace #"[\.#]" "-")))

(defn package->module-name
  "Convert package name to namespace.
  hl7.fhir.r4.core#4.0.1 -> Aidbox.FHIR.R4.Core"
  [x]
  (str "Aidbox.FHIR."
       (->> (-> x
                (str/replace #"hl7.fhir." "")
                (str/split #"\."))
            (map ->pascal-case)
            (str/join "."))))

;;
;; Constraints
;;

(defn generate-constraint-module [schema]
  (generate-module
   :name (package->module-name (:package schema))
   :deps [{:module "Aidbox.FHIR.Base" :members []}
          {:module "Aidbox.FHIR.Utils" :members []}]
   :classes (generate-class schema (map generate-class (:backbone-elements schema)))))

;;
;; main
;;

(defn datatypes-file-path []
  (io/file "Base.cs"))

(defn resource-file-path [ir-schema]
  (io/file (package->directory (:package ir-schema))
           (str (->pascal-case (:resource-name ir-schema)) ".cs")))

(defn generate-resource-map [schemas]
  ;; TODO refactor
  ;; The base or not base should be decided on converter layer
  (->> schemas
       (remove (fn [schema]
                 (fhir/primitive-type? schema)))
       (map (fn [schema]
              (assoc schema :base? (or (fhir/base-type? schema)
                                       (and (fhir/datatype? schema)
                                            (not (fhir/primitive-type? schema)))))))
       (sort-by :base?)
       (reverse)
       (map (fn [schema]
              (let [class-name' (class-name (:resource-name schema))
                    module-name (if (:base? schema)
                                  "Base"
                                  (package->module-name (:package schema)))]
                (format "{ typeof(Aidbox.FHIR.%s.%s), \"%s\"}"
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
                :name "Aidbox.FHIR.Base"
                :deps []
                :classes (map generate-class ir-schemas))}])

  (generate-resource-module [_ ir-schema]
    {:path (resource-file-path ir-schema)
     :content (generate-module
               :name (package->module-name (:package ir-schema))
               :deps [{:module "Aidbox.FHIR.Base" :members []}
                      {:module "Aidbox.FHIR.Utils" :members []}]
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
            :content (generate-constraint-module
                      (assoc ir-schema :url (:url ir-schema)))})
         constrained-ir-schemas))

  (generate-sdk-files [_ ir-schemas]
    (let [common-sdk-files (generator/prepare-sdk-files :dotnet)
          utils (generate-utils-namespace ir-schemas)]
      (conj common-sdk-files {:path (io/file "Utils.cs") :content utils}))))

(def generator (->DotNetCodeGenerator))
