(ns aidbox-sdk.core
  (:gen-class)
  (:require
   [clojure.tools.cli :as cli]
   [aidbox-sdk.generator :as generator]))

(defn -main [& args]
  (let [[source target] (cli/parse-opts args nil)]
    (generator/build-all! nil)))
