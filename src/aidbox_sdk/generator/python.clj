(ns aidbox-sdk.generator.python
  (:require
   [aidbox-sdk.generator.helpers :refer [->pascal-case ->snake-case
                                         uppercase-first-letter vector->map]]
   [aidbox-sdk.generator.python.templates :as templates]
   [aidbox-sdk.generator.utils :as u]
   [clojure.java.io :as io]
   [clojure.set :as set]
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
;; Constraints
;;

(defn apply-excluded [excluded schema]
  (filter (fn [field-schema]
            (not (some #(= % (:name field-schema)) excluded)))
          schema))

(defn apply-required [required elements]
  (->> elements
       (map (fn [element]
              (if (contains? (set required) (:name element))
                (assoc element :required true)
                element)))))

(defn apply-choices [choices schema]
  (->> choices
       (map (fn [[key, item]]
              (set/difference
               (set (:choices (first (filter #(= (:name %) (name key)) schema))))
               (set (:choices item)))))
       (reduce set/union #{})
       ((fn [choises-to-exclude]
          (filter #(not (contains? choises-to-exclude (:name %))) schema)))))

(defn pattern-codeable-concept [name schema]
  (->> (str "}")
       (str "\tpublic new " (str/join ", " (map #(str "Coding" (str/join (str/split (:code %) #"-"))) (get-in schema [:pattern :coding] []))) "[] Coding { get; } = [new()];\n") #_(str/join ", " (map #(str "Coding" (str/join (str/split (:code %) #"-")) "()") (get-in schema [:pattern :coding] [])))
       (str "\nclass " (str/join (map uppercase-first-letter (str/split name #"-"))) " : CodeableConcept\n{\n")
       (str (when-let [coding (:coding (:pattern schema))]
              (str/join (map (fn [code]
                               (->> (str "}")
                                    (str (when (contains? code :code)  (str "\tpublic new string Code { get; } = \"" (:code code) "\";\n")))
                                    (str (when (contains? code :system) (str "\tpublic new string System { get; } = \"" (:system code) "\";\n")))
                                    (str (when (contains? code :display) (str "\tpublic new string Display { get; } = \"" (:display code) "\";\n")))
                                    (str "\n\nclass Coding" (str/join (str/split (:code code) #"-")) " : Coding\n{\n"))) coding))) "\n")))

(defn create-single-pattern [constraint-name, [key, schema], elements]
  (case (url->resource-name (some #(when (= (name key) (:name %)) (:value %)) elements))
    "CodeableConcept" (pattern-codeable-concept (str (uppercase-first-letter (url->resource-name constraint-name)) (uppercase-first-letter (subs (str key) 1))) schema) ""))

(defn apply-patterns [constraint-name patterns schema]
  (->> (map (fn [item]
              (if-let [pattern (some #(when (= (name (first %)) (:name item)) (last %)) patterns)]
                (case (:value item)
                  "str" (assoc item :value (:pattern pattern) :literal true)
                  "CodeableConcept" (conj item (hash-map :value (str (str/join (map uppercase-first-letter (str/split (url->resource-name constraint-name) #"-"))) (str/join (map uppercase-first-letter (str/split (:name item) #"-")))) :codeable-concept-pattern true))
                  "Quantity" item item) item)) (:elements schema))
       (hash-map :elements)
       (conj schema (hash-map :patterns (concat (get schema :patterns []) (map (fn [item] (create-single-pattern constraint-name item (:elements schema))) patterns))))))

(defn add-meta [constraint-name elements]
  (->> (filter #(not= (:name %) "meta") elements)
       (concat [{:name "meta"
                 :required true
                 :value "Meta"
                 :type "Meta"
                 :meta (str " = Meta(profile=[\"" constraint-name "\"])")}])))

(defn apply-single-constraint [constraint parent-schema]
  (->> (:elements parent-schema)
       (apply-required (:required constraint))
       (apply-excluded (:excluded constraint))
       (apply-choices (filter #(contains? (last %) :choices) (:elements constraint)))
       (add-meta (:url constraint))
       (hash-map :elements)
       (conj parent-schema)
       (apply-patterns (:url constraint) (filter #(contains? (last %) :pattern) (:elements constraint)))))

(defn apply-constraints [constraint-schemas base-schemas]
  (loop [result {}]
    (if (= (count constraint-schemas) (count result))
      result
      (recur
       (reduce (fn [acc constraint-schema]
                 (cond
                   (contains? result (:url constraint-schema))
                   acc

                   (contains? result (:base constraint-schema))
                   (assoc acc
                          (:url constraint-schema)
                          (assoc (apply-single-constraint constraint-schema
                                                          (get result (:base constraint-schema)))
                                 :package (:package constraint-schema)))

                   (contains? base-schemas (:base constraint-schema))
                   (assoc acc
                          (:url constraint-schema)
                          (assoc (apply-single-constraint constraint-schema
                                                          (get base-schemas (:base constraint-schema)))
                                 :package (:package constraint-schema)))

                   :else acc))

               result
               constraint-schemas)))))

;;
;; Main
;;

(defrecord PythonCodeGenerator []
  CodeGenerator
  (generate-datatypes [_ ir-schemas]
    [{:path (datatypes-file-path)
      :content (generate-module
                :deps [{:module "pydantic" :members ["*"]}
                       {:module "typing" :members ["Optional" "List"]}]
                :classes (map (fn [ir-schema]
                                (generate-class ir-schema
                                                (generate-backbone-classes ir-schema)))
                              ir-schemas))}])

  (generate-resource-module [_ ir-schema]
    {:path (resource-file-path ir-schema)
     :content (generate-module
               :deps [{:module "pydantic" :members ["*"]}
                      {:module "typing" :members ["Optional" "List"]}
                      {:module "..base" :members ["*"]}]
               :classes [(generate-class ir-schema
                                         (generate-backbone-classes ir-schema))])})

  (generate-search-params [_ ir-schemas]
    (map (fn [ir-schema]
           {:path (search-param-filepath ir-schema)
            :content (generate-module
                      :deps [{:module "typing" :members ["Optional"]}]
                      :classes [(generate-class
                                 {:name (format "%sSearchParameters" (:name ir-schema))
                                  :base (when (:base ir-schema)
                                          (format "%sSearchParameters" (:base ir-schema)))
                                  :elements (:elements ir-schema)})])})
         ir-schemas))

  (generate-constraints [_ constraint-schemas ir-schemas]
    (->> (apply-constraints constraint-schemas (vector->map ir-schemas))
         (mapv (fn [[name' schema]]
                 {:path (constraint-file-path schema name')
                  :content (generate-module
                            :deps [{:module "pydantic" :members ["*"]}
                                   {:module "typing" :members ["Optional" "List"]}
                                   {:module "..base" :members ["*"]}]
                            :classes (generate-class schema (generate-backbone-classes schema)))}))))

  (generate-sdk-files [_] templates/files))

(def generator (->PythonCodeGenerator))
