from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Period
from base import CodeableConcept
from base import Range
from base import Timing
from base import Quantity
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class DeviceRequestParameter(BackboneElement):
    code: Optional[CodeableConcept] = None
    value_range: Optional[Range] = None
    value_boolean: Optional[bool] = None
    value_quantity: Optional[Quantity] = None
    value_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class DeviceRequest(DomainResource):
    performer_type: Optional[CodeableConcept] = None
    insurance: Optional[List[Reference]] = field(default_factory=list)
    instantiates_canonical: Optional[List[str]] = field(default_factory=list)
    instantiates_uri: Optional[List[str]] = field(default_factory=list)
    relevant_history: Optional[List[Reference]] = field(default_factory=list)
    supporting_info: Optional[List[Reference]] = field(default_factory=list)
    encounter: Optional[Reference] = None
    prior_request: Optional[List[Reference]] = field(default_factory=list)
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    authored_on: Optional[str] = None
    occurrence_timing: Optional[Timing] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    code_reference: Optional[Reference] = None
    requester: Optional[Reference] = None
    priority: Optional[str] = None
    occurrence_period: Optional[Period] = None
    status: Optional[str] = None
    code_codeable_concept: Optional[CodeableConcept] = None
    group_identifier: Optional[Identifier] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    intent: str
    based_on: Optional[List[Reference]] = field(default_factory=list)
    occurrence_date_time: Optional[str] = None
    subject: Reference
    parameter: Optional[List[DeviceRequestParameter]] = field(default_factory=list)
    performer: Optional[Reference] = None
    reason_reference: Optional[List[Reference]] = field(default_factory=list)