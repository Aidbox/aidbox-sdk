from typing import Optional, List
from pydantic import *
from ..base.Annotation import Annotation
from ..base.Attachment import Attachment
from ..base.CodeableConcept import CodeableConcept
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class Communication_Payload(BackboneElement):
    content_string: Optional[str] = None
    content_reference: Optional[Reference] = None
    content_attachment: Optional[Attachment] = None

class Communication(DomainResource):
    category: Optional[List[CodeableConcept]] = None
    received: Optional[str] = None
    instantiates_canonical: Optional[List[str]] = None
    payload: Optional[List[Communication_Payload]] = None
    instantiates_uri: Optional[List[str]] = None
    encounter: Optional[Reference] = None
    medium: Optional[List[CodeableConcept]] = None
    recipient: Optional[List[Reference]] = None
    reason_code: Optional[List[CodeableConcept]] = None
    status_reason: Optional[CodeableConcept] = None
    topic: Optional[CodeableConcept] = None
    sent: Optional[str] = None
    note: Optional[List[Annotation]] = None
    priority: Optional[str] = None
    status: str
    sender: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = None
    in_response_to: Optional[List[Reference]] = None
    based_on: Optional[List[Reference]] = None
    part_of: Optional[List[Reference]] = None
    subject: Optional[Reference] = None
    about: Optional[List[Reference]] = None
    reason_reference: Optional[List[Reference]] = None