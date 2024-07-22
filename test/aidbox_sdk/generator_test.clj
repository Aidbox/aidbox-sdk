(ns aidbox-sdk.generator-test
  (:require  [clojure.test :refer [deftest testing]]
             [matcho.core :as matcho]
             [aidbox-sdk.generator :as sut]))

(deftest apply-constraints-test
  (testing "base schema is a specialization schema"

    (def constraints [{:package "hl7.fhir.r4.core",
                       :derivation "constraint",
                       :excluded ["value"],
                       :type "Extension",
                       :elements
                       {:extension
                        {:slicing
                         {:slices
                          {:code
                           {:schema
                            {:scalar true,
                             :excluded ["extension"],
                             :required ["value"],
                             :type "Extension",
                             :elements
                             {:url {:fixed "code", :type "uri"},
                              :valueCodeableConcept
                              {:required-element true, :type "CodeableConcept", :choiceOf "value"},
                              :value {:choices ["valueCodeableConcept"]}}},
                            :min 0,
                            :max 1,
                            :match {:type "pattern", :value {:url "code"}}},
                           :period
                           {:schema
                            {:scalar true,
                             :excluded ["extension"],
                             :required ["value"],
                             :type "Extension",
                             :elements
                             {:url {:fixed "period", :type "uri"},
                              :valuePeriod
                              {:required-element true, :type "Period", :choiceOf "value"},
                              :value {:choices ["valuePeriod"]}}},
                            :min 0,
                            :max 1,
                            :match {:type "pattern", :value {:url "period"}}}},
                          :discriminator [{:type "value", :path "url"}],
                          :rules "open"}},
                        :url
                        {:fixed "http://hl7.org/fhir/StructureDefinition/patient-nationality"}},
                       :id "patient-nationality",
                       :kind "complex-type",
                       :url "http://hl7.org/fhir/StructureDefinition/patient-nationality",
                       :base "http://hl7.org/fhir/StructureDefinition/Extension"}])

    (def base {"http://hl7.org/fhir/StructureDefinition/Extension"
               {:package "hl7.fhir.r4.core",
                :derivation "specialization",
                :name "Extension",
                :type "Extension",
                :elements
                [{:name "valueBase64Binary",
                  :base "Extension",
                  :array false,
                  :required false,
                  :value "string"}],
                :url "http://hl7.org/fhir/StructureDefinition/Extension",
                :backbone-elements [],
                :base "http://hl7.org/fhir/StructureDefinition/Element"}})

    (matcho/match
     (sut/apply-constraints constraints base)
      {"http://hl7.org/fhir/StructureDefinition/patient-nationality"
       {:package "hl7.fhir.r4.core",
        :derivation "specialization",
        :name "Extension",
        :type "Extension",
        :elements
        [{:name "meta",
          :required true,
          :value "Meta",
          :meta
          " = new() { Profile = [\"http://hl7.org/fhir/StructureDefinition/patient-nationality\"] };"}
         {:name "valueBase64Binary",
          :base "Extension",
          :array false,
          :required false,
          :value "string"}]
        :url "http://hl7.org/fhir/StructureDefinition/Extension",
        :base "http://hl7.org/fhir/StructureDefinition/Element"}}))

  (testing "base schema is a constraint schema"
    (def constraints [{:package "hl7.fhir.us.mcode",
                       :derivation "constraint",
                       :fhirVersion "4.0.1",
                       :name "SecondaryCancerCondition",
                       :type "Condition",
                       :resourceType "StructureDefinition",
                       :title "Secondary Cancer Condition Profile",
                       :status "active",
                       :id "mcode-secondary-cancer-condition",
                       :kind "resource",
                       :url
                       "http://hl7.org/fhir/us/mcode/StructureDefinition/mcode-secondary-cancer-condition",
                       :base "http://hl7.org/fhir/us/core/StructureDefinition/us-core-condition",
                       :version "2.1.0",
                       :fqn "hl7.fhir.us.mcode#2.1.0/mcode-secondary-cancer-condition"}])

    (def base {"http://hl7.org/fhir/us/core/StructureDefinition/us-core-condition"
               {:package "hl7.fhir.us.core",
                :derivation "constraint",
                :fhirVersion "4.0.1",
                :jurisdiction [{:coding [{:system "urn:iso:std:iso:3166", :code "US"}]}],
                :name "USCoreCondition",
                :type "Condition",
                :experimental false,
                :resourceType "StructureDefinition",
                :elements {:recordedDate {:mustSupport true}}
                :title "US Core Condition Profile",
                :status "active",
                :id "us-core-condition",
                :kind "resource",
                :url "http://hl7.org/fhir/us/core/StructureDefinition/us-core-condition",
                :base "http://hl7.org/fhir/StructureDefinition/Condition",
                :version "4.1.0",
                :fqn "hl7.fhir.us.core#4.1.0/us-core-condition",
                :required ["category" "code"]}})

    (matcho/match
     (sut/apply-constraints constraints base)
      {"http://hl7.org/fhir/us/mcode/StructureDefinition/mcode-secondary-cancer-condition"
       {:package "hl7.fhir.us.mcode",
        :derivation "constraint",
        :name "USCoreCondition",
        :type "Condition",
        :experimental false,
        :resourceType "StructureDefinition",
        :elements
        [{:name "meta",
          :required true,
          :value "Meta",
          :meta
          " = new() { Profile = [\"http://hl7.org/fhir/us/mcode/StructureDefinition/mcode-secondary-cancer-condition\"] };"}
         [:recordedDate {:mustSupport true}]]
        :title "US Core Condition Profile",
        :status "active",
        :id "us-core-condition",
        :kind "resource",
        :url "http://hl7.org/fhir/us/core/StructureDefinition/us-core-condition",
        :base "http://hl7.org/fhir/StructureDefinition/Condition",
        :version "4.1.0",
        :fqn "hl7.fhir.us.core#4.1.0/us-core-condition",
        :required ["category" "code"]}})))
