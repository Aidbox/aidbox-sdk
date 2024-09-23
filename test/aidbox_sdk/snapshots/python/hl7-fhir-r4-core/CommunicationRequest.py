from typing import Optional, List
from pydantic import *
from ..base import *

class CommunicationRequest_Payload(BackboneElement):
    content_string: Optional[str] = None
    content_reference: Optional[Reference] = None
    content_attachment: Optional[Attachment] = None

class CommunicationRequest(DomainResource):
    category: Optional[List[CodeableConcept]] = None
    payload: Optional[List[CommunicationRequest_Payload]] = None
    encounter: Optional[Reference] = None
    medium: Optional[List[CodeableConcept]] = None
    recipient: Optional[List[Reference]] = None
    reason_code: Optional[List[CodeableConcept]] = None
    status_reason: Optional[CodeableConcept] = None
    authored_on: Optional[str] = None
    note: Optional[List[Annotation]] = None
    requester: Optional[Reference] = None
    priority: Optional[str] = None
    occurrence_period: Optional[Period] = None
    status: str
    group_identifier: Optional[Identifier] = None
    sender: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = None
    do_not_perform: Optional[bool] = None
    replaces: Optional[List[Reference]] = None
    based_on: Optional[List[Reference]] = None
    occurrence_date_time: Optional[str] = None
    subject: Optional[Reference] = None
    about: Optional[List[Reference]] = None
    reason_reference: Optional[List[Reference]] = None