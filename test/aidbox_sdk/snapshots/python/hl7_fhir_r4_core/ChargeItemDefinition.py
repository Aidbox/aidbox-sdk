from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import Period
from base import ContactDetail
from base import CodeableConcept
from base import DomainResource
from base import Money
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ChargeItemDefinitionPropertyGroupPriceComponent(BackboneElement):
    code: Optional[CodeableConcept] = None
    type: str
    amount: Optional[Money] = None
    factor: Optional[float] = None

@dataclass(kw_only=True)
class ChargeItemDefinitionPropertyGroup(BackboneElement):
    applicability: Optional[List[Reference]] = field(default_factory=list)
    price_component: Optional[List[ChargeItemDefinitionPropertyGroupPriceComponent]] = field(default_factory=list)

@dataclass(kw_only=True)
class ChargeItemDefinitionApplicability(BackboneElement):
    language: Optional[str] = None
    expression: Optional[str] = None
    description: Optional[str] = None

@dataclass(kw_only=True)
class ChargeItemDefinition(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    property_group: Optional[List[ChargeItemDefinitionPropertyGroup]] = field(default_factory=list)
    instance: Optional[List[Reference]] = field(default_factory=list)
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    title: Optional[str] = None
    derived_from_uri: Optional[List[str]] = field(default_factory=list)
    status: str
    url: str
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    last_review_date: Optional[str] = None
    replaces: Optional[List[str]] = field(default_factory=list)
    part_of: Optional[List[str]] = field(default_factory=list)
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    applicability: Optional[List[ChargeItemDefinitionApplicability]] = field(default_factory=list)
    effective_period: Optional[Period] = None