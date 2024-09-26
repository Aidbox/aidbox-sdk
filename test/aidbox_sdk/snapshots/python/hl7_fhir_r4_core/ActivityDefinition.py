from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import Age
from base import Period
from base import ContactDetail
from base import CodeableConcept
from base import Expression
from base import Dosage
from base import Range
from base import RelatedArtifact
from base import Timing
from base import Quantity
from base import Duration
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ActivityDefinitionParticipant(BackboneElement):
    role: Optional[CodeableConcept] = None
    type: str

@dataclass(kw_only=True)
class ActivityDefinitionDynamicValue(BackboneElement):
    path: str
    expression: Expression

@dataclass(kw_only=True)
class ActivityDefinition(DomainResource):
    observation_result_requirement: Optional[List[Reference]] = field(default_factory=list)
    timing_range: Optional[Range] = None
    description: Optional[str] = None
    date: Optional[str] = None
    transform: Optional[str] = None
    endorser: Optional[List[ContactDetail]] = field(default_factory=list)
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    dosage: Optional[List[Dosage]] = field(default_factory=list)
    observation_requirement: Optional[List[Reference]] = field(default_factory=list)
    purpose: Optional[str] = None
    subject_codeable_concept: Optional[CodeableConcept] = None
    product_codeable_concept: Optional[CodeableConcept] = None
    name: Optional[str] = None
    product_reference: Optional[Reference] = None
    timing_period: Optional[Period] = None
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    topic: Optional[List[CodeableConcept]] = field(default_factory=list)
    participant: Optional[List[ActivityDefinitionParticipant]] = field(default_factory=list)
    title: Optional[str] = None
    library: Optional[List[str]] = field(default_factory=list)
    author: Optional[List[ContactDetail]] = field(default_factory=list)
    timing_date_time: Optional[str] = None
    timing_timing: Optional[Timing] = None
    usage: Optional[str] = None
    timing_duration: Optional[Duration] = None
    priority: Optional[str] = None
    status: str
    subtitle: Optional[str] = None
    kind: Optional[str] = None
    dynamic_value: Optional[List[ActivityDefinitionDynamicValue]] = field(default_factory=list)
    url: Optional[str] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = field(default_factory=list)
    do_not_perform: Optional[bool] = None
    body_site: Optional[List[CodeableConcept]] = field(default_factory=list)
    timing_age: Optional[Age] = None
    intent: Optional[str] = None
    specimen_requirement: Optional[List[Reference]] = field(default_factory=list)
    reviewer: Optional[List[ContactDetail]] = field(default_factory=list)
    quantity: Optional[Quantity] = None
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = field(default_factory=list)
    location: Optional[Reference] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    subject_reference: Optional[Reference] = None
    profile: Optional[str] = None
    effective_period: Optional[Period] = None