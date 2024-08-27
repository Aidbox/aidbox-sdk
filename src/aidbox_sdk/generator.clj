(ns aidbox-sdk.generator
  (:require
   [aidbox-sdk.fhir :as fhir]
   [aidbox-sdk.generator.helpers :refer [->pascal-case]]
   [clojure.string :as str]))

;;
;; Search Params
;;
;; TODO Search params should be a part of converter, not generator.

(defn search-parameters-for [schemas resource-name]
  (->> schemas
       (filter fhir/search-parameter?)
       (remove fhir/search-parameter-from-extension?)
       (filter #(contains? (set (:base %)) resource-name))))

(defn resolve-elements [schemas resource]
  (->> (search-parameters-for schemas resource)
       (map :code)
       (distinct)
       (sort)))

(defn search-parameters-structures
  [search-parameters-schemas schemas]
  (->> schemas
       (map (fn [schema]
              {:name (:id schema)
               :base (when-let [base (:base schema)]
                       (->pascal-case
                        (str/replace base #"http://hl7.org/fhir/StructureDefinition/" "")))
               :elements (resolve-elements search-parameters-schemas (:id schema))}))
       (remove #(empty? (:elements %)))))

;;
;; main
;;

(defprotocol CodeGenerator
  (generate-datatypes [this ir-schemas])
  (generate-resource-module [this ir-schema])
  (generate-search-params [this search-schemas fhir-schemas])
  (generate-constraints [this constraint-schemas ir-schemas])
  (generate-sdk-files [this]))
