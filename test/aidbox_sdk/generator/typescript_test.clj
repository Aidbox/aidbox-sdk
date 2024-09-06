(ns aidbox-sdk.generator.typescript-test
  (:require
   [aidbox-sdk.fixtures.schemas :as fixtures]
   [aidbox-sdk.generator :as sut]
   [aidbox-sdk.generator.typescript :refer [generator] :as gen.typescript]
   [clojure.java.io :as io]
   [clojure.test :refer [deftest is testing]]))

#_(deftest test-generate-deps
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

#_(deftest test-generate-property
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

#_(deftest test-generate-class
    (testing "base"
      (is (= "class Patient(DomainResource):\n    multiple_birth_boolean: Optional[bool] = None\n    address: Optional[List[Address]] = None\n    deceased_date_time: Optional[str] = None\n    managing_organization: Optional[Reference] = None\n    deceased_boolean: Optional[bool] = None\n    name: Optional[List[HumanName]] = None\n    birth_date: Optional[str] = None\n    multiple_birth_integer: Optional[int] = None\n    photo: Optional[List[Attachment]] = None\n    link: Optional[List[Patient_Link]] = None\n    active: Optional[bool] = None\n    communication: Optional[List[Patient_Communication]] = None\n    identifier: Optional[List[Identifier]] = None\n    telecom: Optional[List[ContactPoint]] = None\n    general_practitioner: Optional[List[Reference]] = None\n    gender: Optional[str] = None\n    marital_status: Optional[CodeableConcept] = None\n    contact: Optional[List[Patient_Contact]] = None"
             (gen.python/generate-class fixtures/patient-ir-schema))))

    (testing "with inner classes"
      (is (= "class Patient_Link(BackboneElement):\n    other: Reference\n    type: str\n\nclass Patient_Communication(BackboneElement):\n    language: CodeableConcept\n    preferred: Optional[bool] = None\n\nclass Patient_Contact(BackboneElement):\n    address: Optional[Address] = None\n    gender: Optional[str] = None\n    name: Optional[HumanName] = None\n    organization: Optional[Reference] = None\n    period: Optional[Period] = None\n    relationship: Optional[List[CodeableConcept]] = None\n    telecom: Optional[List[ContactPoint]] = None\n\nclass Patient(DomainResource):\n    multiple_birth_boolean: Optional[bool] = None\n    address: Optional[List[Address]] = None\n    deceased_date_time: Optional[str] = None\n    managing_organization: Optional[Reference] = None\n    deceased_boolean: Optional[bool] = None\n    name: Optional[List[HumanName]] = None\n    birth_date: Optional[str] = None\n    multiple_birth_integer: Optional[int] = None\n    photo: Optional[List[Attachment]] = None\n    link: Optional[List[Patient_Link]] = None\n    active: Optional[bool] = None\n    communication: Optional[List[Patient_Communication]] = None\n    identifier: Optional[List[Identifier]] = None\n    telecom: Optional[List[ContactPoint]] = None\n    general_practitioner: Optional[List[Reference]] = None\n    gender: Optional[str] = None\n    marital_status: Optional[CodeableConcept] = None\n    contact: Optional[List[Patient_Contact]] = None"
             (gen.python/generate-class fixtures/patient-ir-schema
                                        ["class Patient_Link(BackboneElement):\n    other: Reference\n    type: str"
                                         "class Patient_Communication(BackboneElement):\n    language: CodeableConcept\n    preferred: Optional[bool] = None"
                                         "class Patient_Contact(BackboneElement):\n    address: Optional[Address] = None\n    gender: Optional[str] = None\n    name: Optional[HumanName] = None\n    organization: Optional[Reference] = None\n    period: Optional[Period] = None\n    relationship: Optional[List[CodeableConcept]] = None\n    telecom: Optional[List[ContactPoint]] = None"])))))

#_(deftest test-generate-datatypes
    (is
     (= [{:path (io/file "base/__init__.py"),
          :content
          "from pydantic import *\nfrom typing import Optional, List\n\nclass Coding(Element):\n    code: Optional[str] = None\n    system: Optional[str] = None\n    display: Optional[str] = None\n    version: Optional[str] = None\n    user_selected: Optional[bool] = None"}]
        (sut/generate-datatypes generator [fixtures/coding-ir-schema]))))

(deftest test-generate-resources
  (is
   (= {:path (io/file "hl7-fhir-r4-core/Patient.ts"),
       :content
       "import { Address, Attachment, Period, CodeableConcept, ContactPoint, HumanName, DomainResource, Reference, Identifier, BackboneElement } from '../datatypes';\n\nexport type Patient_Link = BackboneElement & {\n    type: string;\n    other: Reference;\n};\n\nexport type Patient_Communication = BackboneElement & {\n    language: CodeableConcept;\n    preferred?: boolean;\n};\n\nexport type Patient_Contact = BackboneElement & {\n    name?: HumanName;\n    gender?: string;\n    period?: Period;\n    address?: Address;\n    telecom?: ContactPoint[];\n    organization?: Reference;\n    relationship?: CodeableConcept[];\n};\n\nexport type Patient = DomainResource & {\n    address?: Address[];\n    managingOrganization?: Reference;\n    name?: HumanName[];\n    birthDate?: string;\n    multipleBirth?: boolean | number;\n    deceased?: string | boolean;\n    photo?: Attachment[];\n    link?: BackboneElement[];\n    active?: boolean;\n    communication?: BackboneElement[];\n    identifier?: Identifier[];\n    telecom?: ContactPoint[];\n    generalPractitioner?: Reference[];\n    gender?: string;\n    maritalStatus?: CodeableConcept;\n    contact?: BackboneElement[];\n};"}
      (sut/generate-resource-module generator fixtures/patient-ir-schema))))

#_(deftest test-generate-search-params
    (is
     (= [{:path (io/file "search/PatientSearchParameters.py"),
          :content
          "from typing import Optional\n\nclass PatientSearchParameters(DomainResourceSearchParameters):\n    id: Optional[str] = None\n    active: Optional[str] = None\n    address: Optional[str] = None\n    address_city: Optional[str] = None\n    address_country: Optional[str] = None\n    address_postalcode: Optional[str] = None\n    address_state: Optional[str] = None\n    address_use: Optional[str] = None\n    age: Optional[str] = None\n    birth_order_boolean: Optional[str] = None\n    birthdate: Optional[str] = None\n    death_date: Optional[str] = None\n    deceased: Optional[str] = None\n    email: Optional[str] = None\n    ethnicity: Optional[str] = None\n    family: Optional[str] = None\n    gender: Optional[str] = None\n    general_practitioner: Optional[str] = None\n    given: Optional[str] = None\n    identifier: Optional[str] = None\n    language: Optional[str] = None\n    link: Optional[str] = None\n    mothers_maiden_name: Optional[str] = None\n    name: Optional[str] = None\n    organization: Optional[str] = None\n    part_agree: Optional[str] = None\n    phone: Optional[str] = None\n    phonetic: Optional[str] = None\n    race: Optional[str] = None\n    telecom: Optional[str] = None"}]
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
