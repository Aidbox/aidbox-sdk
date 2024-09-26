from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Period
from base import CodeableConcept
from base import Quantity
from base import DomainResource
from base import Ratio
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class MedicationAdministrationDosage(BackboneElement):
    dose: Optional[Quantity] = None
    site: Optional[CodeableConcept] = None
    text: Optional[str] = None
    route: Optional[CodeableConcept] = None
    method: Optional[CodeableConcept] = None
    rate_ratio: Optional[Ratio] = None
    rate_quantity: Optional[Quantity] = None

@dataclass(kw_only=True)
class MedicationAdministrationPerformer(BackboneElement):
    actor: Reference
    function: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class MedicationAdministration(DomainResource):
    category: Optional[CodeableConcept] = None
    request: Optional[Reference] = None
    event_history: Optional[List[Reference]] = field(default_factory=list)
    dosage: Optional[MedicationAdministrationDosage] = None
    instantiates: Optional[List[str]] = field(default_factory=list)
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    medication_codeable_concept: Optional[CodeableConcept] = None
    status_reason: Optional[List[CodeableConcept]] = field(default_factory=list)
    note: Optional[List[Annotation]] = field(default_factory=list)
    supporting_information: Optional[List[Reference]] = field(default_factory=list)
    effective_date_time: Optional[str] = None
    status: str
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    context: Optional[Reference] = None
    device: Optional[List[Reference]] = field(default_factory=list)
    medication_reference: Optional[Reference] = None
    part_of: Optional[List[Reference]] = field(default_factory=list)
    subject: Reference
    performer: Optional[List[MedicationAdministrationPerformer]] = field(default_factory=list)
    effective_period: Optional[Period] = None
    reason_reference: Optional[List[Reference]] = field(default_factory=list)