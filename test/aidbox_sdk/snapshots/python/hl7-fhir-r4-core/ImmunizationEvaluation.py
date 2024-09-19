from pydantic import *
from typing import Optional, List
from ..base import *

class ImmunizationEvaluation(DomainResource):
    patient: Reference
    description: Optional[str] = None
    series_doses_positive_int: Optional[int] = None
    date: Optional[str] = None
    dose_number_positive_int: Optional[int] = None
    series: Optional[str] = None
    authority: Optional[Reference] = None
    dose_number_string: Optional[str] = None
    series_doses_string: Optional[str] = None
    dose_status_reason: Optional[List[CodeableConcept]] = None
    immunization_event: Reference
    status: str
    identifier: Optional[List[Identifier]] = None
    target_disease: CodeableConcept
    dose_status: CodeableConcept