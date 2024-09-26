from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ImmunizationRecommendationRecommendationDateCriterion(BackboneElement):
    code: CodeableConcept
    value: str

@dataclass(kw_only=True)
class ImmunizationRecommendationRecommendation(BackboneElement):
    description: Optional[str] = None
    series_doses_positive_int: Optional[int] = None
    contraindicated_vaccine_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    dose_number_positive_int: Optional[int] = None
    series: Optional[str] = None
    vaccine_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    dose_number_string: Optional[str] = None
    series_doses_string: Optional[str] = None
    forecast_status: CodeableConcept
    forecast_reason: Optional[List[CodeableConcept]] = field(default_factory=list)
    date_criterion: Optional[List[ImmunizationRecommendationRecommendationDateCriterion]] = field(default_factory=list)
    target_disease: Optional[CodeableConcept] = None
    supporting_immunization: Optional[List[Reference]] = field(default_factory=list)
    supporting_patient_information: Optional[List[Reference]] = field(default_factory=list)

@dataclass(kw_only=True)
class ImmunizationRecommendation(DomainResource):
    date: str
    patient: Reference
    authority: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    recommendation: list[ImmunizationRecommendationRecommendation] = field(default_factory=list)