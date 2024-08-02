(ns aidbox-sdk.cli
  (:require
   [clojure.tools.cli :as cli]
   [aidbox-sdk.generator :as generator]))

(def cli-options
  [["-a" "--auth BASE64_string" "Base64 of username:password"
    :validate [(complement nil?) "auth token is required"]]
   ["-h" "--help"]])

(defn validate-args [[input output]]
  (cond-> []
    (nil? input)  (conj "Please provide input argument")
    (nil? output) (conj "Please provide output argument")))

(defn print-errors [errors]
  (binding [*out* *err*]
    (doseq [e errors]
      (println "ERROR:" e))))

(defn help [summary]
  (println "Generate Aidbox SDK from FHIR schemas")
  (println)
  (println "USAGE")
  (println "aidbox-sdk <input-source> <output-dir> [options]")
  (println)
  (println "OPTIONS")
  (println summary))

(defn build [options arguments]
  (let [[input output] arguments]
    (println "Building FHIR SDK...")
    (generator/build-all! :auth  (:auth options)
                          :input input
                          :output output)
    (println "Finished succesfully!")))

(defn app [{:keys [exit]} args]
  (let [{:keys [options arguments summary errors]} (cli/parse-opts args cli-options)
        errors (into errors
                     (validate-args args))]
    (cond
      (:help options)
      (do (help summary)
          (exit 0))

      (seq errors)
      (do
        (print-errors errors)
        (exit 1))

      :else
      (try
        (build options arguments)
        (exit 0)

        (catch Throwable e
          (print-errors [e])
          (exit 1))))))
