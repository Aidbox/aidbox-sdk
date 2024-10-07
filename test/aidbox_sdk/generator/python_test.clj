(ns aidbox-sdk.generator.python-test
  (:require
   [aidbox-sdk.fixtures.schemas :as fixtures]
   [aidbox-sdk.generator :as sut]
   [aidbox-sdk.generator.python :refer [generator] :as gen.python]
   [clojure.java.io :as io]
   [clojure.test :refer [deftest is testing]]
   [clojure.string :as str]))

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
                                          :type "boolean"} false))))

  (testing "required"
    (is (= "type: str"
           (gen.python/generate-property {:name "type",
                                          :base "Patient_Link",
                                          :array false,
                                          :required true,
                                          :value "string"
                                          :type "string"} false))))

  (testing "array optional"
    (is (= "address: Optional[List[Address]] = field(default_factory=list)"
           (gen.python/generate-property {:name "address",
                                          :base "Patient",
                                          :array true,
                                          :required false,
                                          :value "Address"
                                          :type "Address"} false))))

  (testing "array required"
    (is (= "extension: list[Extension] = field(default_factory=list)"
           (gen.python/generate-property {:name "extension",
                                          :base "Element",
                                          :array true,
                                          :required true,
                                          :value "Extension"
                                          :type "Extension"} false))))

  (testing "element with literal"
    ;; TODO
    )

  (testing "element with meta"
    (is (= "meta: Meta"
           (gen.python/generate-property {:name "meta"
                                          :required true
                                          :value "Meta"
                                          :profile "http://hl7.org/fhir/StructureDefinition/vitalsigns"
                                          :type "Meta"}
                                         false)))

    (is (= "meta: Meta"
           (gen.python/generate-property {:name "meta"
                                          :required true
                                          :value "Meta"
                                          :type "Meta"}
                                         false)))

    (is (= "meta: Optional[Meta] = None"
           (gen.python/generate-property {:name "meta"
                                          :required false
                                          :value "Meta"
                                          :type "Meta"}
                                         false))))

  (testing "element with choices"
    ;; TODO
    ))

(deftest test-generate-class
  (testing "base"
    (is (= "@dataclass(kw_only=True)\nclass Patient(DomainResource):\n    multiple_birth_boolean: Optional[bool] = None\n    address: Optional[List[Address]] = field(default_factory=list)\n    deceased_date_time: Optional[str] = None\n    managing_organization: Optional[Reference] = None\n    deceased_boolean: Optional[bool] = None\n    name: Optional[List[HumanName]] = field(default_factory=list)\n    birth_date: Optional[str] = None\n    multiple_birth_integer: Optional[int] = None\n    photo: Optional[List[Attachment]] = field(default_factory=list)\n    link: Optional[List[PatientLink]] = field(default_factory=list)\n    active: Optional[bool] = None\n    communication: Optional[List[PatientCommunication]] = field(default_factory=list)\n    identifier: Optional[List[Identifier]] = field(default_factory=list)\n    telecom: Optional[List[ContactPoint]] = field(default_factory=list)\n    general_practitioner: Optional[List[Reference]] = field(default_factory=list)\n    gender: Optional[str] = None\n    marital_status: Optional[CodeableConcept] = None\n    contact: Optional[List[PatientContact]] = field(default_factory=list)"
           (gen.python/generate-class fixtures/patient-ir-schema))))

  (testing "with inner classes"
    (is (= "class PatientLink(BackboneElement):\n    other: Reference\n    type: str\n\nclass PatientCommunication(BackboneElement):\n    language: CodeableConcept\n    preferred: Optional[bool] = None\n\nclass PatientContact(BackboneElement):\n    address: Optional[Address] = None\n    gender: Optional[str] = None\n    name: Optional[HumanName] = None\n    organization: Optional[Reference] = None\n    period: Optional[Period] = None\n    relationship: Optional[List[CodeableConcept]] = None\n    telecom: Optional[List[ContactPoint]] = None\n\n@dataclass(kw_only=True)\nclass Patient(DomainResource):\n    multiple_birth_boolean: Optional[bool] = None\n    address: Optional[List[Address]] = field(default_factory=list)\n    deceased_date_time: Optional[str] = None\n    managing_organization: Optional[Reference] = None\n    deceased_boolean: Optional[bool] = None\n    name: Optional[List[HumanName]] = field(default_factory=list)\n    birth_date: Optional[str] = None\n    multiple_birth_integer: Optional[int] = None\n    photo: Optional[List[Attachment]] = field(default_factory=list)\n    link: Optional[List[PatientLink]] = field(default_factory=list)\n    active: Optional[bool] = None\n    communication: Optional[List[PatientCommunication]] = field(default_factory=list)\n    identifier: Optional[List[Identifier]] = field(default_factory=list)\n    telecom: Optional[List[ContactPoint]] = field(default_factory=list)\n    general_practitioner: Optional[List[Reference]] = field(default_factory=list)\n    gender: Optional[str] = None\n    marital_status: Optional[CodeableConcept] = None\n    contact: Optional[List[PatientContact]] = field(default_factory=list)"
           (gen.python/generate-class fixtures/patient-ir-schema
                                      ["class PatientLink(BackboneElement):\n    other: Reference\n    type: str"
                                       "class PatientCommunication(BackboneElement):\n    language: CodeableConcept\n    preferred: Optional[bool] = None"
                                       "class PatientContact(BackboneElement):\n    address: Optional[Address] = None\n    gender: Optional[str] = None\n    name: Optional[HumanName] = None\n    organization: Optional[Reference] = None\n    period: Optional[Period] = None\n    relationship: Optional[List[CodeableConcept]] = None\n    telecom: Optional[List[ContactPoint]] = None"])))))

(deftest test-generate-datatypes
  (is
   (= [{:path (io/file "base/__init__.py"),
        :content
        (str/join "\n" ["from __future__ import annotations"
                        "from typing import Optional, List"
                        "from dataclasses import dataclass, field"
                        ""
                        "@dataclass(kw_only=True)"
                        "class Coding(Element):"
                        "    code: Optional[str] = None"
                        "    system: Optional[str] = None"
                        "    display: Optional[str] = None"
                        "    version: Optional[str] = None"
                        "    user_selected: Optional[bool] = None"])}]

      (sut/generate-datatypes generator [fixtures/coding-ir-schema]))))

(deftest test-generate-resources
  (is
   (= {:path (io/file "hl7_fhir_r4_core/Patient.py"),
       :content
       (str/join "\n" ["from typing import Optional, List"
                       "from dataclasses import dataclass, field"
                       "from base import Address"
                       "from base import Attachment"
                       "from base import Period"
                       "from base import CodeableConcept"
                       "from base import ContactPoint"
                       "from base import DomainResource"
                       "from base import HumanName"
                       "from base import Reference"
                       "from base import Identifier"
                       "from base import BackboneElement"
                       ""
                       "@dataclass(kw_only=True)"
                       "class PatientLink(BackboneElement):"
                       "    type: str"
                       "    other: Reference"
                       ""
                       "@dataclass(kw_only=True)"
                       "class PatientCommunication(BackboneElement):"
                       "    language: CodeableConcept"
                       "    preferred: Optional[bool] = None"
                       ""
                       "@dataclass(kw_only=True)"
                       "class PatientContact(BackboneElement):"
                       "    name: Optional[HumanName] = None"
                       "    gender: Optional[str] = None"
                       "    period: Optional[Period] = None"
                       "    address: Optional[Address] = None"
                       "    telecom: Optional[List[ContactPoint]] = field(default_factory=list)"
                       "    organization: Optional[Reference] = None"
                       "    relationship: Optional[List[CodeableConcept]] = field(default_factory=list)"
                       ""
                       "@dataclass(kw_only=True)"
                       "class Patient(DomainResource):"
                       "    multiple_birth_boolean: Optional[bool] = None"
                       "    address: Optional[List[Address]] = field(default_factory=list)"
                       "    deceased_date_time: Optional[str] = None"
                       "    managing_organization: Optional[Reference] = None"
                       "    deceased_boolean: Optional[bool] = None"
                       "    name: Optional[List[HumanName]] = field(default_factory=list)"
                       "    birth_date: Optional[str] = None"
                       "    multiple_birth_integer: Optional[int] = None"
                       "    photo: Optional[List[Attachment]] = field(default_factory=list)"
                       "    link: Optional[List[PatientLink]] = field(default_factory=list)"
                       "    active: Optional[bool] = None"
                       "    communication: Optional[List[PatientCommunication]] = field(default_factory=list)"
                       "    identifier: Optional[List[Identifier]] = field(default_factory=list)"
                       "    telecom: Optional[List[ContactPoint]] = field(default_factory=list)"
                       "    general_practitioner: Optional[List[Reference]] = field(default_factory=list)"
                       "    gender: Optional[str] = None"
                       "    marital_status: Optional[CodeableConcept] = None"
                       "    contact: Optional[List[PatientContact]] = field(default_factory=list)"])}
      (sut/generate-resource-module generator fixtures/patient-ir-schema))))

(deftest test-generate-search-params
  (is
   (= (sut/generate-search-params generator fixtures/patient-search-params-ir-schemas)
      [{:path (io/file "search/PatientSearchParameters.py"),
        :content
        "from typing import Optional\nfrom dataclasses import dataclass, field\nfrom .DomainResourceSearchParameters import DomainResourceSearchParameters\n\n@dataclass(kw_only=True)\nclass PatientSearchParameters(DomainResourceSearchParameters):\n    id: Optional[str] = None\n    active: Optional[str] = None\n    address: Optional[str] = None\n    address_city: Optional[str] = None\n    address_country: Optional[str] = None\n    address_postalcode: Optional[str] = None\n    address_state: Optional[str] = None\n    address_use: Optional[str] = None\n    age: Optional[str] = None\n    birth_order_boolean: Optional[str] = None\n    birthdate: Optional[str] = None\n    death_date: Optional[str] = None\n    deceased: Optional[str] = None\n    email: Optional[str] = None\n    ethnicity: Optional[str] = None\n    family: Optional[str] = None\n    gender: Optional[str] = None\n    general_practitioner: Optional[str] = None\n    given: Optional[str] = None\n    identifier: Optional[str] = None\n    language: Optional[str] = None\n    link: Optional[str] = None\n    mothers_maiden_name: Optional[str] = None\n    name: Optional[str] = None\n    organization: Optional[str] = None\n    part_agree: Optional[str] = None\n    phone: Optional[str] = None\n    phonetic: Optional[str] = None\n    race: Optional[str] = None\n    telecom: Optional[str] = None"}])))

(deftest generate-constraints
  (is
   (= (first [{:path (io/file "hl7_fhir_r4_core/Ldlcholesterol.py"),
               :content
               "from typing import Optional, List\nfrom dataclasses import dataclass, field\nfrom base import Meta\n\n@dataclass(kw_only=True)\nclass ObservationReferenceRange:\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = field(default_factory=list)\n\n@dataclass(kw_only=True)\nclass ObservationComponentReferenceRange:\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = field(default_factory=list)\n\n@dataclass(kw_only=True)\nclass ObservationComponent:\n    reference_range: Optional[List[ObservationComponentReferenceRange]] = field(default_factory=list)\n    interpretation: Optional[List[CodeableConcept]] = field(default_factory=list)\n    value_time: Optional[str] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    value_sampled_data: Optional[SampledData] = None\n    code: CodeableConcept\n    value_codeable_concept: Optional[CodeableConcept] = None\n    value_period: Optional[Period] = None\n    value_range: Optional[Range] = None\n    value_integer: Optional[int] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n\n@dataclass(kw_only=True)\nclass Ldlcholesterol(DomainResource):\n    meta: Meta = Meta(profile=[\"http://hl7.org/fhir/StructureDefinition/ldlcholesterol\"])\n    category: Optional[List[CodeableConcept]] = field(default_factory=list)\n    reference_range: list[ObservationReferenceRange] = field(default_factory=list)\n    interpretation: Optional[List[CodeableConcept]] = field(default_factory=list)\n    encounter: Optional[Reference] = None\n    method: Optional[CodeableConcept] = None\n    value_time: Optional[str] = None\n    specimen: Optional[Reference] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    component: Optional[List[ObservationComponent]] = field(default_factory=list)\n    note: Optional[List[Annotation]] = field(default_factory=list)\n    value_sampled_data: Optional[SampledData] = None\n    effective_date_time: Optional[str] = None\n    status: str\n    code: CodeableConcept\n    identifier: Optional[List[Identifier]] = field(default_factory=list)\n    effective_timing: Optional[Timing] = None\n    value_codeable_concept: Optional[CodeableConcept] = None\n    body_site: Optional[CodeableConcept] = None\n    focus: Optional[List[Reference]] = field(default_factory=list)\n    issued: Optional[str] = None\n    value_period: Optional[Period] = None\n    device: Optional[Reference] = None\n    effective_instant: Optional[str] = None\n    based_on: Optional[List[Reference]] = field(default_factory=list)\n    value_range: Optional[Range] = None\n    part_of: Optional[List[Reference]] = field(default_factory=list)\n    value_integer: Optional[int] = None\n    subject: Optional[Reference] = None\n    performer: Optional[List[Reference]] = field(default_factory=list)\n    data_absent_reason: Optional[CodeableConcept] = None\n    effective_period: Optional[Period] = None"}
              {:path (io/file "hl7_fhir_r4_core/Cholesterol.py"),
               :content
               "from typing import Optional, List\nfrom dataclasses import dataclass, field\nfrom base import Meta\n\n@dataclass(kw_only=True)\nclass ObservationReferenceRange:\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = field(default_factory=list)\n\n@dataclass(kw_only=True)\nclass ObservationComponentReferenceRange:\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = field(default_factory=list)\n\n@dataclass(kw_only=True)\nclass ObservationComponent:\n    reference_range: Optional[List[ObservationComponentReferenceRange]] = field(default_factory=list)\n    interpretation: Optional[List[CodeableConcept]] = field(default_factory=list)\n    value_time: Optional[str] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    value_sampled_data: Optional[SampledData] = None\n    code: CodeableConcept\n    value_codeable_concept: Optional[CodeableConcept] = None\n    value_period: Optional[Period] = None\n    value_range: Optional[Range] = None\n    value_integer: Optional[int] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n\n@dataclass(kw_only=True)\nclass Cholesterol(DomainResource):\n    meta: Meta = Meta(profile=[\"http://hl7.org/fhir/StructureDefinition/cholesterol\"])\n    category: Optional[List[CodeableConcept]] = field(default_factory=list)\n    reference_range: list[ObservationReferenceRange] = field(default_factory=list)\n    interpretation: Optional[List[CodeableConcept]] = field(default_factory=list)\n    encounter: Optional[Reference] = None\n    method: Optional[CodeableConcept] = None\n    value_time: Optional[str] = None\n    specimen: Optional[Reference] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    component: Optional[List[ObservationComponent]] = field(default_factory=list)\n    note: Optional[List[Annotation]] = field(default_factory=list)\n    value_sampled_data: Optional[SampledData] = None\n    effective_date_time: Optional[str] = None\n    status: str\n    code: CodeableConcept\n    identifier: Optional[List[Identifier]] = field(default_factory=list)\n    effective_timing: Optional[Timing] = None\n    value_codeable_concept: Optional[CodeableConcept] = None\n    body_site: Optional[CodeableConcept] = None\n    focus: Optional[List[Reference]] = field(default_factory=list)\n    issued: Optional[str] = None\n    value_period: Optional[Period] = None\n    device: Optional[Reference] = None\n    effective_instant: Optional[str] = None\n    based_on: Optional[List[Reference]] = field(default_factory=list)\n    value_range: Optional[Range] = None\n    part_of: Optional[List[Reference]] = field(default_factory=list)\n    value_integer: Optional[int] = None\n    subject: Optional[Reference] = None\n    performer: Optional[List[Reference]] = field(default_factory=list)\n    data_absent_reason: Optional[CodeableConcept] = None\n    effective_period: Optional[Period] = None"}
              {:path
               (io/file "hl7_fhir_r4_core/ObservationGenetics.py"),
               :content
               "from typing import Optional, List\nfrom dataclasses import dataclass, field\nfrom base import Meta\n\n@dataclass(kw_only=True)\nclass ObservationReferenceRange:\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = field(default_factory=list)\n\n@dataclass(kw_only=True)\nclass ObservationComponentReferenceRange:\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = field(default_factory=list)\n\n@dataclass(kw_only=True)\nclass ObservationComponent:\n    reference_range: Optional[List[ObservationComponentReferenceRange]] = field(default_factory=list)\n    interpretation: Optional[List[CodeableConcept]] = field(default_factory=list)\n    value_time: Optional[str] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    value_sampled_data: Optional[SampledData] = None\n    code: CodeableConcept\n    value_codeable_concept: Optional[CodeableConcept] = None\n    value_period: Optional[Period] = None\n    value_range: Optional[Range] = None\n    value_integer: Optional[int] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n\n@dataclass(kw_only=True)\nclass ObservationGenetics(DomainResource):\n    meta: Meta = Meta(profile=[\"http://hl7.org/fhir/StructureDefinition/observation-genetics\"])\n    category: Optional[List[CodeableConcept]] = field(default_factory=list)\n    reference_range: Optional[List[ObservationReferenceRange]] = field(default_factory=list)\n    has_member: Optional[List[Reference]] = field(default_factory=list)\n    derived_from: Optional[List[Reference]] = field(default_factory=list)\n    interpretation: Optional[List[CodeableConcept]] = field(default_factory=list)\n    encounter: Optional[Reference] = None\n    method: Optional[CodeableConcept] = None\n    value_time: Optional[str] = None\n    specimen: Optional[Reference] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    component: Optional[List[ObservationComponent]] = field(default_factory=list)\n    note: Optional[List[Annotation]] = field(default_factory=list)\n    value_sampled_data: Optional[SampledData] = None\n    effective_date_time: Optional[str] = None\n    status: str\n    code: CodeableConcept\n    identifier: Optional[List[Identifier]] = field(default_factory=list)\n    effective_timing: Optional[Timing] = None\n    value_codeable_concept: Optional[CodeableConcept] = None\n    body_site: Optional[CodeableConcept] = None\n    focus: Optional[List[Reference]] = field(default_factory=list)\n    issued: Optional[str] = None\n    value_period: Optional[Period] = None\n    device: Optional[Reference] = None\n    effective_instant: Optional[str] = None\n    based_on: Optional[List[Reference]] = field(default_factory=list)\n    value_range: Optional[Range] = None\n    part_of: Optional[List[Reference]] = field(default_factory=list)\n    value_integer: Optional[int] = None\n    subject: Optional[Reference] = None\n    performer: Optional[List[Reference]] = field(default_factory=list)\n    data_absent_reason: Optional[CodeableConcept] = None\n    effective_period: Optional[Period] = None"}
              {:path
               (io/file "hl7_fhir_r4_core/Devicemetricobservation.py"),
               :content
               "from typing import Optional, List\nfrom dataclasses import dataclass, field\nfrom base import Meta\n\n@dataclass(kw_only=True)\nclass ObservationReferenceRange:\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = field(default_factory=list)\n\n@dataclass(kw_only=True)\nclass ObservationComponentReferenceRange:\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = field(default_factory=list)\n\n@dataclass(kw_only=True)\nclass ObservationComponent:\n    reference_range: Optional[List[ObservationComponentReferenceRange]] = field(default_factory=list)\n    interpretation: Optional[List[CodeableConcept]] = field(default_factory=list)\n    value_time: Optional[str] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    value_sampled_data: Optional[SampledData] = None\n    code: CodeableConcept\n    value_codeable_concept: Optional[CodeableConcept] = None\n    value_period: Optional[Period] = None\n    value_range: Optional[Range] = None\n    value_integer: Optional[int] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n\n@dataclass(kw_only=True)\nclass Devicemetricobservation(DomainResource):\n    meta: Meta = Meta(profile=[\"http://hl7.org/fhir/StructureDefinition/devicemetricobservation\"])\n    category: Optional[List[CodeableConcept]] = field(default_factory=list)\n    reference_range: Optional[List[ObservationReferenceRange]] = field(default_factory=list)\n    has_member: Optional[List[Reference]] = field(default_factory=list)\n    derived_from: Optional[List[Reference]] = field(default_factory=list)\n    interpretation: Optional[List[CodeableConcept]] = field(default_factory=list)\n    method: Optional[CodeableConcept] = None\n    value_time: Optional[str] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    component: Optional[List[ObservationComponent]] = field(default_factory=list)\n    note: Optional[List[Annotation]] = field(default_factory=list)\n    value_sampled_data: Optional[SampledData] = None\n    effective_date_time: str\n    status: str\n    code: CodeableConcept\n    identifier: Optional[List[Identifier]] = field(default_factory=list)\n    effective_timing: Optional[Timing] = None\n    value_codeable_concept: Optional[CodeableConcept] = None\n    body_site: Optional[CodeableConcept] = None\n    focus: Optional[List[Reference]] = field(default_factory=list)\n    value_period: Optional[Period] = None\n    device: Reference\n    effective_instant: Optional[str] = None\n    based_on: Optional[List[Reference]] = field(default_factory=list)\n    value_range: Optional[Range] = None\n    part_of: Optional[List[Reference]] = field(default_factory=list)\n    value_integer: Optional[int] = None\n    subject: Reference\n    performer: Optional[List[Reference]] = field(default_factory=list)\n    effective_period: Optional[Period] = None"}
              {:path (io/file "hl7_fhir_r4_core/Triglyceride.py"),
               :content
               "from typing import Optional, List\nfrom dataclasses import dataclass, field\nfrom base import Meta\n\n@dataclass(kw_only=True)\nclass ObservationReferenceRange:\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = field(default_factory=list)\n\n@dataclass(kw_only=True)\nclass ObservationComponentReferenceRange:\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = field(default_factory=list)\n\n@dataclass(kw_only=True)\nclass ObservationComponent:\n    reference_range: Optional[List[ObservationComponentReferenceRange]] = field(default_factory=list)\n    interpretation: Optional[List[CodeableConcept]] = field(default_factory=list)\n    value_time: Optional[str] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    value_sampled_data: Optional[SampledData] = None\n    code: CodeableConcept\n    value_codeable_concept: Optional[CodeableConcept] = None\n    value_period: Optional[Period] = None\n    value_range: Optional[Range] = None\n    value_integer: Optional[int] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n\n@dataclass(kw_only=True)\nclass Triglyceride(DomainResource):\n    meta: Meta = Meta(profile=[\"http://hl7.org/fhir/StructureDefinition/triglyceride\"])\n    category: Optional[List[CodeableConcept]] = field(default_factory=list)\n    reference_range: list[ObservationReferenceRange] = field(default_factory=list)\n    interpretation: Optional[List[CodeableConcept]] = field(default_factory=list)\n    encounter: Optional[Reference] = None\n    method: Optional[CodeableConcept] = None\n    value_time: Optional[str] = None\n    specimen: Optional[Reference] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    component: Optional[List[ObservationComponent]] = field(default_factory=list)\n    note: Optional[List[Annotation]] = field(default_factory=list)\n    value_sampled_data: Optional[SampledData] = None\n    effective_date_time: Optional[str] = None\n    status: str\n    code: CodeableConcept\n    identifier: Optional[List[Identifier]] = field(default_factory=list)\n    effective_timing: Optional[Timing] = None\n    value_codeable_concept: Optional[CodeableConcept] = None\n    body_site: Optional[CodeableConcept] = None\n    focus: Optional[List[Reference]] = field(default_factory=list)\n    issued: Optional[str] = None\n    value_period: Optional[Period] = None\n    device: Optional[Reference] = None\n    effective_instant: Optional[str] = None\n    based_on: Optional[List[Reference]] = field(default_factory=list)\n    value_range: Optional[Range] = None\n    part_of: Optional[List[Reference]] = field(default_factory=list)\n    value_integer: Optional[int] = None\n    subject: Optional[Reference] = None\n    performer: Optional[List[Reference]] = field(default_factory=list)\n    data_absent_reason: Optional[CodeableConcept] = None\n    effective_period: Optional[Period] = None"}
              {:path (io/file "hl7_fhir_r4_core/Vitalsigns.py"),
               :content
               "from typing import Optional, List\nfrom dataclasses import dataclass, field\nfrom base import Meta\n\n@dataclass(kw_only=True)\nclass ObservationReferenceRange:\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = field(default_factory=list)\n\n@dataclass(kw_only=True)\nclass ObservationComponentReferenceRange:\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = field(default_factory=list)\n\n@dataclass(kw_only=True)\nclass ObservationComponent:\n    reference_range: Optional[List[ObservationComponentReferenceRange]] = field(default_factory=list)\n    interpretation: Optional[List[CodeableConcept]] = field(default_factory=list)\n    value_time: Optional[str] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    value_sampled_data: Optional[SampledData] = None\n    code: CodeableConcept\n    value_codeable_concept: Optional[CodeableConcept] = None\n    value_period: Optional[Period] = None\n    value_range: Optional[Range] = None\n    value_integer: Optional[int] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n\n@dataclass(kw_only=True)\nclass Vitalsigns(DomainResource):\n    meta: Meta = Meta(profile=[\"http://hl7.org/fhir/StructureDefinition/vitalsigns\"])\n    category: list[CodeableConcept] = field(default_factory=list)\n    reference_range: Optional[List[ObservationReferenceRange]] = field(default_factory=list)\n    has_member: Optional[List[Reference]] = field(default_factory=list)\n    derived_from: Optional[List[Reference]] = field(default_factory=list)\n    interpretation: Optional[List[CodeableConcept]] = field(default_factory=list)\n    encounter: Optional[Reference] = None\n    method: Optional[CodeableConcept] = None\n    value_time: Optional[str] = None\n    specimen: Optional[Reference] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    component: Optional[List[ObservationComponent]] = field(default_factory=list)\n    note: Optional[List[Annotation]] = field(default_factory=list)\n    value_sampled_data: Optional[SampledData] = None\n    effective_date_time: Optional[str] = None\n    status: str\n    code: CodeableConcept\n    identifier: Optional[List[Identifier]] = field(default_factory=list)\n    effective_timing: Optional[Timing] = None\n    value_codeable_concept: Optional[CodeableConcept] = None\n    body_site: Optional[CodeableConcept] = None\n    focus: Optional[List[Reference]] = field(default_factory=list)\n    issued: Optional[str] = None\n    value_period: Optional[Period] = None\n    device: Optional[Reference] = None\n    effective_instant: Optional[str] = None\n    based_on: Optional[List[Reference]] = field(default_factory=list)\n    value_range: Optional[Range] = None\n    part_of: Optional[List[Reference]] = field(default_factory=list)\n    value_integer: Optional[int] = None\n    subject: Reference\n    performer: Optional[List[Reference]] = field(default_factory=list)\n    data_absent_reason: Optional[CodeableConcept] = None\n    effective_period: Optional[Period] = None"}
              {:path (io/file "hl7_fhir_r4_core/Hdlcholesterol.py"),
               :content
               "from typing import Optional, List\nfrom dataclasses import dataclass, field\nfrom base import Meta\n\n@dataclass(kw_only=True)\nclass ObservationReferenceRange:\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = field(default_factory=list)\n\n@dataclass(kw_only=True)\nclass ObservationComponentReferenceRange:\n    age: Optional[Range] = None\n    low: Optional[Quantity] = None\n    high: Optional[Quantity] = None\n    text: Optional[str] = None\n    type: Optional[CodeableConcept] = None\n    applies_to: Optional[List[CodeableConcept]] = field(default_factory=list)\n\n@dataclass(kw_only=True)\nclass ObservationComponent:\n    reference_range: Optional[List[ObservationComponentReferenceRange]] = field(default_factory=list)\n    interpretation: Optional[List[CodeableConcept]] = field(default_factory=list)\n    value_time: Optional[str] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    value_sampled_data: Optional[SampledData] = None\n    code: CodeableConcept\n    value_codeable_concept: Optional[CodeableConcept] = None\n    value_period: Optional[Period] = None\n    value_range: Optional[Range] = None\n    value_integer: Optional[int] = None\n    data_absent_reason: Optional[CodeableConcept] = None\n\n@dataclass(kw_only=True)\nclass Hdlcholesterol(DomainResource):\n    meta: Meta = Meta(profile=[\"http://hl7.org/fhir/StructureDefinition/hdlcholesterol\"])\n    category: Optional[List[CodeableConcept]] = field(default_factory=list)\n    reference_range: list[ObservationReferenceRange] = field(default_factory=list)\n    interpretation: Optional[List[CodeableConcept]] = field(default_factory=list)\n    encounter: Optional[Reference] = None\n    method: Optional[CodeableConcept] = None\n    value_time: Optional[str] = None\n    specimen: Optional[Reference] = None\n    value_quantity: Optional[Quantity] = None\n    value_string: Optional[str] = None\n    value_ratio: Optional[Ratio] = None\n    value_boolean: Optional[bool] = None\n    value_date_time: Optional[str] = None\n    component: Optional[List[ObservationComponent]] = field(default_factory=list)\n    note: Optional[List[Annotation]] = field(default_factory=list)\n    value_sampled_data: Optional[SampledData] = None\n    effective_date_time: Optional[str] = None\n    status: str\n    code: CodeableConcept\n    identifier: Optional[List[Identifier]] = field(default_factory=list)\n    effective_timing: Optional[Timing] = None\n    value_codeable_concept: Optional[CodeableConcept] = None\n    body_site: Optional[CodeableConcept] = None\n    focus: Optional[List[Reference]] = field(default_factory=list)\n    issued: Optional[str] = None\n    value_period: Optional[Period] = None\n    device: Optional[Reference] = None\n    effective_instant: Optional[str] = None\n    based_on: Optional[List[Reference]] = field(default_factory=list)\n    value_range: Optional[Range] = None\n    part_of: Optional[List[Reference]] = field(default_factory=list)\n    value_integer: Optional[int] = None\n    subject: Optional[Reference] = None\n    performer: Optional[List[Reference]] = field(default_factory=list)\n    data_absent_reason: Optional[CodeableConcept] = None\n    effective_period: Optional[Period] = None"}])
      (first (sut/generate-constraints generator (vals fixtures/observation-constraints-ir-schema))))))
