(ns aidbox-sdk.generator
  (:require
   [clojure.java.io :as io]))

(defn prepare-sdk-files [target-language files]
  (for [file files]
    {:path file
     :content (slurp
               (io/resource
                (str "sdk/" (name target-language) "/" file)))}))

;;
;; main
;;

(defprotocol CodeGenerator
  (generate-datatypes [this ir-schemas])
  (generate-resource-module [this ir-schema])
  (generate-search-params [this ir-schemas])
  (generate-constraints [this ir-schemas])
  (generate-sdk-files [this ir-schemas])
  (generate-valuesets [this vs-schemas]))
