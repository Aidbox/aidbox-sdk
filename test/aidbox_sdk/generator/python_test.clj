(ns aidbox-sdk.generator.python-test
  (:require
   [aidbox-sdk.fixtures.schemas :as fixtures]
   [aidbox-sdk.generator :as sut]
   [aidbox-sdk.generator.python :refer [generator] :as gen.python]
   [clojure.java.io :as io]
   [clojure.test :refer [deftest is testing]]))

(deftest test-generate-deps
  (testing "no members"
    (is (= "import pydantic"
           (gen.python/generate-deps [{:module "pydantic" :members []}]))))

  (testing "with members"
    (is (= "from pydantic import *"
           (gen.python/generate-deps [{:module "pydantic" :members ["*"]}]))))

  (testing "multiple deps"
    (is (= "from pydantic import *\nfrom typing import Optional, List"
           (gen.python/generate-deps [{:module "pydantic" :members ["*"]}
                                      {:module "typing" :members ["Optional" "List"]}])))))

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
    (is (= "class Patient(DomainResource):\n    active: Optional[bool] = None\n    address: Optional[List[Address]] = None\n    birth_date: Optional[str] = None\n    communication: Optional[List[BackboneElement]] = None\n    contact: Optional[List[BackboneElement]] = None\n    deceased_boolean: Optional[bool] = None\n    deceased_date_time: Optional[str] = None\n    gender: Optional[str] = None\n    general_practitioner: Optional[List[Reference]] = None\n    identifier: Optional[List[Identifier]] = None\n    link: Optional[List[BackboneElement]] = None\n    managing_organization: Optional[Reference] = None\n    marital_status: Optional[CodeableConcept] = None\n    multiple_birth_boolean: Optional[bool] = None\n    multiple_birth_integer: Optional[int] = None\n    name: Optional[List[HumanName]] = None\n    photo: Optional[List[Attachment]] = None\n    telecom: Optional[List[ContactPoint]] = None"
           (gen.python/generate-class fixtures/patient-ir-schema)

           )))

  (testing "with inner classes"
    (is (= "class Patient_Link(BackboneElement):\n    other: Reference\n    type: str\n\nclass Patient_Communication(BackboneElement):\n    language: CodeableConcept\n    preferred: Optional[bool] = None\n\nclass Patient_Contact(BackboneElement):\n    address: Optional[Address] = None\n    gender: Optional[str] = None\n    name: Optional[HumanName] = None\n    organization: Optional[Reference] = None\n    period: Optional[Period] = None\n    relationship: Optional[List[CodeableConcept]] = None\n    telecom: Optional[List[ContactPoint]] = None\n\nclass Patient(DomainResource):\n    active: Optional[bool] = None\n    address: Optional[List[Address]] = None\n    birth_date: Optional[str] = None\n    communication: Optional[List[BackboneElement]] = None\n    contact: Optional[List[BackboneElement]] = None\n    deceased_boolean: Optional[bool] = None\n    deceased_date_time: Optional[str] = None\n    gender: Optional[str] = None\n    general_practitioner: Optional[List[Reference]] = None\n    identifier: Optional[List[Identifier]] = None\n    link: Optional[List[BackboneElement]] = None\n    managing_organization: Optional[Reference] = None\n    marital_status: Optional[CodeableConcept] = None\n    multiple_birth_boolean: Optional[bool] = None\n    multiple_birth_integer: Optional[int] = None\n    name: Optional[List[HumanName]] = None\n    photo: Optional[List[Attachment]] = None\n    telecom: Optional[List[ContactPoint]] = None"
           (gen.python/generate-class fixtures/patient-ir-schema
                                      ["class Patient_Link(BackboneElement):\n    other: Reference\n    type: str"
                                       "class Patient_Communication(BackboneElement):\n    language: CodeableConcept\n    preferred: Optional[bool] = None"
                                       "class Patient_Contact(BackboneElement):\n    address: Optional[Address] = None\n    gender: Optional[str] = None\n    name: Optional[HumanName] = None\n    organization: Optional[Reference] = None\n    period: Optional[Period] = None\n    relationship: Optional[List[CodeableConcept]] = None\n    telecom: Optional[List[ContactPoint]] = None"])))))

(deftest test-generate-datatypes
  (is
   (= [{:path (io/file "base/__init__.py"),
        :content
        "from pydantic import *\nfrom typing import Optional, List\n\nclass Coding(Element):\n    code: Optional[str] = None\n    display: Optional[str] = None\n    system: Optional[str] = None\n    user_selected: Optional[bool] = None\n    version: Optional[str] = None"}]
      (sut/generate-datatypes generator [fixtures/coding-ir-schema]))))

(deftest test-generate-resources
  (is
   (= {:path (io/file "hl7-fhir-r4-core/Patient.py"),
       :content
       "from pydantic import *\nfrom typing import Optional, List\nfrom ..base import *\n\nclass Patient_Link(BackboneElement):\n    other: Reference\n    type: str\n\nclass Patient_Communication(BackboneElement):\n    language: CodeableConcept\n    preferred: Optional[bool] = None\n\nclass Patient_Contact(BackboneElement):\n    address: Optional[Address] = None\n    gender: Optional[str] = None\n    name: Optional[HumanName] = None\n    organization: Optional[Reference] = None\n    period: Optional[Period] = None\n    relationship: Optional[List[CodeableConcept]] = None\n    telecom: Optional[List[ContactPoint]] = None\n\nclass Patient(DomainResource):\n    active: Optional[bool] = None\n    address: Optional[List[Address]] = None\n    birth_date: Optional[str] = None\n    communication: Optional[List[BackboneElement]] = None\n    contact: Optional[List[BackboneElement]] = None\n    deceased_boolean: Optional[bool] = None\n    deceased_date_time: Optional[str] = None\n    gender: Optional[str] = None\n    general_practitioner: Optional[List[Reference]] = None\n    identifier: Optional[List[Identifier]] = None\n    link: Optional[List[BackboneElement]] = None\n    managing_organization: Optional[Reference] = None\n    marital_status: Optional[CodeableConcept] = None\n    multiple_birth_boolean: Optional[bool] = None\n    multiple_birth_integer: Optional[int] = None\n    name: Optional[List[HumanName]] = None\n    photo: Optional[List[Attachment]] = None\n    telecom: Optional[List[ContactPoint]] = None"}
      (sut/generate-resource-module generator fixtures/patient-ir-schema))))

(deftest test-generate-search-params
  (is
   (= [{:path (io/file "search/PatientSearchParameters.py"),
        :content
        "from typing import Optional\n\nclass PatientSearchParameters(DomainResourceSearchParameters):\n    id: Optional[str] = None\n    active: Optional[str] = None\n    address: Optional[str] = None\n    address_city: Optional[str] = None\n    address_country: Optional[str] = None\n    address_postalcode: Optional[str] = None\n    address_state: Optional[str] = None\n    address_use: Optional[str] = None\n    age: Optional[str] = None\n    birth_order_boolean: Optional[str] = None\n    birthdate: Optional[str] = None\n    death_date: Optional[str] = None\n    deceased: Optional[str] = None\n    email: Optional[str] = None\n    ethnicity: Optional[str] = None\n    family: Optional[str] = None\n    gender: Optional[str] = None\n    general_practitioner: Optional[str] = None\n    given: Optional[str] = None\n    identifier: Optional[str] = None\n    language: Optional[str] = None\n    link: Optional[str] = None\n    mothers_maiden_name: Optional[str] = None\n    name: Optional[str] = None\n    organization: Optional[str] = None\n    part_agree: Optional[str] = None\n    phone: Optional[str] = None\n    phonetic: Optional[str] = None\n    race: Optional[str] = None\n    telecom: Optional[str] = None"}]
      (sut/generate-search-params generator fixtures/patient-search-params-ir-schemas))))

#_(deftest generate-constraints
    (is
     (= (sut/generate-constraints generator fixtures/some-constraint-ir-schema)
        {:path (io/file "hl7-fhir-r4-core/Patient.cs"),
         :content
         "using Aidbox.FHIR.Base;\nusing Aidbox.FHIR.Utils;\n\nnamespace Aidbox.FHIR.R4.Core;\n\npublic class Patient : DomainResource, IResource\n{\n    public bool? MultipleBirthBoolean { get; set; }\n    public Base.Address[]? Address { get; set; }\n    public string? DeceasedDateTime { get; set; }\n    public Base.ResourceReference? ManagingOrganization { get; set; }\n    public bool? DeceasedBoolean { get; set; }\n    public Base.HumanName[]? Name { get; set; }\n    public string? BirthDate { get; set; }\n    public int? MultipleBirthInteger { get; set; }\n    public object? MultipleBirth    \n    {\n        get\n        {\n            if (MultipleBirthBoolean is not null)\n            {\n                return MultipleBirthBoolean;\n            }\n    \n            if (MultipleBirthInteger is not null)\n            {\n                return MultipleBirthInteger;\n            }\n    \n            return null;\n        }\n    \n        set\n        {\n            if (value?.GetType() == typeof(bool))\n            {\n                MultipleBirthBoolean = (bool)value;return;\n            }\n    \n            if (value?.GetType() == typeof(int))\n            {\n                MultipleBirthInteger = (int)value;return;\n            }\n    \n            throw new ArgumentException(\"Invalid type provided\");\n        }\n    }\n    public object? Deceased    \n    {\n        get\n        {\n            if (DeceasedDateTime is not null)\n            {\n                return DeceasedDateTime;\n            }\n    \n            if (DeceasedBoolean is not null)\n            {\n                return DeceasedBoolean;\n            }\n    \n            return null;\n        }\n    \n        set\n        {\n            if (value?.GetType() == typeof(string))\n            {\n                DeceasedDateTime = (string)value;return;\n            }\n    \n            if (value?.GetType() == typeof(bool))\n            {\n                DeceasedBoolean = (bool)value;return;\n            }\n    \n            throw new ArgumentException(\"Invalid type provided\");\n        }\n    }\n    public Base.Attachment[]? Photo { get; set; }\n    public Patient_Link[]? Link { get; set; }\n    public bool? Active { get; set; }\n    public Patient_Communication[]? Communication { get; set; }\n    public Base.Identifier[]? Identifier { get; set; }\n    public Base.ContactPoint[]? Telecom { get; set; }\n    public Base.ResourceReference[]? GeneralPractitioner { get; set; }\n    public string? Gender { get; set; }\n    public Base.CodeableConcept? MaritalStatus { get; set; }\n    public Patient_Contact[]? Contact { get; set; }\n\n    public class Patient_Link : BackboneElement\n    {\n        public required string Type { get; set; }\n        public required Base.ResourceReference Other { get; set; }\n    }\n\n    public class Patient_Communication : BackboneElement\n    {\n        public required Base.CodeableConcept Language { get; set; }\n        public bool? Preferred { get; set; }\n    }\n\n    public class Patient_Contact : BackboneElement\n    {\n        public Base.HumanName? Name { get; set; }\n        public string? Gender { get; set; }\n        public Base.Period? Period { get; set; }\n        public Base.Address? Address { get; set; }\n        public Base.ContactPoint[]? Telecom { get; set; }\n        public Base.ResourceReference? Organization { get; set; }\n        public Base.CodeableConcept[]? Relationship { get; set; }\n    }\n}"})))

(comment

  (spit "/tmp/PatientSearchParameters.py"
        (first (map :content (sut/generate-search-params generator fixtures/patient-search-params-schemas
                                                         [fixtures/patient-fhir-schema])))))
