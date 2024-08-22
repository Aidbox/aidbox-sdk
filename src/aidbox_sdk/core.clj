(ns aidbox-sdk.core
  (:gen-class)
  (:require
   [aidbox-sdk.cli :as cli]
   [aidbox-sdk.fhir :as fhir]
   [aidbox-sdk.converter :as converter]
   [aidbox-sdk.generator :as generator]
   [aidbox-sdk.generator.dotnet :as dotnet]
   [aidbox-sdk.schema :as importer]
   [clojure.java.io :as io]))

;; Need for GraalVM
(set! *warn-on-reflection* true)

;;
;; I/O Helpers
;;

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

(defn save-to-file! [path content]
  (io/make-parents path)
  (spit path content))

(defn save-files! [output-dir files]
  (doseq [{:keys [path content]} files]
    (save-to-file! (io/file output-dir path) content)))

;;
;;
;;

(defn lang->generator [lang]
  (case lang
    :dotnet dotnet/generator
    #_#_#_#_#_#_:python python/generator
            :typescript typescript/generator
        :java java/generator))

(defn generate! [target-language input options]
  (let [output-dir (io/file (:output-dir options))
        save-files! #(save-files! output-dir %)
        all-schemas (importer/retrieve (importer/resource input)
                                       {:auth (:auth-token options)})

        datatype?        (every-pred fhir/fhir-schema? fhir/base-schema? fhir/datatype?)
        domain-resource? (every-pred fhir/fhir-schema? fhir/base-schema? fhir/domain-resource?)
        constraint?      (every-pred fhir/fhir-schema? fhir/constraint? (complement fhir/extension?))

        fhir-schemas         (filter fhir/fhir-schema? all-schemas)
        datatype-schemas     (filter datatype? all-schemas)
        resource-schemas     (filter domain-resource? all-schemas)
        constraint-schemas   (filter constraint? all-schemas)
        search-param-schemas (filter fhir/search-parameter? all-schemas)

        ir-schemas           (converter/convert fhir-schemas)
        datatype-ir-schemas  (converter/convert datatype-schemas)
        resource-ir-schemas  (converter/convert resource-schemas)
        generator'           (lang->generator target-language)

        generate-resource-module #(generator/generate-resource-module generator' %)]

    (println "Preparing directories")
    (prepare-output-directory! output-dir)

    (println "Building FHIR SDK...")
    (println "---")

    (println "Generating datatypes")
    (save-files! (generator/generate-datatypes generator' datatype-ir-schemas))

    (println "Generating resources")
    (save-files! (map generate-resource-module resource-ir-schemas))

    (println "Generating constraints")
    (save-files! (generator/generate-constraints generator' constraint-schemas ir-schemas))

    (println "Generating search parameters")
    (save-files! (generator/generate-search-params generator' search-param-schemas fhir-schemas))

    (println "Generating common SDK files")
    (save-files! (generator/generate-sdk-files generator'))

    (println "Finished succesfully!")))

(def system {:exit (fn [status] (System/exit status))
             :generate generate!})

(defn -main [& args]
  (cli/app system args))
