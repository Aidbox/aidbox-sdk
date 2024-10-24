(ns aidbox-sdk.schema.verify-test
  (:require [aidbox-sdk.schema.verify :as sut :refer [simplify-package-meta]]
            [matcher-combinators.test :refer [match? thrown-match?]]
            [clojure.test :refer [deftest is testing]]))

(def r4-core-package
  {:name         "hl7.fhir.r4.core"
   :version      "4.0.1"
   :fhirVersions ["4.0.1"]
   :type         "fhir.core"
   :dependencies []})

(def us-core-package
  {:name         "hl7.fhir.us.core"
   :version      "4.1.0"
   :fhirVersions ["4.0.1"]
   :type         "fhir.ig"
   :dependencies [":hl7.fhir.r4.core#4.0.1"
                  ":us.nlm.vsac#0.3.0"
                  ":hl7.fhir.uv.sdc#2.7.0"]})

(def us-mcode-package
  {:name         "hl7.fhir.us.mcode"
   :version      "2.1.0"
   :fhirVersions ["4.0.1"]
   :type         "fhir.ig"
   :dependencies [":hl7.fhir.r4.core#4.0.1"
                  ":hl7.terminology.r4#5.0.0"]})

(deftest versions-match?-test
  (testing "version match according to semver"
    (is (sut/versions-match? "1.0.0" "1.0.0"))
    (is (sut/versions-match? "1.0.1" "1.0"))

    (is (not (sut/versions-match? "1.1" "1.0")))
    (is (not (sut/versions-match? "2.0" "1.0")))

    (is (not (sut/versions-match? "2" "2.0.0")))))

(deftest extract-meta-from-package-test
  (testing "TODO"
    (is true)))

(deftest find-core-package-test
  (testing "throws an exception if no core package found"
    (is (thrown-match? clojure.lang.ExceptionInfo
                       {}
                       (sut/find-core-package [us-core-package]))))

  (testing "throws an exception if more then one core package found"
    (let [r5-core-package {:name    "hl7.fhir.r5.core"
                           :version "5.0.0"
                           :type    "fhir.core"}]
      (is (thrown-match? clojure.lang.ExceptionInfo
                         {:packages [(simplify-package-meta r4-core-package)
                                     (simplify-package-meta r5-core-package)]}
                         (sut/find-core-package [r4-core-package
                                                 r5-core-package])))))

  (testing "returns a core package iff there is only one"
    (is (match? (sut/find-core-package [r4-core-package
                                        us-core-package])
                r4-core-package))))

(deftest find-extra-packages-test
  (testing "throws an exception if there is duplicate"
    (let [us-core-package' (assoc us-core-package :version "5.1.0")]
      (is (thrown-match? clojure.lang.ExceptionInfo
                         {:packages [(:name us-core-package)]}
                         (sut/find-extra-packages [r4-core-package
                                                   us-core-package
                                                   us-core-package'])))))

  (testing "returns extra packages if there is no duplicates"
    (is (match? (sut/find-extra-packages [r4-core-package
                                          us-core-package])
                [us-core-package]))))

(deftest find-core-package-mismatch-test
  (testing "returns a vec with mismatched names"
    (let [us-mcode-package (assoc us-mcode-package :fhirVersions ["4.1.0"])]
      (is (match? (sut/find-core-package-mismatch "4.0.1"
                                                  [us-core-package
                                                   us-mcode-package])
                  [(assoc us-mcode-package :match-with-core? false)]))))

  (testing "returns an empty vec when fhirVersions is not specified"
    (let [us-mcode-package (assoc us-mcode-package :fhirVersions [])]
      (is (match? (sut/find-core-package-mismatch "4.0.1"
                                                  [us-core-package
                                                   us-mcode-package])
                  []))))

  (testing "returns an empty vec when all matched"
    (is (match? (sut/find-core-package-mismatch "4.0.1"
                                                [us-core-package
                                                 us-mcode-package])
                [])))

  (testing "returns an empty vec when major and minor match"
    (is (match? (sut/find-core-package-mismatch "4.0"
                                                [us-core-package
                                                 us-mcode-package])
                []))))

(deftest find-dependencies-mismatch-test
  (let [us-vsac-package {:name "us.nlm.vsac", :version "0.3.0"}
        uv-sdc-package  {:name "hl7.fhir.uv.sdc", :version "2.7.0"}
        term-package    {:name "hl7.terminology.r4", :version "5.0.0"}]
    (testing "returns a vec with mismatched names and version"
      (testing "when required package was not found"
        (is (match? (sut/find-dependencies-mismatch [r4-core-package
                                                     us-core-package
                                                     us-mcode-package])
                    [(assoc us-core-package :failed-dependencies
                            [{:required (simplify-package-meta us-vsac-package)
                              :found    []}
                             {:required (simplify-package-meta uv-sdc-package)
                              :found    []}])

                     (assoc us-mcode-package :failed-dependencies
                            [{:required (simplify-package-meta term-package)
                              :found    []}])])))

      (testing "when required package is found, but version do not match"
        (let [uv-sdc-package' (assoc uv-sdc-package :version "2.8.0")
              term-package'   (assoc term-package :version "5.1.0")]
          (is (match? (sut/find-dependencies-mismatch [r4-core-package
                                                       us-core-package
                                                       us-mcode-package
                                                       us-vsac-package
                                                       uv-sdc-package'
                                                       term-package'])
                      [(assoc us-core-package :failed-dependencies
                              [{:required  (simplify-package-meta uv-sdc-package)
                                :found    [(simplify-package-meta uv-sdc-package')]}])

                       (assoc us-mcode-package :failed-dependencies
                              [{:required  (simplify-package-meta term-package)
                                :found    [(simplify-package-meta term-package')]}])])))))

    (testing "returns an empty vec when no dependencies"
      (is (match? (sut/find-dependencies-mismatch [r4-core-package])
                  [])))

    (testing "returns an empty vec when all matched"
      (is (match? (sut/find-dependencies-mismatch [r4-core-package
                                                   us-core-package
                                                   us-mcode-package
                                                   us-vsac-package
                                                   uv-sdc-package
                                                   term-package])
                  [])))))
