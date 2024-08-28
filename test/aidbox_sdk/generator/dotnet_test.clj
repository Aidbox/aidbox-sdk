(ns aidbox-sdk.generator.dotnet-test
  (:require
   [aidbox-sdk.fixtures.schemas :as fixtures]
   [aidbox-sdk.generator :as sut]
   [aidbox-sdk.generator.dotnet :refer [generator] :as gen.dotnet]
   [matcho.core :as matcho]
   [clojure.java.io :as io]
   [clojure.test :refer [deftest is testing]]))

(deftest test-apply-constraints
  (testing "base schema is a specialization schema"

    (def constraints
      [{:package "hl7.fhir.r4.core",
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
     (gen.dotnet/apply-constraints constraints base)
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
     (gen.dotnet/apply-constraints constraints base)
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

(deftest test-generate-property
  (testing "simple case"
    (is (= "public bool? Active { get; set; }"
           (gen.dotnet/generate-property {:name "active",
                                          :base "Patient",
                                          :array false,
                                          :required false,
                                          :value "bool"}))))

  (testing "required"
    (is (= "public required string Type { get; set; }"
           (gen.dotnet/generate-property {:name "type",
                                          :base "Patient_Link",
                                          :array false,
                                          :required true,
                                          :value "string"}))))

  (testing "array optional"
    (is (= "public Base.Address[]? Address { get; set; }"
           (gen.dotnet/generate-property {:name "address",
                                          :base "Patient",
                                          :array true,
                                          :required false,
                                          :value "Base.Address"}))))

  (testing "array required"
    (is (= "public required Extension[] Extension { get; set; }"
           (gen.dotnet/generate-property {:name "extension",
                                          :base "Element",
                                          :array true,
                                          :required true,
                                          :value "Extension"
                                          :type "Extension"}))))

  (testing "element with literal"
    ;; TODO
    )

  (testing "element with meta"
    ;; TODO
    )

  (testing "element with choices"
    ;; TODO
    ))

#_(deftest test-generate-class

    (testing ""))

(deftest test-generate-datatypes
  (is
   (= (sut/generate-datatypes generator [fixtures/coding-ir-schema])
      [{:path (io/file "Base.cs"),
        :content
        "namespace Aidbox.FHIR.Base;\n\npublic class Coding : Element\n{\n    public string? Code { get; set; }\n    public string? System { get; set; }\n    public string? Display { get; set; }\n    public string? Version { get; set; }\n    public bool? UserSelected { get; set; }\n}"}])))

(deftest test-generate-resources
  (is
   (= (sut/generate-resource-module generator fixtures/patient-ir-schema)
      {:path (io/file "hl7-fhir-r4-core/Patient.cs"),
       :content
       "using Aidbox.FHIR.Base;\nusing Aidbox.FHIR.Utils;\n\nnamespace Aidbox.FHIR.R4.Core;\n\npublic class Patient : DomainResource, IResource\n{\n    public bool? MultipleBirthBoolean { get; set; }\n    public Base.Address[]? Address { get; set; }\n    public string? DeceasedDateTime { get; set; }\n    public Base.ResourceReference? ManagingOrganization { get; set; }\n    public bool? DeceasedBoolean { get; set; }\n    public Base.HumanName[]? Name { get; set; }\n    public string? BirthDate { get; set; }\n    public int? MultipleBirthInteger { get; set; }\n    public object? MultipleBirth    \n    {\n        get\n        {\n            if (MultipleBirthBoolean is not null)\n            {\n                return MultipleBirthBoolean;\n            }\n    \n            if (MultipleBirthInteger is not null)\n            {\n                return MultipleBirthInteger;\n            }\n    \n            return null;\n        }\n    \n        set\n        {\n            if (value?.GetType() == typeof(bool))\n            {\n                MultipleBirthBoolean = (bool)value;\n                return;\n            }\n    \n            if (value?.GetType() == typeof(int))\n            {\n                MultipleBirthInteger = (int)value;\n                return;\n            }\n    \n            throw new ArgumentException(\"Invalid type provided\");\n        }\n    }\n    public object? Deceased    \n    {\n        get\n        {\n            if (DeceasedDateTime is not null)\n            {\n                return DeceasedDateTime;\n            }\n    \n            if (DeceasedBoolean is not null)\n            {\n                return DeceasedBoolean;\n            }\n    \n            return null;\n        }\n    \n        set\n        {\n            if (value?.GetType() == typeof(string))\n            {\n                DeceasedDateTime = (string)value;\n                return;\n            }\n    \n            if (value?.GetType() == typeof(bool))\n            {\n                DeceasedBoolean = (bool)value;\n                return;\n            }\n    \n            throw new ArgumentException(\"Invalid type provided\");\n        }\n    }\n    public Base.Attachment[]? Photo { get; set; }\n    public Patient_Link[]? Link { get; set; }\n    public bool? Active { get; set; }\n    public Patient_Communication[]? Communication { get; set; }\n    public Base.Identifier[]? Identifier { get; set; }\n    public Base.ContactPoint[]? Telecom { get; set; }\n    public Base.ResourceReference[]? GeneralPractitioner { get; set; }\n    public string? Gender { get; set; }\n    public Base.CodeableConcept? MaritalStatus { get; set; }\n    public Patient_Contact[]? Contact { get; set; }\n\n    public class Patient_Link : BackboneElement\n    {\n        public required string Type { get; set; }\n        public required Base.ResourceReference Other { get; set; }\n    }\n\n    public class Patient_Communication : BackboneElement\n    {\n        public required Base.CodeableConcept Language { get; set; }\n        public bool? Preferred { get; set; }\n    }\n\n    public class Patient_Contact : BackboneElement\n    {\n        public Base.HumanName? Name { get; set; }\n        public string? Gender { get; set; }\n        public Base.Period? Period { get; set; }\n        public Base.Address? Address { get; set; }\n        public Base.ContactPoint[]? Telecom { get; set; }\n        public Base.ResourceReference? Organization { get; set; }\n        public Base.CodeableConcept[]? Relationship { get; set; }\n    }\n}"})))

(deftest test-generate-search-params
  (is
   (= (sut/generate-search-params generator fixtures/patient-search-params-ir-schemas)
      [{:path (io/file "search/PatientSearchParameters.cs"),
        :content
        "namespace Aidbox.FHIR.Search;\n\npublic class PatientSearchParameters : DomainResourceSearchParameters\n{\n    public string? Id { get; set; }\n    public string? Active { get; set; }\n    public string? Address { get; set; }\n    public string? AddressCity { get; set; }\n    public string? AddressCountry { get; set; }\n    public string? AddressPostalcode { get; set; }\n    public string? AddressState { get; set; }\n    public string? AddressUse { get; set; }\n    public string? Age { get; set; }\n    public string? BirthOrderBoolean { get; set; }\n    public string? Birthdate { get; set; }\n    public string? DeathDate { get; set; }\n    public string? Deceased { get; set; }\n    public string? Email { get; set; }\n    public string? Ethnicity { get; set; }\n    public string? Family { get; set; }\n    public string? Gender { get; set; }\n    public string? GeneralPractitioner { get; set; }\n    public string? Given { get; set; }\n    public string? Identifier { get; set; }\n    public string? Language { get; set; }\n    public string? Link { get; set; }\n    public string? MothersMaidenName { get; set; }\n    public string? Name { get; set; }\n    public string? Organization { get; set; }\n    public string? PartAgree { get; set; }\n    public string? Phone { get; set; }\n    public string? Phonetic { get; set; }\n    public string? Race { get; set; }\n    public string? Telecom { get; set; }\n}"}])))

;; TODO
#_(deftest generate-constraints
    (is
     (= (sut/generate-constraints generator fixtures/some-sonstraint-ir-schema)
        {:path (io/file "hl7-fhir-r4-core/Patient.cs"),
         :content
         "using Aidbox.FHIR.Base;\nusing Aidbox.FHIR.Utils;\n\nnamespace Aidbox.FHIR.R4.Core;\n\npublic class Patient : DomainResource, IResource\n{\n    public bool? MultipleBirthBoolean { get; set; }\n    public Base.Address[]? Address { get; set; }\n    public string? DeceasedDateTime { get; set; }\n    public Base.ResourceReference? ManagingOrganization { get; set; }\n    public bool? DeceasedBoolean { get; set; }\n    public Base.HumanName[]? Name { get; set; }\n    public string? BirthDate { get; set; }\n    public int? MultipleBirthInteger { get; set; }\n    public object? MultipleBirth    \n    {\n        get\n        {\n            if (MultipleBirthBoolean is not null)\n            {\n                return MultipleBirthBoolean;\n            }\n    \n            if (MultipleBirthInteger is not null)\n            {\n                return MultipleBirthInteger;\n            }\n    \n            return null;\n        }\n    \n        set\n        {\n            if (value?.GetType() == typeof(bool))\n            {\n                MultipleBirthBoolean = (bool)value;return;\n            }\n    \n            if (value?.GetType() == typeof(int))\n            {\n                MultipleBirthInteger = (int)value;return;\n            }\n    \n            throw new ArgumentException(\"Invalid type provided\");\n        }\n    }\n    public object? Deceased    \n    {\n        get\n        {\n            if (DeceasedDateTime is not null)\n            {\n                return DeceasedDateTime;\n            }\n    \n            if (DeceasedBoolean is not null)\n            {\n                return DeceasedBoolean;\n            }\n    \n            return null;\n        }\n    \n        set\n        {\n            if (value?.GetType() == typeof(string))\n            {\n                DeceasedDateTime = (string)value;return;\n            }\n    \n            if (value?.GetType() == typeof(bool))\n            {\n                DeceasedBoolean = (bool)value;return;\n            }\n    \n            throw new ArgumentException(\"Invalid type provided\");\n        }\n    }\n    public Base.Attachment[]? Photo { get; set; }\n    public Patient_Link[]? Link { get; set; }\n    public bool? Active { get; set; }\n    public Patient_Communication[]? Communication { get; set; }\n    public Base.Identifier[]? Identifier { get; set; }\n    public Base.ContactPoint[]? Telecom { get; set; }\n    public Base.ResourceReference[]? GeneralPractitioner { get; set; }\n    public string? Gender { get; set; }\n    public Base.CodeableConcept? MaritalStatus { get; set; }\n    public Patient_Contact[]? Contact { get; set; }\n\n    public class Patient_Link : BackboneElement\n    {\n        public required string Type { get; set; }\n        public required Base.ResourceReference Other { get; set; }\n    }\n\n    public class Patient_Communication : BackboneElement\n    {\n        public required Base.CodeableConcept Language { get; set; }\n        public bool? Preferred { get; set; }\n    }\n\n    public class Patient_Contact : BackboneElement\n    {\n        public Base.HumanName? Name { get; set; }\n        public string? Gender { get; set; }\n        public Base.Period? Period { get; set; }\n        public Base.Address? Address { get; set; }\n        public Base.ContactPoint[]? Telecom { get; set; }\n        public Base.ResourceReference? Organization { get; set; }\n        public Base.CodeableConcept[]? Relationship { get; set; }\n    }\n}"})))
