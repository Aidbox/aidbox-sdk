(ns aidbox-sdk.generator.helpers
  (:require
   [clojure.data.json :as json]
   [clojure.string :as str]))

(set! *warn-on-reflection* true)

(defn words
  "Takes a string and makes collection of words.

  \\p{Lu} and \\p{Lt} are \"Unicode properties\" which mean uppercase letter and
  titlecase letter accordingly.
  About unicode properties: https://www.regular-expressions.info/unicode.html#category"
  [s]
  (remove str/blank? (str/split s #"(?<=[\p{Ll}])(?=[\p{Lu}\p{Lt}])|[-_\s]")))

(defn ->pascal-case [s]
  (str/join (map str/capitalize (words s))))

(defn ->snake-case [s]
  (str/join "_" (map str/lower-case (words s))))

(defn ->camel-case [s]
  (str/join (into [(first (words s))]
                  (map str/capitalize (rest (words s))))))

(defn uppercase-first-letter
  "NOTE: Do not confuse with `capitalize` and `->pascal-case` functions.
  `capitalize` function lowercasing all letters after first.
  `->pascal-case` removes all _ and - characters"
  [s]
  (str (str/upper-case (get s 0 "")) (str/join (rest s))))

(defn starts-with-capital? [^String s]
  (Character/isUpperCase (.charAt s 0)))

(defn vector->map [v]
  (update-vals (group-by :url v) first))

(defn safe-conj [a b] (conj a (or b {})))

(defn rand-int-between [min max]
  (int (+ min (Math/floor (rand (- max min))))))

(defn parse-json [s]
  (json/read-str s :key-fn keyword))
