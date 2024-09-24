from typing import Optional, List
from base import Period
from base import CodeableConcept
from base import Quantity
from base import DomainResource
from base import Money
from base import Reference
from base import Identifier
from base import BackboneElement

class Coverage_CostToBeneficiary_Exception(BackboneElement):
    type: CodeableConcept
    period: Optional[Period] = None

class Coverage_CostToBeneficiary(BackboneElement):
    type: Optional[CodeableConcept] = None
    exception: Optional[List[Coverage_CostToBeneficiary_Exception]] = None
    value_money: Optional[Money] = None
    value_quantity: Optional[Quantity] = None

class Coverage_Class(BackboneElement):
    name: Optional[str] = None
    type: CodeableConcept
    value: str

class Coverage(DomainResource):
    policy_holder: Optional[Reference] = None
    beneficiary: Reference
    contract: Optional[List[Reference]] = None
    relationship: Optional[CodeableConcept] = None
    type: Optional[CodeableConcept] = None
    cost_to_beneficiary: Optional[List[Coverage_CostToBeneficiary]] = None
    subrogation: Optional[bool] = None
    subscriber: Optional[Reference] = None
    payor: list[Reference] = []
    status: str
    class_: Optional[List[Coverage_Class]] = None
    identifier: Optional[List[Identifier]] = None
    order: Optional[int] = None
    network: Optional[str] = None
    period: Optional[Period] = None
    dependent: Optional[str] = None
    subscriber_id: Optional[str] = None