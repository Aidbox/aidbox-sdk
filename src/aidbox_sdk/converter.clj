(ns aidbox-sdk.converter
  (:require
   [clojure.walk :as walk]
   [clojure.string :as str]
   [aidbox-sdk.generator.helpers :refer [->pascal-case
                                         safe-conj
                                         uppercase-first-letter]]))

(def primitives #{"dateTime" "xhtml" "Distance" "time" "date" "string" "uuid" "oid" "id" "Dosage" "Duration" "instant" "Count" "decimal" "code" "base64Binary" "unsignedInt" "url" "markdown" "uri" "positiveInt"  "canonical" "Age" "Timing"})

(defn url->resource-name
  "There are :id and :name in schemas but they are not reliable source."
  [url]
  (last (str/split (str url) #"/")))

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
                (str (url->resource-name parent-name) "_" (uppercase-first-letter (name k))) v (.contains required (name k)))}))

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
    (conj data
          {:backbone-elements
           (if (empty? backbone-elements)
             []
             (map (fn [[k, v]] (compile-backbone name k v)) backbone-elements))})))

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
                    :package (get schema :package)
                    :url (get schema :url)
                    :type (get schema :type)
                    :derivation (get schema :derivation))))))

;; resolve references

(defn- find-schema-by-url [schemas url]
  (->> schemas
       (filter #(= url (:url %)))
       (first)))

(defn- find-element-by-reference [element-reference schemas]
  (let [[schema-url & path] element-reference
        schema (find-schema-by-url schemas schema-url)
        element (get-in schema (map keyword path))]
    (or element {})))

(defn find-elements-by-names [element-names schema]
  (filter #(contains?
            (set element-names)
            (:name %))
          (:elements schema)))

(defn resolve-references [schemas]
  (walk/postwalk
   (fn [x]
     (if-let [reference (:elementReference x)]
       (merge (dissoc x :elementReference)
              (find-element-by-reference reference schemas))
       x))
   schemas))

(defn resolve-element-choices [schema el]
  (if (:choices el)
    (update el :choices find-elements-by-names schema)
    el))

(defn resolve-schema-choices [schema]
  (-> schema
      (update :elements
              (fn [elements]
                (map #(resolve-element-choices schema %) elements)))))

(defn resolve-choices [schemas]
  (map resolve-schema-choices schemas))

(defn convert [schemas]
  (->> schemas
       (resolve-references)
       (compile-elements)
       (combine-elements)
       (map (fn [schema] (update schema
                                :backbone-elements #(resolve-choices (flatten-backbones % [])))))
       (resolve-choices)))
