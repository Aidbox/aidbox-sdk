(ns aidbox-sdk.generator.utils
  (:require [clojure.string :as str]))


(defn x2 [s] (apply str (repeat 2 s)))

(def indent
  "Default 4 spaces C# indentation."
  "    ")

(defn using [& nss]
  (->> nss
       (map #(str "using " % ";"))
       (str/join "\n")))

(defn namespace [nsn]
  (str "namespace " nsn ";"))
