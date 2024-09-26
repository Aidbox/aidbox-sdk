from typing import Optional, List
from dataclasses import dataclass, field
from base import Attachment
from base import Period
from base import CodeableConcept
from base import Coding
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class DocumentReferenceContent(BackboneElement):
    format: Optional[Coding] = None
    attachment: Attachment

@dataclass(kw_only=True)
class DocumentReferenceRelatesTo(BackboneElement):
    code: str
    target: Reference

@dataclass(kw_only=True)
class DocumentReferenceContext(BackboneElement):
    event: Optional[List[CodeableConcept]] = field(default_factory=list)
    period: Optional[Period] = None
    related: Optional[List[Reference]] = field(default_factory=list)
    encounter: Optional[List[Reference]] = field(default_factory=list)
    facility_type: Optional[CodeableConcept] = None
    practice_setting: Optional[CodeableConcept] = None
    source_patient_info: Optional[Reference] = None

@dataclass(kw_only=True)
class DocumentReference(DomainResource):
    description: Optional[str] = None
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    date: Optional[str] = None
    doc_status: Optional[str] = None
    content: list[DocumentReferenceContent] = field(default_factory=list)
    type: Optional[CodeableConcept] = None
    author: Optional[List[Reference]] = field(default_factory=list)
    master_identifier: Optional[Identifier] = None
    custodian: Optional[Reference] = None
    status: str
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    relates_to: Optional[List[DocumentReferenceRelatesTo]] = field(default_factory=list)
    context: Optional[DocumentReferenceContext] = None
    security_label: Optional[List[CodeableConcept]] = field(default_factory=list)
    subject: Optional[Reference] = None
    authenticator: Optional[Reference] = None