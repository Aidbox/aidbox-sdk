(ns aidbox-sdk.core
  (:gen-class)
  (:require
   [clojure.java.io :as io]
   [aidbox-sdk.generator :as generator]))

(set! *warn-on-reflection* true)

(defn url?
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

(defn -main [& args]
  (let [[input output] args]
    (cond
      (nil? input)
      (binding [*out* *err*]
        (println "Error: please provide an input argument"))

      (nil? output)
      (binding [*out* *err*]
        (println "Error: please provide an output argument"))

      :else
      (do
        (println "Building FHIR SDK...")
        (generator/build-all!
         (resource input)
         (io/as-file output))
        (println "Finished succesfully!")
        (System/exit 0)))))
