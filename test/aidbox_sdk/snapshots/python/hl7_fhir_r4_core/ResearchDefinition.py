from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import Period
from base import ContactDetail
from base import CodeableConcept
from base import RelatedArtifact
from base import DomainResource
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class ResearchDefinition(DomainResource):
    description: Optional[str] = None
    exposure_alternative: Optional[Reference] = None
    date: Optional[str] = None
    endorser: Optional[List[ContactDetail]] = field(default_factory=list)
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    purpose: Optional[str] = None
    subject_codeable_concept: Optional[CodeableConcept] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    outcome: Optional[Reference] = None
    topic: Optional[List[CodeableConcept]] = field(default_factory=list)
    title: Optional[str] = None
    library: Optional[List[str]] = field(default_factory=list)
    author: Optional[List[ContactDetail]] = field(default_factory=list)
    usage: Optional[str] = None
    status: str
    subtitle: Optional[str] = None
    population: Reference
    comment: Optional[List[str]] = field(default_factory=list)
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = field(default_factory=list)
    reviewer: Optional[List[ContactDetail]] = field(default_factory=list)
    short_title: Optional[str] = None
    exposure: Optional[Reference] = None
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = field(default_factory=list)
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    subject_reference: Optional[Reference] = None
    effective_period: Optional[Period] = None