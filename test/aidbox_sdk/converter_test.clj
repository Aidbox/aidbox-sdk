(ns aidbox-sdk.converter-test
  (:require
   [aidbox-sdk.converter :as sut]
   [aidbox-sdk.fixtures :as fixt]
   [matcho.core :refer [match]]
   [aidbox-sdk.fixtures.schemas :as fixtures]
   [clojure.test :refer [deftest is testing use-fixtures]]))

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
    (match (sut/convert [fixtures/patient-fhir-schema])
      [fixtures/patient-ir-schema]))

  (testing "convert constraint"
    (is (= [(fixt/get-data :organization-preferred-contact-ir-schema)]
           (sut/convert [(fixt/get-data :organization-preferred-contact-fhir-schema)])))))

(deftest test-convert-constraints
  (testing "constraints"
    (match (vals fixtures/observation-constraints-ir-schema)
      (sut/apply-constraints [fixtures/observation-ir-schema]
                             fixtures/observation-constraints))))

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

(comment
  (fixt/load-data!)

  @fixt/data

  ::close)
