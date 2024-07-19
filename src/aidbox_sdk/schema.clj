(ns aidbox-sdk.schema
  (:require [clojure.data.json :as json]
            [clojure.java.io :as io]
            [clojure.string :as str]))

(defn get-directory-files [path]
  (->> path
       file-seq
       (remove #(.isDirectory %))))

(defn fetch-packages [source-path]
  (->> source-path
       (get-directory-files)
       (remove #(.isDirectory %))
       ;; FIXME is this really good approach to determine packages?
       (filter #(str/includes? (.getName %) "hl7.fhir"))))

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

(defn merge-duplicates [schemas]
  (->> schemas
       (group-by :url)
       (map (fn [[_url same-url-schemas]]
              (apply merge same-url-schemas)))))


(defmulti retrieve class)

(defmethod retrieve java.io.File
  [source]
  (->> (fetch-packages source)
       (map parse-package)
       (flatten)
       (remove #(nil? (:package-meta %)))
       (map (fn [schema]
              (assoc schema :package (get-in schema [:package-meta :name]))))
       (merge-duplicates)))

(defmethod retrieve java.net.URL
  [source]
  (do "something"))
