from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Attachment
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class CommunicationRequestPayload(BackboneElement):
    content_string: Optional[str] = None
    content_reference: Optional[Reference] = None
    content_attachment: Optional[Attachment] = None

@dataclass(kw_only=True)
class CommunicationRequest(DomainResource):
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    payload: Optional[List[CommunicationRequestPayload]] = field(default_factory=list)
    encounter: Optional[Reference] = None
    medium: Optional[List[CodeableConcept]] = field(default_factory=list)
    recipient: Optional[List[Reference]] = field(default_factory=list)
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    status_reason: Optional[CodeableConcept] = None
    authored_on: Optional[str] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    requester: Optional[Reference] = None
    priority: Optional[str] = None
    occurrence_period: Optional[Period] = None
    status: str
    group_identifier: Optional[Identifier] = None
    sender: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    do_not_perform: Optional[bool] = None
    replaces: Optional[List[Reference]] = field(default_factory=list)
    based_on: Optional[List[Reference]] = field(default_factory=list)
    occurrence_date_time: Optional[str] = None
    subject: Optional[Reference] = None
    about: Optional[List[Reference]] = field(default_factory=list)
    reason_reference: Optional[List[Reference]] = field(default_factory=list)