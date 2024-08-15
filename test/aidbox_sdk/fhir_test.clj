(ns aidbox-sdk.fhir-test
  (:require [aidbox-sdk.fhir :as sut]
            [clojure.test :as t :refer [deftest testing is run-tests]]))


(deftest test-fhir-helper-functions

  (testing "something"
    (is (= 1 1)
        "One should be equal one")
    )
  )


(comment

  (run-tests)
  )
