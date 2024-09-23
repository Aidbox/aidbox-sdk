from typing import Optional, List
from pydantic import *
from ..base import *

class BodyStructure(DomainResource):
    image: Optional[List[Attachment]] = None
    active: Optional[bool] = None
    patient: Reference
    location: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    morphology: Optional[CodeableConcept] = None
    description: Optional[str] = None
    location_qualifier: Optional[List[CodeableConcept]] = None