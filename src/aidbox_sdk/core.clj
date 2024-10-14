(ns aidbox-sdk.core
  (:gen-class)
  (:require
   [aidbox-sdk.cli :as cli]
   [aidbox-sdk.converter :as converter]
   [aidbox-sdk.fhir :as fhir]
   [aidbox-sdk.generator :as generator]
   [aidbox-sdk.generator.java :as java]
   [aidbox-sdk.generator.dotnet :as dotnet]
   [aidbox-sdk.generator.python :as python]
   [aidbox-sdk.generator.typescript :as typescript]
   [aidbox-sdk.schema :as importer]
   [clojure.java.io :as io]))

;; Need for GraalVM
(set! *warn-on-reflection* true)

;;
;; I/O Helpers
;;

(defn create-directory! [^java.io.File dir]
  (io/make-parents dir)
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

(defn lang->generator [lang]
  (case lang
    :dotnet dotnet/generator
    :python python/generator
    :typescript typescript/generator
    :java java/generator))

(defn generate! [target-language input options]
  (let [output-dir (io/file (:output-dir options))
        save-files! #(save-files! output-dir %)
        all-schemas (importer/retrieve (importer/resource input)
                                       {:auth (:auth-token options)
                                        :exit (:exit options)})

        base-type?       (every-pred fhir/fhir-schema? fhir/base-type?)
        datatype?        (every-pred fhir/fhir-schema? fhir/datatype? (complement fhir/primitive-type?))
        constraint?      (every-pred fhir/fhir-schema? fhir/constraint? (complement fhir/extension?))
        search-param?    (every-pred fhir/search-parameter? (complement fhir/search-parameter-from-extension?))

        fhir-schemas         (filter fhir/fhir-schema? all-schemas)
        base-schemas         (filter base-type?        all-schemas)
        datatype-schemas     (filter datatype?         all-schemas)
        constraint-schemas   (filter constraint?       all-schemas)
        search-param-schemas (filter search-param?     all-schemas)
        resource-schemas     (filter #(and
                                       (fhir/fhir-schema? %)
                                       (not (fhir/base-type? %))
                                       (not (fhir/datatype? %))
                                       (or (fhir/resource-type? %)
                                           (fhir/domain-resource? %)
                                           (fhir/backbone-element? %)))
                                     all-schemas)

        ir-schemas              (converter/convert fhir-schemas)
        base-ir-schemas         (converter/convert base-schemas)
        datatype-ir-schemas     (converter/convert datatype-schemas)
        resource-ir-schemas     (converter/convert resource-schemas)
        search-param-ir-schemas (converter/convert-search-params search-param-schemas
                                                                 fhir-schemas)
        constraint-ir-schemas   (converter/apply-constraints
                                 (filter fhir/specialization? ir-schemas)
                                 constraint-schemas)

        generator' (lang->generator target-language)

        generate-resource-module #(generator/generate-resource-module generator' %)]

    (println "Preparing directories")
    (prepare-output-directory! output-dir)

    (println "Building FHIR SDK...")
    (println "---")

    (println "Generating datatypes")
    (save-files! (generator/generate-datatypes
                  generator'
                  (converter/sort-by-base
                   (into base-ir-schemas datatype-ir-schemas))))

    (println "Generating resources")
    (save-files! (map generate-resource-module resource-ir-schemas))

    (println "Generating constraints")
    (save-files! (generator/generate-constraints generator' constraint-ir-schemas))

    (println "Generating search parameters")
    (save-files! (generator/generate-search-params generator' search-param-ir-schemas))

    (println "Generating common SDK files")
    (save-files! (generator/generate-sdk-files generator' ir-schemas))

    (println "Finished succesfully!")
    (println "Output dir: " (.getAbsolutePath output-dir))))

(def system {:exit (fn [status] (System/exit status))
             :generate generate!})

(defn -main [& args]
  (cli/app system args))
