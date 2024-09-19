from pydantic import *
from typing import Optional, List
from ..base import *

class Slot(DomainResource):
    schedule: Reference
    service_category: Optional[List[CodeableConcept]] = None
    specialty: Optional[List[CodeableConcept]] = None
    start: str
    service_type: Optional[List[CodeableConcept]] = None
    appointment_type: Optional[CodeableConcept] = None
    status: str
    comment: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    end: str
    overbooked: Optional[bool] = None