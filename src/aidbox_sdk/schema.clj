(ns aidbox-sdk.schema
  (:require [aidbox-sdk.schema.verify :as verify]
            [aidbox-sdk.generator.helpers :refer [rand-int-between parse-json]]
            [clj-http.lite.client :as http.client]
            [clojure.java.io :as io]
            [clojure.string :as str]))

(defn get-packages-from-directory
  "Returns all packages in the given directory, including files in subdirectories. "
  [path]
  (let [packages (->> path
                      file-seq
                      (remove #(.isDirectory %))
                      ;; FIXME only gzip, but there is no problem to accept unpacked ndjson
                      ;; see https://github.com/Aidbox/aidbox-sdk/issues/11
                      (filter #(str/ends-with? (.getName %) ".gz")))]
    (println "✅ Found packages:" (count packages))
    packages))
(defn create-gzip-reader [path]
  (-> path
      (io/input-stream)
      (java.util.zip.GZIPInputStream.)
      (io/reader)))

;; TODO derive some criteria to determine whether it's a package (is it valid?)
;; see https://github.com/Aidbox/aidbox-sdk/issues/10
(defn parse-package [path]
  (println "Parsing package:" (str path))
  (with-open [reader (create-gzip-reader path)]
    (->> reader
         line-seq
         (mapv parse-json))))

(defn remove-invalid-schemas [schemas]
  (remove #(nil? (:package-meta %)) schemas))

(defn add-resource-type-for-fhir-schemas [schemas]
  (->> schemas
       (map (fn [schema]
              (if-not (:resourceType schema)
                (assoc schema :resourceType "FHIRSchema")
                schema)))))

(defn prepare-schemas [schemas]
  (map #(->> (get-in % [:package-meta :name])
             (assoc  %  :package))
       schemas))

(defn- url?
  "Safe version of as-url function"
  [s]
  (try
    (let [_ (io/as-url s)]
      true)
    (catch java.net.MalformedURLException _ false)
    (catch java.net.URISyntaxException _ false)))

(defn resource [path]
  (if (url? path)
    {:type :url :source path}
    {:type :file :source path}))

(defmulti retrieve (fn [& args] (:type (first args))))

(defmethod retrieve :file
  [{:keys [source]} _]
  (println "Retrieving packages from: " (str source))
  (->> (get-packages-from-directory (io/as-file source))
       (mapv parse-package)
       (verify/check-compatibility!)
       (flatten)
       (remove-invalid-schemas)
       (prepare-schemas)
       (add-resource-type-for-fhir-schemas)))

(defn- next-timeout
  "Timeout calculation for retrying like in kafka.
  https://kafka.js.org/docs/retry-detailed"
  [timeout]
  (let [factor 0.2
        multiplier 2]
    (* (rand-int-between
        (* timeout (- 1 factor))
        (* timeout (+ 1 factor)))
       multiplier)))

(defn- retry [f & {:keys [timeout trials]
                   :or   {timeout 3000
                          trials  3}}]
  (if (zero? (dec trials))
    (f)
    (try
      (f)
      (catch Throwable _
        (Thread/sleep ^long timeout)
        (retry f {:timeout (next-timeout timeout)
                  :trials  (dec trials)})))))

(defn fetch-n-parse [url opts]
  (let [result (retry #(http.client/get url {:headers {"Authorization" (str "Basic " (:auth opts))}}))]
    (some-> result :body parse-json)))

(defn skip-root-package [packages]
  (rest packages))

(defn get-fhir-version [package]
  (let [allowed-base-packages #{"hl7.fhir.r4.core" "hl7.fhir.r4b.core" "hl7.fhir.r5.core"}]
    (->> (keys (:dependencies package))
         (map name)
         (filter #(contains? allowed-base-packages %))
         first)))

(defn enrich-schema-with-fhir-version [schema version]
  (if version
    (assoc schema :fhir-version version)
    (assoc schema :fhir-version (:package schema))))

(defmethod retrieve :url
  [{:keys [source]} {:keys [exit] :as opts}]
  (let [extract-link (fn [package] (-> package :href))
        extract-name (fn [package] (str (:name package) "#" (:version package)))
        fhir-packages (try
                        (println "Downloading list of dependencies from:" source)
                        (-> (fetch-n-parse source opts)
                            (skip-root-package))

                        (catch Exception _
                          (println
                           "ERROR: Cannot download FHIR packages. You might have provided the wrong source or forgotten to provide an authentication token.")
                          (exit 1)
                          []))]
    (->> fhir-packages
         ;; TODO using pmap for side effects is questionable
         (map (fn [package]
                (let [base-package-name (get-fhir-version package)
                      schemas (fetch-n-parse (extract-link package) opts)]
                  (println "Downloading schemas for:" (extract-name package))
                  (map #(enrich-schema-with-fhir-version % base-package-name)  schemas))))
         (flatten))))
