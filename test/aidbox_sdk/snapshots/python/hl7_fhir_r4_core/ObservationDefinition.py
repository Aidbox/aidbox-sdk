from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import Range
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ObservationDefinitionQuantitativeDetails(BackboneElement):
    unit: Optional[CodeableConcept] = None
    customary_unit: Optional[CodeableConcept] = None
    conversion_factor: Optional[float] = None
    decimal_precision: Optional[int] = None

@dataclass(kw_only=True)
class ObservationDefinitionQualifiedInterval(BackboneElement):
    age: Optional[Range] = None
    range: Optional[Range] = None
    gender: Optional[str] = None
    context: Optional[CodeableConcept] = None
    category: Optional[str] = None
    applies_to: Optional[List[CodeableConcept]] = field(default_factory=list)
    condition: Optional[str] = None
    gestational_age: Optional[Range] = None

@dataclass(kw_only=True)
class ObservationDefinition(DomainResource):
    quantitative_details: Optional[ObservationDefinitionQuantitativeDetails] = None
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    method: Optional[CodeableConcept] = None
    valid_coded_value_set: Optional[Reference] = None
    qualified_interval: Optional[List[ObservationDefinitionQualifiedInterval]] = field(default_factory=list)
    abnormal_coded_value_set: Optional[Reference] = None
    code: CodeableConcept
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    permitted_data_type: Optional[List[str]] = field(default_factory=list)
    multiple_results_allowed: Optional[bool] = None
    normal_coded_value_set: Optional[Reference] = None
    preferred_report_name: Optional[str] = None
    critical_coded_value_set: Optional[Reference] = None