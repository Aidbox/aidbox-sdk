from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Period
from base import CodeableConcept
from base import Dosage
from base import Quantity
from base import Duration
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class MedicationRequestSubstitution(BackboneElement):
    reason: Optional[CodeableConcept] = None
    allowed_boolean: Optional[bool] = None
    allowed_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class MedicationRequestDispenseRequestInitialFill(BackboneElement):
    duration: Optional[Duration] = None
    quantity: Optional[Quantity] = None

@dataclass(kw_only=True)
class MedicationRequestDispenseRequest(BackboneElement):
    quantity: Optional[Quantity] = None
    performer: Optional[Reference] = None
    initial_fill: Optional[MedicationRequestDispenseRequestInitialFill] = None
    validity_period: Optional[Period] = None
    dispense_interval: Optional[Duration] = None
    expected_supply_duration: Optional[Duration] = None
    number_of_repeats_allowed: Optional[int] = None

@dataclass(kw_only=True)
class MedicationRequest(DomainResource):
    performer_type: Optional[CodeableConcept] = None
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    insurance: Optional[List[Reference]] = field(default_factory=list)
    instantiates_canonical: Optional[List[str]] = field(default_factory=list)
    event_history: Optional[List[Reference]] = field(default_factory=list)
    instantiates_uri: Optional[List[str]] = field(default_factory=list)
    substitution: Optional[MedicationRequestSubstitution] = None
    detected_issue: Optional[List[Reference]] = field(default_factory=list)
    encounter: Optional[Reference] = None
    dispense_request: Optional[MedicationRequestDispenseRequest] = None
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    medication_codeable_concept: Optional[CodeableConcept] = None
    status_reason: Optional[CodeableConcept] = None
    authored_on: Optional[str] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    requester: Optional[Reference] = None
    supporting_information: Optional[List[Reference]] = field(default_factory=list)
    reported_reference: Optional[Reference] = None
    priority: Optional[str] = None
    status: str
    dosage_instruction: Optional[List[Dosage]] = field(default_factory=list)
    group_identifier: Optional[Identifier] = None
    recorder: Optional[Reference] = None
    reported_boolean: Optional[bool] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    do_not_perform: Optional[bool] = None
    intent: str
    based_on: Optional[List[Reference]] = field(default_factory=list)
    prior_prescription: Optional[Reference] = None
    medication_reference: Optional[Reference] = None
    course_of_therapy_type: Optional[CodeableConcept] = None
    subject: Reference
    performer: Optional[Reference] = None
    reason_reference: Optional[List[Reference]] = field(default_factory=list)