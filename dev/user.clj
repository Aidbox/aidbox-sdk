(ns user
  (:require [aidbox-sdk.generator :as gen]
            [clojure.data]
            [clojure.java.io :as io]))

(def source' (io/file "resources/schemas"))

(def target (io/file "/tmp/sdk"))

(defn vector-to-map [v]
  (->> (map (fn [item] (hash-map (:url item) item)) v)
       (into {})))

(apply merge [{:a 1 :b 2} {:a 3 :c 4}])

(comment

  (io/file "../resources/schemas")

  (->> (gen/retrieve-schemas' source')
       (filter #(= "hl7.fhir.us.mcode" (:package %))))

  (->> (gen/retrieve-schemas' source')
       (filter #(= "hl7.fhir.us.mcode" (:name %))))

  (->> (gen/retrieve-schemas' source')
       (filter #(= (:type %) "Patient"))
       (gen/prepared-schemas)
       (map (fn [schema]
              (conj schema {:backbone-elements
                            (gen/flat-backbones (:backbone-elements schema) [])})))
       (vector-to-map))

  (->> (gen/retrieve-schemas' source')
       (filter #(= (:base %) "http://hl7.org/fhir/StructureDefinition/Patient")))

  (->> (gen/retrieve-schemas' source')
       (filter gen/base-schema?)
       (gen/prepared-schemas)
       (map (fn [schema]
              (conj schema {:backbone-elements
                            (gen/flat-backbones (:backbone-elements schema) [])})))
       (vector-to-map))

  (def mcodes (->> (gen/retrieve-schemas' source')
                   (filterv #(= "constraint" (:derivation %)))
                   (vec)))

  (def bases (->> (gen/retrieve-schemas' source')
                  #_(filter gen/base-schema?)
                  (gen/prepared-schemas)
                  (map (fn [schema]
                         (conj schema {:backbone-elements
                                       (gen/flat-backbones (:backbone-elements schema) [])})))
                  (vector-to-map)))

  (get bases "http://hl7.org/fhir/StructureDefinition/Extension")

  (count (gen/apply-constraints mcodes
                                bases))

  (vec (gen/retrieve-schemas' source'))
  (contains? (->> (gen/retrieve-schemas' source')
                  (filter gen/base-schema?)
                  (gen/prepared-schemas)
                  (map (fn [schema]
                         (conj schema {:backbone-elements
                                       (gen/flat-backbones (:backbone-elements schema) [])})))
                  (vector-to-map))
             "http://hl7.org/fhir/StructureDefinition/Observation")

  (gen/build-all! source' target)

  ;;
  )
