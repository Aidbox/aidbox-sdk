from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import DomainResource
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class ResearchSubject(DomainResource):
    study: Reference
    period: Optional[Period] = None
    status: str
    consent: Optional[Reference] = None
    actual_arm: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    individual: Reference
    assigned_arm: Optional[str] = None