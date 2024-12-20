from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
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
    dose_status_reason: Optional[List[CodeableConcept]] = field(default_factory=list)
    immunization_event: Reference
    status: str
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    target_disease: CodeableConcept
    dose_status: CodeableConcept