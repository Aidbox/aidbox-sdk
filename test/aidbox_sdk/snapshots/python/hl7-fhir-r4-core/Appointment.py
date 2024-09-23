from typing import Optional, List
from pydantic import *
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class Appointment_Participant(BackboneElement):
    type: Optional[List[CodeableConcept]] = None
    actor: Optional[Reference] = None
    period: Optional[Period] = None
    status: str
    required: Optional[str] = None

class Appointment(DomainResource):
    description: Optional[str] = None
    service_category: Optional[List[CodeableConcept]] = None
    slot: Optional[List[Reference]] = None
    specialty: Optional[List[CodeableConcept]] = None
    cancelation_reason: Optional[CodeableConcept] = None
    requested_period: Optional[List[Period]] = None
    patient_instruction: Optional[str] = None
    start: Optional[str] = None
    reason_code: Optional[List[CodeableConcept]] = None
    created: Optional[str] = None
    participant: list[Appointment_Participant] = []
    service_type: Optional[List[CodeableConcept]] = None
    supporting_information: Optional[List[Reference]] = None
    priority: Optional[int] = None
    appointment_type: Optional[CodeableConcept] = None
    status: str
    comment: Optional[str] = None
    minutes_duration: Optional[int] = None
    identifier: Optional[List[Identifier]] = None
    based_on: Optional[List[Reference]] = None
    end: Optional[str] = None
    reason_reference: Optional[List[Reference]] = None