(ns aidbox-sdk.generator.typescript-test
  (:require
   [aidbox-sdk.fixtures :as fixt]
   [aidbox-sdk.generator :as sut]
   [aidbox-sdk.generator.typescript :refer [generator] :as gen.typescript]
   [matcho.core :refer [match]]
   [clojure.java.io :as io]
   [clojure.string :as str]
   [clojure.test :refer [deftest is testing use-fixtures]]))

(use-fixtures :once fixt/prepare-examples)

(deftest test-generate-deps
  (testing "import for base package"
    (is (= "import { Bundle } from \"./Bundle\";"
           (gen.typescript/generate-deps {:package "hl7.fhir.r4.core"
                                          :deps #{"Bundle"}}))))

  (testing "import for package outside of base"
    (is (= "import { Bundle } from \"../hl7-fhir-r4-core/Bundle\";"
           (gen.typescript/generate-deps {:package "hl7.fhir.us.core"
                                          :deps #{"Bundle"}
                                          :fhir-version "hl7.fhir.r4.core"})))))

(deftest test-generate-property
  (testing "simple case"
    (is (= "active?: boolean;"
           (gen.typescript/generate-property {:name "active",
                                              :base "Patient",
                                              :array false,
                                              :required false,
                                              :value "bool"
                                              :type "boolean"}))))

  (testing "required"
    (is (= "type: string;"
           (gen.typescript/generate-property {:name "type",
                                              :base "Patient_Link",
                                              :array false,
                                              :required true,
                                              :value "string"
                                              :type "string"}))))

  (testing "array optional"
    (is (= "address?: Address[];"
           (gen.typescript/generate-property {:name "address",
                                              :base "Patient",
                                              :array true,
                                              :required false,
                                              :value "Address"
                                              :type "Address"}))))

  (testing "array required"
    (is (= "extension: Extension[];"
           (gen.typescript/generate-property {:name "extension",
                                              :base "Element",
                                              :array true,
                                              :required true,
                                              :value "Extension"
                                              :type "Extension"}))))

  (testing "element with literal"
    ;; TODO
    )

  (testing "element with meta"
    (is (= "meta: Meta & { profile: [\"http://hl7.org/fhir/StructureDefinition/vitalsigns\"] };"
           (gen.typescript/generate-property {:name "meta"
                                              :required true
                                              :value "Meta"
                                              :profile "http://hl7.org/fhir/StructureDefinition/vitalsigns"
                                              :type "Meta"})))

    (is (= "meta: Meta;"
           (gen.typescript/generate-property {:name "meta"
                                              :required true
                                              :value "Meta"
                                              :type "Meta"})))

    (is (= "meta?: Meta;"
           (gen.typescript/generate-property {:name "meta"
                                              :required false
                                              :value "Meta"
                                              :type "Meta"}))))

  (testing "element with choices"
    (is (= "value?: Reference | number;"
           (gen.typescript/generate-property {:name "value",
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

(deftest test-generate-class
  (testing "base"
    (match
     (str/split-lines
      (gen.typescript/generate-class (fixt/get-data :patient-ir-schema)))

      ["export type Patient = DomainResource & {"
       "    resourceType: 'Patient'"
       "    multipleBirthBoolean?: boolean;"
       "    _multipleBirthBoolean?: Element;"
       "    address?: Address[];"
       "    deceasedDateTime?: string;"
       "    _deceasedDateTime?: Element;"
       "    managingOrganization?: Reference;"
       "    deceasedBoolean?: boolean;"
       "    _deceasedBoolean?: Element;"
       "    name?: HumanName[];"
       "    birthDate?: string;"
       "    _birthDate?: Element;"
       "    multipleBirthInteger?: number;"
       "    _multipleBirthInteger?: Element;"
       "    photo?: Attachment[];"
       "    link?: PatientLink[];"
       "    active?: boolean;"
       "    _active?: Element;"
       "    communication?: PatientCommunication[];"
       "    identifier?: Identifier[];"
       "    telecom?: ContactPoint[];"
       "    generalPractitioner?: Reference[];"
       "    gender?: AdministrativeGender;"
       "    _gender?: Element;"
       "    maritalStatus?: CodeableConcept;"
       "    contact?: PatientContact[];"
       "};"]))

  (testing "empty elements"
    (is (= "export type Base = {};"
           (gen.typescript/generate-class {:package "hl7.fhir.r5.core",
                                           :derivation nil,
                                           :type "Base",
                                           :elements (),
                                           :url "http://hl7.org/fhir/StructureDefinition/Base",
                                           :resource-name "Base"
                                           :base-resource-name nil,
                                           :backbone-elements (),
                                           :base nil,
                                           :deps #{}}))))

  (testing "with inner classes"
    (match
     (str/split-lines
      (gen.typescript/generate-class (fixt/get-data :patient-ir-schema)
                                     (map gen.typescript/generate-class (:backbone-elements (fixt/get-data :patient-ir-schema)))))

      ["export type PatientLink = BackboneElement & {"
       "    type: string;"
       "    other: Reference;"
       "};"
       ""
       "export type PatientCommunication = BackboneElement & {"
       "    language: CodeableConcept;"
       "    preferred?: boolean;"
       "};"
       ""
       "export type PatientContact = BackboneElement & {"
       "    name?: HumanName;"
       "    gender?: string;"
       "    period?: Period;"
       "    address?: Address;"
       "    telecom?: ContactPoint[];"
       "    organization?: Reference;"
       "    relationship?: CodeableConcept[];"
       "};"
       ""
       "export type Patient = DomainResource & {"
       "    resourceType: 'Patient'"
       "    multipleBirthBoolean?: boolean;"
       "    _multipleBirthBoolean?: Element;"
       "    address?: Address[];"
       "    deceasedDateTime?: string;"
       "    _deceasedDateTime?: Element;"
       "    managingOrganization?: Reference;"
       "    deceasedBoolean?: boolean;"
       "    _deceasedBoolean?: Element;"
       "    name?: HumanName[];"
       "    birthDate?: string;"
       "    _birthDate?: Element;"
       "    multipleBirthInteger?: number;"
       "    _multipleBirthInteger?: Element;"
       "    photo?: Attachment[];"
       "    link?: PatientLink[];"
       "    active?: boolean;"
       "    _active?: Element;"
       "    communication?: PatientCommunication[];"
       "    identifier?: Identifier[];"
       "    telecom?: ContactPoint[];"
       "    generalPractitioner?: Reference[];"
       "    gender?: AdministrativeGender;"
       "    _gender?: Element;"
       "    maritalStatus?: CodeableConcept;"
       "    contact?: PatientContact[];"
       "};"])))

#_(deftest test-generate-datatypes
    (is
     (= [{:path (io/file "base/__init__.py"),
          :content
          "from pydantic import *\nfrom typing import Optional, List\n\nclass Coding(Element):\n    code: Optional[str] = None\n    system: Optional[str] = None\n    display: Optional[str] = None\n    version: Optional[str] = None\n    user_selected: Optional[bool] = None"}]
        (sut/generate-datatypes generator [fixtures/coding-ir-schema]))))

(deftest test-generate-resources
  (match
   (str/split-lines (:content (sut/generate-resource-module generator (fixt/get-data :patient-ir-schema))))

    ["import { Address } from \"./Address\";"
     "import { Attachment } from \"./Attachment\";"
     "import { Period } from \"./Period\";"
     "import { CodeableConcept } from \"./CodeableConcept\";"
     "import { ContactPoint } from \"./ContactPoint\";"
     "import { HumanName } from \"./HumanName\";"
     "import { DomainResource } from \"./DomainResource\";"
     "import { Reference } from \"./Reference\";"
     "import { Identifier } from \"./Identifier\";"
     "import { BackboneElement } from \"./BackboneElement\";"
     "import { AdministrativeGender } from './valuesets';"
     ""
     "export type PatientLink = BackboneElement & {"
     "    type: string;"
     "    other: Reference;"
     "};"
     ""
     "export type PatientCommunication = BackboneElement & {"
     "    language: CodeableConcept;"
     "    preferred?: boolean;"
     "};"
     ""
     "export type PatientContact = BackboneElement & {"
     "    name?: HumanName;"
     "    gender?: string;"
     "    period?: Period;"
     "    address?: Address;"
     "    telecom?: ContactPoint[];"
     "    organization?: Reference;"
     "    relationship?: CodeableConcept[];"
     "};"
     ""
     "export type Patient = DomainResource & {"
     "    resourceType: 'Patient'"
     "    multipleBirthBoolean?: boolean;"
     "    _multipleBirthBoolean?: Element;"
     "    address?: Address[];"
     "    deceasedDateTime?: string;"
     "    _deceasedDateTime?: Element;"
     "    managingOrganization?: Reference;"
     "    deceasedBoolean?: boolean;"
     "    _deceasedBoolean?: Element;"
     "    name?: HumanName[];"
     "    birthDate?: string;"
     "    _birthDate?: Element;"
     "    multipleBirthInteger?: number;"
     "    _multipleBirthInteger?: Element;"
     "    photo?: Attachment[];"
     "    link?: PatientLink[];"
     "    active?: boolean;"
     "    _active?: Element;"
     "    communication?: PatientCommunication[];"
     "    identifier?: Identifier[];"
     "    telecom?: ContactPoint[];"
     "    generalPractitioner?: Reference[];"
     "    gender?: AdministrativeGender;"
     "    _gender?: Element;"
     "    maritalStatus?: CodeableConcept;"
     "    contact?: PatientContact[];"
     "};"]))

#_(deftest test-generate-search-params
    (is
     (= [{:path (io/file "search/PatientSearchParameters.py"),
          :content
          "from typing import Optional\n\nclass PatientSearchParameters(DomainResourceSearchParameters):\n    id: Optional[str] = None\n    active: Optional[str] = None\n    address: Optional[str] = None\n    address_city: Optional[str] = None\n    address_country: Optional[str] = None\n    address_postalcode: Optional[str] = None\n    address_state: Optional[str] = None\n    address_use: Optional[str] = None\n    age: Optional[str] = None\n    birth_order_boolean: Optional[str] = None\n    birthdate: Optional[str] = None\n    death_date: Optional[str] = None\n    deceased: Optional[str] = None\n    email: Optional[str] = None\n    ethnicity: Optional[str] = None\n    family: Optional[str] = None\n    gender: Optional[str] = None\n    general_practitioner: Optional[str] = None\n    given: Optional[str] = None\n    identifier: Optional[str] = None\n    language: Optional[str] = None\n    link: Optional[str] = None\n    mothers_maiden_name: Optional[str] = None\n    name: Optional[str] = None\n    organization: Optional[str] = None\n    part_agree: Optional[str] = None\n    phone: Optional[str] = None\n    phonetic: Optional[str] = None\n    race: Optional[str] = None\n    telecom: Optional[str] = None"}]
        (sut/generate-search-params generator (fixt/get-data :patient-search-params-ir-schema))

        (sut/generate-search-params generator fixtures/patient-search-params-ir-schemas))))

#_(deftest generate-constraints
    (is
     (= [{:path (io/file "hl7-fhir-r4-core/Ldlcholesterol.py"),
          :content
          "from pydantic import *\nfrom typing import Optional, List\nfrom ..base import *\n\nclass Observation_ReferenceRange(BackboneElement):\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = None\n\nclass Observation_Component_ReferenceRange(BackboneElement):\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = None\n\nclass Observation_Component(BackboneElement):\n    reference_range: Optional[List[Observation_Component_ReferenceRange]] = None\n    interpretation: Optional[List[CodeableConcept]] = None\n    value_time: Optional[str] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    value_sampled_data: Optional[SampledData] = None\n    code: CodeableConcept\n    value_codeable_concept: Optional[CodeableConcept] = None\n    value_period: Optional[Period] = None\n    value_range: Optional[Range] = None\n    value_integer: Optional[int] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n\nclass Ldlcholesterol(DomainResource):\n    meta: Meta = Meta(profile=[\"http://hl7.org/fhir/StructureDefinition/ldlcholesterol\"])\n    category: Optional[List[CodeableConcept]] = None\n    reference_range: list[Observation_ReferenceRange] = []\n    interpretation: Optional[List[CodeableConcept]] = None\n    encounter: Optional[Reference] = None\n    method: Optional[CodeableConcept] = None\n    value_time: Optional[str] = None\n    specimen: Optional[Reference] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    component: Optional[List[Observation_Component]] = None\n    note: Optional[List[Annotation]] = None\n    value_sampled_data: Optional[SampledData] = None\n    effective_date_time: Optional[str] = None\n    status: str\n    code: CodeableConcept\n    identifier: Optional[List[Identifier]] = None\n    effective_timing: Optional[Timing] = None\n    value_codeable_concept: Optional[CodeableConcept] = None\n    body_site: Optional[CodeableConcept] = None\n    focus: Optional[List[Reference]] = None\n    issued: Optional[str] = None\n    value_period: Optional[Period] = None\n    device: Optional[Reference] = None\n    effective_instant: Optional[str] = None\n    based_on: Optional[List[Reference]] = None\n    value_range: Optional[Range] = None\n    part_of: Optional[List[Reference]] = None\n    value_integer: Optional[int] = None\n    subject: Optional[Reference] = None\n    performer: Optional[List[Reference]] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n    effective_period: Optional[Period] = None"}
         {:path (io/file "hl7-fhir-r4-core/Cholesterol.py"),
          :content
          "from pydantic import *\nfrom typing import Optional, List\nfrom ..base import *\n\nclass Observation_ReferenceRange(BackboneElement):\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = None\n\nclass Observation_Component_ReferenceRange(BackboneElement):\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = None\n\nclass Observation_Component(BackboneElement):\n    reference_range: Optional[List[Observation_Component_ReferenceRange]] = None\n    interpretation: Optional[List[CodeableConcept]] = None\n    value_time: Optional[str] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    value_sampled_data: Optional[SampledData] = None\n    code: CodeableConcept\n    value_codeable_concept: Optional[CodeableConcept] = None\n    value_period: Optional[Period] = None\n    value_range: Optional[Range] = None\n    value_integer: Optional[int] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n\nclass Cholesterol(DomainResource):\n    meta: Meta = Meta(profile=[\"http://hl7.org/fhir/StructureDefinition/cholesterol\"])\n    category: Optional[List[CodeableConcept]] = None\n    reference_range: list[Observation_ReferenceRange] = []\n    interpretation: Optional[List[CodeableConcept]] = None\n    encounter: Optional[Reference] = None\n    method: Optional[CodeableConcept] = None\n    value_time: Optional[str] = None\n    specimen: Optional[Reference] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    component: Optional[List[Observation_Component]] = None\n    note: Optional[List[Annotation]] = None\n    value_sampled_data: Optional[SampledData] = None\n    effective_date_time: Optional[str] = None\n    status: str\n    code: CodeableConcept\n    identifier: Optional[List[Identifier]] = None\n    effective_timing: Optional[Timing] = None\n    value_codeable_concept: Optional[CodeableConcept] = None\n    body_site: Optional[CodeableConcept] = None\n    focus: Optional[List[Reference]] = None\n    issued: Optional[str] = None\n    value_period: Optional[Period] = None\n    device: Optional[Reference] = None\n    effective_instant: Optional[str] = None\n    based_on: Optional[List[Reference]] = None\n    value_range: Optional[Range] = None\n    part_of: Optional[List[Reference]] = None\n    value_integer: Optional[int] = None\n    subject: Optional[Reference] = None\n    performer: Optional[List[Reference]] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n    effective_period: Optional[Period] = None"}
         {:path (io/file "hl7-fhir-r4-core/ObservationGenetics.py"),
          :content
          "from pydantic import *\nfrom typing import Optional, List\nfrom ..base import *\n\nclass Observation_ReferenceRange(BackboneElement):\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = None\n\nclass Observation_Component_ReferenceRange(BackboneElement):\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = None\n\nclass Observation_Component(BackboneElement):\n    reference_range: Optional[List[Observation_Component_ReferenceRange]] = None\n    interpretation: Optional[List[CodeableConcept]] = None\n    value_time: Optional[str] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    value_sampled_data: Optional[SampledData] = None\n    code: CodeableConcept\n    value_codeable_concept: Optional[CodeableConcept] = None\n    value_period: Optional[Period] = None\n    value_range: Optional[Range] = None\n    value_integer: Optional[int] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n\nclass Observation-genetics(DomainResource):\n    meta: Meta = Meta(profile=[\"http://hl7.org/fhir/StructureDefinition/observation-genetics\"])\n    category: Optional[List[CodeableConcept]] = None\n    reference_range: Optional[List[Observation_ReferenceRange]] = None\n    has_member: Optional[List[Reference]] = None\n    derived_from: Optional[List[Reference]] = None\n    interpretation: Optional[List[CodeableConcept]] = None\n    encounter: Optional[Reference] = None\n    method: Optional[CodeableConcept] = None\n    value_time: Optional[str] = None\n    specimen: Optional[Reference] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    component: Optional[List[Observation_Component]] = None\n    note: Optional[List[Annotation]] = None\n    value_sampled_data: Optional[SampledData] = None\n    effective_date_time: Optional[str] = None\n    status: str\n    code: CodeableConcept\n    identifier: Optional[List[Identifier]] = None\n    effective_timing: Optional[Timing] = None\n    value_codeable_concept: Optional[CodeableConcept] = None\n    body_site: Optional[CodeableConcept] = None\n    focus: Optional[List[Reference]] = None\n    issued: Optional[str] = None\n    value_period: Optional[Period] = None\n    device: Optional[Reference] = None\n    effective_instant: Optional[str] = None\n    based_on: Optional[List[Reference]] = None\n    value_range: Optional[Range] = None\n    part_of: Optional[List[Reference]] = None\n    value_integer: Optional[int] = None\n    subject: Optional[Reference] = None\n    performer: Optional[List[Reference]] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n    effective_period: Optional[Period] = None"}
         {:path (io/file "hl7-fhir-r4-core/Devicemetricobservation.py"),
          :content
          "from pydantic import *\nfrom typing import Optional, List\nfrom ..base import *\n\nclass Observation_ReferenceRange(BackboneElement):\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = None\n\nclass Observation_Component_ReferenceRange(BackboneElement):\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = None\n\nclass Observation_Component(BackboneElement):\n    reference_range: Optional[List[Observation_Component_ReferenceRange]] = None\n    interpretation: Optional[List[CodeableConcept]] = None\n    value_time: Optional[str] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    value_sampled_data: Optional[SampledData] = None\n    code: CodeableConcept\n    value_codeable_concept: Optional[CodeableConcept] = None\n    value_period: Optional[Period] = None\n    value_range: Optional[Range] = None\n    value_integer: Optional[int] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n\nclass Devicemetricobservation(DomainResource):\n    meta: Meta = Meta(profile=[\"http://hl7.org/fhir/StructureDefinition/devicemetricobservation\"])\n    category: Optional[List[CodeableConcept]] = None\n    reference_range: Optional[List[Observation_ReferenceRange]] = None\n    has_member: Optional[List[Reference]] = None\n    derived_from: Optional[List[Reference]] = None\n    interpretation: Optional[List[CodeableConcept]] = None\n    method: Optional[CodeableConcept] = None\n    value_time: Optional[str] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    component: Optional[List[Observation_Component]] = None\n    note: Optional[List[Annotation]] = None\n    value_sampled_data: Optional[SampledData] = None\n    effective_date_time: str\n    status: str\n    code: CodeableConcept\n    identifier: Optional[List[Identifier]] = None\n    effective_timing: Optional[Timing] = None\n    value_codeable_concept: Optional[CodeableConcept] = None\n    body_site: Optional[CodeableConcept] = None\n    focus: Optional[List[Reference]] = None\n    value_period: Optional[Period] = None\n    device: Reference\n    effective_instant: Optional[str] = None\n    based_on: Optional[List[Reference]] = None\n    value_range: Optional[Range] = None\n    part_of: Optional[List[Reference]] = None\n    value_integer: Optional[int] = None\n    subject: Reference\n    performer: Optional[List[Reference]] = None\n    effective_period: Optional[Period] = None"}
         {:path (io/file "hl7-fhir-r4-core/Triglyceride.py"),
          :content
          "from pydantic import *\nfrom typing import Optional, List\nfrom ..base import *\n\nclass Observation_ReferenceRange(BackboneElement):\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = None\n\nclass Observation_Component_ReferenceRange(BackboneElement):\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = None\n\nclass Observation_Component(BackboneElement):\n    reference_range: Optional[List[Observation_Component_ReferenceRange]] = None\n    interpretation: Optional[List[CodeableConcept]] = None\n    value_time: Optional[str] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    value_sampled_data: Optional[SampledData] = None\n    code: CodeableConcept\n    value_codeable_concept: Optional[CodeableConcept] = None\n    value_period: Optional[Period] = None\n    value_range: Optional[Range] = None\n    value_integer: Optional[int] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n\nclass Triglyceride(DomainResource):\n    meta: Meta = Meta(profile=[\"http://hl7.org/fhir/StructureDefinition/triglyceride\"])\n    category: Optional[List[CodeableConcept]] = None\n    reference_range: list[Observation_ReferenceRange] = []\n    interpretation: Optional[List[CodeableConcept]] = None\n    encounter: Optional[Reference] = None\n    method: Optional[CodeableConcept] = None\n    value_time: Optional[str] = None\n    specimen: Optional[Reference] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    component: Optional[List[Observation_Component]] = None\n    note: Optional[List[Annotation]] = None\n    value_sampled_data: Optional[SampledData] = None\n    effective_date_time: Optional[str] = None\n    status: str\n    code: CodeableConcept\n    identifier: Optional[List[Identifier]] = None\n    effective_timing: Optional[Timing] = None\n    value_codeable_concept: Optional[CodeableConcept] = None\n    body_site: Optional[CodeableConcept] = None\n    focus: Optional[List[Reference]] = None\n    issued: Optional[str] = None\n    value_period: Optional[Period] = None\n    device: Optional[Reference] = None\n    effective_instant: Optional[str] = None\n    based_on: Optional[List[Reference]] = None\n    value_range: Optional[Range] = None\n    part_of: Optional[List[Reference]] = None\n    value_integer: Optional[int] = None\n    subject: Optional[Reference] = None\n    performer: Optional[List[Reference]] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n    effective_period: Optional[Period] = None"}
         {:path (io/file "hl7-fhir-r4-core/Vitalsigns.py"),
          :content
          "from pydantic import *\nfrom typing import Optional, List\nfrom ..base import *\n\nclass Observation_ReferenceRange(BackboneElement):\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = None\n\nclass Observation_Component_ReferenceRange(BackboneElement):\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = None\n\nclass Observation_Component(BackboneElement):\n    reference_range: Optional[List[Observation_Component_ReferenceRange]] = None\n    interpretation: Optional[List[CodeableConcept]] = None\n    value_time: Optional[str] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    value_sampled_data: Optional[SampledData] = None\n    code: CodeableConcept\n    value_codeable_concept: Optional[CodeableConcept] = None\n    value_period: Optional[Period] = None\n    value_range: Optional[Range] = None\n    value_integer: Optional[int] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n\nclass Vitalsigns(DomainResource):\n    meta: Meta = Meta(profile=[\"http://hl7.org/fhir/StructureDefinition/vitalsigns\"])\n    category: list[CodeableConcept] = []\n    reference_range: Optional[List[Observation_ReferenceRange]] = None\n    has_member: Optional[List[Reference]] = None\n    derived_from: Optional[List[Reference]] = None\n    interpretation: Optional[List[CodeableConcept]] = None\n    encounter: Optional[Reference] = None\n    method: Optional[CodeableConcept] = None\n    value_time: Optional[str] = None\n    specimen: Optional[Reference] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    component: Optional[List[Observation_Component]] = None\n    note: Optional[List[Annotation]] = None\n    value_sampled_data: Optional[SampledData] = None\n    effective_date_time: Optional[str] = None\n    status: str\n    code: CodeableConcept\n    identifier: Optional[List[Identifier]] = None\n    effective_timing: Optional[Timing] = None\n    value_codeable_concept: Optional[CodeableConcept] = None\n    body_site: Optional[CodeableConcept] = None\n    focus: Optional[List[Reference]] = None\n    issued: Optional[str] = None\n    value_period: Optional[Period] = None\n    device: Optional[Reference] = None\n    effective_instant: Optional[str] = None\n    based_on: Optional[List[Reference]] = None\n    value_range: Optional[Range] = None\n    part_of: Optional[List[Reference]] = None\n    value_integer: Optional[int] = None\n    subject: Reference\n    performer: Optional[List[Reference]] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n    effective_period: Optional[Period] = None"}
         {:path (io/file "hl7-fhir-r4-core/Hdlcholesterol.py"),
          :content
          "from pydantic import *\nfrom typing import Optional, List\nfrom ..base import *\n\nclass Observation_ReferenceRange(BackboneElement):\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = None\n\nclass Observation_Component_ReferenceRange(BackboneElement):\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = None\n\nclass Observation_Component(BackboneElement):\n    reference_range: Optional[List[Observation_Component_ReferenceRange]] = None\n    interpretation: Optional[List[CodeableConcept]] = None\n    value_time: Optional[str] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    value_sampled_data: Optional[SampledData] = None\n    code: CodeableConcept\n    value_codeable_concept: Optional[CodeableConcept] = None\n    value_period: Optional[Period] = None\n    value_range: Optional[Range] = None\n    value_integer: Optional[int] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n\nclass Hdlcholesterol(DomainResource):\n    meta: Meta = Meta(profile=[\"http://hl7.org/fhir/StructureDefinition/hdlcholesterol\"])\n    category: Optional[List[CodeableConcept]] = None\n    reference_range: list[Observation_ReferenceRange] = []\n    interpretation: Optional[List[CodeableConcept]] = None\n    encounter: Optional[Reference] = None\n    method: Optional[CodeableConcept] = None\n    value_time: Optional[str] = None\n    specimen: Optional[Reference] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    component: Optional[List[Observation_Component]] = None\n    note: Optional[List[Annotation]] = None\n    value_sampled_data: Optional[SampledData] = None\n    effective_date_time: Optional[str] = None\n    status: str\n    code: CodeableConcept\n    identifier: Optional[List[Identifier]] = None\n    effective_timing: Optional[Timing] = None\n    value_codeable_concept: Optional[CodeableConcept] = None\n    body_site: Optional[CodeableConcept] = None\n    focus: Optional[List[Reference]] = None\n    issued: Optional[str] = None\n    value_period: Optional[Period] = None\n    device: Optional[Reference] = None\n    effective_instant: Optional[str] = None\n    based_on: Optional[List[Reference]] = None\n    value_range: Optional[Range] = None\n    part_of: Optional[List[Reference]] = None\n    value_integer: Optional[int] = None\n    subject: Optional[Reference] = None\n    performer: Optional[List[Reference]] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n    effective_period: Optional[Period] = None"}]
        (sut/generate-constraints generator fixtures/observation-constraints-ir-schema))))

(comment
  (fixt/load-data!)

  (fixt/get-data :patient-ir-schema)

  @fixt/data

  ;
  )
