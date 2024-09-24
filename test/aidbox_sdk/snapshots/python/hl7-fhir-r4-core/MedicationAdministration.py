from typing import Optional, List
from base import Annotation
from base import Period
from base import CodeableConcept
from base import Quantity
from base import DomainResource
from base import Ratio
from base import Reference
from base import Identifier
from base import BackboneElement

class MedicationAdministration_Dosage(BackboneElement):
    dose: Optional[Quantity] = None
    site: Optional[CodeableConcept] = None
    text: Optional[str] = None
    route: Optional[CodeableConcept] = None
    method: Optional[CodeableConcept] = None
    rate_ratio: Optional[Ratio] = None
    rate_quantity: Optional[Quantity] = None

class MedicationAdministration_Performer(BackboneElement):
    actor: Reference
    function: Optional[CodeableConcept] = None

class MedicationAdministration(DomainResource):
    category: Optional[CodeableConcept] = None
    request: Optional[Reference] = None
    event_history: Optional[List[Reference]] = None
    dosage: Optional[MedicationAdministration_Dosage] = None
    instantiates: Optional[List[str]] = None
    reason_code: Optional[List[CodeableConcept]] = None
    medication_codeable_concept: Optional[CodeableConcept] = None
    status_reason: Optional[List[CodeableConcept]] = None
    note: Optional[List[Annotation]] = None
    supporting_information: Optional[List[Reference]] = None
    effective_date_time: Optional[str] = None
    status: str
    identifier: Optional[List[Identifier]] = None
    context: Optional[Reference] = None
    device: Optional[List[Reference]] = None
    medication_reference: Optional[Reference] = None
    part_of: Optional[List[Reference]] = None
    subject: Reference
    performer: Optional[List[MedicationAdministration_Performer]] = None
    effective_period: Optional[Period] = None
    reason_reference: Optional[List[Reference]] = None