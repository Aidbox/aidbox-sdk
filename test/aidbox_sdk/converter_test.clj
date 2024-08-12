(ns aidbox-sdk.converter-test
  (:require
   [clojure.test :refer [deftest is]]
   [aidbox-sdk.fixtures.schemas :as fixtures]
   [aidbox-sdk.converter :as sut]))


(deftest resolve-reference-test
  (is (= (sut/resolve-references fixtures/schemas-with-element-reference)
         fixtures/schemas-with-element-reference-resolved)))
