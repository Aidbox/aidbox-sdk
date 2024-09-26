from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class Schedule(DomainResource):
    actor: list[Reference] = field(default_factory=list)
    active: Optional[bool] = None
    comment: Optional[str] = None
    specialty: Optional[List[CodeableConcept]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    service_type: Optional[List[CodeableConcept]] = field(default_factory=list)
    planning_horizon: Optional[Period] = None
    service_category: Optional[List[CodeableConcept]] = field(default_factory=list)