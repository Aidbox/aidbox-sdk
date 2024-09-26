from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import Annotation
from base import Period
from base import ContactDetail
from base import CodeableConcept
from base import RelatedArtifact
from base import DomainResource
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class Evidence(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    endorser: Optional[List[ContactDetail]] = field(default_factory=list)
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    outcome: Optional[List[Reference]] = field(default_factory=list)
    topic: Optional[List[CodeableConcept]] = field(default_factory=list)
    title: Optional[str] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    author: Optional[List[ContactDetail]] = field(default_factory=list)
    status: str
    subtitle: Optional[str] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = field(default_factory=list)
    reviewer: Optional[List[ContactDetail]] = field(default_factory=list)
    short_title: Optional[str] = None
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = field(default_factory=list)
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    exposure_background: Reference
    effective_period: Optional[Period] = None
    exposure_variant: Optional[List[Reference]] = field(default_factory=list)