from typing import Optional, List
from pydantic import *
from base.CodeableConcept import CodeableConcept
from base.Range import Range
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier
from base.BackboneElement import BackboneElement

class ObservationDefinition_QuantitativeDetails(BackboneElement):
    unit: Optional[CodeableConcept] = None
    customary_unit: Optional[CodeableConcept] = None
    conversion_factor: Optional[float] = None
    decimal_precision: Optional[int] = None

class ObservationDefinition_QualifiedInterval(BackboneElement):
    age: Optional[Range] = None
    range: Optional[Range] = None
    gender: Optional[str] = None
    context: Optional[CodeableConcept] = None
    category: Optional[str] = None
    applies_to: Optional[List[CodeableConcept]] = None
    condition: Optional[str] = None
    gestational_age: Optional[Range] = None

class ObservationDefinition(DomainResource):
    quantitative_details: Optional[ObservationDefinition_QuantitativeDetails] = None
    category: Optional[List[CodeableConcept]] = None
    method: Optional[CodeableConcept] = None
    valid_coded_value_set: Optional[Reference] = None
    qualified_interval: Optional[List[ObservationDefinition_QualifiedInterval]] = None
    abnormal_coded_value_set: Optional[Reference] = None
    code: CodeableConcept
    identifier: Optional[List[Identifier]] = None
    permitted_data_type: Optional[List[str]] = None
    multiple_results_allowed: Optional[bool] = None
    normal_coded_value_set: Optional[Reference] = None
    preferred_report_name: Optional[str] = None
    critical_coded_value_set: Optional[Reference] = None