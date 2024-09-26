(ns aidbox-sdk.generator.python
  (:require
   [aidbox-sdk.generator :as generator]
   [aidbox-sdk.generator.helpers :refer [->pascal-case ->snake-case
                                         uppercase-first-letter
                                         starts-with-capital?]]
   [aidbox-sdk.generator.utils :as u]
   [clojure.set :as set]
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

    "integer"      "int"
    "unsignedInt"  "int"
    "positiveInt"  "int"

    "integer64"    "int"
    "base64Binary" "str"

    "uri"          "str"
    "url"          "str"
    "canonical"    "str"
    "oid"          "str"
    "uuid"         "str"

    "string"       "str"
    "code"         "str"
    "xhtml"        "str"
    "markdown"     "str"
    "id"           "str"

    ;; hardcoded just in case
    "Meta"         "Meta"
    ;; else
    fhir-type))

(defn url->resource-name [reference]
  (last (str/split (str reference) #"/")))

(defn class-alias [class-name]
  (get {"List" "FhirList"} class-name class-name))

(defn class-name
  "Generate class name from schema url."
  [url]
  (-> url
      url->resource-name
      ->pascal-case
      class-alias))

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
  hl7.fhir.r4.core -> hl7_fhir_r4_core"
  [x]
  (str/replace x #"[\.#]" "_"))

(defn datatypes-file-path []
  (io/file "base/__init__.py"))

(defn resource-file-path [ir-schema]
  (io/file (package->directory (:package ir-schema))
           (str (->pascal-case (:name ir-schema)) ".py")))

(defn constraint-file-path [ir-schema name]
  (io/file (package->directory (:package ir-schema))
           (str (->pascal-case (url->resource-name name)) ".py")))

(defn search-param-filepath [ir-schema]
  (io/file "search" (str (:name ir-schema) "SearchParameters.py")))

(defn generate-polymorphic-property [_element]
  nil)

(defn ->backbone-type [element]
  (str (->pascal-case (:base element)) (uppercase-first-letter (:name element))))

(def restricted-python-words
  #{"False" "None" "True" "and" "as" "assert" "async" "await" "break" "class"
   "continue" "def" "del" "elif" "else" "except" "finally" "for" "from" "global"
   "if" "import" "in" "is" "lambda" "nonlocal" "not" "or" "pass" "raise"
   "return" "try" "while" "with" "yield"})

(defn guard-python-property-name [prop]
  (if (restricted-python-words prop)
    (str prop "_")
    prop))

(defn remove-guard-from-class-name [class-name]
  (if (= \_ (last class-name))
    (subs class-name 0 (dec (count class-name)))
    class-name))

(defn generate-property
  "Generates class property from schema element.

  Use string instead of classname if `forward-reference?` is true:
  class Element:
      extension: Optional['Extension']"
  [element forward-reference?]
  (let [name (guard-python-property-name (->snake-case (:name element)))
        lang-type (if (= "BackboneElement" (:type element))
                    (->backbone-type element)
                    (->lang-type (:type element)))
        lang-type
        (cond->> lang-type

          :always
          remove-guard-from-class-name

          (and forward-reference? (starts-with-capital? lang-type))
          (format "'%s'"))

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
                        (:meta element)
                        (format "Meta(profile=[\"%s\"])" (:profile element))

                        (:array element)
                        "field(default_factory=list)"

                        (not (:required element))
                        "None"

                        :else nil)]

    (if (contains? element :choices)
      (generate-polymorphic-property element)
      (str name ": " type (when default-value (str " = " default-value))))))

(def special-classes #{"Element" "Resource"})

(defn generate-class
  "Generates Python class from IR (intermediate representation) schema."
  [ir-schema & [inner-classes]]
  (let [base-class (url->resource-name (:base ir-schema))
        schema-name (or (:url ir-schema) (:name ir-schema))
        class-name' (class-name schema-name)
        special-class? (special-classes class-name')
        elements (->> (:elements ir-schema)
                      (map #(if (and (= (:base %) "Bundle_Entry")
                                     (= (:name %) "resource"))
                              (assoc % :value "T")
                              %)))
        properties (->> elements
                        (map #(generate-property % special-class?))
                        (remove nil?)
                        (map u/add-indent)
                        (str/join "\n"))
        base-class-name (some-> (when-not (str/blank? base-class)
                                  (uppercase-first-letter base-class)))
        base-class-name (when base-class-name
                          (str "(" base-class-name ")"))]
    (str
      (when (seq inner-classes)
        (str (str/join "\n\n" inner-classes) "\n\n"))

      ;; kw_only restrict to create object like this: Address("a", "b")
      ;; and you have to use Address(use="a", type="b")
      ;; this is so dumb.
      ;; no matter how you sort fields, there's warning
      ;; https://stackoverflow.com/questions/72472220/dataclass-inheritance-fields-without-default-values-cannot-appear-after-fields
      "@dataclass(kw_only=True)"
      "\n"
      "class " class-name' base-class-name ":"
      "\n"
      properties
      (when-not (seq properties)
        (u/add-indent "pass")))))

(defn generate-module
  [& {:keys [deps classes]
      :or {classes []}}]
  (->> (conj []
             (generate-deps deps)
             classes)
       (flatten)
       (str/join "\n\n")))

(defn gen [ir-schema]
  (generate-class ir-schema (map generate-class (:backbone-elements ir-schema))))

(defn generate-datatypes-python-classes* [ir-schemas classes already-generated deferred-schemas]
  (if-let [ir-schema (first ir-schemas)]
    (cond

      (already-generated (class-name (or (:url ir-schema) (:name ir-schema))))
      (recur (rest ir-schemas) classes already-generated deferred-schemas)

      ;; no deps and base => we can easily generate
      (or (and (empty? (:deps ir-schema))
               (not (:base ir-schema)))

          ;; deps are generated => generate
          (and (seq (:deps ir-schema))
               (clojure.set/subset? (:deps ir-schema) already-generated))

          (special-classes (class-name (or (:url ir-schema) (:name ir-schema)))))
      (recur
        (rest ir-schemas)
        (conj classes (gen ir-schema))
        (conj already-generated (class-name (or (:url ir-schema) (:name ir-schema))))
        deferred-schemas)

      ;; no deps but extends => skipping, we need to generate base first
      (or (and (empty? (:deps ir-schema))
               (:base ir-schema))

          ;; not all deps are generated => skip
          (and (seq (:deps ir-schema))
               (not (clojure.set/subset? (:deps ir-schema) already-generated))))
      (recur (rest ir-schemas)
             classes
             already-generated
             (conj deferred-schemas ir-schema))

      :else
      (throw (Exception. (str "Can't generate "
                              (class-name (or (:url ir-schema) (:name ir-schema)))))))
    (cond
      (seq deferred-schemas)
      (->> deferred-schemas
           (mapv gen)
           (concat classes)
           (into []))
      :else
      classes)))

(defn generate-datatypes-python-classes [ir-schemas]
  (generate-datatypes-python-classes* (->> ir-schemas (sort-by
                                                        (fn [{:keys [base deps]}]
                                                          (+ (count deps) (if base 500 0)))) vec)
                                      [] #{} []))

(defn valid-base-for-search-param? [ir-schema]
  (and (:base ir-schema) (not= (:base ir-schema) "Base")))

;;
;; Main
;;

(defrecord PythonCodeGenerator []
  CodeGenerator
  (generate-datatypes [_ ir-schemas]
    [{:path (datatypes-file-path)
      :content (generate-module
                 :deps [{:module "__future__" :members ["annotations"]}
                        {:module "typing" :members ["Optional" "List"]}
                        {:module "dataclasses" :members ["dataclass", "field"]}]
                 :classes
                 (generate-datatypes-python-classes ir-schemas))}])

  (generate-resource-module [_ ir-schema]
    {:path (resource-file-path ir-schema)
     :content (generate-module
                :deps (concat [{:module "typing" :members ["Optional" "List"]}
                               {:module "dataclasses" :members ["dataclass", "field"]}]
                              (map (fn [d] {:module "base" :members [(class-alias d)]})
                                   (:deps ir-schema)))
                :classes [(generate-class ir-schema
                                          (map generate-class (:backbone-elements ir-schema)))])})

  (generate-search-params [_ ir-schemas]
    (map (fn [ir-schema]
           {:path (search-param-filepath ir-schema)
            :content (generate-module
                      :deps (cond-> [{:module "typing" :members ["Optional"]}
                                     {:module "dataclasses" :members ["dataclass", "field"]}]

                              (valid-base-for-search-param? ir-schema)
                              (conj {:module (str "." (format "%sSearchParameters" (:base ir-schema)))
                                     :members [(format "%sSearchParameters" (:base ir-schema))]}))
                      :classes [(generate-class
                                 {:name (format "%sSearchParameters" (:name ir-schema))
                                  :base (when (valid-base-for-search-param? ir-schema)
                                          (format "%sSearchParameters" (:base ir-schema)))
                                  :elements (:elements ir-schema)})])})
         ir-schemas))

  (generate-constraints [_ constraint-ir-schemas]
    (mapv (fn [[constraint-name schema]]
            {:path (constraint-file-path schema constraint-name)
             :content (generate-module
                        :deps  (concat [{:module "typing" :members ["Optional" "List"]}
                                        {:module "dataclasses" :members ["dataclass", "field"]}
                                        #_{:module "pydantic" :members ["*"]}]
                                       (map (fn [d] {:module (str "..base." d) :members [d]}) (:deps schema)))
                        :classes (generate-class (assoc schema :url constraint-name)
                                                 (map generate-class (:backbone-elements schema))))})
          constraint-ir-schemas))

  (generate-sdk-files [_] (generator/prepare-sdk-files :python)))

(def generator (->PythonCodeGenerator))
