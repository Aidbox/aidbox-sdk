(ns user
  (:require
   [aidbox-sdk.converter :as converter]
   [aidbox-sdk.core :as sdk]
   [aidbox-sdk.fhir :as fhir]
   [aidbox-sdk.schema :as import]
   [clojure.walk :as walk]
   [aidbox-sdk.generator.helpers :as helpers]
   [aidbox-sdk.models :as models]
   [clojure.set :as set]
   [clj-http.lite.client :as http.client]
   [clojure.string :as str]
   [clojure.data.json :as json]
   [clojure.edn :as edn]
   [clojure.data]))

(defn value-sets [all-schemas]
  (let [fhir-version->value-set-file
        {"hl7.fhir.r4.core" "resources/r4-value-sets.edn"
         "hl7.fhir.r4b.core" "resources/r4b-value-sets.edn"
         "hl7.fhir.r5.core" "resources/r5-value-sets.edn"}
        used-fhir-versions (->> all-schemas (map :fhir-version) distinct)]
    (reduce (fn [acc fhir-version]
              (let [value-set (walk/keywordize-keys
                               (edn/read-string
                                (slurp
                                 (get fhir-version->value-set-file fhir-version))))
                    prepared (->> value-set
                                  #_(map #(hash-map
                                           :name (:name %)
                                           :values (map :code (-> % :expansion :contains))))
                                  #_(remove #(> (count (:value %)) 20)))]
                (assoc acc fhir-version prepared)))
            {}
            used-fhir-versions)))

(defonce aidbox-schemas (atom nil))

(defn load-aidbox-schemas [from]
  (let [from (case from
               :r4 "http://localhost:3333/r4/fhir-packages"
               :r5 "http://localhost:3333/r5/fhir-packages"
               :r4b "http://localhost:3333/r4b/fhir-packages"
               :aidbox "http://localhost:8765/api/sdk/fhir-packages")]
    (reset! aidbox-schemas
            (import/retrieve
             (import/resource from) {:auth "YmFzaWM6c2VjcmV0"})))
  nil)

(comment
  (load-aidbox-schemas :r4b)

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

        ;; valuesets
        used-fhir-versions      (->> all-schemas (map :fhir-version) distinct)
        vs-schemas              (import/retrieve-valuesets used-fhir-versions)
        converted-vs-schemas    (converter/convert-valusets vs-schemas)
        available-valuesets     (converter/available-valuesets converted-vs-schemas)

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

        ir-schemas              (converter/convert fhir-schemas available-valuesets)
        base-ir-schemas         (converter/convert base-schemas available-valuesets)
        datatype-ir-schemas     (converter/convert datatype-schemas available-valuesets)
        resource-ir-schemas     (converter/convert resource-schemas available-valuesets)

        search-param-ir-schemas (converter/convert-search-params search-param-schemas
                                                                 fhir-schemas)
        constrained-ir-schemas  (converter/apply-constraints
                                 (filter fhir/specialization? ir-schemas)
                                 constraint-schemas)
        ]

    converted-vs-schemas

    #_(->> vs-schemas
           (map (fn [[fhir-version schemas]]
                  {:path fhir-version
                   :content
                   (map (fn [vs]
                          (let [type-name (:name vs)
                                values (->> (get-in vs [:expansion :contains])
                                            (map #(:code %))
                                            (map #(format "\"%s\"" %))
                                            (str/join " | "))]
                            (str "type " type-name " = " values ";")))
                        schemas)})))

    #_(->> vs-schemas
           vals
           flatten
           (filter #(= (:name %) "RequestPriority")))

    converted-vs-schemas

    ;let
    )

  ;comment
  )

(comment
  ;; Mock Server

  ;; (re-)run server
  (do (require '[mock-server.main :as server])
      (mock-server)
      (def mock-server (server/run)))

  ;; stop server
  (mock-server)

  :mock-server-shortcuts)

(comment
  (sdk/generate! :dotnet
                 "http://localhost:3333/r4/fhir-packages"
                 {:output-dir "/tmp/aidbox-dotnet-sdk"
                  :exit (fn [_] nil)})

  (sdk/generate! :typescript
                 "http://localhost:3333/r4/fhir-packages"
                 {:output-dir "dist/typescript"
                  :exit (fn [_] nil)})

  (sdk/generate! :python
                 "http://localhost:3333/r4/fhir-packages"
                 {:output-dir "dist/python"
                  :exit (fn [_] nil)})

  ;; generating from aidbox
  (sdk/generate! :typescript
                 "http://localhost:8765/api/sdk/fhir-packages"
                 {:output-dir "dist/typescript"
                  :auth-token "YmFzaWM6c2VjcmV0"
                  :exit (fn [_] nil)})

  :generator-shortcuts)

(comment

  (def r4-vs-required  (edn/read-string (slurp "resources/r4-value-sets-required.edn")))

  (def r4b-vs-required (edn/read-string (slurp "resources/r4b-value-sets-required.edn")))

  (def r5-vs-required  (edn/read-string (slurp "resources/r5-value-sets-required.edn")))

  (def r4-vs-resolved (for [vs r4-vs-required]
                        (let [response (try (some-> (http.client/get
                                                     (str "https://tx.fhir.org/r4/ValueSet/$expand?url=" vs)
                                                     {:headers {"Accept" "application/json"}})
                                                    :body json/read-str)
                                            (catch Exception e
                                              nil))]
                          response)))

  (def r4b-vs-resolved (for [vs r4b-vs-required]
                         (let [response (try (some-> (http.client/get
                                                      (str "https://tx.fhir.org/r4/ValueSet/$expand?url=" vs)
                                                      {:headers {"Accept" "application/json"}})
                                                     :body json/read-str)
                                             (catch Exception e
                                               nil))]
                           response)))

  (def r5-vs-resolved (for [vs r5-vs-required]
                        (let [response (try (some-> (http.client/get
                                                     (str "https://tx.fhir.org/r4/ValueSet/$expand?url=" vs)
                                                     {:headers {"Accept" "application/json"}})
                                                    :body json/read-str)
                                            (catch Exception e
                                              nil))]
                          response)))

  (->> r5-vs-resolved
       (remove nil?)
       (sort-by #(get % "name"))
       (spit "resources/r5-value-sets.edn")))
