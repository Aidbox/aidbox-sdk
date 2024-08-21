(ns aidbox-sdk.core
  (:gen-class)
  (:require
   [aidbox-sdk.cli :as cli]
   [aidbox-sdk.fhir :as fhir]
   [aidbox-sdk.converter :as converter]
   [aidbox-sdk.generator :as generator]
   [aidbox-sdk.generator.dotnet]
   [aidbox-sdk.schema :as importer]
   [clojure.java.io :as io]))

;; Need for GraalVM
(set! *warn-on-reflection* true)

;;
;; I/O Helpers
;;

(defn save-to-file! [path content]
  (io/make-parents path)
  (spit path content))

(defn create-directory! [dir]
  (when-not (.mkdir dir)
    (throw (Exception. (str "Can't create directory: " dir)))))

(defn delete-directory!
  "Recursively delete a directory."
  [^java.io.File file]
  (when (.exists file)
    (when (.isDirectory file)
      (run! delete-directory! (.listFiles file)))
    (io/delete-file file)))

(defn prepare-output-directory! [dir]
  (delete-directory! dir)
  (create-directory! dir))

(defn generate [target-language input options]
  (let [output-dir (io/file (:output-dir options))
        all-schemas (importer/retrieve (importer/resource input)
                                       {:auth (:auth-token options)})
        fhir-schemas (filter fhir/fhir-schema? all-schemas)
        resources-schemas (->> fhir-schemas
                               (filter fhir/base-schema?)
                               (filter fhir/domain-resource?))
        resources-ir-schemas (converter/convert resources-schemas)
        generate-resource-module (fn [ir-schema]
                                   (generator/generate-resource-module target-language ir-schema))]

    (prepare-output-directory! output-dir)

    (println "Building FHIR SDK...")

    (doseq [{:keys [path content]}
            (map generate-resource-module resources-ir-schemas)]
      (save-to-file! (io/file output-dir path) content))

    (println "Finished succesfully!")))

(def system {:exit (fn [status] (System/exit status))
             :generate generate})

(defn -main [& args]
  (cli/app system args))
