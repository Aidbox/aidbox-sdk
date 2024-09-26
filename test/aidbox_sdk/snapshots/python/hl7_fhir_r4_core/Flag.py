from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class Flag(DomainResource):
    code: CodeableConcept
    author: Optional[Reference] = None
    period: Optional[Period] = None
    status: str
    subject: Reference
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    encounter: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)