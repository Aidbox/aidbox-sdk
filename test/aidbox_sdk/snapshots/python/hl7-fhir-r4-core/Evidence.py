from typing import Optional, List
from pydantic import *
from base.UsageContext import UsageContext
from base.Annotation import Annotation
from base.Period import Period
from base.ContactDetail import ContactDetail
from base.CodeableConcept import CodeableConcept
from base.RelatedArtifact import RelatedArtifact
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier

class Evidence(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    endorser: Optional[List[ContactDetail]] = None
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    outcome: Optional[List[Reference]] = None
    topic: Optional[List[CodeableConcept]] = None
    title: Optional[str] = None
    note: Optional[List[Annotation]] = None
    author: Optional[List[ContactDetail]] = None
    status: str
    subtitle: Optional[str] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = None
    reviewer: Optional[List[ContactDetail]] = None
    short_title: Optional[str] = None
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = None
    contact: Optional[List[ContactDetail]] = None
    exposure_background: Reference
    effective_period: Optional[Period] = None
    exposure_variant: Optional[List[Reference]] = None