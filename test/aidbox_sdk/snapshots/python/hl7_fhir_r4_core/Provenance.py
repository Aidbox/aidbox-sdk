from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import Signature
from base import DomainResource
from base import Reference
from base import BackboneElement

@dataclass(kw_only=True)
class ProvenanceAgent(BackboneElement):
    who: Reference
    role: Optional[List[CodeableConcept]] = field(default_factory=list)
    type: Optional[CodeableConcept] = None
    on_behalf_of: Optional[Reference] = None

@dataclass(kw_only=True)
class ProvenanceEntity(BackboneElement):
    role: str
    what: Reference
    agent: Optional[List[Reference]] = field(default_factory=list)

@dataclass(kw_only=True)
class Provenance(DomainResource):
    signature: Optional[List[Signature]] = field(default_factory=list)
    occurred_date_time: Optional[str] = None
    recorded: str
    agent: list[ProvenanceAgent] = field(default_factory=list)
    policy: Optional[List[str]] = field(default_factory=list)
    reason: Optional[List[CodeableConcept]] = field(default_factory=list)
    activity: Optional[CodeableConcept] = None
    target: list[Reference] = field(default_factory=list)
    location: Optional[Reference] = None
    entity: Optional[List[ProvenanceEntity]] = field(default_factory=list)
    occurred_period: Optional[Period] = None