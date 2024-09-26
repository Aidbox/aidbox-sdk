from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import Coding
from base import DomainResource
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class MessageDefinitionAllowedResponse(BackboneElement):
    message: str
    situation: Optional[str] = None

@dataclass(kw_only=True)
class MessageDefinitionFocus(BackboneElement):
    max: Optional[str] = None
    min: int
    code: str
    profile: Optional[str] = None

@dataclass(kw_only=True)
class MessageDefinition(DomainResource):
    description: Optional[str] = None
    category: Optional[str] = None
    date: str
    publisher: Optional[str] = None
    parent: Optional[List[str]] = field(default_factory=list)
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    purpose: Optional[str] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    title: Optional[str] = None
    status: str
    allowed_response: Optional[List[MessageDefinitionAllowedResponse]] = field(default_factory=list)
    graph: Optional[List[str]] = field(default_factory=list)
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    focus: Optional[List[MessageDefinitionFocus]] = field(default_factory=list)
    replaces: Optional[List[str]] = field(default_factory=list)
    response_required: Optional[str] = None
    base: Optional[str] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    event_uri: Optional[str] = None
    event_coding: Optional[Coding] = None