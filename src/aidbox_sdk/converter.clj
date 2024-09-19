(ns aidbox-sdk.converter
  (:require
   [aidbox-sdk.fhir :as fhir]
   [aidbox-sdk.generator.helpers :refer [->pascal-case safe-conj
                                         uppercase-first-letter vector->map]]
   [clojure.set :as set]
   [clojure.string :as str]
   [clojure.walk :as walk]))

(def primitives #{"dateTime" "xhtml" "Distance" "time" "date" "string" "uuid" "oid" "id" "Dosage" "Duration" "instant" "Count" "decimal" "code" "base64Binary" "unsignedInt" "url" "markdown" "uri" "positiveInt"  "canonical" "Age" "Timing"})

(defn url->resource-name
  "There are :id and :name in schemas but they are not reliable source."
  [url]
  (str/replace
   (last (str/split (str url) #"/"))
   #"\||\."
   "-"))

(defn flatten-backbones [backbone-elements accumulator]
  (reduce (fn [acc item]
            (concat (flatten-backbones (:backbone-elements item) acc)
                    [(dissoc item :backbone-elements)]))
          accumulator
          backbone-elements))

;;; combine elements

(defn concat-elements-circulary [schemas parent-name elements]
  (if (not (nil? parent-name))
    (->> (concat elements (get-in schemas [parent-name :elements] []))
         (concat-elements-circulary schemas (get-in schemas [parent-name :base])))
    elements))

(defn concat-backbones-circulary [schemas parent-name backbones]
  (if (not (nil? parent-name))
    (->> (concat backbones (get-in schemas [parent-name :backbone-elements] []))
         (concat-backbones-circulary schemas (get-in schemas [parent-name :base])))
    backbones))

(defn mix-parents-elements-circular [schemas schema]
  (if (:base schema)
    (->> (concat-elements-circulary schemas (:base schema) [])
         (concat (:elements schema))
         (hash-map :elements)
         (conj schema))
    schema))

(defn mix-parents-backbones-circular [schemas definition]
  (if (not (nil? (get definition :base nil)))
    (->> (concat-backbones-circulary schemas (get definition :base) [])
         (concat (:backbone-elements definition))
         (hash-map :backbone-elements)
         (conj definition))
    definition))

(defn combine-elements [schemas]
  (for [schema schemas]
    (->> schema
         (mix-parents-elements-circular schemas)
         (mix-parents-backbones-circular schemas))))

;;; compile elements

(defn- escape-keyword [word]
  (if (contains? #{"class", "from", "assert", "global", "for", "import"} word)
    (str word "_")
    word))

(defn- get-type [name type]
  (cond
    (= type "Expression")       "Base.ResourceExpression"
    (= type "Reference")        "Base.ResourceReference"
    (= type "BackboneElement")  (str "" (uppercase-first-letter name))
    (= type "boolean")          "bool"
    (= type "integer")          "int"
    (= type "unsignedInt")      "uint"
    (= type "")                 "string"
    (.contains primitives type) "string"
    :else (if type (str "Base." type) "string")))

(defn- derive-basic-type [name element]
  (get-type name (url->resource-name (:type element))))

(defn- transform-element [name element required]
  (->> (derive-basic-type name element)))

(defn- resolve-backbone-elements [[k, v]]
  (if (= (url->resource-name (:type v)) "BackboneElement") (vector k, v) (vector)))

(defn- collect-types [parent-name required [k v]]
  (if (contains? v :choices)
    {:name    (escape-keyword (name k))
     :choices (:choices v)}
    {:name     (escape-keyword (name k))
     :base     parent-name
     :array    (boolean (:array v))
     :required (.contains required (name k))
     :value    (transform-element
                (str (url->resource-name parent-name) "_" (uppercase-first-letter (name k)))
                v
                (.contains required (name k)))
     :type     (:type v)

     :choice-option (boolean (:choiceOf v))}))

(defn- get-typings-and-imports [parent-name required data]
  (reduce (fn [acc item]
            {:elements (conj (:elements acc)
                             (collect-types parent-name required item))
             :backbone-elements (conj (:backbone-elements acc) (resolve-backbone-elements item))
             :name parent-name})
          {:elements [] :backbone-elements []}
          data))

(defn- compile-backbone [parent-name property-name schema]
  (let [name (str parent-name "_" (->pascal-case (name property-name)))
        data (get-typings-and-imports
              name
              (or (:required schema) [])
              (seq (:elements schema)))
        backbone-elements (remove empty? (:backbone-elements data))]
    (-> data
        (assoc :backbone-elements
               (if (empty? backbone-elements)
                 []
                 (map (fn [[k, v]] (compile-backbone name k v)) backbone-elements)))
        (assoc :base "BackboneElement"))))

(defn- clear-backbone-elements [resource-type schema]
  (->> (:backbone-elements schema)
       (remove empty?)
       (map (fn [[k v]] (compile-backbone resource-type k v)))
       (hash-map :backbone-elements)
       (conj schema)))

(defn compile-elements [schemas]
  (for [schema schemas]
    (->> (get-typings-and-imports
          (:type schema)
          (or (:required schema) [])
          (seq (:elements schema)))
         (clear-backbone-elements
          (url->resource-name (:url schema)))
         (safe-conj
          (hash-map :base (get schema :base)
                    :base-resource-name (when (get schema :base)
                                          (url->resource-name (get schema :base)))
                    :package (get schema :package)
                    :url (get schema :url)
                    :type (get schema :type)
                    :derivation (get schema :derivation))))))

;; resolve references
(defn resolve-element-references [schema]
  (update schema :elements
          (fn [elements]
            (walk/postwalk
             (fn [x]
               ;; TODO add type of the reference
               (if (:elementReference x)
                 (-> x
                     (assoc :type "Reference")
                     (dissoc :elementReference))

                 x))
             elements))))

;;

(defn find-elements-by-names [element-names schema]
  (filter #(contains?
            (set element-names)
            (:name %))
          (:elements schema)))

(defn resolve-element-choices [schema el]
  (if (:choices el)
    (let [choices (find-elements-by-names (:choices el) schema)]
      (-> el
          (assoc :choices choices)
          (merge (select-keys (first choices) [:base :array :required]))))
    el))

(defn resolve-schema-choices [schema]
  (-> schema
      (update :elements
              (fn [elements]
                (map #(resolve-element-choices schema %) elements)))))

(defn resolve-choices [schemas]
  (map resolve-schema-choices schemas))

(defn collect-dependencies [schema]
  (let [primitive-element? (partial fhir/primitive-element? (:package schema))]
    (set/union
     (cond-> #{}
       (:base-resource-name schema) (conj (:base-resource-name schema))
       (fhir/constraint? schema)    (conj "Meta"))

     (->> (:elements schema)
          (remove primitive-element?)
          (map :type)
          (remove nil?)
          set)

     (->> (:backbone-elements schema)
          (map :elements)
          flatten
          (remove primitive-element?)
          (map :type)
          (remove nil?)
          set))))

(defn resolve-dependencies [schemas]
  (map #(assoc % :deps (collect-dependencies %)) schemas))

;;
;; Convert main function
;;

(defn convert [schemas]
  (->> schemas
       (map resolve-element-references)
       (compile-elements)
       (combine-elements)
       (map (fn [schema]
              (update schema :backbone-elements #(resolve-choices (flatten-backbones % [])))))
       (resolve-choices)
       (resolve-dependencies)))

;;
;; Search Params
;;

(defn resolve-elements [schemas resource]
  (->> schemas
       (filter #(contains? (set (:base %)) resource))
       (map :code)
       (distinct)
       (sort)))

(defn convert-search-params [search-params-schemas all-schemas]
  (->> all-schemas
       (map (fn [schema]
              {:name (:id schema)
               :base (when-let [base (:base schema)]
                       (->pascal-case (url->resource-name base)))
               :elements (->> (resolve-elements search-params-schemas (:id schema))
                              (map (fn [el] {:type "string" :name el})))}))
       (remove #(empty? (:elements %)))))

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
       (map (fn [[key item]] (set/difference
                              (set (:choices (first (filter #(= (:name %) (name key)) schema))))
                              (set (:choices item)))))
       (reduce set/union #{})
       ((fn [choices-to-exclude]
          (filter #(not (contains? choices-to-exclude (:name %))) schema)))))

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

(defn create-single-pattern [constraint-name [key schema] elements]
  (case (url->resource-name (some #(when (= (name key) (:name %)) (:value %)) elements))
    "CodeableConcept" (pattern-codeable-concept (str (uppercase-first-letter (url->resource-name constraint-name)) (uppercase-first-letter (subs (str key) 1))) schema) ""))

(defn apply-patterns [constraint-name patterns schema]
  (->> (map (fn [item]
              (if-let [pattern (some #(when (= (name (first %)) (:name item)) (last %)) patterns)]
                (case (:value item)
                  "str" (assoc item :value (:pattern pattern) :literal true)
                  "CodeableConcept" (conj item (hash-map :value (str
                                                                 (str/join
                                                                  (map uppercase-first-letter
                                                                       (str/split (url->resource-name constraint-name) #"-")))
                                                                 (str/join (map uppercase-first-letter
                                                                                (str/split (:name item) #"-"))))
                                                         :codeable-concept-pattern true))
                  "Quantity" item item) item)) (:elements schema))
       (hash-map :elements) (conj schema (hash-map :patterns (concat (get schema :patterns []) (map (fn [item] (create-single-pattern constraint-name item (:elements schema))) patterns))))))

(defn add-meta [constraint-name elements]
  (->> (filter #(not (= (:name %) "meta")) elements)
       (concat [{:name "meta"
                 :required true
                 :value "Meta"
                 :profile constraint-name
                 :type "Meta"
                 :meta (str " = new() { Profile = [\"" constraint-name "\"] };")}])))

(defn copy-from-constraint [properties new-schema]
  (merge new-schema properties))

(defn convert-constraint [constraint parent-schema]
  (->> (:elements parent-schema)
       (apply-required (:required constraint))
       (apply-excluded (:excluded constraint))
       (apply-choices (filter #(contains? (last %) :choices)
                              (:elements constraint)))
       (add-meta (:url constraint))
       (hash-map :elements)
       (conj parent-schema)
       (copy-from-constraint {:package (:package constraint)
                              :derivation (:derivation constraint)})
       (apply-patterns (:url constraint)
                       (filter #(contains? (last %) :pattern)
                               (:elements constraint)))
       ((fn [schema] (update schema :deps set/union #{"Meta"})))))

(defn convert-constraints [constraint-schemas base-schemas]
  (let [base-schemas (vector->map base-schemas)]
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
                            (convert-constraint constraint-schema
                                                (get result (:base constraint-schema))))

                     (contains? base-schemas (:base constraint-schema))
                     (assoc acc
                            (:url constraint-schema)
                            (convert-constraint constraint-schema
                                                (get base-schemas (:base constraint-schema))))

                     :else acc))

                 result
                 constraint-schemas))))))
