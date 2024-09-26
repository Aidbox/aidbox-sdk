from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class Slot(DomainResource):
    schedule: Reference
    service_category: Optional[List[CodeableConcept]] = field(default_factory=list)
    specialty: Optional[List[CodeableConcept]] = field(default_factory=list)
    start: str
    service_type: Optional[List[CodeableConcept]] = field(default_factory=list)
    appointment_type: Optional[CodeableConcept] = None
    status: str
    comment: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    end: str
    overbooked: Optional[bool] = None