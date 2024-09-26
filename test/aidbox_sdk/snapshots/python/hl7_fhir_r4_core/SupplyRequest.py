from typing import Optional, List
from dataclasses import dataclass, field
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
class SupplyRequestParameter(BackboneElement):
    code: Optional[CodeableConcept] = None
    value_range: Optional[Range] = None
    value_boolean: Optional[bool] = None
    value_quantity: Optional[Quantity] = None
    value_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class SupplyRequest(DomainResource):
    category: Optional[CodeableConcept] = None
    supplier: Optional[List[Reference]] = field(default_factory=list)
    deliver_to: Optional[Reference] = None
    item_reference: Optional[Reference] = None
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    authored_on: Optional[str] = None
    occurrence_timing: Optional[Timing] = None
    deliver_from: Optional[Reference] = None
    requester: Optional[Reference] = None
    priority: Optional[str] = None
    occurrence_period: Optional[Period] = None
    status: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    item_codeable_concept: Optional[CodeableConcept] = None
    quantity: Quantity
    occurrence_date_time: Optional[str] = None
    parameter: Optional[List[SupplyRequestParameter]] = field(default_factory=list)
    reason_reference: Optional[List[Reference]] = field(default_factory=list)