from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Period
from base import CodeableConcept
from base import Range
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class RiskAssessmentPrediction(BackboneElement):
    relative_risk: Optional[float] = None
    when_range: Optional[Range] = None
    outcome: Optional[CodeableConcept] = None
    when_period: Optional[Period] = None
    rationale: Optional[str] = None
    probability_range: Optional[Range] = None
    qualitative_risk: Optional[CodeableConcept] = None
    probability_decimal: Optional[float] = None

@dataclass(kw_only=True)
class RiskAssessment(DomainResource):
    parent: Optional[Reference] = None
    encounter: Optional[Reference] = None
    prediction: Optional[List[RiskAssessmentPrediction]] = field(default_factory=list)
    method: Optional[CodeableConcept] = None
    basis: Optional[List[Reference]] = field(default_factory=list)
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    mitigation: Optional[str] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    occurrence_period: Optional[Period] = None
    status: str
    condition: Optional[Reference] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    based_on: Optional[Reference] = None
    occurrence_date_time: Optional[str] = None
    subject: Reference
    performer: Optional[Reference] = None
    reason_reference: Optional[List[Reference]] = field(default_factory=list)