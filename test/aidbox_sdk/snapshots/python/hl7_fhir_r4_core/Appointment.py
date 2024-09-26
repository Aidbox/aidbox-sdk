from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class AppointmentParticipant(BackboneElement):
    type: Optional[List[CodeableConcept]] = field(default_factory=list)
    actor: Optional[Reference] = None
    period: Optional[Period] = None
    status: str
    required: Optional[str] = None

@dataclass(kw_only=True)
class Appointment(DomainResource):
    description: Optional[str] = None
    service_category: Optional[List[CodeableConcept]] = field(default_factory=list)
    slot: Optional[List[Reference]] = field(default_factory=list)
    specialty: Optional[List[CodeableConcept]] = field(default_factory=list)
    cancelation_reason: Optional[CodeableConcept] = None
    requested_period: Optional[List[Period]] = field(default_factory=list)
    patient_instruction: Optional[str] = None
    start: Optional[str] = None
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    created: Optional[str] = None
    participant: list[AppointmentParticipant] = field(default_factory=list)
    service_type: Optional[List[CodeableConcept]] = field(default_factory=list)
    supporting_information: Optional[List[Reference]] = field(default_factory=list)
    priority: Optional[int] = None
    appointment_type: Optional[CodeableConcept] = None
    status: str
    comment: Optional[str] = None
    minutes_duration: Optional[int] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    based_on: Optional[List[Reference]] = field(default_factory=list)
    end: Optional[str] = None
    reason_reference: Optional[List[Reference]] = field(default_factory=list)