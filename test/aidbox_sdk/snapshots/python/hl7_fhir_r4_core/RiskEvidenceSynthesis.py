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
from base import BackboneElement

@dataclass(kw_only=True)
class RiskEvidenceSynthesisSampleSize(BackboneElement):
    description: Optional[str] = None
    number_of_studies: Optional[int] = None
    number_of_participants: Optional[int] = None

@dataclass(kw_only=True)
class RiskEvidenceSynthesisCertaintyCertaintySubcomponent(BackboneElement):
    note: Optional[List[Annotation]] = field(default_factory=list)
    type: Optional[CodeableConcept] = None
    rating: Optional[List[CodeableConcept]] = field(default_factory=list)

@dataclass(kw_only=True)
class RiskEvidenceSynthesisCertainty(BackboneElement):
    note: Optional[List[Annotation]] = field(default_factory=list)
    rating: Optional[List[CodeableConcept]] = field(default_factory=list)
    certainty_subcomponent: Optional[List[RiskEvidenceSynthesisCertaintyCertaintySubcomponent]] = field(default_factory=list)

@dataclass(kw_only=True)
class RiskEvidenceSynthesisRiskEstimatePrecisionEstimate(BackboneElement):
    to: Optional[float] = None
    from_: Optional[float] = None
    type: Optional[CodeableConcept] = None
    level: Optional[float] = None

@dataclass(kw_only=True)
class RiskEvidenceSynthesisRiskEstimate(BackboneElement):
    type: Optional[CodeableConcept] = None
    value: Optional[float] = None
    description: Optional[str] = None
    unit_of_measure: Optional[CodeableConcept] = None
    numerator_count: Optional[int] = None
    denominator_count: Optional[int] = None
    precision_estimate: Optional[List[RiskEvidenceSynthesisRiskEstimatePrecisionEstimate]] = field(default_factory=list)

@dataclass(kw_only=True)
class RiskEvidenceSynthesis(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    endorser: Optional[List[ContactDetail]] = field(default_factory=list)
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    sample_size: Optional[RiskEvidenceSynthesisSampleSize] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    study_type: Optional[CodeableConcept] = None
    outcome: Reference
    topic: Optional[List[CodeableConcept]] = field(default_factory=list)
    title: Optional[str] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    author: Optional[List[ContactDetail]] = field(default_factory=list)
    synthesis_type: Optional[CodeableConcept] = None
    status: str
    population: Reference
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = field(default_factory=list)
    certainty: Optional[List[RiskEvidenceSynthesisCertainty]] = field(default_factory=list)
    reviewer: Optional[List[ContactDetail]] = field(default_factory=list)
    exposure: Optional[Reference] = None
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = field(default_factory=list)
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    risk_estimate: Optional[RiskEvidenceSynthesisRiskEstimate] = None
    effective_period: Optional[Period] = None