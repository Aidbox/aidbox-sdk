(ns aidbox-sdk.generator.dotnet-test
  (:require
   [aidbox-sdk.fixtures.schemas :as fixtures]
   [aidbox-sdk.generator :as sut]
   [aidbox-sdk.generator.dotnet :refer [generator] :as gen.dotnet]
   [clojure.java.io :as io]
   [clojure.test :refer [deftest is testing]]))

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

(deftest generate-datatypes
  (is
   (= (sut/generate-datatypes generator [fixtures/coding-ir-schema])
      [{:path (io/file "Base.cs"),
        :content
        "namespace Aidbox.FHIR.Base;\n\npublic class Coding : Element\n{\n    public string? Code { get; set; }\n    public string? System { get; set; }\n    public string? Display { get; set; }\n    public string? Version { get; set; }\n    public bool? UserSelected { get; set; }\n}"}])))

(deftest generate-resources
  (is
   (= (sut/generate-resource-module generator fixtures/patient-ir-schema)
      {:path (io/file "hl7-fhir-r4-core/Patient.cs"),
       :content
       "using Aidbox.FHIR.Base;\nusing Aidbox.FHIR.Utils;\n\nnamespace Aidbox.FHIR.R4.Core;\n\npublic class Patient : DomainResource, IResource\n{\n    public bool? MultipleBirthBoolean { get; set; }\n    public Base.Address[]? Address { get; set; }\n    public string? DeceasedDateTime { get; set; }\n    public Base.ResourceReference? ManagingOrganization { get; set; }\n    public bool? DeceasedBoolean { get; set; }\n    public Base.HumanName[]? Name { get; set; }\n    public string? BirthDate { get; set; }\n    public int? MultipleBirthInteger { get; set; }\n    public object? MultipleBirth    \n    {\n        get\n        {\n            if (MultipleBirthBoolean is not null)\n            {\n                return MultipleBirthBoolean;\n            }\n    \n            if (MultipleBirthInteger is not null)\n            {\n                return MultipleBirthInteger;\n            }\n    \n            return null;\n        }\n    \n        set\n        {\n            if (value?.GetType() == typeof(bool))\n            {\n                MultipleBirthBoolean = (bool)value;\n                return;\n            }\n    \n            if (value?.GetType() == typeof(int))\n            {\n                MultipleBirthInteger = (int)value;\n                return;\n            }\n    \n            throw new ArgumentException(\"Invalid type provided\");\n        }\n    }\n    public object? Deceased    \n    {\n        get\n        {\n            if (DeceasedDateTime is not null)\n            {\n                return DeceasedDateTime;\n            }\n    \n            if (DeceasedBoolean is not null)\n            {\n                return DeceasedBoolean;\n            }\n    \n            return null;\n        }\n    \n        set\n        {\n            if (value?.GetType() == typeof(string))\n            {\n                DeceasedDateTime = (string)value;\n                return;\n            }\n    \n            if (value?.GetType() == typeof(bool))\n            {\n                DeceasedBoolean = (bool)value;\n                return;\n            }\n    \n            throw new ArgumentException(\"Invalid type provided\");\n        }\n    }\n    public Base.Attachment[]? Photo { get; set; }\n    public Patient_Link[]? Link { get; set; }\n    public bool? Active { get; set; }\n    public Patient_Communication[]? Communication { get; set; }\n    public Base.Identifier[]? Identifier { get; set; }\n    public Base.ContactPoint[]? Telecom { get; set; }\n    public Base.ResourceReference[]? GeneralPractitioner { get; set; }\n    public string? Gender { get; set; }\n    public Base.CodeableConcept? MaritalStatus { get; set; }\n    public Patient_Contact[]? Contact { get; set; }\n\n    public class Patient_Link : BackboneElement\n    {\n        public required string Type { get; set; }\n        public required Base.ResourceReference Other { get; set; }\n    }\n\n    public class Patient_Communication : BackboneElement\n    {\n        public required Base.CodeableConcept Language { get; set; }\n        public bool? Preferred { get; set; }\n    }\n\n    public class Patient_Contact : BackboneElement\n    {\n        public Base.HumanName? Name { get; set; }\n        public string? Gender { get; set; }\n        public Base.Period? Period { get; set; }\n        public Base.Address? Address { get; set; }\n        public Base.ContactPoint[]? Telecom { get; set; }\n        public Base.ResourceReference? Organization { get; set; }\n        public Base.CodeableConcept[]? Relationship { get; set; }\n    }\n}"})))

(deftest generate-search-params
  (is
   (= (sut/generate-search-params generator fixtures/patient-search-params-schemas
                                  [fixtures/patient-fhir-schema])
      [{:path (io/file "search/PatientSearchParameters.cs"),
        :content
        "namespace Aidbox.FHIR.Search;\n\npublic class PatientSearchParameters : DomainResourceSearchParameters\n{\n    public string? Active { get; set; }\n    public string? Address { get; set; }\n    public string? AddressCity { get; set; }\n    public string? AddressCountry { get; set; }\n    public string? AddressPostalcode { get; set; }\n    public string? AddressState { get; set; }\n    public string? AddressUse { get; set; }\n    public string? Birthdate { get; set; }\n    public string? DeathDate { get; set; }\n    public string? Deceased { get; set; }\n    public string? Email { get; set; }\n    public string? Ethnicity { get; set; }\n    public string? Family { get; set; }\n    public string? Gender { get; set; }\n    public string? GeneralPractitioner { get; set; }\n    public string? Given { get; set; }\n    public string? Id { get; set; }\n    public string? Identifier { get; set; }\n    public string? Language { get; set; }\n    public string? Link { get; set; }\n    public string? Name { get; set; }\n    public string? Organization { get; set; }\n    public string? PartAgree { get; set; }\n    public string? Phone { get; set; }\n    public string? Phonetic { get; set; }\n    public string? Race { get; set; }\n    public string? Telecom { get; set; }\n}"}])))

;; TODO
#_(deftest generate-constraints
    (is
     (= (sut/generate-constraints generator fixtures/some-sonstraint-ir-schema)
        {:path (io/file "hl7-fhir-r4-core/Patient.cs"),
         :content
         "using Aidbox.FHIR.Base;\nusing Aidbox.FHIR.Utils;\n\nnamespace Aidbox.FHIR.R4.Core;\n\npublic class Patient : DomainResource, IResource\n{\n    public bool? MultipleBirthBoolean { get; set; }\n    public Base.Address[]? Address { get; set; }\n    public string? DeceasedDateTime { get; set; }\n    public Base.ResourceReference? ManagingOrganization { get; set; }\n    public bool? DeceasedBoolean { get; set; }\n    public Base.HumanName[]? Name { get; set; }\n    public string? BirthDate { get; set; }\n    public int? MultipleBirthInteger { get; set; }\n    public object? MultipleBirth    \n    {\n        get\n        {\n            if (MultipleBirthBoolean is not null)\n            {\n                return MultipleBirthBoolean;\n            }\n    \n            if (MultipleBirthInteger is not null)\n            {\n                return MultipleBirthInteger;\n            }\n    \n            return null;\n        }\n    \n        set\n        {\n            if (value?.GetType() == typeof(bool))\n            {\n                MultipleBirthBoolean = (bool)value;return;\n            }\n    \n            if (value?.GetType() == typeof(int))\n            {\n                MultipleBirthInteger = (int)value;return;\n            }\n    \n            throw new ArgumentException(\"Invalid type provided\");\n        }\n    }\n    public object? Deceased    \n    {\n        get\n        {\n            if (DeceasedDateTime is not null)\n            {\n                return DeceasedDateTime;\n            }\n    \n            if (DeceasedBoolean is not null)\n            {\n                return DeceasedBoolean;\n            }\n    \n            return null;\n        }\n    \n        set\n        {\n            if (value?.GetType() == typeof(string))\n            {\n                DeceasedDateTime = (string)value;return;\n            }\n    \n            if (value?.GetType() == typeof(bool))\n            {\n                DeceasedBoolean = (bool)value;return;\n            }\n    \n            throw new ArgumentException(\"Invalid type provided\");\n        }\n    }\n    public Base.Attachment[]? Photo { get; set; }\n    public Patient_Link[]? Link { get; set; }\n    public bool? Active { get; set; }\n    public Patient_Communication[]? Communication { get; set; }\n    public Base.Identifier[]? Identifier { get; set; }\n    public Base.ContactPoint[]? Telecom { get; set; }\n    public Base.ResourceReference[]? GeneralPractitioner { get; set; }\n    public string? Gender { get; set; }\n    public Base.CodeableConcept? MaritalStatus { get; set; }\n    public Patient_Contact[]? Contact { get; set; }\n\n    public class Patient_Link : BackboneElement\n    {\n        public required string Type { get; set; }\n        public required Base.ResourceReference Other { get; set; }\n    }\n\n    public class Patient_Communication : BackboneElement\n    {\n        public required Base.CodeableConcept Language { get; set; }\n        public bool? Preferred { get; set; }\n    }\n\n    public class Patient_Contact : BackboneElement\n    {\n        public Base.HumanName? Name { get; set; }\n        public string? Gender { get; set; }\n        public Base.Period? Period { get; set; }\n        public Base.Address? Address { get; set; }\n        public Base.ContactPoint[]? Telecom { get; set; }\n        public Base.ResourceReference? Organization { get; set; }\n        public Base.CodeableConcept[]? Relationship { get; set; }\n    }\n}"})))
