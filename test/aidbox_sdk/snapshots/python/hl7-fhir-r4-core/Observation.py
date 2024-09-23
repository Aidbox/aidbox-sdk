from typing import Optional, List
from pydantic import *
from ..base import *

class Observation_ReferenceRange(BackboneElement):
    age: Optional[Range] = None
    low: Optional[Quantity] = None
    high: Optional[Quantity] = None
    text: Optional[str] = None
    type: Optional[CodeableConcept] = None
    applies_to: Optional[List[CodeableConcept]] = None

class Observation_Component(BackboneElement):
    reference_range: Optional[List[Reference]] = None
    interpretation: Optional[List[CodeableConcept]] = None
    value_time: Optional[str] = None
    value_quantity: Optional[Quantity] = None
    value_string: Optional[str] = None
    value_ratio: Optional[Ratio] = None
    value_boolean: Optional[bool] = None
    value_date_time: Optional[str] = None
    value_sampled_data: Optional[SampledData] = None
    code: CodeableConcept
    value_codeable_concept: Optional[CodeableConcept] = None
    value_period: Optional[Period] = None
    value_range: Optional[Range] = None
    value_integer: Optional[int] = None
    data_absent_reason: Optional[CodeableConcept] = None

class Observation(DomainResource):
    category: Optional[List[CodeableConcept]] = None
    reference_range: Optional[List[Observation_ReferenceRange]] = None
    has_member: Optional[List[Reference]] = None
    derived_from: Optional[List[Reference]] = None
    interpretation: Optional[List[CodeableConcept]] = None
    encounter: Optional[Reference] = None
    method: Optional[CodeableConcept] = None
    value_time: Optional[str] = None
    specimen: Optional[Reference] = None
    value_quantity: Optional[Quantity] = None
    value_string: Optional[str] = None
    value_ratio: Optional[Ratio] = None
    value_boolean: Optional[bool] = None
    value_date_time: Optional[str] = None
    component: Optional[List[Observation_Component]] = None
    note: Optional[List[Annotation]] = None
    value_sampled_data: Optional[SampledData] = None
    effective_date_time: Optional[str] = None
    status: str
    code: CodeableConcept
    identifier: Optional[List[Identifier]] = None
    effective_timing: Optional[Timing] = None
    value_codeable_concept: Optional[CodeableConcept] = None
    body_site: Optional[CodeableConcept] = None
    focus: Optional[List[Reference]] = None
    issued: Optional[str] = None
    value_period: Optional[Period] = None
    device: Optional[Reference] = None
    effective_instant: Optional[str] = None
    based_on: Optional[List[Reference]] = None
    value_range: Optional[Range] = None
    part_of: Optional[List[Reference]] = None
    value_integer: Optional[int] = None
    subject: Optional[Reference] = None
    performer: Optional[List[Reference]] = None
    data_absent_reason: Optional[CodeableConcept] = None
    effective_period: Optional[Period] = None