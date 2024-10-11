(ns aidbox-sdk.generator.dotnet-test
  (:require
   [aidbox-sdk.fixtures.schemas :as fixtures]
   [aidbox-sdk.generator :as sut]
   [aidbox-sdk.generator.dotnet :refer [generator] :as gen.dotnet]
   [clojure.java.io :as io]
   [clojure.test :refer [deftest is testing]]
   [clojure.string :as str]))

(deftest test-generate-property
  (testing "simple case"
    (is (= "public bool? Active { get; set; }"
           (gen.dotnet/generate-property {:name "active",
                                          :base "Patient",
                                          :array false,
                                          :required false,
                                          :type "boolean"
                                          :value "bool"}))))

  (testing "required"
    (is (= "public required string Type { get; set; }"
           (gen.dotnet/generate-property {:name "type",
                                          :base "Patient_Link",
                                          :array false,
                                          :required true,
                                          :type "string"
                                          :value "string"}))))

  (testing "array optional"
    (is (= "public Base.Address[]? Address { get; set; }"
           (gen.dotnet/generate-property {:name "address",
                                          :base "Patient",
                                          :array true,
                                          :required false,
                                          :type "Address"
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
    (is (= "public new Meta Meta { get; } = new() { Profile = [\"http://hl7.org/fhir/StructureDefinition/vitalsigns\"] };"
           (gen.dotnet/generate-property {:name "meta",
                                          :required false,
                                          :value "Meta",
                                          :profile "http://hl7.org/fhir/StructureDefinition/vitalsigns",
                                          :type "Meta"})))

    (is (= "public required Meta Meta { get; set; }"
           (gen.dotnet/generate-property {:name "meta",
                                          :required true,
                                          :value "Meta",
                                          :type "Meta"})))

    (is (= "public Meta Meta { get; set; }"
           (gen.dotnet/generate-property {:name "meta"
                                          :required false
                                          :value "Meta"
                                          :type "Meta"}))))

  (testing "element with choices"
    (is (= (str/join "\n"
                     ["public object? Value    "
                      "    {"
                      "        get"
                      "        {"
                      "            if (ValueReference is not null)"
                      "            {"
                      "                return ValueReference;"
                      "            }"
                      "    "
                      "            if (ValueInteger is not null)"
                      "            {"
                      "                return ValueInteger;"
                      "            }"
                      "    "
                      "            return null;"
                      "        }"
                      "    "
                      "        set"
                      "        {"
                      "            if (value?.GetType() == typeof(Base.ResourceReference))"
                      "            {"
                      "                ValueReference = (Base.ResourceReference)value;"
                      "                return;"
                      "            }"
                      "    "
                      "            if (value?.GetType() == typeof(int))"
                      "            {"
                      "                ValueInteger = (int)value;"
                      "                return;"
                      "            }"
                      "    "
                      "            throw new ArgumentException(\"Invalid type provided\");"
                      "        }"
                      "    }"])
           (gen.dotnet/generate-property {:name "value",
                                          :choices
                                          [{:name "valueReference"
                                            :base "Observation"
                                            :array false
                                            :required false
                                            :value "Base.ResourceReference"
                                            :type "Reference"
                                            :choice-option true}
                                           {:name "valueInteger"
                                            :base "Observation"
                                            :array false
                                            :required false
                                            :value "int"
                                            :type "integer"
                                            :choice-option true}],
                                          :base "Observation",
                                          :array false,
                                          :required false})))))

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
       "using Aidbox.FHIR.Base;\nusing Aidbox.FHIR.Utils;\n\nnamespace Aidbox.FHIR.R4.Core;\n\npublic class Patient : DomainResource\n{\n    public bool? MultipleBirthBoolean { get; set; }\n    public Base.Address[]? Address { get; set; }\n    public string? DeceasedDateTime { get; set; }\n    public Base.ResourceReference? ManagingOrganization { get; set; }\n    public bool? DeceasedBoolean { get; set; }\n    public Base.HumanName[]? Name { get; set; }\n    public string? BirthDate { get; set; }\n    public int? MultipleBirthInteger { get; set; }\n    public object? MultipleBirth    \n    {\n        get\n        {\n            if (MultipleBirthBoolean is not null)\n            {\n                return MultipleBirthBoolean;\n            }\n    \n            if (MultipleBirthInteger is not null)\n            {\n                return MultipleBirthInteger;\n            }\n    \n            return null;\n        }\n    \n        set\n        {\n            if (value?.GetType() == typeof(bool))\n            {\n                MultipleBirthBoolean = (bool)value;\n                return;\n            }\n    \n            if (value?.GetType() == typeof(int))\n            {\n                MultipleBirthInteger = (int)value;\n                return;\n            }\n    \n            throw new ArgumentException(\"Invalid type provided\");\n        }\n    }\n    public object? Deceased    \n    {\n        get\n        {\n            if (DeceasedDateTime is not null)\n            {\n                return DeceasedDateTime;\n            }\n    \n            if (DeceasedBoolean is not null)\n            {\n                return DeceasedBoolean;\n            }\n    \n            return null;\n        }\n    \n        set\n        {\n            if (value?.GetType() == typeof(string))\n            {\n                DeceasedDateTime = (string)value;\n                return;\n            }\n    \n            if (value?.GetType() == typeof(bool))\n            {\n                DeceasedBoolean = (bool)value;\n                return;\n            }\n    \n            throw new ArgumentException(\"Invalid type provided\");\n        }\n    }\n    public Base.Attachment[]? Photo { get; set; }\n    public PatientLink[]? Link { get; set; }\n    public bool? Active { get; set; }\n    public PatientCommunication[]? Communication { get; set; }\n    public Base.Identifier[]? Identifier { get; set; }\n    public Base.ContactPoint[]? Telecom { get; set; }\n    public Base.ResourceReference[]? GeneralPractitioner { get; set; }\n    public string? Gender { get; set; }\n    public Base.CodeableConcept? MaritalStatus { get; set; }\n    public PatientContact[]? Contact { get; set; }\n\n    public class PatientLink : BackboneElement\n    {\n        public required string Type { get; set; }\n        public required Base.ResourceReference Other { get; set; }\n    }\n\n    public class PatientCommunication : BackboneElement\n    {\n        public required Base.CodeableConcept Language { get; set; }\n        public bool? Preferred { get; set; }\n    }\n\n    public class PatientContact : BackboneElement\n    {\n        public Base.HumanName? Name { get; set; }\n        public string? Gender { get; set; }\n        public Base.Period? Period { get; set; }\n        public Base.Address? Address { get; set; }\n        public Base.ContactPoint[]? Telecom { get; set; }\n        public Base.ResourceReference? Organization { get; set; }\n        public Base.CodeableConcept[]? Relationship { get; set; }\n    }\n}"})))

(deftest test-generate-search-params
  (is
   (= (sut/generate-search-params generator fixtures/patient-search-params-ir-schemas)
      [{:path (io/file "search/PatientSearchParameters.cs"),
        :content
        (str/join "\n" ["namespace Aidbox.FHIR.Search;"
                        ""
                        "public class PatientSearchParameters : DomainResourceSearchParameters"
                        "{"
                        "    public string? Id { get; set; }"
                        "    public string? Active { get; set; }"
                        "    public string? Address { get; set; }"
                        "    public string? AddressCity { get; set; }"
                        "    public string? AddressCountry { get; set; }"
                        "    public string? AddressPostalcode { get; set; }"
                        "    public string? AddressState { get; set; }"
                        "    public string? AddressUse { get; set; }"
                        "    public string? Age { get; set; }"
                        "    public string? BirthOrderBoolean { get; set; }"
                        "    public string? Birthdate { get; set; }"
                        "    public string? DeathDate { get; set; }"
                        "    public string? Deceased { get; set; }"
                        "    public string? Email { get; set; }"
                        "    public string? Ethnicity { get; set; }"
                        "    public string? Family { get; set; }"
                        "    public string? Gender { get; set; }"
                        "    public string? GeneralPractitioner { get; set; }"
                        "    public string? Given { get; set; }"
                        "    public string? Identifier { get; set; }"
                        "    public string? Language { get; set; }"
                        "    public string? Link { get; set; }"
                        "    public string? MothersMaidenName { get; set; }"
                        "    public string? Name { get; set; }"
                        "    public string? Organization { get; set; }"
                        "    public string? PartAgree { get; set; }"
                        "    public string? Phone { get; set; }"
                        "    public string? Phonetic { get; set; }"
                        "    public string? Race { get; set; }"
                        "    public string? Telecom { get; set; }"
                        "}"])}])))

;; TODO
#_(deftest generate-constraints
    (is
     (= (sut/generate-constraints generator fixtures/some-sonstraint-ir-schema)
        {:path (io/file "hl7-fhir-r4-core/Patient.cs"),
         :content
         "using Aidbox.FHIR.Base;\nusing Aidbox.FHIR.Utils;\n\nnamespace Aidbox.FHIR.R4.Core;\n\npublic class Patient : DomainResource, IResource\n{\n    public bool? MultipleBirthBoolean { get; set; }\n    public Base.Address[]? Address { get; set; }\n    public string? DeceasedDateTime { get; set; }\n    public Base.ResourceReference? ManagingOrganization { get; set; }\n    public bool? DeceasedBoolean { get; set; }\n    public Base.HumanName[]? Name { get; set; }\n    public string? BirthDate { get; set; }\n    public int? MultipleBirthInteger { get; set; }\n    public object? MultipleBirth    \n    {\n        get\n        {\n            if (MultipleBirthBoolean is not null)\n            {\n                return MultipleBirthBoolean;\n            }\n    \n            if (MultipleBirthInteger is not null)\n            {\n                return MultipleBirthInteger;\n            }\n    \n            return null;\n        }\n    \n        set\n        {\n            if (value?.GetType() == typeof(bool))\n            {\n                MultipleBirthBoolean = (bool)value;return;\n            }\n    \n            if (value?.GetType() == typeof(int))\n            {\n                MultipleBirthInteger = (int)value;return;\n            }\n    \n            throw new ArgumentException(\"Invalid type provided\");\n        }\n    }\n    public object? Deceased    \n    {\n        get\n        {\n            if (DeceasedDateTime is not null)\n            {\n                return DeceasedDateTime;\n            }\n    \n            if (DeceasedBoolean is not null)\n            {\n                return DeceasedBoolean;\n            }\n    \n            return null;\n        }\n    \n        set\n        {\n            if (value?.GetType() == typeof(string))\n            {\n                DeceasedDateTime = (string)value;return;\n            }\n    \n            if (value?.GetType() == typeof(bool))\n            {\n                DeceasedBoolean = (bool)value;return;\n            }\n    \n            throw new ArgumentException(\"Invalid type provided\");\n        }\n    }\n    public Base.Attachment[]? Photo { get; set; }\n    public Patient_Link[]? Link { get; set; }\n    public bool? Active { get; set; }\n    public Patient_Communication[]? Communication { get; set; }\n    public Base.Identifier[]? Identifier { get; set; }\n    public Base.ContactPoint[]? Telecom { get; set; }\n    public Base.ResourceReference[]? GeneralPractitioner { get; set; }\n    public string? Gender { get; set; }\n    public Base.CodeableConcept? MaritalStatus { get; set; }\n    public Patient_Contact[]? Contact { get; set; }\n\n    public class Patient_Link : BackboneElement\n    {\n        public required string Type { get; set; }\n        public required Base.ResourceReference Other { get; set; }\n    }\n\n    public class Patient_Communication : BackboneElement\n    {\n        public required Base.CodeableConcept Language { get; set; }\n        public bool? Preferred { get; set; }\n    }\n\n    public class Patient_Contact : BackboneElement\n    {\n        public Base.HumanName? Name { get; set; }\n        public string? Gender { get; set; }\n        public Base.Period? Period { get; set; }\n        public Base.Address? Address { get; set; }\n        public Base.ContactPoint[]? Telecom { get; set; }\n        public Base.ResourceReference? Organization { get; set; }\n        public Base.CodeableConcept[]? Relationship { get; set; }\n    }\n}"})))

(deftest test-generate-resource-map
  (is
   (= ["{ typeof(Aidbox.FHIR.Aidbox.FHIR.R4.Core.Observation), \"Observation\"}"
       "{ typeof(Aidbox.FHIR.Aidbox.FHIR.Uv.Sdc.SdcQuestionLibrary), \"SdcQuestionLibrary\"}"]
      (gen.dotnet/generate-resource-map [{:package "hl7.fhir.uv.sdc",
                                          :name "Demographics",
                                          :id "sdc-question-library"
                                          :resource-name "sdc-question-library",
                                          :type "Demographics",
                                          :url "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-question-library",
                                          :base "http://hl7.org/fhir/StructureDefinition/Resource",
                                          :fhir-version "hl7.fhir.r4.core"}
                                         {:package "hl7.fhir.r4.core",
                                          :derivation "specialization",
                                          :name "Observation",
                                          :resource-name "Observation",
                                          :type "Observation",
                                          :url "http://hl7.org/fhir/StructureDefinition/Observation",
                                          :base-resource-name "Domain-Resource",
                                          :base "http://hl7.org/fhir/StructureDefinition/DomainResource",
                                          :fhir-version "hl7.fhir.r4.core"}]))))
