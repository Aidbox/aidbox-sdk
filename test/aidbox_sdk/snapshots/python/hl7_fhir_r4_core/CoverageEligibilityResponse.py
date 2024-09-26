from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Money
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class CoverageEligibilityResponseInsuranceItemBenefit(BackboneElement):
    used_string: Optional[str] = None
    allowed_money: Optional[Money] = None
    type: CodeableConcept
    allowed_unsigned_int: Optional[int] = None
    used_unsigned_int: Optional[int] = None
    allowed_string: Optional[str] = None
    used_money: Optional[Money] = None

@dataclass(kw_only=True)
class CoverageEligibilityResponseInsuranceItem(BackboneElement):
    description: Optional[str] = None
    category: Optional[CodeableConcept] = None
    authorization_required: Optional[bool] = None
    modifier: Optional[List[CodeableConcept]] = field(default_factory=list)
    authorization_supporting: Optional[List[CodeableConcept]] = field(default_factory=list)
    unit: Optional[CodeableConcept] = None
    excluded: Optional[bool] = None
    name: Optional[str] = None
    product_or_service: Optional[CodeableConcept] = None
    term: Optional[CodeableConcept] = None
    benefit: Optional[List[CoverageEligibilityResponseInsuranceItemBenefit]] = field(default_factory=list)
    authorization_url: Optional[str] = None
    network: Optional[CodeableConcept] = None
    provider: Optional[Reference] = None

@dataclass(kw_only=True)
class CoverageEligibilityResponseInsurance(BackboneElement):
    item: Optional[List[CoverageEligibilityResponseInsuranceItem]] = field(default_factory=list)
    inforce: Optional[bool] = None
    coverage: Reference
    benefit_period: Optional[Period] = None

@dataclass(kw_only=True)
class CoverageEligibilityResponseError(BackboneElement):
    code: CodeableConcept

@dataclass(kw_only=True)
class CoverageEligibilityResponse(DomainResource):
    patient: Reference
    requestor: Optional[Reference] = None
    insurance: Optional[List[CoverageEligibilityResponseInsurance]] = field(default_factory=list)
    request: Reference
    pre_auth_ref: Optional[str] = None
    purpose: list[str] = field(default_factory=list)
    created: str
    outcome: str
    disposition: Optional[str] = None
    insurer: Reference
    status: str
    serviced_date: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    error: Optional[List[CoverageEligibilityResponseError]] = field(default_factory=list)
    form: Optional[CodeableConcept] = None
    serviced_period: Optional[Period] = None