from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Period
from base import CodeableConcept
from base import Dosage
from base import DomainResource
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class MedicationStatement(DomainResource):
    category: Optional[CodeableConcept] = None
    dosage: Optional[List[Dosage]] = field(default_factory=list)
    derived_from: Optional[List[Reference]] = field(default_factory=list)
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    medication_codeable_concept: Optional[CodeableConcept] = None
    status_reason: Optional[List[CodeableConcept]] = field(default_factory=list)
    note: Optional[List[Annotation]] = field(default_factory=list)
    effective_date_time: Optional[str] = None
    status: str
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    context: Optional[Reference] = None
    date_asserted: Optional[str] = None
    based_on: Optional[List[Reference]] = field(default_factory=list)
    medication_reference: Optional[Reference] = None
    part_of: Optional[List[Reference]] = field(default_factory=list)
    information_source: Optional[Reference] = None
    subject: Reference
    effective_period: Optional[Period] = None
    reason_reference: Optional[List[Reference]] = field(default_factory=list)