from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class AppointmentResponse(DomainResource):
    end: Optional[str] = None
    actor: Optional[Reference] = None
    start: Optional[str] = None
    comment: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    appointment: Reference
    participant_type: Optional[List[CodeableConcept]] = field(default_factory=list)
    participant_status: str