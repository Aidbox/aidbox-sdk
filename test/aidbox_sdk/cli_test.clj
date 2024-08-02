(ns aidbox-sdk.cli-test
  (:require [aidbox-sdk.cli :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest cli-helpers-test

  (testing "validate-args"
    (is (= (sut/validate-args [])
           ["Please provide input argument"
            "Please provide output argument"]))

    (is (= (sut/validate-args ["resource/schemas"])
           ["Please provide output argument"]))

    (is (= (sut/validate-args ["resource/schemas" "distee"])
           []))

    (is (= (sut/validate-args ["resource/schemas" "distee" "-h"])
           []))

    #_(is (= (sut/validate-args ["resource/schemas" "-h"])
             ["Please provide output argument"]))))
