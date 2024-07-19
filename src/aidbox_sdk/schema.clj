(ns aidbox-sdk.schema
  (:require [clojure.data.json :as json]
            [clojure.java.io :as io]
            [clojure.string :as str]))

(defn get-packages-from-directory
  "Returns all packages in the given directory, including files in subdirectories.
   NOTE: right now it'll filter out all files which do not contains hl7.fhir
   in their name."
  [path]
  (->> path
       file-seq
       (remove #(.isDirectory %))
       ;; FIXME is this really good approach to determine packages?
       (filter #(str/includes? (.getName %) "hl7.fhir"))
       ;; FIXME only gzip, but there is no problem to accept unpacked ndjson
       (filter #(str/ends-with? (.getName %) ".gz"))))

(defn create-gzip-reader [path]
  (-> path
      (io/input-stream)
      (java.util.zip.GZIPInputStream.)
      (io/reader)))

(defn parse-package [path]
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
  (->> (get-packages-from-directory source)
       (map parse-package)
       (flatten)
       (remove-invalid-schemas)
       (prepare-schemas)
       (merge-duplicates)))

(defmethod retrieve java.net.URL
  [source]
  (do "something"))