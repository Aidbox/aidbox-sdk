from typing import Optional, List
from dataclasses import dataclass, field
from base import Address
from base import Attachment
from base import Period
from base import CodeableConcept
from base import Coding
from base import Quantity
from base import DomainResource
from base import Money
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ExplanationOfBenefitInsurance(BackboneElement):
    focal: bool
    coverage: Reference
    pre_auth_ref: Optional[List[str]] = field(default_factory=list)

@dataclass(kw_only=True)
class ExplanationOfBenefitBenefitBalanceFinancial(BackboneElement):
    type: CodeableConcept
    used_money: Optional[Money] = None
    allowed_money: Optional[Money] = None
    allowed_string: Optional[str] = None
    used_unsigned_int: Optional[int] = None
    allowed_unsigned_int: Optional[int] = None

@dataclass(kw_only=True)
class ExplanationOfBenefitBenefitBalance(BackboneElement):
    name: Optional[str] = None
    term: Optional[CodeableConcept] = None
    unit: Optional[CodeableConcept] = None
    network: Optional[CodeableConcept] = None
    category: CodeableConcept
    excluded: Optional[bool] = None
    financial: Optional[List[ExplanationOfBenefitBenefitBalanceFinancial]] = field(default_factory=list)
    description: Optional[str] = None

@dataclass(kw_only=True)
class ExplanationOfBenefitProcessNote(BackboneElement):
    text: Optional[str] = None
    type: Optional[str] = None
    number: Optional[int] = None
    language: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class ExplanationOfBenefitDiagnosis(BackboneElement):
    type: Optional[List[CodeableConcept]] = field(default_factory=list)
    sequence: int
    on_admission: Optional[CodeableConcept] = None
    package_code: Optional[CodeableConcept] = None
    diagnosis_reference: Optional[Reference] = None
    diagnosis_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class ExplanationOfBenefitSupportingInfo(BackboneElement):
    category: CodeableConcept
    value_reference: Optional[Reference] = None
    value_quantity: Optional[Quantity] = None
    timing_period: Optional[Period] = None
    value_string: Optional[str] = None
    value_boolean: Optional[bool] = None
    reason: Optional[Coding] = None
    sequence: int
    code: Optional[CodeableConcept] = None
    timing_date: Optional[str] = None
    value_attachment: Optional[Attachment] = None

@dataclass(kw_only=True)
class ExplanationOfBenefitPayment(BackboneElement):
    date: Optional[str] = None
    type: Optional[CodeableConcept] = None
    amount: Optional[Money] = None
    adjustment: Optional[Money] = None
    identifier: Optional[Identifier] = None
    adjustment_reason: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class ExplanationOfBenefitItemAdjudication(BackboneElement):
    value: Optional[float] = None
    amount: Optional[Money] = None
    reason: Optional[CodeableConcept] = None
    category: CodeableConcept

@dataclass(kw_only=True)
class ExplanationOfBenefitItemDetailSubDetail(BackboneElement):
    category: Optional[CodeableConcept] = None
    modifier: Optional[List[CodeableConcept]] = field(default_factory=list)
    revenue: Optional[CodeableConcept] = None
    adjudication: Optional[List[Reference]] = field(default_factory=list)
    net: Optional[Money] = None
    product_or_service: CodeableConcept
    udi: Optional[List[Reference]] = field(default_factory=list)
    program_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    factor: Optional[float] = None
    sequence: int
    quantity: Optional[Quantity] = None
    note_number: Optional[List[int]] = field(default_factory=list)
    unit_price: Optional[Money] = None

@dataclass(kw_only=True)
class ExplanationOfBenefitItemDetail(BackboneElement):
    category: Optional[CodeableConcept] = None
    modifier: Optional[List[CodeableConcept]] = field(default_factory=list)
    revenue: Optional[CodeableConcept] = None
    adjudication: Optional[List[Reference]] = field(default_factory=list)
    net: Optional[Money] = None
    product_or_service: CodeableConcept
    udi: Optional[List[Reference]] = field(default_factory=list)
    program_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    factor: Optional[float] = None
    sequence: int
    sub_detail: Optional[List[ExplanationOfBenefitItemDetailSubDetail]] = field(default_factory=list)
    quantity: Optional[Quantity] = None
    note_number: Optional[List[int]] = field(default_factory=list)
    unit_price: Optional[Money] = None

@dataclass(kw_only=True)
class ExplanationOfBenefitItem(BackboneElement):
    category: Optional[CodeableConcept] = None
    diagnosis_sequence: Optional[List[int]] = field(default_factory=list)
    procedure_sequence: Optional[List[int]] = field(default_factory=list)
    location_address: Optional[Address] = None
    modifier: Optional[List[CodeableConcept]] = field(default_factory=list)
    revenue: Optional[CodeableConcept] = None
    adjudication: Optional[List[ExplanationOfBenefitItemAdjudication]] = field(default_factory=list)
    encounter: Optional[List[Reference]] = field(default_factory=list)
    location_codeable_concept: Optional[CodeableConcept] = None
    net: Optional[Money] = None
    sub_site: Optional[List[CodeableConcept]] = field(default_factory=list)
    care_team_sequence: Optional[List[int]] = field(default_factory=list)
    product_or_service: CodeableConcept
    location_reference: Optional[Reference] = None
    udi: Optional[List[Reference]] = field(default_factory=list)
    information_sequence: Optional[List[int]] = field(default_factory=list)
    program_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    factor: Optional[float] = None
    serviced_date: Optional[str] = None
    sequence: int
    body_site: Optional[CodeableConcept] = None
    quantity: Optional[Quantity] = None
    note_number: Optional[List[int]] = field(default_factory=list)
    unit_price: Optional[Money] = None
    serviced_period: Optional[Period] = None
    detail: Optional[List[ExplanationOfBenefitItemDetail]] = field(default_factory=list)

@dataclass(kw_only=True)
class ExplanationOfBenefitProcedure(BackboneElement):
    udi: Optional[List[Reference]] = field(default_factory=list)
    date: Optional[str] = None
    type: Optional[List[CodeableConcept]] = field(default_factory=list)
    sequence: int
    procedure_reference: Optional[Reference] = None
    procedure_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class ExplanationOfBenefitRelated(BackboneElement):
    claim: Optional[Reference] = None
    reference: Optional[Identifier] = None
    relationship: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class ExplanationOfBenefitTotal(BackboneElement):
    amount: Money
    category: CodeableConcept

@dataclass(kw_only=True)
class ExplanationOfBenefitAccident(BackboneElement):
    date: Optional[str] = None
    type: Optional[CodeableConcept] = None
    location_address: Optional[Address] = None
    location_reference: Optional[Reference] = None

@dataclass(kw_only=True)
class ExplanationOfBenefitPayee(BackboneElement):
    type: Optional[CodeableConcept] = None
    party: Optional[Reference] = None

@dataclass(kw_only=True)
class ExplanationOfBenefitAddItemDetailSubDetail(BackboneElement):
    net: Optional[Money] = None
    factor: Optional[float] = None
    modifier: Optional[List[CodeableConcept]] = field(default_factory=list)
    quantity: Optional[Quantity] = None
    unit_price: Optional[Money] = None
    note_number: Optional[List[int]] = field(default_factory=list)
    adjudication: Optional[List[Reference]] = field(default_factory=list)
    product_or_service: CodeableConcept

@dataclass(kw_only=True)
class ExplanationOfBenefitAddItemDetail(BackboneElement):
    modifier: Optional[List[CodeableConcept]] = field(default_factory=list)
    adjudication: Optional[List[Reference]] = field(default_factory=list)
    net: Optional[Money] = None
    product_or_service: CodeableConcept
    factor: Optional[float] = None
    sub_detail: Optional[List[ExplanationOfBenefitAddItemDetailSubDetail]] = field(default_factory=list)
    quantity: Optional[Quantity] = None
    note_number: Optional[List[int]] = field(default_factory=list)
    unit_price: Optional[Money] = None

@dataclass(kw_only=True)
class ExplanationOfBenefitAddItem(BackboneElement):
    location_address: Optional[Address] = None
    modifier: Optional[List[CodeableConcept]] = field(default_factory=list)
    adjudication: Optional[List[Reference]] = field(default_factory=list)
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
    sub_detail_sequence: Optional[List[int]] = field(default_factory=list)
    body_site: Optional[CodeableConcept] = None
    quantity: Optional[Quantity] = None
    provider: Optional[List[Reference]] = field(default_factory=list)
    note_number: Optional[List[int]] = field(default_factory=list)
    unit_price: Optional[Money] = None
    serviced_period: Optional[Period] = None
    detail: Optional[List[ExplanationOfBenefitAddItemDetail]] = field(default_factory=list)

@dataclass(kw_only=True)
class ExplanationOfBenefitCareTeam(BackboneElement):
    role: Optional[CodeableConcept] = None
    provider: Reference
    sequence: int
    responsible: Optional[bool] = None
    qualification: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class ExplanationOfBenefit(DomainResource):
    patient: Reference
    claim_response: Optional[Reference] = None
    insurance: list[ExplanationOfBenefitInsurance] = field(default_factory=list)
    benefit_balance: Optional[List[ExplanationOfBenefitBenefitBalance]] = field(default_factory=list)
    facility: Optional[Reference] = None
    process_note: Optional[List[ExplanationOfBenefitProcessNote]] = field(default_factory=list)
    diagnosis: Optional[List[ExplanationOfBenefitDiagnosis]] = field(default_factory=list)
    pre_auth_ref: Optional[List[str]] = field(default_factory=list)
    adjudication: Optional[List[Reference]] = field(default_factory=list)
    enterer: Optional[Reference] = None
    supporting_info: Optional[List[ExplanationOfBenefitSupportingInfo]] = field(default_factory=list)
    use: str
    payment: Optional[ExplanationOfBenefitPayment] = None
    item: Optional[List[ExplanationOfBenefitItem]] = field(default_factory=list)
    type: CodeableConcept
    created: str
    procedure: Optional[List[ExplanationOfBenefitProcedure]] = field(default_factory=list)
    outcome: str
    related: Optional[List[ExplanationOfBenefitRelated]] = field(default_factory=list)
    disposition: Optional[str] = None
    referral: Optional[Reference] = None
    pre_auth_ref_period: Optional[List[Period]] = field(default_factory=list)
    total: Optional[List[ExplanationOfBenefitTotal]] = field(default_factory=list)
    insurer: Reference
    funds_reserve: Optional[CodeableConcept] = None
    priority: Optional[CodeableConcept] = None
    accident: Optional[ExplanationOfBenefitAccident] = None
    status: str
    payee: Optional[ExplanationOfBenefitPayee] = None
    prescription: Optional[Reference] = None
    billable_period: Optional[Period] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    form: Optional[Attachment] = None
    sub_type: Optional[CodeableConcept] = None
    funds_reserve_requested: Optional[CodeableConcept] = None
    benefit_period: Optional[Period] = None
    precedence: Optional[int] = None
    form_code: Optional[CodeableConcept] = None
    provider: Reference
    add_item: Optional[List[ExplanationOfBenefitAddItem]] = field(default_factory=list)
    original_prescription: Optional[Reference] = None
    care_team: Optional[List[ExplanationOfBenefitCareTeam]] = field(default_factory=list)
    claim: Optional[Reference] = None