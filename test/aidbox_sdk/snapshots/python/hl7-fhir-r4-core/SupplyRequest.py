from pydantic import *
from typing import Optional, List
from ..base import *

class SupplyRequest_Parameter(BackboneElement):
    code: Optional[CodeableConcept] = None
    value_range: Optional[Range] = None
    value_boolean: Optional[bool] = None
    value_quantity: Optional[Quantity] = None
    value_codeable_concept: Optional[CodeableConcept] = None

class SupplyRequest(DomainResource):
    category: Optional[CodeableConcept] = None
    supplier: Optional[List[Reference]] = None
    deliver_to: Optional[Reference] = None
    item_reference: Optional[Reference] = None
    reason_code: Optional[List[CodeableConcept]] = None
    authored_on: Optional[str] = None
    occurrence_timing: Optional[Timing] = None
    deliver_from: Optional[Reference] = None
    requester: Optional[Reference] = None
    priority: Optional[str] = None
    occurrence_period: Optional[Period] = None
    status: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    item_codeable_concept: Optional[CodeableConcept] = None
    quantity: Quantity
    occurrence_date_time: Optional[str] = None
    parameter: Optional[List[SupplyRequest_Parameter]] = None
    reason_reference: Optional[List[Reference]] = None