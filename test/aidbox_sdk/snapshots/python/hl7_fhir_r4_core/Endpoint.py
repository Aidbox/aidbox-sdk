from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import Coding
from base import ContactPoint
from base import DomainResource
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class Endpoint(DomainResource):
    connection_type: Coding
    address: str
    managing_organization: Optional[Reference] = None
    name: Optional[str] = None
    payload_mime_type: Optional[List[str]] = field(default_factory=list)
    payload_type: list[CodeableConcept] = field(default_factory=list)
    header: Optional[List[str]] = field(default_factory=list)
    status: str
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    period: Optional[Period] = None
    contact: Optional[List[ContactPoint]] = field(default_factory=list)