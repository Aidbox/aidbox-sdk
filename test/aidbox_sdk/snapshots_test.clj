(ns aidbox-sdk.snapshots-test
  (:require
    [aidbox-sdk.converter :as converter]
    [aidbox-sdk.fhir :as fhir]
    [aidbox-sdk.generator :as gen]
    [aidbox-sdk.generator.dotnet :as dotnet]
    [aidbox-sdk.generator.typescript :as typescript]
    [aidbox-sdk.generator.python :as python]
    [aidbox-sdk.schema :as importer]
    [clojure.java.io :as io]
    [clojure.string :as str]
    [clojure.test :refer [deftest]]
    [matcho.core :as matcho]))

(set! *warn-on-reflection* true)

(defn load-schemas-from-aidbox []
  (importer/retrieve
   (importer/resource "http://localhost:3333/r4/fhir-packages")
   {:auth "YmFzaWM6c2VjcmV0"}))

(def m-load-schemas-from-aidbox (memoize load-schemas-from-aidbox))

(def test-snapshots-typescript-path "test/aidbox_sdk/snapshots/typescript")
(def test-snapshots-dotnet-path "test/aidbox_sdk/snapshots/dotnet")
(def test-snapshots-python-path "test/aidbox_sdk/snapshots/python")

(defn make-path
  [language-path ns-kw]
  (str language-path "/" (namespace ns-kw) "/" (name ns-kw)))

(defn match-snapshot
  "Accepts a unique namespaced keyword and a value.
   Creates a file (using the keyword for its name) if not already present, and writes the value to it.
   If a file with that name is already present it compares its content to the value using a test/is macro."
  [language-path k v]
  (let [file-name (make-path language-path k)
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

(deftest ^:snapshot r4-snapshots-dotnet-test
  (doseq [{:keys [^java.io.File path content]}
          (->> (m-load-schemas-from-aidbox)
               (filter fhir/fhir-schema?)
               (filter fhir/base-schema?)
               (filter fhir/domain-resource?)
               converter/convert
               (map #(gen/generate-resource-module dotnet/generator %)))]

    (match-snapshot test-snapshots-dotnet-path (->> path .getPath keyword) content)))

(deftest ^:snapshot r4-snapshots-typescript-test
  (doseq [{:keys [^java.io.File path content]}
          (->> (m-load-schemas-from-aidbox)
               (filter fhir/fhir-schema?)
               (filter fhir/base-schema?)
               (filter fhir/domain-resource?)
               converter/convert
               (map #(gen/generate-resource-module typescript/generator %)))]

    (match-snapshot test-snapshots-typescript-path (->> path .getPath keyword) content)))

(deftest ^:snapshot r4-snapshots-python-test
  (doseq [{:keys [^java.io.File path content]}
          (->> (m-load-schemas-from-aidbox)
               (filter fhir/fhir-schema?)
               (filter fhir/base-schema?)
               (filter fhir/domain-resource?)
               converter/convert
               (map #(gen/generate-resource-module python/generator %)))]

    (match-snapshot test-snapshots-python-path (->> path .getPath keyword) content)))


(comment
  (->> (m-load-schemas-from-aidbox)
       (filter fhir/fhir-schema?)
       (filter fhir/base-schema?)
       (filter fhir/domain-resource?)
       converter/convert
       (map #(gen/generate-resource-module dotnet/generator %))
       first
       :content))
