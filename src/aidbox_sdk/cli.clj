(ns aidbox-sdk.cli
  (:require
   [clojure.tools.cli :as cli]
   [clojure.string :as str]))

(def cli-options
  [["-a" "--auth-token BASE64_string" "Base64 of username:password"
    :validate [(complement nil?) "auth token is required"]]
   ["-o" "--output-dir Output directory" "Output directory"
    :default "out"]
   ["-h" "--help"]])

(def supported-commands #{"generate"})
(def supported-languages #{"dotnet" "python" "typescript" "java"})

(defn validate-args [args]
  (let [[command target-language input] args]
    (cond-> []
      (not= "generate" command)
      (conj (str "Please provide one of the supported commands: "
                 (str/join ", " supported-commands)))

      (not (contains? supported-languages target-language))
      (conj (str "Please provide one of the supported target languages: "
                 (str/join ", " supported-languages)))

      (nil? input)
      (conj "Please provide a source of fhir packages"))))

(defn print-errors [errors]
  (binding [*out* *err*]
    (doseq [e errors]
      (println "ERROR:" e))))

(defn help [summary]
  (println "Generate Aidbox SDK from FHIR schemas")
  (println)
  (println "USAGE")
  (println "aidbox-sdk generate <target-language> <input-source> [options]")
  (println)
  (println "OPTIONS")
  (println summary))

(defn app [{:keys [exit generate]} args]
  (let [{:keys [options arguments summary errors]} (cli/parse-opts args cli-options)
        errors (into errors (validate-args args))
        [command target-language input] arguments]
    (cond
      (:help options)
      (do (help summary)
          (exit 0))

      (and
       (seq arguments)
       (seq errors))
      (do
        (print-errors errors)
        (exit 1))

      (= command "generate")
      (try
        (generate (keyword target-language) input (assoc options :exit exit))
        (exit 0)

        (catch Throwable e
          (print-errors e)
          (exit 1)))

      :else
      (do (help summary)
          (exit 0)))))
