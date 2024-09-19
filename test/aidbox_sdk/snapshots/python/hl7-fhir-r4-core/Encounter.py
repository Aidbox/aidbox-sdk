from pydantic import *
from typing import Optional, List
from ..base import *

class Encounter_Diagnosis(BackboneElement):
    use: Optional[CodeableConcept] = None
    rank: Optional[int] = None
    condition: Reference

class Encounter_Participant(BackboneElement):
    type: Optional[List[CodeableConcept]] = None
    period: Optional[Period] = None
    individual: Optional[Reference] = None

class Encounter_ClassHistory(BackboneElement):
    class: Coding
    period: Period

class Encounter_Hospitalization(BackboneElement):
    discharge_disposition: Optional[CodeableConcept] = None
    pre_admission_identifier: Optional[Identifier] = None
    special_arrangement: Optional[List[CodeableConcept]] = None
    diet_preference: Optional[List[CodeableConcept]] = None
    admit_source: Optional[CodeableConcept] = None
    special_courtesy: Optional[List[CodeableConcept]] = None
    re_admission: Optional[CodeableConcept] = None
    origin: Optional[Reference] = None
    destination: Optional[Reference] = None

class Encounter_Location(BackboneElement):
    period: Optional[Period] = None
    status: Optional[str] = None
    location: Reference
    physical_type: Optional[CodeableConcept] = None

class Encounter_StatusHistory(BackboneElement):
    period: Period
    status: str

class Encounter(DomainResource):
    appointment: Optional[List[Reference]] = None
    diagnosis: Optional[List[Encounter_Diagnosis]] = None
    service_provider: Optional[Reference] = None
    episode_of_care: Optional[List[Reference]] = None
    reason_code: Optional[List[CodeableConcept]] = None
    type: Optional[List[CodeableConcept]] = None
    participant: Optional[List[Encounter_Participant]] = None
    service_type: Optional[CodeableConcept] = None
    account: Optional[List[Reference]] = None
    class_history: Optional[List[Encounter_ClassHistory]] = None
    priority: Optional[CodeableConcept] = None
    status: str
    class: Coding
    length: Optional[Duration] = None
    identifier: Optional[List[Identifier]] = None
    hospitalization: Optional[Encounter_Hospitalization] = None
    period: Optional[Period] = None
    based_on: Optional[List[Reference]] = None
    part_of: Optional[Reference] = None
    location: Optional[List[Encounter_Location]] = None
    subject: Optional[Reference] = None
    status_history: Optional[List[Encounter_StatusHistory]] = None
    reason_reference: Optional[List[Reference]] = None