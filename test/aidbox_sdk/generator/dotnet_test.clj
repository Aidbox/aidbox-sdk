(ns aidbox-sdk.generator.dotnet-test
  (:require
   [clojure.test :refer [deftest is testing]]
   [aidbox-sdk.generator.dotnet :as sut]))

(deftest test-generate-property
  (testing "simple case"
    (is (= "public bool? Active { get; set; }"
           (sut/generate-property {:name "active",
                                   :base "Patient",
                                   :array false,
                                   :required false,
                                   :value "bool"}))))

  (testing "with required"
    (is (= "public required string Type { get; set; }"
           (sut/generate-property {:name "type",
                                   :base "Patient_Link",
                                   :array false,
                                   :required true,
                                   :value "string"}))))

  (testing "array"
    (is (= "public Base.Address[]? Address { get; set; }"
           (sut/generate-property {:name "address",
                                   :base "Patient",
                                   :array true,
                                   :required false,
                                   :value "Base.Address"}))))

  (testing "element with literal"
    ;; TODO
    )

  (testing "element with meta"
    ;; TODO
    )

  (testing "element with choices"
    ;; TODO
    ))

#_
(deftest test-generate-class

  (testing "")

  )
