(ns aidbox-sdk.generator.utils
  (:require [clojure.string :as str]))


(defn x2 [s] (apply str (repeat 2 s)))
(defn x3 [s] (apply str (repeat 3 s)))

(def indent
  "Default 4 spaces C# indentation."
  "    ")

(defn add-indent [s]
  (str indent s))

(defn using [& nss]
  (->> nss
       (map #(str "using " % ";"))
       (str/join "\n")))

(defn namespace [nsn]
  (str "namespace " nsn ";"))
