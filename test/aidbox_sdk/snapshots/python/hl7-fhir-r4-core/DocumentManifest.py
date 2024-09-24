from typing import Optional, List
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

class DocumentManifest_Related(BackboneElement):
    ref: Optional[Reference] = None
    identifier: Optional[Identifier] = None

class DocumentManifest(DomainResource):
    description: Optional[str] = None
    content: list[Reference] = []
    recipient: Optional[List[Reference]] = None
    type: Optional[CodeableConcept] = None
    created: Optional[str] = None
    related: Optional[List[DocumentManifest_Related]] = None
    source: Optional[str] = None
    author: Optional[List[Reference]] = None
    master_identifier: Optional[Identifier] = None
    status: str
    identifier: Optional[List[Identifier]] = None
    subject: Optional[Reference] = None