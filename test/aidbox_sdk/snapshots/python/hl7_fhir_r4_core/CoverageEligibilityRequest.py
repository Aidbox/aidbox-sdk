from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import Quantity
from base import DomainResource
from base import Money
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class CoverageEligibilityRequestInsurance(BackboneElement):
    focal: Optional[bool] = None
    coverage: Reference
    business_arrangement: Optional[str] = None

@dataclass(kw_only=True)
class CoverageEligibilityRequestSupportingInfo(BackboneElement):
    sequence: int
    information: Reference
    applies_to_all: Optional[bool] = None

@dataclass(kw_only=True)
class CoverageEligibilityRequestItemDiagnosis(BackboneElement):
    diagnosis_reference: Optional[Reference] = None
    diagnosis_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class CoverageEligibilityRequestItem(BackboneElement):
    category: Optional[CodeableConcept] = None
    facility: Optional[Reference] = None
    diagnosis: Optional[List[CoverageEligibilityRequestItemDiagnosis]] = field(default_factory=list)
    modifier: Optional[List[CodeableConcept]] = field(default_factory=list)
    product_or_service: Optional[CodeableConcept] = None
    quantity: Optional[Quantity] = None
    provider: Optional[Reference] = None
    supporting_info_sequence: Optional[List[int]] = field(default_factory=list)
    unit_price: Optional[Money] = None
    detail: Optional[List[Reference]] = field(default_factory=list)

@dataclass(kw_only=True)
class CoverageEligibilityRequest(DomainResource):
    patient: Reference
    insurance: Optional[List[CoverageEligibilityRequestInsurance]] = field(default_factory=list)
    facility: Optional[Reference] = None
    enterer: Optional[Reference] = None
    supporting_info: Optional[List[CoverageEligibilityRequestSupportingInfo]] = field(default_factory=list)
    purpose: list[str] = field(default_factory=list)
    item: Optional[List[CoverageEligibilityRequestItem]] = field(default_factory=list)
    created: str
    insurer: Reference
    priority: Optional[CodeableConcept] = None
    status: str
    serviced_date: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    provider: Optional[Reference] = None
    serviced_period: Optional[Period] = None