from typing import Optional, List
from pydantic import *
from ..base import *

class RiskAssessment_Prediction(BackboneElement):
    relative_risk: Optional[float] = None
    when_range: Optional[Range] = None
    outcome: Optional[CodeableConcept] = None
    when_period: Optional[Period] = None
    rationale: Optional[str] = None
    probability_range: Optional[Range] = None
    qualitative_risk: Optional[CodeableConcept] = None
    probability_decimal: Optional[float] = None

class RiskAssessment(DomainResource):
    parent: Optional[Reference] = None
    encounter: Optional[Reference] = None
    prediction: Optional[List[RiskAssessment_Prediction]] = None
    method: Optional[CodeableConcept] = None
    basis: Optional[List[Reference]] = None
    reason_code: Optional[List[CodeableConcept]] = None
    mitigation: Optional[str] = None
    note: Optional[List[Annotation]] = None
    occurrence_period: Optional[Period] = None
    status: str
    condition: Optional[Reference] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    based_on: Optional[Reference] = None
    occurrence_date_time: Optional[str] = None
    subject: Reference
    performer: Optional[Reference] = None
    reason_reference: Optional[List[Reference]] = None