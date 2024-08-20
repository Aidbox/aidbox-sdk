(ns aidbox-sdk.snapshots-test
  (:require
   [clojure.test :refer [deftest is]]
   [clojure.java.io :as io]
   [clojure.string :as str]
   [matcho.core :as matcho]
   [aidbox-sdk.schema :as importer]
   [aidbox-sdk.converter :as converter]
   [aidbox-sdk.fhir :as fhir]
   [aidbox-sdk.generator :as gen]))

(defn load-r4-schemas []
  (importer/retrieve
   (importer/resource "http://localhost:8765/api/sdk/fhir-packages")
   {:auth "YmFzaWM6c2VjcmV0"}))

(def m-load-r4-schemas (memoize load-r4-schemas))

(defn make-path
  [ns-kw]
  (str "test/aidbox_sdk/snapshots/" (namespace ns-kw) "/" (name ns-kw)))

(defn match-snapshot
  "Accepts a unique namespaced keyword and a value.
   Creates a file (using the keyword for its name) if not already present, and writes the value to it.
   If a file with that name is already present it compares its content to the value using a test/is macro."
  [k v]
  (let [file-name (make-path k)
        file (io/file file-name)]
    (if (.exists file)
      (let [snapshot (slurp file)]
        ;; TODO show string diff instead of matcho
        (matcho/match
         (str/split-lines snapshot)
          (str/split-lines v)))
      (do
        (io/make-parents file-name)
        (spit file-name v)))))

(deftest ^:snapshot r4-snapshots
  (doseq [{:keys [path content]}
          (->> (load-r4-schemas)
               (filter fhir/fhir-schema?)
               (filter fhir/base-schema?)
               (filter fhir/domain-resource?)
               (converter/convert)
               (map #(gen/generate-resource-module :dotnet %)))]

    (match-snapshot (->> path .getPath keyword) content))

;
  )
(comment
  (->> (m-load-r4-schemas)
       (filter fhir/fhir-schema?)
       (filter fhir/base-schema?)
       (filter fhir/domain-resource?)
       converter/convert
       (map #(gen/generate-resource-module :dotnet %))
       first
       :content))
