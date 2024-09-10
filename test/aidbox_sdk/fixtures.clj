(ns aidbox-sdk.fixtures
  (:require
   [clojure.edn :as edn]
   [clojure.java.io :as io]
   [clojure.string :as str]))

(def data (atom {}))

(defn get-data [key]
  (get @data key))

(defn load-data! []
  (let [ex-dir (io/file "test/aidbox_sdk/fixtures")]
    (->> (.listFiles ex-dir)
         (filter #(not (str/ends-with? (.getPath %) ".clj")))
         (reduce (fn [acc file]
                   (assoc acc
                          (keyword
                           (str/replace
                            (str/replace (.getName file) #".edn" "") #"_" "-"))
                          (edn/read-string
                           (slurp file))))
                 {})
         (reset! data))))

(defn prepare-examples [f]
  (load-data!)
  (f)
  (reset! data {}))
