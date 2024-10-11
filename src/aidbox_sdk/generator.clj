(ns aidbox-sdk.generator
  (:require
   [aidbox-sdk.utils :as u]
   [clojure.java.io :as io]))

(defn prepare-sdk-files [target-language]
  (let [base-dir (io/file "resources" "sdk" (name target-language))]
    (->> base-dir
         u/list-files
         (map (fn [file]
                {:path (.toFile (u/get-relative-path base-dir file))
                 :content (slurp file)})))))

;;
;; main
;;

(defprotocol CodeGenerator
  (generate-datatypes [this ir-schemas])
  (generate-resource-module [this ir-schema])
  (generate-search-params [this ir-schemas])
  (generate-constraints [this ir-schemas])
  (generate-sdk-files [this ir-schemas]))
