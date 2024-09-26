from typing import Optional, List
from dataclasses import dataclass, field
from base import Address
from base import Period
from base import CodeableConcept
from base import ContactPoint
from base import Quantity
from base import HumanName
from base import DomainResource
from base import Money
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class InsurancePlanCoverageBenefitLimit(BackboneElement):
    code: Optional[CodeableConcept] = None
    value: Optional[Quantity] = None

@dataclass(kw_only=True)
class InsurancePlanCoverageBenefit(BackboneElement):
    type: CodeableConcept
    limit: Optional[List[InsurancePlanCoverageBenefitLimit]] = field(default_factory=list)
    requirement: Optional[str] = None

@dataclass(kw_only=True)
class InsurancePlanCoverage(BackboneElement):
    type: CodeableConcept
    benefit: list[InsurancePlanCoverageBenefit] = field(default_factory=list)
    network: Optional[List[Reference]] = field(default_factory=list)

@dataclass(kw_only=True)
class InsurancePlanPlanGeneralCost(BackboneElement):
    cost: Optional[Money] = None
    type: Optional[CodeableConcept] = None
    comment: Optional[str] = None
    group_size: Optional[int] = None

@dataclass(kw_only=True)
class InsurancePlanPlanSpecificCostBenefitCost(BackboneElement):
    type: CodeableConcept
    value: Optional[Quantity] = None
    qualifiers: Optional[List[CodeableConcept]] = field(default_factory=list)
    applicability: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class InsurancePlanPlanSpecificCostBenefit(BackboneElement):
    cost: Optional[List[InsurancePlanPlanSpecificCostBenefitCost]] = field(default_factory=list)
    type: CodeableConcept

@dataclass(kw_only=True)
class InsurancePlanPlanSpecificCost(BackboneElement):
    benefit: Optional[List[InsurancePlanPlanSpecificCostBenefit]] = field(default_factory=list)
    category: CodeableConcept

@dataclass(kw_only=True)
class InsurancePlanPlan(BackboneElement):
    type: Optional[CodeableConcept] = None
    network: Optional[List[Reference]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    general_cost: Optional[List[InsurancePlanPlanGeneralCost]] = field(default_factory=list)
    coverage_area: Optional[List[Reference]] = field(default_factory=list)
    specific_cost: Optional[List[InsurancePlanPlanSpecificCost]] = field(default_factory=list)

@dataclass(kw_only=True)
class InsurancePlanContact(BackboneElement):
    name: Optional[HumanName] = None
    address: Optional[Address] = None
    purpose: Optional[CodeableConcept] = None
    telecom: Optional[List[ContactPoint]] = field(default_factory=list)

@dataclass(kw_only=True)
class InsurancePlan(DomainResource):
    coverage_area: Optional[List[Reference]] = field(default_factory=list)
    name: Optional[str] = None
    coverage: Optional[List[InsurancePlanCoverage]] = field(default_factory=list)
    type: Optional[List[CodeableConcept]] = field(default_factory=list)
    alias: Optional[List[str]] = field(default_factory=list)
    status: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    administered_by: Optional[Reference] = None
    owned_by: Optional[Reference] = None
    network: Optional[List[Reference]] = field(default_factory=list)
    period: Optional[Period] = None
    plan: Optional[List[InsurancePlanPlan]] = field(default_factory=list)
    endpoint: Optional[List[Reference]] = field(default_factory=list)
    contact: Optional[List[InsurancePlanContact]] = field(default_factory=list)