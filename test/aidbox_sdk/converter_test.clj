(ns aidbox-sdk.converter-test
  (:require
   [aidbox-sdk.converter :as sut]
   [aidbox-sdk.fixtures :as fixt]
   [aidbox-sdk.fixtures.schemas :as fixtures]
   [clojure.test :refer [deftest is testing use-fixtures]]
   [matcho.core :refer [match]]))

(use-fixtures :once fixt/prepare-examples)

(deftest test-resolve-element-references
  (match
   (sut/resolve-element-references
    {:elements
     {:component
      {:type "BackboneElement",
       :array true,
       :summary true,
       :elements
       {:referenceRange
        {:array true,
         :elementReference
         ["http://hl7.org/fhir/StructureDefinition/Observation"
          "elements"
          "referenceRange"]}}}}})
    {:elements
     {:component
      {:type "BackboneElement",
       :array true,
       :summary true,
       :elements {:referenceRange {:array true, :type "Reference"}}}}}))

(deftest test-resolve-dependencies
  (testing "simple case"
    (is (= #{"Address"
             "Attachment"
             "Period"
             "CodeableConcept"
             "ContactPoint"
             "HumanName"
             "DomainResource"
             "Reference"
             "Identifier"
             "BackboneElement"}
           (-> (sut/resolve-dependencies [(dissoc (fixt/get-data :patient-ir-schema) :deps)])
               first
               :deps))))

  (testing "another package"
    (is (= #{"Address"
             "Attachment"
             "Period"
             "CodeableConcept"
             "ContactPoint"
             "HumanName"
             "DomainResource"
             "Reference"
             "Identifier"
             "BackboneElement"}
           (-> (sut/resolve-dependencies [(dissoc (fixt/get-data :patient-ir-schema) :deps)])
               first
               :deps))))

  (testing "another package specialization demanding base types"
    (is (= #{"Resource" "Element"}
           (-> (sut/resolve-dependencies [(fixt/get-data :sdc-question-library-ir-schema-no-deps)])
               first
               :deps)))))

(deftest test-url->resource-name
  (testing "one word"
    (is (= "Immunization"
           (sut/url->resource-name "http://hl7.org/fhir/StructureDefinition/Immunization"))))

  (testing "multiple words"
    (is (= "Test-Report"
           (sut/url->resource-name "http://hl7.org/fhir/StructureDefinition/TestReport"))))

  (testing "with abbreviation"
    (is (= "open-EHR-exposure-Date"
           (sut/url->resource-name "http://hl7.org/fhir/StructureDefinition/openEHR-exposureDate"))))

  (testing "with digits"
    (is (= "iso21090-ADXP-delivery-Address-Line"
           (sut/url->resource-name "http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-deliveryAddressLine"))))

  (testing "starting with digit"
    (is (= "schema-11179-object-Class-Property"
           (sut/url->resource-name "http://hl7.org/fhir/StructureDefinition/11179-objectClassProperty")))))

(deftest test-resolve-choices
  (is (= fixtures/schemas-with-element-choices-resolved
         (sut/resolve-choices fixtures/schemas-with-element-choices))))

(deftest test-backbones-flattening
  (is (= fixtures/flattened-backbone-elements
         (sut/flatten-backbones fixtures/unflattened-backbone-elements []))))

(deftest test-convert
  (testing "convert resource"
    (match (sut/convert [fixtures/patient-fhir-schema]
                        {"hl7.fhir.r4.core"
                         #{"http://hl7.org/fhir/ValueSet/administrative-gender"}})

      [fixtures/patient-ir-schema]))

  (testing "convert constraint"
    (match
     (sut/convert [(fixt/get-data :organization-preferred-contact-fhir-schema)] #{})
      [(fixt/get-data :organization-preferred-contact-ir-schema)])))

(deftest test-apply-constraints
  (testing "constraints"
    (match (vals fixtures/observation-constraints-ir-schema)
      (sut/apply-constraints [fixtures/observation-ir-schema]
                             fixtures/observation-constraints)))

  (testing "another package constraints"
    ;; TODO
    (is (= ["hl7.fhir.r5.core" "hl7.fhir.us.core" "hl7.fhir.us.core"]
           (map :package (sut/apply-constraints
                          [fixtures/observation-ir-schema]
                          [(fixt/get-data :vitalsigns-fhir-schema)
                           (fixt/get-data :us-core-vital-signs-fhir-schema)
                           (fixt/get-data :us-core-bmi-fhir-schema)]))))))

(deftest test-sort-by-base
  (match
   (sut/sort-by-base
    [{:url "http://hl7.org/fhir/StructureDefinition/Resource" :base nil}
     {:url "http://hl7.org/fhir/StructureDefinition/Element" :base nil}
     {:url "http://hl7.org/fhir/StructureDefinition/SampledData"
      :base "http://hl7.org/fhir/StructureDefinition/Element"}])

    [{:url "http://hl7.org/fhir/StructureDefinition/Resource", :base nil}
     {:url "http://hl7.org/fhir/StructureDefinition/Element", :base nil}
     {:url "http://hl7.org/fhir/StructureDefinition/SampledData",
      :base "http://hl7.org/fhir/StructureDefinition/Element"}]))

(deftest test-collect-dependencies
  (match
   (sut/collect-dependencies (fixt/get-data :patient-ir-schema))
    #{"Address"
      "Attachment"
      "Period"
      "CodeableConcept"
      "ContactPoint"
      "HumanName"
      "DomainResource"
      "Reference"
      "Identifier"
      "BackboneElement"}))

(comment
  (fixt/load-data!)

  @fixt/data

  (keys @fixt/data)

  ::close)
