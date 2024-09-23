from typing import Optional, List
from pydantic import *
from ..base.CodeableConcept import CodeableConcept
from ..base.Coding import Coding
from ..base.ContactPoint import ContactPoint
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.BackboneElement import BackboneElement

class MessageHeader_Response(BackboneElement):
    code: str
    details: Optional[Reference] = None
    identifier: str

class MessageHeader_Source(BackboneElement):
    name: Optional[str] = None
    contact: Optional[ContactPoint] = None
    version: Optional[str] = None
    endpoint: str
    software: Optional[str] = None

class MessageHeader_Destination(BackboneElement):
    name: Optional[str] = None
    target: Optional[Reference] = None
    endpoint: str
    receiver: Optional[Reference] = None

class MessageHeader(DomainResource):
    response: Optional[MessageHeader_Response] = None
    definition: Optional[str] = None
    enterer: Optional[Reference] = None
    source: MessageHeader_Source
    author: Optional[Reference] = None
    reason: Optional[CodeableConcept] = None
    responsible: Optional[Reference] = None
    sender: Optional[Reference] = None
    focus: Optional[List[Reference]] = None
    event_uri: Optional[str] = None
    destination: Optional[List[MessageHeader_Destination]] = None
    event_coding: Optional[Coding] = None