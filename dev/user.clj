(ns user
  (:require
   [aidbox-sdk.core :as sdk]
   [aidbox-sdk.fhir :as fhir]
   [aidbox-sdk.converter :as converter]
   [aidbox-sdk.fixtures.schemas :as fixtures]
   [aidbox-sdk.generator :as gen]
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
  ;;     "StructureDefinition")

  (->> aidbox-schemas
       (filter #(= "Patient" (:id %)))
       (converter/convert))

  (->> aidbox-schemas
       (filter fhir/fhir-schema?)
       (converter/convert))

  (->> aidbox-schemas
       (filter fhir/fhir-schema?)
       (filter fhir/constraint?)
       (converter/convert))

  (->> r4-schemas
       (filter #(= nil (:resourceType %)))
       (filter fhir/constraint?))

  (gen/build-all!
   :input "resources/schemas"
   :target-language "dotnet"
   :output "dist")

  (gen/build-all!
   :auth "YmFzaWM6c2VjcmV0"
   :target-language "dotnet"
   :input "http://localhost:8765/api/sdk/fhir-packages"
   :output "dist1")

  (sdk/generate :dotnet "http://localhost:8765/api/sdk/fhir-packages"
                {:auth-token "YmFzaWM6c2VjcmV0"
                 :output-dir "dist-new"})

  (cli/app {:exit (fn [s])} ["-h"])

  (cli/parse-args ["generate" "dotnet" "-h"])

  (clojure.walk/postwalk (fn [x] (prn x)

                           x)

                         fixtures/unflattened-backbone-elements)

  :rcf)
