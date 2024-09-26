from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import Coding
from base import ContactPoint
from base import DomainResource
from base import Reference
from base import BackboneElement

@dataclass(kw_only=True)
class MessageHeaderResponse(BackboneElement):
    code: str
    details: Optional[Reference] = None
    identifier: str

@dataclass(kw_only=True)
class MessageHeaderSource(BackboneElement):
    name: Optional[str] = None
    contact: Optional[ContactPoint] = None
    version: Optional[str] = None
    endpoint: str
    software: Optional[str] = None

@dataclass(kw_only=True)
class MessageHeaderDestination(BackboneElement):
    name: Optional[str] = None
    target: Optional[Reference] = None
    endpoint: str
    receiver: Optional[Reference] = None

@dataclass(kw_only=True)
class MessageHeader(DomainResource):
    response: Optional[MessageHeaderResponse] = None
    definition: Optional[str] = None
    enterer: Optional[Reference] = None
    source: MessageHeaderSource
    author: Optional[Reference] = None
    reason: Optional[CodeableConcept] = None
    responsible: Optional[Reference] = None
    sender: Optional[Reference] = None
    focus: Optional[List[Reference]] = field(default_factory=list)
    event_uri: Optional[str] = None
    destination: Optional[List[MessageHeaderDestination]] = field(default_factory=list)
    event_coding: Optional[Coding] = None