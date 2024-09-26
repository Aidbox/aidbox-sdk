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
class EffectEvidenceSynthesisEffectEstimatePrecisionEstimate(BackboneElement):
    to: Optional[float] = None
    from_: Optional[float] = None
    type: Optional[CodeableConcept] = None
    level: Optional[float] = None

@dataclass(kw_only=True)
class EffectEvidenceSynthesisEffectEstimate(BackboneElement):
    type: Optional[CodeableConcept] = None
    value: Optional[float] = None
    description: Optional[str] = None
    variant_state: Optional[CodeableConcept] = None
    unit_of_measure: Optional[CodeableConcept] = None
    precision_estimate: Optional[List[EffectEvidenceSynthesisEffectEstimatePrecisionEstimate]] = field(default_factory=list)

@dataclass(kw_only=True)
class EffectEvidenceSynthesisSampleSize(BackboneElement):
    description: Optional[str] = None
    number_of_studies: Optional[int] = None
    number_of_participants: Optional[int] = None

@dataclass(kw_only=True)
class EffectEvidenceSynthesisCertaintyCertaintySubcomponent(BackboneElement):
    note: Optional[List[Annotation]] = field(default_factory=list)
    type: Optional[CodeableConcept] = None
    rating: Optional[List[CodeableConcept]] = field(default_factory=list)

@dataclass(kw_only=True)
class EffectEvidenceSynthesisCertainty(BackboneElement):
    note: Optional[List[Annotation]] = field(default_factory=list)
    rating: Optional[List[CodeableConcept]] = field(default_factory=list)
    certainty_subcomponent: Optional[List[EffectEvidenceSynthesisCertaintyCertaintySubcomponent]] = field(default_factory=list)

@dataclass(kw_only=True)
class EffectEvidenceSynthesisResultsByExposure(BackboneElement):
    description: Optional[str] = None
    variant_state: Optional[CodeableConcept] = None
    exposure_state: Optional[str] = None
    risk_evidence_synthesis: Reference

@dataclass(kw_only=True)
class EffectEvidenceSynthesis(DomainResource):
    description: Optional[str] = None
    exposure_alternative: Reference
    date: Optional[str] = None
    effect_estimate: Optional[List[EffectEvidenceSynthesisEffectEstimate]] = field(default_factory=list)
    endorser: Optional[List[ContactDetail]] = field(default_factory=list)
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    sample_size: Optional[EffectEvidenceSynthesisSampleSize] = None
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
    certainty: Optional[List[EffectEvidenceSynthesisCertainty]] = field(default_factory=list)
    reviewer: Optional[List[ContactDetail]] = field(default_factory=list)
    exposure: Reference
    results_by_exposure: Optional[List[EffectEvidenceSynthesisResultsByExposure]] = field(default_factory=list)
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = field(default_factory=list)
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    effective_period: Optional[Period] = None