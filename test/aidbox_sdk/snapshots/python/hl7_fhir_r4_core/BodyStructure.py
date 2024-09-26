from typing import Optional, List
from dataclasses import dataclass, field
from base import Attachment
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class BodyStructure(DomainResource):
    image: Optional[List[Attachment]] = field(default_factory=list)
    active: Optional[bool] = None
    patient: Reference
    location: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    morphology: Optional[CodeableConcept] = None
    description: Optional[str] = None
    location_qualifier: Optional[List[CodeableConcept]] = field(default_factory=list)