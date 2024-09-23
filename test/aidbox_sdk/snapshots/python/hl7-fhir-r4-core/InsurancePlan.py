from typing import Optional, List
from pydantic import *
from ..base.Address import Address
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.ContactPoint import ContactPoint
from ..base.Quantity import Quantity
from ..base.HumanName import HumanName
from ..base.DomainResource import DomainResource
from ..base.Money import Money
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class InsurancePlan_Coverage_Benefit_Limit(BackboneElement):
    code: Optional[CodeableConcept] = None
    value: Optional[Quantity] = None

class InsurancePlan_Coverage_Benefit(BackboneElement):
    type: CodeableConcept
    limit: Optional[List[InsurancePlan_Coverage_Benefit_Limit]] = None
    requirement: Optional[str] = None

class InsurancePlan_Coverage(BackboneElement):
    type: CodeableConcept
    benefit: list[InsurancePlan_Coverage_Benefit] = []
    network: Optional[List[Reference]] = None

class InsurancePlan_Plan_GeneralCost(BackboneElement):
    cost: Optional[Money] = None
    type: Optional[CodeableConcept] = None
    comment: Optional[str] = None
    group_size: Optional[int] = None

class InsurancePlan_Plan_SpecificCost_Benefit_Cost(BackboneElement):
    type: CodeableConcept
    value: Optional[Quantity] = None
    qualifiers: Optional[List[CodeableConcept]] = None
    applicability: Optional[CodeableConcept] = None

class InsurancePlan_Plan_SpecificCost_Benefit(BackboneElement):
    cost: Optional[List[InsurancePlan_Plan_SpecificCost_Benefit_Cost]] = None
    type: CodeableConcept

class InsurancePlan_Plan_SpecificCost(BackboneElement):
    benefit: Optional[List[InsurancePlan_Plan_SpecificCost_Benefit]] = None
    category: CodeableConcept

class InsurancePlan_Plan(BackboneElement):
    type: Optional[CodeableConcept] = None
    network: Optional[List[Reference]] = None
    identifier: Optional[List[Identifier]] = None
    general_cost: Optional[List[InsurancePlan_Plan_GeneralCost]] = None
    coverage_area: Optional[List[Reference]] = None
    specific_cost: Optional[List[InsurancePlan_Plan_SpecificCost]] = None

class InsurancePlan_Contact(BackboneElement):
    name: Optional[HumanName] = None
    address: Optional[Address] = None
    purpose: Optional[CodeableConcept] = None
    telecom: Optional[List[ContactPoint]] = None

class InsurancePlan(DomainResource):
    coverage_area: Optional[List[Reference]] = None
    name: Optional[str] = None
    coverage: Optional[List[InsurancePlan_Coverage]] = None
    type: Optional[List[CodeableConcept]] = None
    alias: Optional[List[str]] = None
    status: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    administered_by: Optional[Reference] = None
    owned_by: Optional[Reference] = None
    network: Optional[List[Reference]] = None
    period: Optional[Period] = None
    plan: Optional[List[InsurancePlan_Plan]] = None
    endpoint: Optional[List[Reference]] = None
    contact: Optional[List[InsurancePlan_Contact]] = None