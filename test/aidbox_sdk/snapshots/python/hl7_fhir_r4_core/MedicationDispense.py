from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import CodeableConcept
from base import Dosage
from base import Quantity
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class MedicationDispenseSubstitution(BackboneElement):
    type: Optional[CodeableConcept] = None
    reason: Optional[List[CodeableConcept]] = field(default_factory=list)
    was_substituted: bool
    responsible_party: Optional[List[Reference]] = field(default_factory=list)

@dataclass(kw_only=True)
class MedicationDispensePerformer(BackboneElement):
    actor: Reference
    function: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class MedicationDispense(DomainResource):
    status_reason_reference: Optional[Reference] = None
    category: Optional[CodeableConcept] = None
    when_handed_over: Optional[str] = None
    when_prepared: Optional[str] = None
    event_history: Optional[List[Reference]] = field(default_factory=list)
    substitution: Optional[MedicationDispenseSubstitution] = None
    detected_issue: Optional[List[Reference]] = field(default_factory=list)
    medication_codeable_concept: Optional[CodeableConcept] = None
    type: Optional[CodeableConcept] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    status_reason_codeable_concept: Optional[CodeableConcept] = None
    supporting_information: Optional[List[Reference]] = field(default_factory=list)
    status: str
    dosage_instruction: Optional[List[Dosage]] = field(default_factory=list)
    days_supply: Optional[Quantity] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    context: Optional[Reference] = None
    medication_reference: Optional[Reference] = None
    quantity: Optional[Quantity] = None
    part_of: Optional[List[Reference]] = field(default_factory=list)
    location: Optional[Reference] = None
    authorizing_prescription: Optional[List[Reference]] = field(default_factory=list)
    receiver: Optional[List[Reference]] = field(default_factory=list)
    subject: Optional[Reference] = None
    destination: Optional[Reference] = None
    performer: Optional[List[MedicationDispensePerformer]] = field(default_factory=list)