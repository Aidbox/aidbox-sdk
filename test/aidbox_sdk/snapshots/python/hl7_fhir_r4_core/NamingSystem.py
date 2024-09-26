from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import Period
from base import ContactDetail
from base import CodeableConcept
from base import DomainResource
from base import BackboneElement

@dataclass(kw_only=True)
class NamingSystemUniqueId(BackboneElement):
    type: str
    value: str
    period: Optional[Period] = None
    comment: Optional[str] = None
    preferred: Optional[bool] = None

@dataclass(kw_only=True)
class NamingSystem(DomainResource):
    description: Optional[str] = None
    date: str
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    name: str
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    type: Optional[CodeableConcept] = None
    responsible: Optional[str] = None
    usage: Optional[str] = None
    status: str
    kind: str
    unique_id: list[NamingSystemUniqueId] = field(default_factory=list)
    contact: Optional[List[ContactDetail]] = field(default_factory=list)