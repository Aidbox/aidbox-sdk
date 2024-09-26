from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class AccountCoverage(BackboneElement):
    coverage: Reference
    priority: Optional[int] = None

@dataclass(kw_only=True)
class AccountGuarantor(BackboneElement):
    party: Reference
    on_hold: Optional[bool] = None
    period: Optional[Period] = None

@dataclass(kw_only=True)
class Account(DomainResource):
    description: Optional[str] = None
    name: Optional[str] = None
    service_period: Optional[Period] = None
    coverage: Optional[List[AccountCoverage]] = field(default_factory=list)
    type: Optional[CodeableConcept] = None
    guarantor: Optional[List[AccountGuarantor]] = field(default_factory=list)
    status: str
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    part_of: Optional[Reference] = None
    subject: Optional[List[Reference]] = field(default_factory=list)
    owner: Optional[Reference] = None