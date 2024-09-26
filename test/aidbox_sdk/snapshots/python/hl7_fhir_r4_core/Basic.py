from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class Basic(DomainResource):
    code: CodeableConcept
    author: Optional[Reference] = None
    created: Optional[str] = None
    subject: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)