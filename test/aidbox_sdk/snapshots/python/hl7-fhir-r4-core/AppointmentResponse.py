from typing import Optional, List
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier

class AppointmentResponse(DomainResource):
    end: Optional[str] = None
    actor: Optional[Reference] = None
    start: Optional[str] = None
    comment: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    appointment: Reference
    participant_type: Optional[List[CodeableConcept]] = None
    participant_status: str