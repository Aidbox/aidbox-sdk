(ns aidbox-sdk.converter-test
  (:require
   [aidbox-sdk.converter :as sut]
   [aidbox-sdk.fixtures :as fixt]
   [matcho.core :refer [match]]
   [aidbox-sdk.fixtures.schemas :as fixtures]
   [clojure.test :refer [are deftest is testing use-fixtures]]))

(use-fixtures :once fixt/prepare-examples)

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
      (sut/url->resource-name "http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-deliveryAddressLine")

      "us-core-patient-6-0-0"
      (sut/url->resource-name "http://hl7.org/fhir/us/core/structuredefinition/us-core-patient|6.0.0"))))

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
    (is (= [(fixt/get-data :organization-preferred-contact-ir-schema)]
           (sut/convert [(fixt/get-data :organization-preferred-contact-fhir-schema)])))))

(deftest test-convert-constraints
  (testing "constraints"
    (is
     (= fixtures/observation-constraints-ir-schema
        (sut/convert-constraints fixtures/observation-constraints
                                 [fixtures/observation-ir-schema])))))

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
