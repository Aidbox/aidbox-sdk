from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import Coding
from base import Duration
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class EncounterDiagnosis(BackboneElement):
    use: Optional[CodeableConcept] = None
    rank: Optional[int] = None
    condition: Reference

@dataclass(kw_only=True)
class EncounterParticipant(BackboneElement):
    type: Optional[List[CodeableConcept]] = field(default_factory=list)
    period: Optional[Period] = None
    individual: Optional[Reference] = None

@dataclass(kw_only=True)
class EncounterClassHistory(BackboneElement):
    class_: Coding
    period: Period

@dataclass(kw_only=True)
class EncounterHospitalization(BackboneElement):
    discharge_disposition: Optional[CodeableConcept] = None
    pre_admission_identifier: Optional[Identifier] = None
    special_arrangement: Optional[List[CodeableConcept]] = field(default_factory=list)
    diet_preference: Optional[List[CodeableConcept]] = field(default_factory=list)
    admit_source: Optional[CodeableConcept] = None
    special_courtesy: Optional[List[CodeableConcept]] = field(default_factory=list)
    re_admission: Optional[CodeableConcept] = None
    origin: Optional[Reference] = None
    destination: Optional[Reference] = None

@dataclass(kw_only=True)
class EncounterLocation(BackboneElement):
    period: Optional[Period] = None
    status: Optional[str] = None
    location: Reference
    physical_type: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class EncounterStatusHistory(BackboneElement):
    period: Period
    status: str

@dataclass(kw_only=True)
class Encounter(DomainResource):
    appointment: Optional[List[Reference]] = field(default_factory=list)
    diagnosis: Optional[List[EncounterDiagnosis]] = field(default_factory=list)
    service_provider: Optional[Reference] = None
    episode_of_care: Optional[List[Reference]] = field(default_factory=list)
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    type: Optional[List[CodeableConcept]] = field(default_factory=list)
    participant: Optional[List[EncounterParticipant]] = field(default_factory=list)
    service_type: Optional[CodeableConcept] = None
    account: Optional[List[Reference]] = field(default_factory=list)
    class_history: Optional[List[EncounterClassHistory]] = field(default_factory=list)
    priority: Optional[CodeableConcept] = None
    status: str
    class_: Coding
    length: Optional[Duration] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    hospitalization: Optional[EncounterHospitalization] = None
    period: Optional[Period] = None
    based_on: Optional[List[Reference]] = field(default_factory=list)
    part_of: Optional[Reference] = None
    location: Optional[List[EncounterLocation]] = field(default_factory=list)
    subject: Optional[Reference] = None
    status_history: Optional[List[EncounterStatusHistory]] = field(default_factory=list)
    reason_reference: Optional[List[Reference]] = field(default_factory=list)