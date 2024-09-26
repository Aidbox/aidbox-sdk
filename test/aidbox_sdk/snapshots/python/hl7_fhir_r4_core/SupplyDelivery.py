from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import Timing
from base import Quantity
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class SupplyDeliverySuppliedItem(BackboneElement):
    quantity: Optional[Quantity] = None
    item_reference: Optional[Reference] = None
    item_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class SupplyDelivery(DomainResource):
    patient: Optional[Reference] = None
    supplier: Optional[Reference] = None
    supplied_item: Optional[SupplyDeliverySuppliedItem] = None
    type: Optional[CodeableConcept] = None
    occurrence_timing: Optional[Timing] = None
    occurrence_period: Optional[Period] = None
    status: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    based_on: Optional[List[Reference]] = field(default_factory=list)
    part_of: Optional[List[Reference]] = field(default_factory=list)
    occurrence_date_time: Optional[str] = None
    receiver: Optional[List[Reference]] = field(default_factory=list)
    destination: Optional[Reference] = None