from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import Coding
from base import DomainResource
from base import Reference
from base import BackboneElement

@dataclass(kw_only=True)
class AuditEventSource(BackboneElement):
    site: Optional[str] = None
    type: Optional[List[Coding]] = field(default_factory=list)
    observer: Reference

@dataclass(kw_only=True)
class AuditEventAgentNetwork(BackboneElement):
    type: Optional[str] = None
    address: Optional[str] = None

@dataclass(kw_only=True)
class AuditEventAgent(BackboneElement):
    role: Optional[List[CodeableConcept]] = field(default_factory=list)
    requestor: bool
    who: Optional[Reference] = None
    alt_id: Optional[str] = None
    name: Optional[str] = None
    type: Optional[CodeableConcept] = None
    policy: Optional[List[str]] = field(default_factory=list)
    purpose_of_use: Optional[List[CodeableConcept]] = field(default_factory=list)
    network: Optional[AuditEventAgentNetwork] = None
    location: Optional[Reference] = None
    media: Optional[Coding] = None

@dataclass(kw_only=True)
class AuditEventEntityDetail(BackboneElement):
    type: str
    value_string: Optional[str] = None
    value_base64_binary: Optional[str] = None

@dataclass(kw_only=True)
class AuditEventEntity(BackboneElement):
    role: Optional[Coding] = None
    description: Optional[str] = None
    name: Optional[str] = None
    type: Optional[Coding] = None
    lifecycle: Optional[Coding] = None
    query: Optional[str] = None
    security_label: Optional[List[Coding]] = field(default_factory=list)
    what: Optional[Reference] = None
    detail: Optional[List[AuditEventEntityDetail]] = field(default_factory=list)

@dataclass(kw_only=True)
class AuditEvent(DomainResource):
    outcome_desc: Optional[str] = None
    type: Coding
    outcome: Optional[str] = None
    source: AuditEventSource
    recorded: str
    agent: list[AuditEventAgent] = field(default_factory=list)
    purpose_of_event: Optional[List[CodeableConcept]] = field(default_factory=list)
    action: Optional[str] = None
    period: Optional[Period] = None
    entity: Optional[List[AuditEventEntity]] = field(default_factory=list)
    subtype: Optional[List[Coding]] = field(default_factory=list)