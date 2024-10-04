(ns user
  (:require
   [aidbox-sdk.converter :as converter]
   [aidbox-sdk.core :as sdk]
   [aidbox-sdk.fhir :as fhir]
   [aidbox-sdk.schema :as import]
   [clojure.walk :as walk]
   [meander.epsilon :as m]
   [aidbox-sdk.generator.helpers :as helpers]
   [aidbox-sdk.models :as models]
   [clojure.set :as set]
   [clojure.string :as str]
   [clojure.data]))

(defonce aidbox-schemas (atom nil))

(defn load-aidbox-schemas [from]
  (let [from (case from
               :r4 "http://localhost:3333/r4/fhir-packages"
               :r5 "http://localhost:3333/r5/fhir-packages"
               :aidbox "http://localhost:8765/api/sdk/fhir-packages")]
    (reset! aidbox-schemas
            (import/retrieve
             (import/resource from) {:auth "YmFzaWM6c2VjcmV0"})))
  nil)

(comment
  (load-aidbox-schemas :r4)

  (defonce r4-schemas  (import/retrieve (import/resource "resources/r4") {}))
  (defonce r4b-schemas (import/retrieve (import/resource "resources/r4b") {}))
  (defonce r5-schemas  (import/retrieve (import/resource "resources/schemas/r5") {})))

(defn kinds          [schemas] (distinct (map :kind schemas)))
(defn resource-types [schemas] (distinct (map :resourceType schemas)))
(defn packages       [schemas] (distinct (map :package schemas)))

(defn exclude-keys [m keys] (apply dissoc m keys))

(comment

  (kinds r4-schemas)
  ;; => (nil "complex-type" "resource" "primitive-type" "logical")

  (resource-types r4b-schemas)
  ;; => ("SearchParameter" "ValueSet" "StructureDefinition" "CompartmentDefinition")

  (resource-types r5-schemas)
  ;; => ("SearchParameter" "ValueSet" "StructureDefinition" "CompartmentDefinition")

  (resource-types r4-schemas)
  ;; => ("ValueSet" "SearchParameter" nil "StructureDefinition")

  (resource-types @aidbox-schemas)
  ;; => ("FHIRSchema"
  ;;     "SearchParameter"
  ;;     "CompartmentDefinition"
  ;;     "ValueSet"
  ;;     "StructureDefinition")

  (let [all-schemas      @aidbox-schemas

        base-type?       (every-pred fhir/fhir-schema? fhir/base-type?)
        datatype?        (every-pred fhir/fhir-schema? fhir/datatype? (complement fhir/primitive-type?))
        resource?        (every-pred fhir/fhir-schema? fhir/resource?)
        constraint?      (every-pred fhir/fhir-schema? fhir/constraint? (complement fhir/extension?))
        search-param?    (every-pred fhir/search-parameter? (complement fhir/search-parameter-from-extension?))

        fhir-schemas         (filter fhir/fhir-schema? all-schemas)
        base-schemas         (filter base-type?        all-schemas)
        datatype-schemas     (filter datatype?         all-schemas)
        resource-schemas     (filter #(and
                                       (fhir/fhir-schema? %)
                                       (not (fhir/base-type? %))
                                       (not (fhir/datatype? %))
                                       (or (fhir/resource-type? %)
                                           (fhir/domain-resource? %)
                                           (fhir/backbone-element? %)))
                                     all-schemas)
        constraint-schemas   (filter constraint?       all-schemas)
        search-param-schemas (filter search-param?     all-schemas)

        ir-schemas              (converter/convert fhir-schemas)
        base-ir-schemas         (converter/convert base-schemas)
        datatype-ir-schemas     (converter/convert datatype-schemas)
        resource-ir-schemas     (converter/convert resource-schemas)
        search-param-ir-schemas (converter/convert-search-params search-param-schemas
                                                                 fhir-schemas)]

;; (def css constraint-schemas)

    ;; (def cssi constraint-ir-schemas)

    ;; (->> (remove fhir/constraint? ir-schemas)
    ;;      (filter #(contains? (set (map :base css)) %))
    ;;      helpers/vector->map)

    ;; (reduce (fn [acc v] (assoc acc (:url v) v)) css)

    ;; (let [name->map (reduce (fn [acc v] (assoc acc (:url v) v)) css)]
    ;;   (reduce (fn [graph {:keys [url base]}]
    ;;             (if (and base (contains? name->map base))
    ;;               (update graph url conj base)
    ;;               graph))
    ;;           (zipmap (map :url css) (repeat #{}))
    ;;           css))

    ;; (fhir/filter-by-url "http://hl7.org/fhir/StructureDefinition/bmi" ir-schemas)

    ;; (let [base-schemas (->> (remove fhir/constraint? ir-schemas)
    ;;                         (filter #(contains? (set (map :base constraint-schemas)) (:url %)))
    ;;                         helpers/vector->map)]
    ;;   (reduce (fn [acc constraint]
    ;;             (let [base-schema (or (get base-schemas (:base constraint))
    ;;                                   (get acc (:url constraint)))]

    ;;               (assoc acc
    ;;                      (:url constraint)
    ;;                      (converter/apply-constraint base-schema constraint))))

    ;;           {} (converter/sort-by-base constraint-schemas)))

    ;; (converter/apply-constraints (remove fhir/constraint? ir-schemas) constraint-schemas)

    (->> all-schemas
         (filter #(or (fhir/domain-resource? %)
                      (fhir/backbone-element? %)))
         (filter fhir/backbone-element?))
    ;let
    )

;comment
  )

(comment
  ;; Mock Server

  ;; run server
  (do (require '[mock-server.main :as server])
      (def mock-server (server/run)))

  ;; stop server
  (mock-server)

  ;
  )

(comment
  (sdk/generate! :dotnet
                 "http://localhost:3333/r4/fhir-packages"
                 {:output-dir "dist/dotnet"
                  :auth-token "YmFzaWM6c2VjcmV0"
                  :exit (fn [_] nil)})

  (sdk/generate! :typescript
                 "http://localhost:3333/r4/fhir-packages"
                 {:output-dir "dist/typescript"
                  :auth-token "YmFzaWM6c2VjcmV0"
                  :exit (fn [_] nil)})

  (sdk/generate! :python
                 "http://localhost:3333/r4/fhir-packages"
                 {:output-dir "dist/python"
                  :auth-token "YmFzaWM6c2VjcmV0"
                  :exit (fn [_] nil)})

  ;
  )
