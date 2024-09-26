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
class ClaimInsurance(BackboneElement):
    focal: bool
    coverage: Reference
    sequence: int
    identifier: Optional[Identifier] = None
    pre_auth_ref: Optional[List[str]] = field(default_factory=list)
    claim_response: Optional[Reference] = None
    business_arrangement: Optional[str] = None

@dataclass(kw_only=True)
class ClaimDiagnosis(BackboneElement):
    type: Optional[List[CodeableConcept]] = field(default_factory=list)
    sequence: int
    on_admission: Optional[CodeableConcept] = None
    package_code: Optional[CodeableConcept] = None
    diagnosis_reference: Optional[Reference] = None
    diagnosis_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class ClaimSupportingInfo(BackboneElement):
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

@dataclass(kw_only=True)
class ClaimItemDetailSubDetail(BackboneElement):
    category: Optional[CodeableConcept] = None
    modifier: Optional[List[CodeableConcept]] = field(default_factory=list)
    revenue: Optional[CodeableConcept] = None
    net: Optional[Money] = None
    product_or_service: CodeableConcept
    udi: Optional[List[Reference]] = field(default_factory=list)
    program_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    factor: Optional[float] = None
    sequence: int
    quantity: Optional[Quantity] = None
    unit_price: Optional[Money] = None

@dataclass(kw_only=True)
class ClaimItemDetail(BackboneElement):
    category: Optional[CodeableConcept] = None
    modifier: Optional[List[CodeableConcept]] = field(default_factory=list)
    revenue: Optional[CodeableConcept] = None
    net: Optional[Money] = None
    product_or_service: CodeableConcept
    udi: Optional[List[Reference]] = field(default_factory=list)
    program_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    factor: Optional[float] = None
    sequence: int
    sub_detail: Optional[List[ClaimItemDetailSubDetail]] = field(default_factory=list)
    quantity: Optional[Quantity] = None
    unit_price: Optional[Money] = None

@dataclass(kw_only=True)
class ClaimItem(BackboneElement):
    category: Optional[CodeableConcept] = None
    diagnosis_sequence: Optional[List[int]] = field(default_factory=list)
    procedure_sequence: Optional[List[int]] = field(default_factory=list)
    location_address: Optional[Address] = None
    modifier: Optional[List[CodeableConcept]] = field(default_factory=list)
    revenue: Optional[CodeableConcept] = None
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
    unit_price: Optional[Money] = None
    serviced_period: Optional[Period] = None
    detail: Optional[List[ClaimItemDetail]] = field(default_factory=list)

@dataclass(kw_only=True)
class ClaimProcedure(BackboneElement):
    udi: Optional[List[Reference]] = field(default_factory=list)
    date: Optional[str] = None
    type: Optional[List[CodeableConcept]] = field(default_factory=list)
    sequence: int
    procedure_reference: Optional[Reference] = None
    procedure_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class ClaimRelated(BackboneElement):
    claim: Optional[Reference] = None
    reference: Optional[Identifier] = None
    relationship: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class ClaimAccident(BackboneElement):
    date: str
    type: Optional[CodeableConcept] = None
    location_address: Optional[Address] = None
    location_reference: Optional[Reference] = None

@dataclass(kw_only=True)
class ClaimPayee(BackboneElement):
    type: CodeableConcept
    party: Optional[Reference] = None

@dataclass(kw_only=True)
class ClaimCareTeam(BackboneElement):
    role: Optional[CodeableConcept] = None
    provider: Reference
    sequence: int
    responsible: Optional[bool] = None
    qualification: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class Claim(DomainResource):
    patient: Reference
    insurance: list[ClaimInsurance] = field(default_factory=list)
    facility: Optional[Reference] = None
    diagnosis: Optional[List[ClaimDiagnosis]] = field(default_factory=list)
    enterer: Optional[Reference] = None
    supporting_info: Optional[List[ClaimSupportingInfo]] = field(default_factory=list)
    use: str
    item: Optional[List[ClaimItem]] = field(default_factory=list)
    type: CodeableConcept
    created: str
    procedure: Optional[List[ClaimProcedure]] = field(default_factory=list)
    related: Optional[List[ClaimRelated]] = field(default_factory=list)
    referral: Optional[Reference] = None
    total: Optional[Money] = None
    insurer: Optional[Reference] = None
    funds_reserve: Optional[CodeableConcept] = None
    priority: CodeableConcept
    accident: Optional[ClaimAccident] = None
    status: str
    payee: Optional[ClaimPayee] = None
    prescription: Optional[Reference] = None
    billable_period: Optional[Period] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    sub_type: Optional[CodeableConcept] = None
    provider: Reference
    original_prescription: Optional[Reference] = None
    care_team: Optional[List[ClaimCareTeam]] = field(default_factory=list)