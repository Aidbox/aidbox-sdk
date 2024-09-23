from typing import Optional, List
from pydantic import *
from ..base.Address import Address
from ..base.Attachment import Attachment
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.Quantity import Quantity
from ..base.DomainResource import DomainResource
from ..base.Money import Money
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class ClaimResponse_Insurance(BackboneElement):
    focal: bool
    coverage: Reference
    sequence: int
    claim_response: Optional[Reference] = None
    business_arrangement: Optional[str] = None

class ClaimResponse_ProcessNote(BackboneElement):
    text: str
    type: Optional[str] = None
    number: Optional[int] = None
    language: Optional[CodeableConcept] = None

class ClaimResponse_Payment(BackboneElement):
    date: Optional[str] = None
    type: CodeableConcept
    amount: Money
    adjustment: Optional[Money] = None
    identifier: Optional[Identifier] = None
    adjustment_reason: Optional[CodeableConcept] = None

class ClaimResponse_Item_Detail_SubDetail(BackboneElement):
    note_number: Optional[List[int]] = None
    adjudication: Optional[List[Reference]] = None
    sub_detail_sequence: int

class ClaimResponse_Item_Detail(BackboneElement):
    sub_detail: Optional[List[ClaimResponse_Item_Detail_SubDetail]] = None
    note_number: Optional[List[int]] = None
    adjudication: list[Reference] = []
    detail_sequence: int

class ClaimResponse_Item_Adjudication(BackboneElement):
    value: Optional[float] = None
    amount: Optional[Money] = None
    reason: Optional[CodeableConcept] = None
    category: CodeableConcept

class ClaimResponse_Item(BackboneElement):
    detail: Optional[List[ClaimResponse_Item_Detail]] = None
    note_number: Optional[List[int]] = None
    adjudication: list[ClaimResponse_Item_Adjudication] = []
    item_sequence: int

class ClaimResponse_Total(BackboneElement):
    amount: Money
    category: CodeableConcept

class ClaimResponse_Error(BackboneElement):
    code: CodeableConcept
    item_sequence: Optional[int] = None
    detail_sequence: Optional[int] = None
    sub_detail_sequence: Optional[int] = None

class ClaimResponse_AddItem_Detail_SubDetail(BackboneElement):
    net: Optional[Money] = None
    factor: Optional[float] = None
    modifier: Optional[List[CodeableConcept]] = None
    quantity: Optional[Quantity] = None
    unit_price: Optional[Money] = None
    note_number: Optional[List[int]] = None
    adjudication: list[Reference] = []
    product_or_service: CodeableConcept

class ClaimResponse_AddItem_Detail(BackboneElement):
    modifier: Optional[List[CodeableConcept]] = None
    adjudication: list[Reference] = []
    net: Optional[Money] = None
    product_or_service: CodeableConcept
    factor: Optional[float] = None
    sub_detail: Optional[List[ClaimResponse_AddItem_Detail_SubDetail]] = None
    quantity: Optional[Quantity] = None
    note_number: Optional[List[int]] = None
    unit_price: Optional[Money] = None

class ClaimResponse_AddItem(BackboneElement):
    location_address: Optional[Address] = None
    modifier: Optional[List[CodeableConcept]] = None
    adjudication: list[Reference] = []
    subdetail_sequence: Optional[List[int]] = None
    location_codeable_concept: Optional[CodeableConcept] = None
    item_sequence: Optional[List[int]] = None
    net: Optional[Money] = None
    detail_sequence: Optional[List[int]] = None
    sub_site: Optional[List[CodeableConcept]] = None
    product_or_service: CodeableConcept
    location_reference: Optional[Reference] = None
    program_code: Optional[List[CodeableConcept]] = None
    factor: Optional[float] = None
    serviced_date: Optional[str] = None
    body_site: Optional[CodeableConcept] = None
    quantity: Optional[Quantity] = None
    provider: Optional[List[Reference]] = None
    note_number: Optional[List[int]] = None
    unit_price: Optional[Money] = None
    serviced_period: Optional[Period] = None
    detail: Optional[List[ClaimResponse_AddItem_Detail]] = None

class ClaimResponse(DomainResource):
    patient: Reference
    requestor: Optional[Reference] = None
    payee_type: Optional[CodeableConcept] = None
    insurance: Optional[List[ClaimResponse_Insurance]] = None
    request: Optional[Reference] = None
    process_note: Optional[List[ClaimResponse_ProcessNote]] = None
    pre_auth_ref: Optional[str] = None
    adjudication: Optional[List[Reference]] = None
    use: str
    payment: Optional[ClaimResponse_Payment] = None
    item: Optional[List[ClaimResponse_Item]] = None
    type: CodeableConcept
    created: str
    pre_auth_period: Optional[Period] = None
    outcome: str
    disposition: Optional[str] = None
    communication_request: Optional[List[Reference]] = None
    total: Optional[List[ClaimResponse_Total]] = None
    insurer: Reference
    funds_reserve: Optional[CodeableConcept] = None
    status: str
    identifier: Optional[List[Identifier]] = None
    error: Optional[List[ClaimResponse_Error]] = None
    form: Optional[Attachment] = None
    sub_type: Optional[CodeableConcept] = None
    form_code: Optional[CodeableConcept] = None
    add_item: Optional[List[ClaimResponse_AddItem]] = None