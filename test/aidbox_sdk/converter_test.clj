(ns aidbox-sdk.converter-test
  (:require
   [clojure.test :refer [deftest is are testing]]
   [aidbox-sdk.fixtures.schemas :as fixtures]
   [aidbox-sdk.converter :as sut]))

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
  (is (= (sut/resolve-references fixtures/schemas-with-element-reference)
         fixtures/schemas-with-element-reference-resolved)))

(deftest test-resolve-choices
  (is (= (sut/resolve-choices fixtures/schemas-with-element-choices)
         fixtures/schemas-with-element-choices-resolved)))

(deftest test-backbones-flattening
  (is (= (sut/flatten-backbones fixtures/unflattened-backbone-elements [])
         fixtures/flattened-backbone-elements)))

(deftest test-convert
  (testing "convert resource"
    (is (= (sut/convert [fixtures/patient-fhir-schema])

           [fixtures/patient-ir-schema])))

  (testing "convert constraint"
    (is (= (sut/convert [fixtures/organization-preferred-contact-fhir-schema])
           [fixtures/organization-preferred-contact-ir-schema]))))
