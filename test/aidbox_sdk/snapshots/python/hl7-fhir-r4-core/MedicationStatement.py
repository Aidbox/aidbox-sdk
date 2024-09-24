from typing import Optional, List
from base import Annotation
from base import Period
from base import CodeableConcept
from base import Dosage
from base import DomainResource
from base import Reference
from base import Identifier

class MedicationStatement(DomainResource):
    category: Optional[CodeableConcept] = None
    dosage: Optional[List[Dosage]] = None
    derived_from: Optional[List[Reference]] = None
    reason_code: Optional[List[CodeableConcept]] = None
    medication_codeable_concept: Optional[CodeableConcept] = None
    status_reason: Optional[List[CodeableConcept]] = None
    note: Optional[List[Annotation]] = None
    effective_date_time: Optional[str] = None
    status: str
    identifier: Optional[List[Identifier]] = None
    context: Optional[Reference] = None
    date_asserted: Optional[str] = None
    based_on: Optional[List[Reference]] = None
    medication_reference: Optional[Reference] = None
    part_of: Optional[List[Reference]] = None
    information_source: Optional[Reference] = None
    subject: Reference
    effective_period: Optional[Period] = None
    reason_reference: Optional[List[Reference]] = None