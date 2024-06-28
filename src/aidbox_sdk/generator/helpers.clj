(ns aidbox-sdk.generator.helpers
  (:require
   [clojure.string :as str]))

(defn words
  "Takes a string and makes collection of words.

  \\p{Lu} and \\p{Lt} are \"Unicode properties\" which mean uppercase letter and
  titlecase letter accordingly.
  About unicode properties: https://www.regular-expressions.info/unicode.html#category"
  [s]
  (remove str/blank? (str/split s #"(?=[\p{Lu}\p{Lt}])|[-_\s]")))

(defn ->pascal-case [s]
  (str/join (map str/capitalize (words s))))

(defn uppercase-first-letter
  "NOTE: Do not confuse with capitalize function."
  [string]
  (str (str/upper-case (first string)) (subs string 1)))

(defn vector-to-map [v]
  (->> (map (fn [item] (hash-map (:url item) item)) v)
       (into {})))

(defn safe-conj [a b] (conj a (or b {})))
