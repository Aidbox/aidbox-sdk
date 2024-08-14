(ns aidbox-sdk.generator.dotnet.core
  (:require
   [aidbox-sdk.generator.helpers :refer [->pascal-case uppercase-first-letter]]))

(defn polymorphic-element->property [element]
  (throw (Exception. "implement me!")))

(defn generate-property
  "Generates class property from schema element."
  [element]
  (let [type (str
              ;; TODO this is not enough
              ;; In order to properly put "new" modifier we must know if
              ;; there is a same property in ancestor classes
              (when (:meta element)
                "new ")
              (when (and (:required element)
                         (not (:meta element))) "required ")
              (:value element)
              (:generic element)
              (when (:array element) "[]")
              (when (and (not (:required element))
                         (not (:literal element))) "?"))
        name (uppercase-first-letter (:name element))
        accessor (if (or (:meta element)
                         (:codeable-concept-pattern element))
                   "{ get; }"
                   "{ get; set; }")]
    (if (contains? element :choices)
      (polymorphic-element->property element)
      (str "public " type " " name " " accessor
           (when (and (:required element)
                      (:codeable-concept-pattern element)) " = new()")
           (:meta element)))))

(defn generate-class
  "Generates class from intermediate representation schema"
  [schema]
  schema)
