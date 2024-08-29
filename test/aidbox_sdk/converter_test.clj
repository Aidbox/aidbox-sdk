(ns aidbox-sdk.converter-test
  (:require
   [aidbox-sdk.converter :as sut]
   [aidbox-sdk.fixtures.schemas :as fixtures]
   [aidbox-sdk.generator.helpers :refer [vector->map]]
   [clojure.test :refer [are deftest is testing]]))

(deftest test-converter-utils
  (testing "url->resource-name"
    (are [x y] (= x y)
      "date"
      (sut/url->resource-name "http://hl7.org/fhir/StructureDefinition/date")

      "ContactDetail"
      (sut/url->resource-name "http://hl7.org/fhir/StructureDefinition/ContactDetail")

      "Immunization"
      (sut/url->resource-name "http://hl7.org/fhir/StructureDefinition/Immunization")

      "openEHR-exposureDate"
      (sut/url->resource-name "http://hl7.org/fhir/StructureDefinition/openEHR-exposureDate")

      "iso21090-ADXP-deliveryAddressLine"
      (sut/url->resource-name "http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-deliveryAddressLine"))))

(deftest test-resolve-references
  (is (= fixtures/schemas-with-element-reference-resolved
         (sut/resolve-references fixtures/schemas-with-element-reference))))

(deftest test-resolve-choices
  (is (= fixtures/schemas-with-element-choices-resolved
         (sut/resolve-choices fixtures/schemas-with-element-choices))))

(deftest test-backbones-flattening
  (is (= fixtures/flattened-backbone-elements
         (sut/flatten-backbones fixtures/unflattened-backbone-elements []))))

(deftest test-convert
  (testing "convert resource"
    (is (= [fixtures/patient-ir-schema]
           (sut/convert [fixtures/patient-fhir-schema]))))

  (testing "convert constraint"
    (is (= [fixtures/organization-preferred-contact-ir-schema]
           (sut/convert [fixtures/organization-preferred-contact-fhir-schema])))))

(deftest test-convert-constraints
  (testing "constraints"
    (is
     (= fixtures/observation-constraints-ir-schema
        (sut/convert-constraints fixtures/observation-constraints
                                 [fixtures/observation-ir-schema])))))
