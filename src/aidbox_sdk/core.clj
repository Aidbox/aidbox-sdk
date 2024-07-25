(ns aidbox-sdk.core
  (:gen-class)
  (:require
   [clojure.java.io :as io]
   [clojure.tools.cli :as cli]
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


(def cli-options
  [["-a" "--auth BASE64_string" "Base64 of username:password"
    :validate [(complement nil?) "auth token is required"]]
   ["-h" "--help"]])

(defn -main [& args]
  (let [{:keys [options summary]} (cli/parse-opts args cli-options)
        [input output] args]
    (when (:help options)
      (println "Generate Aidbox SDK from FHIR schemas")
      (println)
      (println "USAGE")
      (println "aidbox-sdk <input-source> <output-dir> [options]")
      (println)
      (println "OPTIONS")
      (println summary)
      (System/exit 0))

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

(comment
  (-main "http://localhost:8765/sdk/fhir-packages" "disteee")

  (-main "-h")

  )
