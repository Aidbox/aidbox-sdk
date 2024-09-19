from pydantic import *
from typing import Optional, List
from ..base import *

class AppointmentResponse(DomainResource):
    end: Optional[str] = None
    actor: Optional[Reference] = None
    start: Optional[str] = None
    comment: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    appointment: Reference
    participant_type: Optional[List[CodeableConcept]] = None
    participant_status: str