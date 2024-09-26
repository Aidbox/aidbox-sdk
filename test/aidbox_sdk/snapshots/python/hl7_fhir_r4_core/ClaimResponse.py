from typing import Optional, List
from dataclasses import dataclass, field
from base import Address
from base import Attachment
from base import Period
from base import CodeableConcept
from base import Quantity
from base import DomainResource
from base import Money
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ClaimResponseInsurance(BackboneElement):
    focal: bool
    coverage: Reference
    sequence: int
    claim_response: Optional[Reference] = None
    business_arrangement: Optional[str] = None

@dataclass(kw_only=True)
class ClaimResponseProcessNote(BackboneElement):
    text: str
    type: Optional[str] = None
    number: Optional[int] = None
    language: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class ClaimResponsePayment(BackboneElement):
    date: Optional[str] = None
    type: CodeableConcept
    amount: Money
    adjustment: Optional[Money] = None
    identifier: Optional[Identifier] = None
    adjustment_reason: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class ClaimResponseItemDetailSubDetail(BackboneElement):
    note_number: Optional[List[int]] = field(default_factory=list)
    adjudication: Optional[List[Reference]] = field(default_factory=list)
    sub_detail_sequence: int

@dataclass(kw_only=True)
class ClaimResponseItemDetail(BackboneElement):
    sub_detail: Optional[List[ClaimResponseItemDetailSubDetail]] = field(default_factory=list)
    note_number: Optional[List[int]] = field(default_factory=list)
    adjudication: list[Reference] = field(default_factory=list)
    detail_sequence: int

@dataclass(kw_only=True)
class ClaimResponseItemAdjudication(BackboneElement):
    value: Optional[float] = None
    amount: Optional[Money] = None
    reason: Optional[CodeableConcept] = None
    category: CodeableConcept

@dataclass(kw_only=True)
class ClaimResponseItem(BackboneElement):
    detail: Optional[List[ClaimResponseItemDetail]] = field(default_factory=list)
    note_number: Optional[List[int]] = field(default_factory=list)
    adjudication: list[ClaimResponseItemAdjudication] = field(default_factory=list)
    item_sequence: int

@dataclass(kw_only=True)
class ClaimResponseTotal(BackboneElement):
    amount: Money
    category: CodeableConcept

@dataclass(kw_only=True)
class ClaimResponseError(BackboneElement):
    code: CodeableConcept
    item_sequence: Optional[int] = None
    detail_sequence: Optional[int] = None
    sub_detail_sequence: Optional[int] = None

@dataclass(kw_only=True)
class ClaimResponseAddItemDetailSubDetail(BackboneElement):
    net: Optional[Money] = None
    factor: Optional[float] = None
    modifier: Optional[List[CodeableConcept]] = field(default_factory=list)
    quantity: Optional[Quantity] = None
    unit_price: Optional[Money] = None
    note_number: Optional[List[int]] = field(default_factory=list)
    adjudication: list[Reference] = field(default_factory=list)
    product_or_service: CodeableConcept

@dataclass(kw_only=True)
class ClaimResponseAddItemDetail(BackboneElement):
    modifier: Optional[List[CodeableConcept]] = field(default_factory=list)
    adjudication: list[Reference] = field(default_factory=list)
    net: Optional[Money] = None
    product_or_service: CodeableConcept
    factor: Optional[float] = None
    sub_detail: Optional[List[ClaimResponseAddItemDetailSubDetail]] = field(default_factory=list)
    quantity: Optional[Quantity] = None
    note_number: Optional[List[int]] = field(default_factory=list)
    unit_price: Optional[Money] = None

@dataclass(kw_only=True)
class ClaimResponseAddItem(BackboneElement):
    location_address: Optional[Address] = None
    modifier: Optional[List[CodeableConcept]] = field(default_factory=list)
    adjudication: list[Reference] = field(default_factory=list)
    subdetail_sequence: Optional[List[int]] = field(default_factory=list)
    location_codeable_concept: Optional[CodeableConcept] = None
    item_sequence: Optional[List[int]] = field(default_factory=list)
    net: Optional[Money] = None
    detail_sequence: Optional[List[int]] = field(default_factory=list)
    sub_site: Optional[List[CodeableConcept]] = field(default_factory=list)
    product_or_service: CodeableConcept
    location_reference: Optional[Reference] = None
    program_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    factor: Optional[float] = None
    serviced_date: Optional[str] = None
    body_site: Optional[CodeableConcept] = None
    quantity: Optional[Quantity] = None
    provider: Optional[List[Reference]] = field(default_factory=list)
    note_number: Optional[List[int]] = field(default_factory=list)
    unit_price: Optional[Money] = None
    serviced_period: Optional[Period] = None
    detail: Optional[List[ClaimResponseAddItemDetail]] = field(default_factory=list)

@dataclass(kw_only=True)
class ClaimResponse(DomainResource):
    patient: Reference
    requestor: Optional[Reference] = None
    payee_type: Optional[CodeableConcept] = None
    insurance: Optional[List[ClaimResponseInsurance]] = field(default_factory=list)
    request: Optional[Reference] = None
    process_note: Optional[List[ClaimResponseProcessNote]] = field(default_factory=list)
    pre_auth_ref: Optional[str] = None
    adjudication: Optional[List[Reference]] = field(default_factory=list)
    use: str
    payment: Optional[ClaimResponsePayment] = None
    item: Optional[List[ClaimResponseItem]] = field(default_factory=list)
    type: CodeableConcept
    created: str
    pre_auth_period: Optional[Period] = None
    outcome: str
    disposition: Optional[str] = None
    communication_request: Optional[List[Reference]] = field(default_factory=list)
    total: Optional[List[ClaimResponseTotal]] = field(default_factory=list)
    insurer: Reference
    funds_reserve: Optional[CodeableConcept] = None
    status: str
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    error: Optional[List[ClaimResponseError]] = field(default_factory=list)
    form: Optional[Attachment] = None
    sub_type: Optional[CodeableConcept] = None
    form_code: Optional[CodeableConcept] = None
    add_item: Optional[List[ClaimResponseAddItem]] = field(default_factory=list)