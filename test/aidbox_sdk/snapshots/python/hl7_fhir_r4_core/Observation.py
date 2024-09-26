from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Period
from base import CodeableConcept
from base import Range
from base import Timing
from base import Quantity
from base import DomainResource
from base import SampledData
from base import Ratio
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ObservationReferenceRange(BackboneElement):
    age: Optional[Range] = None
    low: Optional[Quantity] = None
    high: Optional[Quantity] = None
    text: Optional[str] = None
    type: Optional[CodeableConcept] = None
    applies_to: Optional[List[CodeableConcept]] = field(default_factory=list)

@dataclass(kw_only=True)
class ObservationComponent(BackboneElement):
    reference_range: Optional[List[Reference]] = field(default_factory=list)
    interpretation: Optional[List[CodeableConcept]] = field(default_factory=list)
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

@dataclass(kw_only=True)
class Observation(DomainResource):
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    reference_range: Optional[List[ObservationReferenceRange]] = field(default_factory=list)
    has_member: Optional[List[Reference]] = field(default_factory=list)
    derived_from: Optional[List[Reference]] = field(default_factory=list)
    interpretation: Optional[List[CodeableConcept]] = field(default_factory=list)
    encounter: Optional[Reference] = None
    method: Optional[CodeableConcept] = None
    value_time: Optional[str] = None
    specimen: Optional[Reference] = None
    value_quantity: Optional[Quantity] = None
    value_string: Optional[str] = None
    value_ratio: Optional[Ratio] = None
    value_boolean: Optional[bool] = None
    value_date_time: Optional[str] = None
    component: Optional[List[ObservationComponent]] = field(default_factory=list)
    note: Optional[List[Annotation]] = field(default_factory=list)
    value_sampled_data: Optional[SampledData] = None
    effective_date_time: Optional[str] = None
    status: str
    code: CodeableConcept
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    effective_timing: Optional[Timing] = None
    value_codeable_concept: Optional[CodeableConcept] = None
    body_site: Optional[CodeableConcept] = None
    focus: Optional[List[Reference]] = field(default_factory=list)
    issued: Optional[str] = None
    value_period: Optional[Period] = None
    device: Optional[Reference] = None
    effective_instant: Optional[str] = None
    based_on: Optional[List[Reference]] = field(default_factory=list)
    value_range: Optional[Range] = None
    part_of: Optional[List[Reference]] = field(default_factory=list)
    value_integer: Optional[int] = None
    subject: Optional[Reference] = None
    performer: Optional[List[Reference]] = field(default_factory=list)
    data_absent_reason: Optional[CodeableConcept] = None
    effective_period: Optional[Period] = None