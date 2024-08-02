(ns aidbox-sdk.core
  (:gen-class)
  (:require
   [aidbox-sdk.cli :as cli]))

;; Need for GraalVM
(set! *warn-on-reflection* true)

(def ctx {:exit (fn [status] (System/exit status))})

(defn -main [& args]
  (cli/app ctx args))
