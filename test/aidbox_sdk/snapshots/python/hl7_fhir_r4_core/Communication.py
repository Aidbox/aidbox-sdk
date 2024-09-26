from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Attachment
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class CommunicationPayload(BackboneElement):
    content_string: Optional[str] = None
    content_reference: Optional[Reference] = None
    content_attachment: Optional[Attachment] = None

@dataclass(kw_only=True)
class Communication(DomainResource):
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    received: Optional[str] = None
    instantiates_canonical: Optional[List[str]] = field(default_factory=list)
    payload: Optional[List[CommunicationPayload]] = field(default_factory=list)
    instantiates_uri: Optional[List[str]] = field(default_factory=list)
    encounter: Optional[Reference] = None
    medium: Optional[List[CodeableConcept]] = field(default_factory=list)
    recipient: Optional[List[Reference]] = field(default_factory=list)
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    status_reason: Optional[CodeableConcept] = None
    topic: Optional[CodeableConcept] = None
    sent: Optional[str] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    priority: Optional[str] = None
    status: str
    sender: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    in_response_to: Optional[List[Reference]] = field(default_factory=list)
    based_on: Optional[List[Reference]] = field(default_factory=list)
    part_of: Optional[List[Reference]] = field(default_factory=list)
    subject: Optional[Reference] = None
    about: Optional[List[Reference]] = field(default_factory=list)
    reason_reference: Optional[List[Reference]] = field(default_factory=list)