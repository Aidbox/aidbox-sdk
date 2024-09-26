from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import Period
from base import ContactDetail
from base import CodeableConcept
from base import Expression
from base import RelatedArtifact
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class MeasureGroupPopulation(BackboneElement):
    code: Optional[CodeableConcept] = None
    criteria: Expression
    description: Optional[str] = None

@dataclass(kw_only=True)
class MeasureGroupStratifierComponent(BackboneElement):
    code: Optional[CodeableConcept] = None
    criteria: Expression
    description: Optional[str] = None

@dataclass(kw_only=True)
class MeasureGroupStratifier(BackboneElement):
    code: Optional[CodeableConcept] = None
    criteria: Optional[Expression] = None
    component: Optional[List[MeasureGroupStratifierComponent]] = field(default_factory=list)
    description: Optional[str] = None

@dataclass(kw_only=True)
class MeasureGroup(BackboneElement):
    code: Optional[CodeableConcept] = None
    population: Optional[List[MeasureGroupPopulation]] = field(default_factory=list)
    stratifier: Optional[List[MeasureGroupStratifier]] = field(default_factory=list)
    description: Optional[str] = None

@dataclass(kw_only=True)
class MeasureSupplementalData(BackboneElement):
    code: Optional[CodeableConcept] = None
    usage: Optional[List[CodeableConcept]] = field(default_factory=list)
    criteria: Expression
    description: Optional[str] = None

@dataclass(kw_only=True)
class Measure(DomainResource):
    description: Optional[str] = None
    definition: Optional[List[str]] = field(default_factory=list)
    date: Optional[str] = None
    group: Optional[List[MeasureGroup]] = field(default_factory=list)
    endorser: Optional[List[ContactDetail]] = field(default_factory=list)
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    composite_scoring: Optional[CodeableConcept] = None
    disclaimer: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    purpose: Optional[str] = None
    subject_codeable_concept: Optional[CodeableConcept] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    guidance: Optional[str] = None
    type: Optional[List[CodeableConcept]] = field(default_factory=list)
    experimental: Optional[bool] = None
    topic: Optional[List[CodeableConcept]] = field(default_factory=list)
    title: Optional[str] = None
    supplemental_data: Optional[List[MeasureSupplementalData]] = field(default_factory=list)
    library: Optional[List[str]] = field(default_factory=list)
    author: Optional[List[ContactDetail]] = field(default_factory=list)
    usage: Optional[str] = None
    rationale: Optional[str] = None
    status: str
    subtitle: Optional[str] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = field(default_factory=list)
    risk_adjustment: Optional[str] = None
    scoring: Optional[CodeableConcept] = None
    reviewer: Optional[List[ContactDetail]] = field(default_factory=list)
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = field(default_factory=list)
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    subject_reference: Optional[Reference] = None
    improvement_notation: Optional[CodeableConcept] = None
    rate_aggregation: Optional[str] = None
    effective_period: Optional[Period] = None
    clinical_recommendation_statement: Optional[str] = None