from typing import Optional, List
from pydantic import *
from base.Attachment import Attachment
from base.CodeableConcept import CodeableConcept
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier

class BodyStructure(DomainResource):
    image: Optional[List[Attachment]] = None
    active: Optional[bool] = None
    patient: Reference
    location: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    morphology: Optional[CodeableConcept] = None
    description: Optional[str] = None
    location_qualifier: Optional[List[CodeableConcept]] = None