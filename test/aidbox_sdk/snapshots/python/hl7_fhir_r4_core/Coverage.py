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
class CoverageCostToBeneficiaryException(BackboneElement):
    type: CodeableConcept
    period: Optional[Period] = None

@dataclass(kw_only=True)
class CoverageCostToBeneficiary(BackboneElement):
    type: Optional[CodeableConcept] = None
    exception: Optional[List[CoverageCostToBeneficiaryException]] = field(default_factory=list)
    value_money: Optional[Money] = None
    value_quantity: Optional[Quantity] = None

@dataclass(kw_only=True)
class CoverageClass(BackboneElement):
    name: Optional[str] = None
    type: CodeableConcept
    value: str

@dataclass(kw_only=True)
class Coverage(DomainResource):
    policy_holder: Optional[Reference] = None
    beneficiary: Reference
    contract: Optional[List[Reference]] = field(default_factory=list)
    relationship: Optional[CodeableConcept] = None
    type: Optional[CodeableConcept] = None
    cost_to_beneficiary: Optional[List[CoverageCostToBeneficiary]] = field(default_factory=list)
    subrogation: Optional[bool] = None
    subscriber: Optional[Reference] = None
    payor: list[Reference] = field(default_factory=list)
    status: str
    class_: Optional[List[CoverageClass]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    order: Optional[int] = None
    network: Optional[str] = None
    period: Optional[Period] = None
    dependent: Optional[str] = None
    subscriber_id: Optional[str] = None