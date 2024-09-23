from typing import Optional, List
from pydantic import *
from ..base import *

class Claim_Insurance(BackboneElement):
    focal: bool
    coverage: Reference
    sequence: int
    identifier: Optional[Identifier] = None
    pre_auth_ref: Optional[List[str]] = None
    claim_response: Optional[Reference] = None
    business_arrangement: Optional[str] = None

class Claim_Diagnosis(BackboneElement):
    type: Optional[List[CodeableConcept]] = None
    sequence: int
    on_admission: Optional[CodeableConcept] = None
    package_code: Optional[CodeableConcept] = None
    diagnosis_reference: Optional[Reference] = None
    diagnosis_codeable_concept: Optional[CodeableConcept] = None

class Claim_SupportingInfo(BackboneElement):
    category: CodeableConcept
    value_reference: Optional[Reference] = None
    value_quantity: Optional[Quantity] = None
    timing_period: Optional[Period] = None
    value_string: Optional[str] = None
    value_boolean: Optional[bool] = None
    reason: Optional[CodeableConcept] = None
    sequence: int
    code: Optional[CodeableConcept] = None
    timing_date: Optional[str] = None
    value_attachment: Optional[Attachment] = None

class Claim_Item_Detail_SubDetail(BackboneElement):
    category: Optional[CodeableConcept] = None
    modifier: Optional[List[CodeableConcept]] = None
    revenue: Optional[CodeableConcept] = None
    net: Optional[Money] = None
    product_or_service: CodeableConcept
    udi: Optional[List[Reference]] = None
    program_code: Optional[List[CodeableConcept]] = None
    factor: Optional[float] = None
    sequence: int
    quantity: Optional[Quantity] = None
    unit_price: Optional[Money] = None

class Claim_Item_Detail(BackboneElement):
    category: Optional[CodeableConcept] = None
    modifier: Optional[List[CodeableConcept]] = None
    revenue: Optional[CodeableConcept] = None
    net: Optional[Money] = None
    product_or_service: CodeableConcept
    udi: Optional[List[Reference]] = None
    program_code: Optional[List[CodeableConcept]] = None
    factor: Optional[float] = None
    sequence: int
    sub_detail: Optional[List[Claim_Item_Detail_SubDetail]] = None
    quantity: Optional[Quantity] = None
    unit_price: Optional[Money] = None

class Claim_Item(BackboneElement):
    category: Optional[CodeableConcept] = None
    diagnosis_sequence: Optional[List[int]] = None
    procedure_sequence: Optional[List[int]] = None
    location_address: Optional[Address] = None
    modifier: Optional[List[CodeableConcept]] = None
    revenue: Optional[CodeableConcept] = None
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
    unit_price: Optional[Money] = None
    serviced_period: Optional[Period] = None
    detail: Optional[List[Claim_Item_Detail]] = None

class Claim_Procedure(BackboneElement):
    udi: Optional[List[Reference]] = None
    date: Optional[str] = None
    type: Optional[List[CodeableConcept]] = None
    sequence: int
    procedure_reference: Optional[Reference] = None
    procedure_codeable_concept: Optional[CodeableConcept] = None

class Claim_Related(BackboneElement):
    claim: Optional[Reference] = None
    reference: Optional[Identifier] = None
    relationship: Optional[CodeableConcept] = None

class Claim_Accident(BackboneElement):
    date: str
    type: Optional[CodeableConcept] = None
    location_address: Optional[Address] = None
    location_reference: Optional[Reference] = None

class Claim_Payee(BackboneElement):
    type: CodeableConcept
    party: Optional[Reference] = None

class Claim_CareTeam(BackboneElement):
    role: Optional[CodeableConcept] = None
    provider: Reference
    sequence: int
    responsible: Optional[bool] = None
    qualification: Optional[CodeableConcept] = None

class Claim(DomainResource):
    patient: Reference
    insurance: list[Claim_Insurance] = []
    facility: Optional[Reference] = None
    diagnosis: Optional[List[Claim_Diagnosis]] = None
    enterer: Optional[Reference] = None
    supporting_info: Optional[List[Claim_SupportingInfo]] = None
    use: str
    item: Optional[List[Claim_Item]] = None
    type: CodeableConcept
    created: str
    procedure: Optional[List[Claim_Procedure]] = None
    related: Optional[List[Claim_Related]] = None
    referral: Optional[Reference] = None
    total: Optional[Money] = None
    insurer: Optional[Reference] = None
    funds_reserve: Optional[CodeableConcept] = None
    priority: CodeableConcept
    accident: Optional[Claim_Accident] = None
    status: str
    payee: Optional[Claim_Payee] = None
    prescription: Optional[Reference] = None
    billable_period: Optional[Period] = None
    identifier: Optional[List[Identifier]] = None
    sub_type: Optional[CodeableConcept] = None
    provider: Reference
    original_prescription: Optional[Reference] = None
    care_team: Optional[List[Claim_CareTeam]] = None