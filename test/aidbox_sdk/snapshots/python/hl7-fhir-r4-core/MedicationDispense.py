from typing import Optional, List
from pydantic import *
from ..base.Annotation import Annotation
from ..base.CodeableConcept import CodeableConcept
from ..base.Dosage import Dosage
from ..base.Quantity import Quantity
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class MedicationDispense_Substitution(BackboneElement):
    type: Optional[CodeableConcept] = None
    reason: Optional[List[CodeableConcept]] = None
    was_substituted: bool
    responsible_party: Optional[List[Reference]] = None

class MedicationDispense_Performer(BackboneElement):
    actor: Reference
    function: Optional[CodeableConcept] = None

class MedicationDispense(DomainResource):
    status_reason_reference: Optional[Reference] = None
    category: Optional[CodeableConcept] = None
    when_handed_over: Optional[str] = None
    when_prepared: Optional[str] = None
    event_history: Optional[List[Reference]] = None
    substitution: Optional[MedicationDispense_Substitution] = None
    detected_issue: Optional[List[Reference]] = None
    medication_codeable_concept: Optional[CodeableConcept] = None
    type: Optional[CodeableConcept] = None
    note: Optional[List[Annotation]] = None
    status_reason_codeable_concept: Optional[CodeableConcept] = None
    supporting_information: Optional[List[Reference]] = None
    status: str
    dosage_instruction: Optional[List[Dosage]] = None
    days_supply: Optional[Quantity] = None
    identifier: Optional[List[Identifier]] = None
    context: Optional[Reference] = None
    medication_reference: Optional[Reference] = None
    quantity: Optional[Quantity] = None
    part_of: Optional[List[Reference]] = None
    location: Optional[Reference] = None
    authorizing_prescription: Optional[List[Reference]] = None
    receiver: Optional[List[Reference]] = None
    subject: Optional[Reference] = None
    destination: Optional[Reference] = None
    performer: Optional[List[MedicationDispense_Performer]] = None