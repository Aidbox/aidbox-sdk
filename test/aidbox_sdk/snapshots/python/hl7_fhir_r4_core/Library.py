from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import Attachment
from base import Period
from base import ContactDetail
from base import DataRequirement
from base import CodeableConcept
from base import RelatedArtifact
from base import DomainResource
from base import ParameterDefinition
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class Library(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    data_requirement: Optional[List[DataRequirement]] = field(default_factory=list)
    endorser: Optional[List[ContactDetail]] = field(default_factory=list)
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    purpose: Optional[str] = None
    content: Optional[List[Attachment]] = field(default_factory=list)
    subject_codeable_concept: Optional[CodeableConcept] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    type: CodeableConcept
    experimental: Optional[bool] = None
    topic: Optional[List[CodeableConcept]] = field(default_factory=list)
    title: Optional[str] = None
    author: Optional[List[ContactDetail]] = field(default_factory=list)
    usage: Optional[str] = None
    status: str
    subtitle: Optional[str] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = field(default_factory=list)
    reviewer: Optional[List[ContactDetail]] = field(default_factory=list)
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = field(default_factory=list)
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    subject_reference: Optional[Reference] = None
    parameter: Optional[List[ParameterDefinition]] = field(default_factory=list)
    effective_period: Optional[Period] = None