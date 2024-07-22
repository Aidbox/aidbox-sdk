(ns aidbox-sdk.schema
  (:require [aidbox-sdk.schema.verify :as verify]
            [clojure.data.json :as json]
            [clojure.java.io :as io]
            [clojure.string :as str]))

(defn get-packages-from-directory
  "Returns all packages in the given directory, including files in subdirectories.
   NOTE: right now it'll filter out all files which do not contains hl7.fhir
   in their name."
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
  (with-open [rdr (create-gzip-reader path)]
    (->> rdr
         line-seq
         (mapv (fn [line]
                 (json/read-str line :key-fn keyword))))))

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


(defmulti retrieve class)

;; ! According to an example here:
;; ! https://clojuredocs.org/clojure.java.io/file
;; ! it's possible to create a File instance from url, which may lead to bugs
(defmethod retrieve java.io.File
  [source]
  (println "Retrieving packages from: " (str source))
  (->> (get-packages-from-directory source)
       (mapv parse-package)
       (verify/check-compatibility!)
       (flatten)
       (remove-invalid-schemas)
       (prepare-schemas)
       (merge-duplicates)))

(defmethod retrieve java.net.URL
  [source]
  (do "something"))
