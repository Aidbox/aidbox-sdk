from typing import Optional, List
from pydantic import *
from base.Period import Period
from base.CodeableConcept import CodeableConcept
from base.Coding import Coding
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.BackboneElement import BackboneElement

class AuditEvent_Source(BackboneElement):
    site: Optional[str] = None
    type: Optional[List[Coding]] = None
    observer: Reference

class AuditEvent_Agent_Network(BackboneElement):
    type: Optional[str] = None
    address: Optional[str] = None

class AuditEvent_Agent(BackboneElement):
    role: Optional[List[CodeableConcept]] = None
    requestor: bool
    who: Optional[Reference] = None
    alt_id: Optional[str] = None
    name: Optional[str] = None
    type: Optional[CodeableConcept] = None
    policy: Optional[List[str]] = None
    purpose_of_use: Optional[List[CodeableConcept]] = None
    network: Optional[AuditEvent_Agent_Network] = None
    location: Optional[Reference] = None
    media: Optional[Coding] = None

class AuditEvent_Entity_Detail(BackboneElement):
    type: str
    value_string: Optional[str] = None
    value_base64_binary: Optional[str] = None

class AuditEvent_Entity(BackboneElement):
    role: Optional[Coding] = None
    description: Optional[str] = None
    name: Optional[str] = None
    type: Optional[Coding] = None
    lifecycle: Optional[Coding] = None
    query: Optional[str] = None
    security_label: Optional[List[Coding]] = None
    what: Optional[Reference] = None
    detail: Optional[List[AuditEvent_Entity_Detail]] = None

class AuditEvent(DomainResource):
    outcome_desc: Optional[str] = None
    type: Coding
    outcome: Optional[str] = None
    source: AuditEvent_Source
    recorded: str
    agent: list[AuditEvent_Agent] = []
    purpose_of_event: Optional[List[CodeableConcept]] = None
    action: Optional[str] = None
    period: Optional[Period] = None
    entity: Optional[List[AuditEvent_Entity]] = None
    subtype: Optional[List[Coding]] = None