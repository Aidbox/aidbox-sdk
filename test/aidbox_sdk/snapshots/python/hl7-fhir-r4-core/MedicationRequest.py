from typing import Optional, List
from pydantic import *
from base.Annotation import Annotation
from base.Period import Period
from base.CodeableConcept import CodeableConcept
from base.Dosage import Dosage
from base.Quantity import Quantity
from base.Duration import Duration
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier
from base.BackboneElement import BackboneElement

class MedicationRequest_Substitution(BackboneElement):
    reason: Optional[CodeableConcept] = None
    allowed_boolean: Optional[bool] = None
    allowed_codeable_concept: Optional[CodeableConcept] = None

class MedicationRequest_DispenseRequest_InitialFill(BackboneElement):
    duration: Optional[Duration] = None
    quantity: Optional[Quantity] = None

class MedicationRequest_DispenseRequest(BackboneElement):
    quantity: Optional[Quantity] = None
    performer: Optional[Reference] = None
    initial_fill: Optional[MedicationRequest_DispenseRequest_InitialFill] = None
    validity_period: Optional[Period] = None
    dispense_interval: Optional[Duration] = None
    expected_supply_duration: Optional[Duration] = None
    number_of_repeats_allowed: Optional[int] = None

class MedicationRequest(DomainResource):
    performer_type: Optional[CodeableConcept] = None
    category: Optional[List[CodeableConcept]] = None
    insurance: Optional[List[Reference]] = None
    instantiates_canonical: Optional[List[str]] = None
    event_history: Optional[List[Reference]] = None
    instantiates_uri: Optional[List[str]] = None
    substitution: Optional[MedicationRequest_Substitution] = None
    detected_issue: Optional[List[Reference]] = None
    encounter: Optional[Reference] = None
    dispense_request: Optional[MedicationRequest_DispenseRequest] = None
    reason_code: Optional[List[CodeableConcept]] = None
    medication_codeable_concept: Optional[CodeableConcept] = None
    status_reason: Optional[CodeableConcept] = None
    authored_on: Optional[str] = None
    note: Optional[List[Annotation]] = None
    requester: Optional[Reference] = None
    supporting_information: Optional[List[Reference]] = None
    reported_reference: Optional[Reference] = None
    priority: Optional[str] = None
    status: str
    dosage_instruction: Optional[List[Dosage]] = None
    group_identifier: Optional[Identifier] = None
    recorder: Optional[Reference] = None
    reported_boolean: Optional[bool] = None
    identifier: Optional[List[Identifier]] = None
    do_not_perform: Optional[bool] = None
    intent: str
    based_on: Optional[List[Reference]] = None
    prior_prescription: Optional[Reference] = None
    medication_reference: Optional[Reference] = None
    course_of_therapy_type: Optional[CodeableConcept] = None
    subject: Reference
    performer: Optional[Reference] = None
    reason_reference: Optional[List[Reference]] = None