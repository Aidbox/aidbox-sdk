from typing import Optional, List
from pydantic import *
from base.CodeableConcept import CodeableConcept
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier
from base.BackboneElement import BackboneElement

class ImmunizationRecommendation_Recommendation_DateCriterion(BackboneElement):
    code: CodeableConcept
    value: str

class ImmunizationRecommendation_Recommendation(BackboneElement):
    description: Optional[str] = None
    series_doses_positive_int: Optional[int] = None
    contraindicated_vaccine_code: Optional[List[CodeableConcept]] = None
    dose_number_positive_int: Optional[int] = None
    series: Optional[str] = None
    vaccine_code: Optional[List[CodeableConcept]] = None
    dose_number_string: Optional[str] = None
    series_doses_string: Optional[str] = None
    forecast_status: CodeableConcept
    forecast_reason: Optional[List[CodeableConcept]] = None
    date_criterion: Optional[List[ImmunizationRecommendation_Recommendation_DateCriterion]] = None
    target_disease: Optional[CodeableConcept] = None
    supporting_immunization: Optional[List[Reference]] = None
    supporting_patient_information: Optional[List[Reference]] = None

class ImmunizationRecommendation(DomainResource):
    date: str
    patient: Reference
    authority: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = None
    recommendation: list[ImmunizationRecommendation_Recommendation] = []