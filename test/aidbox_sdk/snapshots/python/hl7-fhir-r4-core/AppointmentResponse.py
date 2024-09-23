from typing import Optional, List
from pydantic import *
from ..base.CodeableConcept import CodeableConcept
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier

class AppointmentResponse(DomainResource):
    end: Optional[str] = None
    actor: Optional[Reference] = None
    start: Optional[str] = None
    comment: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    appointment: Reference
    participant_type: Optional[List[CodeableConcept]] = None
    participant_status: str