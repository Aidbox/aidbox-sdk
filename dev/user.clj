(ns user
  (:require
   [aidbox-sdk.core :as sdk]
   [aidbox-sdk.fhir :as fhir]
   [aidbox-sdk.converter :as converter]
   [aidbox-sdk.generator :as gen]
   [aidbox-sdk.generator.python :as gen.python]
   [aidbox-sdk.schema :as import]
   [aidbox-sdk.cli :as cli]
   [clojure.data]
   [clojure.java.io :as io]))

(def r4-schemas  (import/retrieve (import/resource "resources/schemas") {}))
(def r4b-schemas (import/retrieve (import/resource "resources/r4b-schemas") {}))
(def r5-schemas  (import/retrieve (import/resource "resources/r5-schemas") {}))

(def aidbox-schemas (import/retrieve
                     (import/resource "http://localhost:8765/api/sdk/fhir-packages")
                     {:auth "YmFzaWM6c2VjcmV0"}))

(def target (io/file "out/"))

(defn kinds          [schemas] (distinct (map :kind schemas)))
(defn resource-types [schemas] (distinct (map :resourceType schemas)))
(defn packages       [schemas] (distinct (map :package schemas)))

(comment

  (kinds r4-schemas)
  ;; => (nil "complex-type" "resource" "primitive-type" "logical")

  (resource-types r4b-schemas)
  ;; => ("SearchParameter" "ValueSet" "StructureDefinition" "CompartmentDefinition")

  (resource-types r5-schemas)
  ;; => ("SearchParameter" "ValueSet" "StructureDefinition" "CompartmentDefinition")

  (resource-types r4-schemas)
  ;; => ("ValueSet" "SearchParameter" nil "StructureDefinition")

  (resource-types aidbox-schemas)
  ;; => ("FHIRSchema"
  ;;     "SearchParameter"
  ;;     "CompartmentDefinition"
  ;;     "ValueSet"
  ;;     "StructureDefinition")

  (->> aidbox-schemas
       (filter #(= "Patient" (:id %)))
       (converter/convert))

  (converter/convert-search-params
   (->> aidbox-schemas
        (filter fhir/search-parameter?)
        (remove fhir/search-parameter-from-extension?))
   (->> aidbox-schemas
        (filter fhir/fhir-schema?)))

  (let [all-schemas      aidbox-schemas

        base-type?       (every-pred fhir/fhir-schema? fhir/base-type?)
        datatype?        (every-pred fhir/fhir-schema? fhir/datatype? (complement fhir/primitive-type?))
        domain-resource? (every-pred fhir/fhir-schema? fhir/domain-resource?)
        constraint?      (every-pred fhir/fhir-schema? fhir/constraint? (complement fhir/extension?))
        search-param?    (every-pred fhir/search-parameter? (complement fhir/search-parameter-from-extension?))

        fhir-schemas         (filter fhir/fhir-schema? all-schemas)
        base-schemas         (filter base-type?        all-schemas)
        datatype-schemas     (filter datatype?         all-schemas)
        resource-schemas     (filter domain-resource?  all-schemas)
        constraint-schemas   (filter constraint?       all-schemas)
        search-param-schemas (filter search-param?     all-schemas)

        ir-schemas              (converter/convert fhir-schemas)
        base-ir-schemas         (converter/convert base-schemas)
        datatype-ir-schemas     (converter/convert datatype-schemas)
        resource-ir-schemas     (converter/convert resource-schemas)
        search-param-ir-schemas (converter/convert-search-params search-param-schemas
                                                                 fhir-schemas)
        constraint-ir-schemas   (converter/convert-constraints constraint-schemas
                                                               ir-schemas)]


    ()

    base-ir-schemas)





  :rcf)
