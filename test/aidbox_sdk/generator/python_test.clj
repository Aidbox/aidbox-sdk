(ns aidbox-sdk.generator.python-test
  (:require
   [aidbox-sdk.fixtures.schemas :as fixtures]
   [aidbox-sdk.generator :as sut]
   [aidbox-sdk.generator.python :refer [generator] :as gen.python]
   [clojure.java.io :as io]
   [clojure.test :refer [deftest is testing]]))

(deftest test-generate-deps
  (testing "no members"
    (is (= (gen.python/generate-deps [{:module "pydantic" :members []}])
           "import pydantic")))

  (testing "with members"
    (is (= (gen.python/generate-deps [{:module "pydantic" :members ["*"]}])
           "from pydantic import *")))

  (testing "multiple deps"
    (is (= (gen.python/generate-deps [{:module "pydantic" :members ["*"]}
                                      {:module "typing" :members ["Optional" "List"]}])
           "from pydantic import *\nfrom typing import Optional, List"))))

(deftest test-generate-property
  (testing "simple case"
    (is (= "active: Optional[bool] = None"
           (gen.python/generate-property {:name "active",
                                          :base "Patient",
                                          :array false,
                                          :required false,
                                          :value "bool"
                                          :type "boolean"}))))

  (testing "required"
    (is (= "type: str"
           (gen.python/generate-property {:name "type",
                                          :base "Patient_Link",
                                          :array false,
                                          :required true,
                                          :value "string"
                                          :type "string"}))))

  (testing "array optional"
    (is (= "address: Optional[List[Address]] = None"
           (gen.python/generate-property {:name "address",
                                          :base "Patient",
                                          :array true,
                                          :required false,
                                          :value "Address"
                                          :type "Address"}))))

  (testing "array required"
    (is (= "extension: list[Extension] = []"
           (gen.python/generate-property {:name "extension",
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

(deftest test-generate-class
  (testing "base"
    (is (= (gen.python/generate-class fixtures/patient-ir-schema)
          "class Patient(DomainResource):\n    active: Optional[bool] = None\n    address: Optional[List[Address]] = None\n    birth_date: Optional[str] = None\n    communication: Optional[List[BackboneElement]] = None\n    contact: Optional[List[BackboneElement]] = None\n    \n    deceased_boolean: Optional[bool] = None\n    deceased_date_time: Optional[str] = None\n    gender: Optional[str] = None\n    general_practitioner: Optional[List[Reference]] = None\n    identifier: Optional[List[Identifier]] = None\n    link: Optional[List[BackboneElement]] = None\n    managing_organization: Optional[Reference] = None\n    marital_status: Optional[CodeableConcept] = None\n    \n    multiple_birth_boolean: Optional[bool] = None\n    multiple_birth_integer: Optional[integer] = None\n    name: Optional[List[HumanName]] = None\n    photo: Optional[List[Attachment]] = None\n    telecom: Optional[List[ContactPoint]] = None"))))

#_(deftest generate-datatypes
    (is
     (= (sut/generate-datatypes generator [fixtures/coding-ir-schema])

        [{:path (io/file "base" "__init__.py"),
          :content
          "namespace Aidbox.FHIR.Base;\n\npublic class Coding : Element\n{\n    public string? Code { get; set; }\n    public string? System { get; set; }\n    public string? Display { get; set; }\n    public string? Version { get; set; }\n    public bool? UserSelected { get; set; }\n}"}])))

(deftest test-generate-resources
  (is
   (= (sut/generate-resource-module generator fixtures/patient-ir-schema)
      {:path (io/file "hl7-fhir-r4-core/Patient.cs"),
       :content
       "using Aidbox.FHIR.Base;\nusing Aidbox.FHIR.Utils;\n\nnamespace Aidbox.FHIR.R4.Core;\n\npublic class Patient : DomainResource, IResource\n{\n    public bool? MultipleBirthBoolean { get; set; }\n    public Base.Address[]? Address { get; set; }\n    public string? DeceasedDateTime { get; set; }\n    public Base.ResourceReference? ManagingOrganization { get; set; }\n    public bool? DeceasedBoolean { get; set; }\n    public Base.HumanName[]? Name { get; set; }\n    public string? BirthDate { get; set; }\n    public int? MultipleBirthInteger { get; set; }\n    public object? MultipleBirth    \n    {\n        get\n        {\n            if (MultipleBirthBoolean is not null)\n            {\n                return MultipleBirthBoolean;\n            }\n    \n            if (MultipleBirthInteger is not null)\n            {\n                return MultipleBirthInteger;\n            }\n    \n            return null;\n        }\n    \n        set\n        {\n            if (value?.GetType() == typeof(bool))\n            {\n                MultipleBirthBoolean = (bool)value;\n                return;\n            }\n    \n            if (value?.GetType() == typeof(int))\n            {\n                MultipleBirthInteger = (int)value;\n                return;\n            }\n    \n            throw new ArgumentException(\"Invalid type provided\");\n        }\n    }\n    public object? Deceased    \n    {\n        get\n        {\n            if (DeceasedDateTime is not null)\n            {\n                return DeceasedDateTime;\n            }\n    \n            if (DeceasedBoolean is not null)\n            {\n                return DeceasedBoolean;\n            }\n    \n            return null;\n        }\n    \n        set\n        {\n            if (value?.GetType() == typeof(string))\n            {\n                DeceasedDateTime = (string)value;\n                return;\n            }\n    \n            if (value?.GetType() == typeof(bool))\n            {\n                DeceasedBoolean = (bool)value;\n                return;\n            }\n    \n            throw new ArgumentException(\"Invalid type provided\");\n        }\n    }\n    public Base.Attachment[]? Photo { get; set; }\n    public Patient_Link[]? Link { get; set; }\n    public bool? Active { get; set; }\n    public Patient_Communication[]? Communication { get; set; }\n    public Base.Identifier[]? Identifier { get; set; }\n    public Base.ContactPoint[]? Telecom { get; set; }\n    public Base.ResourceReference[]? GeneralPractitioner { get; set; }\n    public string? Gender { get; set; }\n    public Base.CodeableConcept? MaritalStatus { get; set; }\n    public Patient_Contact[]? Contact { get; set; }\n\n    public class Patient_Link : BackboneElement\n    {\n        public required string Type { get; set; }\n        public required Base.ResourceReference Other { get; set; }\n    }\n\n    public class Patient_Communication : BackboneElement\n    {\n        public required Base.CodeableConcept Language { get; set; }\n        public bool? Preferred { get; set; }\n    }\n\n    public class Patient_Contact : BackboneElement\n    {\n        public Base.HumanName? Name { get; set; }\n        public string? Gender { get; set; }\n        public Base.Period? Period { get; set; }\n        public Base.Address? Address { get; set; }\n        public Base.ContactPoint[]? Telecom { get; set; }\n        public Base.ResourceReference? Organization { get; set; }\n        public Base.CodeableConcept[]? Relationship { get; set; }\n    }\n}"})))

#_(deftest generate-search-params
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
