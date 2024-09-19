from pydantic import *
from typing import Optional, List
from ..base import *

class ExplanationOfBenefit_Insurance(BackboneElement):
    focal: bool
    coverage: Reference
    pre_auth_ref: Optional[List[str]] = None

class ExplanationOfBenefit_BenefitBalance_Financial(BackboneElement):
    type: CodeableConcept
    used_money: Optional[Money] = None
    allowed_money: Optional[Money] = None
    allowed_string: Optional[str] = None
    used_unsigned_int: Optional[int] = None
    allowed_unsigned_int: Optional[int] = None

class ExplanationOfBenefit_BenefitBalance(BackboneElement):
    name: Optional[str] = None
    term: Optional[CodeableConcept] = None
    unit: Optional[CodeableConcept] = None
    network: Optional[CodeableConcept] = None
    category: CodeableConcept
    excluded: Optional[bool] = None
    financial: Optional[List[ExplanationOfBenefit_BenefitBalance_Financial]] = None
    description: Optional[str] = None

class ExplanationOfBenefit_ProcessNote(BackboneElement):
    text: Optional[str] = None
    type: Optional[str] = None
    number: Optional[int] = None
    language: Optional[CodeableConcept] = None

class ExplanationOfBenefit_Diagnosis(BackboneElement):
    type: Optional[List[CodeableConcept]] = None
    sequence: int
    on_admission: Optional[CodeableConcept] = None
    package_code: Optional[CodeableConcept] = None
    diagnosis_reference: Optional[Reference] = None
    diagnosis_codeable_concept: Optional[CodeableConcept] = None

class ExplanationOfBenefit_SupportingInfo(BackboneElement):
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

class ExplanationOfBenefit_Payment(BackboneElement):
    date: Optional[str] = None
    type: Optional[CodeableConcept] = None
    amount: Optional[Money] = None
    adjustment: Optional[Money] = None
    identifier: Optional[Identifier] = None
    adjustment_reason: Optional[CodeableConcept] = None

class ExplanationOfBenefit_Item_Adjudication(BackboneElement):
    value: Optional[float] = None
    amount: Optional[Money] = None
    reason: Optional[CodeableConcept] = None
    category: CodeableConcept

class ExplanationOfBenefit_Item_Detail_SubDetail(BackboneElement):
    category: Optional[CodeableConcept] = None
    modifier: Optional[List[CodeableConcept]] = None
    revenue: Optional[CodeableConcept] = None
    adjudication: Optional[List[Reference]] = None
    net: Optional[Money] = None
    product_or_service: CodeableConcept
    udi: Optional[List[Reference]] = None
    program_code: Optional[List[CodeableConcept]] = None
    factor: Optional[float] = None
    sequence: int
    quantity: Optional[Quantity] = None
    note_number: Optional[List[int]] = None
    unit_price: Optional[Money] = None

class ExplanationOfBenefit_Item_Detail(BackboneElement):
    category: Optional[CodeableConcept] = None
    modifier: Optional[List[CodeableConcept]] = None
    revenue: Optional[CodeableConcept] = None
    adjudication: Optional[List[Reference]] = None
    net: Optional[Money] = None
    product_or_service: CodeableConcept
    udi: Optional[List[Reference]] = None
    program_code: Optional[List[CodeableConcept]] = None
    factor: Optional[float] = None
    sequence: int
    sub_detail: Optional[List[ExplanationOfBenefit_Item_Detail_SubDetail]] = None
    quantity: Optional[Quantity] = None
    note_number: Optional[List[int]] = None
    unit_price: Optional[Money] = None

class ExplanationOfBenefit_Item(BackboneElement):
    category: Optional[CodeableConcept] = None
    diagnosis_sequence: Optional[List[int]] = None
    procedure_sequence: Optional[List[int]] = None
    location_address: Optional[Address] = None
    modifier: Optional[List[CodeableConcept]] = None
    revenue: Optional[CodeableConcept] = None
    adjudication: Optional[List[ExplanationOfBenefit_Item_Adjudication]] = None
    encounter: Optional[List[Reference]] = None
    location_codeable_concept: Optional[CodeableConcept] = None
    net: Optional[Money] = None
    sub_site: Optional[List[CodeableConcept]] = None
    care_team_sequence: Optional[List[int]] = None
    product_or_service: CodeableConcept
    location_reference: Optional[Reference] = None
    udi: Optional[List[Reference]] = None
    information_sequence: Optional[List[int]] = None
    program_code: Optional[List[CodeableConcept]] = None
    factor: Optional[float] = None
    serviced_date: Optional[str] = None
    sequence: int
    body_site: Optional[CodeableConcept] = None
    quantity: Optional[Quantity] = None
    note_number: Optional[List[int]] = None
    unit_price: Optional[Money] = None
    serviced_period: Optional[Period] = None
    detail: Optional[List[ExplanationOfBenefit_Item_Detail]] = None

class ExplanationOfBenefit_Procedure(BackboneElement):
    udi: Optional[List[Reference]] = None
    date: Optional[str] = None
    type: Optional[List[CodeableConcept]] = None
    sequence: int
    procedure_reference: Optional[Reference] = None
    procedure_codeable_concept: Optional[CodeableConcept] = None

class ExplanationOfBenefit_Related(BackboneElement):
    claim: Optional[Reference] = None
    reference: Optional[Identifier] = None
    relationship: Optional[CodeableConcept] = None

class ExplanationOfBenefit_Total(BackboneElement):
    amount: Money
    category: CodeableConcept

class ExplanationOfBenefit_Accident(BackboneElement):
    date: Optional[str] = None
    type: Optional[CodeableConcept] = None
    location_address: Optional[Address] = None
    location_reference: Optional[Reference] = None

class ExplanationOfBenefit_Payee(BackboneElement):
    type: Optional[CodeableConcept] = None
    party: Optional[Reference] = None

class ExplanationOfBenefit_AddItem_Detail_SubDetail(BackboneElement):
    net: Optional[Money] = None
    factor: Optional[float] = None
    modifier: Optional[List[CodeableConcept]] = None
    quantity: Optional[Quantity] = None
    unit_price: Optional[Money] = None
    note_number: Optional[List[int]] = None
    adjudication: Optional[List[Reference]] = None
    product_or_service: CodeableConcept

class ExplanationOfBenefit_AddItem_Detail(BackboneElement):
    modifier: Optional[List[CodeableConcept]] = None
    adjudication: Optional[List[Reference]] = None
    net: Optional[Money] = None
    product_or_service: CodeableConcept
    factor: Optional[float] = None
    sub_detail: Optional[List[ExplanationOfBenefit_AddItem_Detail_SubDetail]] = None
    quantity: Optional[Quantity] = None
    note_number: Optional[List[int]] = None
    unit_price: Optional[Money] = None

class ExplanationOfBenefit_AddItem(BackboneElement):
    location_address: Optional[Address] = None
    modifier: Optional[List[CodeableConcept]] = None
    adjudication: Optional[List[Reference]] = None
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
    sub_detail_sequence: Optional[List[int]] = None
    body_site: Optional[CodeableConcept] = None
    quantity: Optional[Quantity] = None
    provider: Optional[List[Reference]] = None
    note_number: Optional[List[int]] = None
    unit_price: Optional[Money] = None
    serviced_period: Optional[Period] = None
    detail: Optional[List[ExplanationOfBenefit_AddItem_Detail]] = None

class ExplanationOfBenefit_CareTeam(BackboneElement):
    role: Optional[CodeableConcept] = None
    provider: Reference
    sequence: int
    responsible: Optional[bool] = None
    qualification: Optional[CodeableConcept] = None

class ExplanationOfBenefit(DomainResource):
    patient: Reference
    claim_response: Optional[Reference] = None
    insurance: list[ExplanationOfBenefit_Insurance] = []
    benefit_balance: Optional[List[ExplanationOfBenefit_BenefitBalance]] = None
    facility: Optional[Reference] = None
    process_note: Optional[List[ExplanationOfBenefit_ProcessNote]] = None
    diagnosis: Optional[List[ExplanationOfBenefit_Diagnosis]] = None
    pre_auth_ref: Optional[List[str]] = None
    adjudication: Optional[List[Reference]] = None
    enterer: Optional[Reference] = None
    supporting_info: Optional[List[ExplanationOfBenefit_SupportingInfo]] = None
    use: str
    payment: Optional[ExplanationOfBenefit_Payment] = None
    item: Optional[List[ExplanationOfBenefit_Item]] = None
    type: CodeableConcept
    created: str
    procedure: Optional[List[ExplanationOfBenefit_Procedure]] = None
    outcome: str
    related: Optional[List[ExplanationOfBenefit_Related]] = None
    disposition: Optional[str] = None
    referral: Optional[Reference] = None
    pre_auth_ref_period: Optional[List[Period]] = None
    total: Optional[List[ExplanationOfBenefit_Total]] = None
    insurer: Reference
    funds_reserve: Optional[CodeableConcept] = None
    priority: Optional[CodeableConcept] = None
    accident: Optional[ExplanationOfBenefit_Accident] = None
    status: str
    payee: Optional[ExplanationOfBenefit_Payee] = None
    prescription: Optional[Reference] = None
    billable_period: Optional[Period] = None
    identifier: Optional[List[Identifier]] = None
    form: Optional[Attachment] = None
    sub_type: Optional[CodeableConcept] = None
    funds_reserve_requested: Optional[CodeableConcept] = None
    benefit_period: Optional[Period] = None
    precedence: Optional[int] = None
    form_code: Optional[CodeableConcept] = None
    provider: Reference
    add_item: Optional[List[ExplanationOfBenefit_AddItem]] = None
    original_prescription: Optional[Reference] = None
    care_team: Optional[List[ExplanationOfBenefit_CareTeam]] = None
    claim: Optional[Reference] = None