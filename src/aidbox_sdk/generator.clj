(ns aidbox-sdk.generator)

;;
;; main
;;

(defprotocol CodeGenerator
  (generate-datatypes [this ir-schemas])
  (generate-resource-module [this ir-schema])
  (generate-search-params [this search-schemas fhir-schemas])
  (generate-constraints [this constraint-schemas ir-schemas])
  (generate-sdk-files [this]))
