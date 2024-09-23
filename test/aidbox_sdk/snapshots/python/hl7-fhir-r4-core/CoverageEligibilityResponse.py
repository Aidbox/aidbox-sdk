from typing import Optional, List
from pydantic import *
from ..base import *

class CoverageEligibilityResponse_Insurance_Item_Benefit(BackboneElement):
    used_string: Optional[str] = None
    allowed_money: Optional[Money] = None
    type: CodeableConcept
    allowed_unsigned_int: Optional[int] = None
    used_unsigned_int: Optional[int] = None
    allowed_string: Optional[str] = None
    used_money: Optional[Money] = None

class CoverageEligibilityResponse_Insurance_Item(BackboneElement):
    description: Optional[str] = None
    category: Optional[CodeableConcept] = None
    authorization_required: Optional[bool] = None
    modifier: Optional[List[CodeableConcept]] = None
    authorization_supporting: Optional[List[CodeableConcept]] = None
    unit: Optional[CodeableConcept] = None
    excluded: Optional[bool] = None
    name: Optional[str] = None
    product_or_service: Optional[CodeableConcept] = None
    term: Optional[CodeableConcept] = None
    benefit: Optional[List[CoverageEligibilityResponse_Insurance_Item_Benefit]] = None
    authorization_url: Optional[str] = None
    network: Optional[CodeableConcept] = None
    provider: Optional[Reference] = None

class CoverageEligibilityResponse_Insurance(BackboneElement):
    item: Optional[List[CoverageEligibilityResponse_Insurance_Item]] = None
    inforce: Optional[bool] = None
    coverage: Reference
    benefit_period: Optional[Period] = None

class CoverageEligibilityResponse_Error(BackboneElement):
    code: CodeableConcept

class CoverageEligibilityResponse(DomainResource):
    patient: Reference
    requestor: Optional[Reference] = None
    insurance: Optional[List[CoverageEligibilityResponse_Insurance]] = None
    request: Reference
    pre_auth_ref: Optional[str] = None
    purpose: list[str] = []
    created: str
    outcome: str
    disposition: Optional[str] = None
    insurer: Reference
    status: str
    serviced_date: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    error: Optional[List[CoverageEligibilityResponse_Error]] = None
    form: Optional[CodeableConcept] = None
    serviced_period: Optional[Period] = None