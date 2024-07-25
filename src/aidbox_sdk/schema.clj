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

(defn merge-duplicates [schemas]
  (->> schemas
       (group-by :url)
       (map (fn [[_url same-url-schemas]]
              (apply merge same-url-schemas)))))

(defn prepare-schemas [schemas]
  (map #(->> (get-in % [:package-meta :name])
             (assoc  %  :package))
       schemas))

(defmulti retrieve :type)

(defmethod retrieve :file
  [{:keys [source]}]
  (println "Retrieving packages from: " (str source))
  (->> (get-packages-from-directory (io/as-file source))
       (mapv parse-package)
       (verify/check-compatibility!)
       (flatten)
       (remove-invalid-schemas)
       (prepare-schemas)
       (merge-duplicates)))

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

(defn fetch-n-parse [url]
  (let [result (retry #(http.client/get url))]
    (some-> result :body parse-json)))

(defn skip-root-package [packages]
  (rest packages))

(defmethod retrieve :url
  [{:keys [source]}]
  (let [extract-link (fn [package] (-> package :href))
        extract-name (fn [package] (str (:name package) "#" (:version package)))
        fhir-packages (do
                        (println "Downloading list of dependencies from:" source)
                        (-> (fetch-n-parse source)
                            (skip-root-package)))]

    (->> fhir-packages
         (pmap (fn [package]
                 (println "Downloading schemas for:" (extract-name package))
                 (fetch-n-parse (extract-link package))))
         (flatten))))
