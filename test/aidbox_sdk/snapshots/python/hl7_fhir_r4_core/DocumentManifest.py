from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class DocumentManifestRelated(BackboneElement):
    ref: Optional[Reference] = None
    identifier: Optional[Identifier] = None

@dataclass(kw_only=True)
class DocumentManifest(DomainResource):
    description: Optional[str] = None
    content: list[Reference] = field(default_factory=list)
    recipient: Optional[List[Reference]] = field(default_factory=list)
    type: Optional[CodeableConcept] = None
    created: Optional[str] = None
    related: Optional[List[DocumentManifestRelated]] = field(default_factory=list)
    source: Optional[str] = None
    author: Optional[List[Reference]] = field(default_factory=list)
    master_identifier: Optional[Identifier] = None
    status: str
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    subject: Optional[Reference] = None