from typing import Optional, List
from pydantic import *
from ..base import *

class ChargeItem_Performer(BackboneElement):
    actor: Reference
    function: Optional[CodeableConcept] = None

class ChargeItem(DomainResource):
    service: Optional[List[Reference]] = None
    definition_uri: Optional[List[str]] = None
    enterer: Optional[Reference] = None
    requesting_organization: Optional[Reference] = None
    product_codeable_concept: Optional[CodeableConcept] = None
    product_reference: Optional[Reference] = None
    definition_canonical: Optional[List[str]] = None
    bodysite: Optional[List[CodeableConcept]] = None
    occurrence_timing: Optional[Timing] = None
    cost_center: Optional[Reference] = None
    note: Optional[List[Annotation]] = None
    account: Optional[List[Reference]] = None
    reason: Optional[List[CodeableConcept]] = None
    supporting_information: Optional[List[Reference]] = None
    occurrence_period: Optional[Period] = None
    status: str
    code: CodeableConcept
    identifier: Optional[List[Identifier]] = None
    context: Optional[Reference] = None
    quantity: Optional[Quantity] = None
    part_of: Optional[List[Reference]] = None
    price_override: Optional[Money] = None
    entered_date: Optional[str] = None
    occurrence_date_time: Optional[str] = None
    override_reason: Optional[str] = None
    performing_organization: Optional[Reference] = None
    subject: Reference
    factor_override: Optional[float] = None
    performer: Optional[List[ChargeItem_Performer]] = None