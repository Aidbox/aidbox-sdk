from typing import Optional, List
from pydantic import *
from ..base import *

class SupplyDelivery_SuppliedItem(BackboneElement):
    quantity: Optional[Quantity] = None
    item_reference: Optional[Reference] = None
    item_codeable_concept: Optional[CodeableConcept] = None

class SupplyDelivery(DomainResource):
    patient: Optional[Reference] = None
    supplier: Optional[Reference] = None
    supplied_item: Optional[SupplyDelivery_SuppliedItem] = None
    type: Optional[CodeableConcept] = None
    occurrence_timing: Optional[Timing] = None
    occurrence_period: Optional[Period] = None
    status: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    based_on: Optional[List[Reference]] = None
    part_of: Optional[List[Reference]] = None
    occurrence_date_time: Optional[str] = None
    receiver: Optional[List[Reference]] = None
    destination: Optional[Reference] = None