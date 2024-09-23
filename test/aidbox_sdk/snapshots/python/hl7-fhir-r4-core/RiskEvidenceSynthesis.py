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
from base.BackboneElement import BackboneElement

class RiskEvidenceSynthesis_SampleSize(BackboneElement):
    description: Optional[str] = None
    number_of_studies: Optional[int] = None
    number_of_participants: Optional[int] = None

class RiskEvidenceSynthesis_Certainty_CertaintySubcomponent(BackboneElement):
    note: Optional[List[Annotation]] = None
    type: Optional[CodeableConcept] = None
    rating: Optional[List[CodeableConcept]] = None

class RiskEvidenceSynthesis_Certainty(BackboneElement):
    note: Optional[List[Annotation]] = None
    rating: Optional[List[CodeableConcept]] = None
    certainty_subcomponent: Optional[List[RiskEvidenceSynthesis_Certainty_CertaintySubcomponent]] = None

class RiskEvidenceSynthesis_RiskEstimate_PrecisionEstimate(BackboneElement):
    to: Optional[float] = None
    from: Optional[float] = None
    type: Optional[CodeableConcept] = None
    level: Optional[float] = None

class RiskEvidenceSynthesis_RiskEstimate(BackboneElement):
    type: Optional[CodeableConcept] = None
    value: Optional[float] = None
    description: Optional[str] = None
    unit_of_measure: Optional[CodeableConcept] = None
    numerator_count: Optional[int] = None
    denominator_count: Optional[int] = None
    precision_estimate: Optional[List[RiskEvidenceSynthesis_RiskEstimate_PrecisionEstimate]] = None

class RiskEvidenceSynthesis(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    endorser: Optional[List[ContactDetail]] = None
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    sample_size: Optional[RiskEvidenceSynthesis_SampleSize] = None
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
    certainty: Optional[List[RiskEvidenceSynthesis_Certainty]] = None
    reviewer: Optional[List[ContactDetail]] = None
    exposure: Optional[Reference] = None
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = None
    contact: Optional[List[ContactDetail]] = None
    risk_estimate: Optional[RiskEvidenceSynthesis_RiskEstimate] = None
    effective_period: Optional[Period] = None