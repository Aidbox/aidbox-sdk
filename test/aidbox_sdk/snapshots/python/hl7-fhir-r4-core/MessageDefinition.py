from typing import Optional, List
from pydantic import *
from ..base.UsageContext import UsageContext
from ..base.ContactDetail import ContactDetail
from ..base.CodeableConcept import CodeableConcept
from ..base.Coding import Coding
from ..base.DomainResource import DomainResource
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class MessageDefinition_AllowedResponse(BackboneElement):
    message: str
    situation: Optional[str] = None

class MessageDefinition_Focus(BackboneElement):
    max: Optional[str] = None
    min: int
    code: str
    profile: Optional[str] = None

class MessageDefinition(DomainResource):
    description: Optional[str] = None
    category: Optional[str] = None
    date: str
    publisher: Optional[str] = None
    parent: Optional[List[str]] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    purpose: Optional[str] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    title: Optional[str] = None
    status: str
    allowed_response: Optional[List[MessageDefinition_AllowedResponse]] = None
    graph: Optional[List[str]] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    focus: Optional[List[MessageDefinition_Focus]] = None
    replaces: Optional[List[str]] = None
    response_required: Optional[str] = None
    base: Optional[str] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = None
    event_uri: Optional[str] = None
    event_coding: Optional[Coding] = None