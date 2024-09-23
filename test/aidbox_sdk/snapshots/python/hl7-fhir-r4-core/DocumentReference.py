from typing import Optional, List
from pydantic import *
from ..base import *

class DocumentReference_Content(BackboneElement):
    format: Optional[Coding] = None
    attachment: Attachment

class DocumentReference_RelatesTo(BackboneElement):
    code: str
    target: Reference

class DocumentReference_Context(BackboneElement):
    event: Optional[List[CodeableConcept]] = None
    period: Optional[Period] = None
    related: Optional[List[Reference]] = None
    encounter: Optional[List[Reference]] = None
    facility_type: Optional[CodeableConcept] = None
    practice_setting: Optional[CodeableConcept] = None
    source_patient_info: Optional[Reference] = None

class DocumentReference(DomainResource):
    description: Optional[str] = None
    category: Optional[List[CodeableConcept]] = None
    date: Optional[str] = None
    doc_status: Optional[str] = None
    content: list[DocumentReference_Content] = []
    type: Optional[CodeableConcept] = None
    author: Optional[List[Reference]] = None
    master_identifier: Optional[Identifier] = None
    custodian: Optional[Reference] = None
    status: str
    identifier: Optional[List[Identifier]] = None
    relates_to: Optional[List[DocumentReference_RelatesTo]] = None
    context: Optional[DocumentReference_Context] = None
    security_label: Optional[List[CodeableConcept]] = None
    subject: Optional[Reference] = None
    authenticator: Optional[Reference] = None