from typing import Optional, List
from pydantic import *
from ..base import *

class EffectEvidenceSynthesis_EffectEstimate_PrecisionEstimate(BackboneElement):
    to: Optional[float] = None
    from: Optional[float] = None
    type: Optional[CodeableConcept] = None
    level: Optional[float] = None

class EffectEvidenceSynthesis_EffectEstimate(BackboneElement):
    type: Optional[CodeableConcept] = None
    value: Optional[float] = None
    description: Optional[str] = None
    variant_state: Optional[CodeableConcept] = None
    unit_of_measure: Optional[CodeableConcept] = None
    precision_estimate: Optional[List[EffectEvidenceSynthesis_EffectEstimate_PrecisionEstimate]] = None

class EffectEvidenceSynthesis_SampleSize(BackboneElement):
    description: Optional[str] = None
    number_of_studies: Optional[int] = None
    number_of_participants: Optional[int] = None

class EffectEvidenceSynthesis_Certainty_CertaintySubcomponent(BackboneElement):
    note: Optional[List[Annotation]] = None
    type: Optional[CodeableConcept] = None
    rating: Optional[List[CodeableConcept]] = None

class EffectEvidenceSynthesis_Certainty(BackboneElement):
    note: Optional[List[Annotation]] = None
    rating: Optional[List[CodeableConcept]] = None
    certainty_subcomponent: Optional[List[EffectEvidenceSynthesis_Certainty_CertaintySubcomponent]] = None

class EffectEvidenceSynthesis_ResultsByExposure(BackboneElement):
    description: Optional[str] = None
    variant_state: Optional[CodeableConcept] = None
    exposure_state: Optional[str] = None
    risk_evidence_synthesis: Reference

class EffectEvidenceSynthesis(DomainResource):
    description: Optional[str] = None
    exposure_alternative: Reference
    date: Optional[str] = None
    effect_estimate: Optional[List[EffectEvidenceSynthesis_EffectEstimate]] = None
    endorser: Optional[List[ContactDetail]] = None
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    sample_size: Optional[EffectEvidenceSynthesis_SampleSize] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    study_type: Optional[CodeableConcept] = None
    outcome: Reference
    topic: Optional[List[CodeableConcept]] = None
    title: Optional[str] = None
    note: Optional[List[Annotation]] = None
    author: Optional[List[ContactDetail]] = None
    synthesis_type: Optional[CodeableConcept] = None
    status: str
    population: Reference
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = None
    certainty: Optional[List[EffectEvidenceSynthesis_Certainty]] = None
    reviewer: Optional[List[ContactDetail]] = None
    exposure: Reference
    results_by_exposure: Optional[List[EffectEvidenceSynthesis_ResultsByExposure]] = None
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = None
    contact: Optional[List[ContactDetail]] = None
    effective_period: Optional[Period] = None