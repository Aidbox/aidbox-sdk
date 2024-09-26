from typing import Optional, List
from dataclasses import dataclass, field
from base import DomainResource
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class EnrollmentRequest(DomainResource):
    status: Optional[str] = None
    created: Optional[str] = None
    insurer: Optional[Reference] = None
    coverage: Optional[Reference] = None
    provider: Optional[Reference] = None
    candidate: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)