(ns aidbox-sdk.generator)

;;
;; main
;;

(defprotocol CodeGenerator
  (generate-datatypes [this schemas])
  (generate-resource-module [this schema])
  (generate-search-params [this search-schemas fhir-schemas])
  (generate-constraints [this constraint-schemas ir-schemas])
  (generate-sdk-files [this]))

#_(defmethod build-all! :dotnet [& {:keys [auth input output]}]
    (let [output                (io/file output)
          search-parameters-dir (io/file output "search")
          all-schemas           (schema/retrieve
                                 (schema/resource input)
                                 {:auth auth})
          fhir-schemas          (filter fhir/fhir-schema? all-schemas)
          search-params-schemas (filter fhir/search-parameter? all-schemas)
          constraints           (filter #(and (fhir/constraint? %)
                                              (not (fhir/extension? %))) all-schemas)]

      (gen/prepare-target-directory! output)

    ;; create base namespace (all FHIR datatypes) file
      (println "---")
      (println "Generating Datatypes")
      (->> all-schemas
           (filter base-schema?)
           (converter/convert)
           (sort-by :base)
           (generate-base-namespace)
           (save-to-file!
            (io/file output "Base.cs")))

    ;; create spezialization files
      (println "Generating resource classes")
      (doseq [item (->> fhir-schemas
                        (filter base-schema?)
                        (filter domain-resource?)
                        (converter/convert)
                        ((fn [schemas]
                           (->> schemas
                                (map (fn [schema]
                                       (update schema :base #(str % ", IResource"))))))))]

        (save-to-file!
         (io/file output (package->directory (:package item)) (str (:name item) ".cs"))
         (generate-resource-namespace item)))

    ;; create resource map file
      (println "Generating resource map")
      (->> all-schemas
           (filter base-schema?)
           (filter domain-resource?)
           (into constraints)
           (remove (fn [schema]
                     (= (:base schema) "http://hl7.org/fhir/StructureDefinition/Bundle")))
           (converter/convert)
           (map #(hash-map
                  :type (str (package->namespace (:package %))
                             "."
                             (->pascal-case (url->resource-type (:url %))))
                  :name (->pascal-case (url->resource-type (:url %)))))
           (generate-utils-namespace)
           (save-to-file!
            (io/file output "ResourceMap.cs")))

    ;; create search parameters classes
      (doseq [item (search-parameters-classes search-params-schemas
                                              all-schemas)]
        (save-to-file!
         (io/file search-parameters-dir (str (:resource-type item) "SearchParameters.cs"))
         (:class-file-content item)))

    ;; create constraints
      (println "Generating constraints classes")
      (doseq [{:keys [name schema file-content]}
              (->> (apply-constraints
                    (filter fhir/fhir-schema? constraints)
                    (->> (filter fhir/fhir-schema? all-schemas)
                         (converter/convert)
                         (vector-to-map)))
                   (mapv (fn [[name' schema]]
                           {:name name'
                            :schema schema
                            :file-content (generate-constraint-namespace
                                           (assoc schema
                                                  :url name'))})))]
        (gen/save-to-file!
         (io/file output
                  (package->directory (:package schema))
                  (str (->pascal-case (url->resource-type name)) ".cs"))
         file-content))

      (println "Generating common SDK files")
      (doseq [file dotnettpl/files]
        (spit (io/file output (:name file)) (:content file)))))
