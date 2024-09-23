from typing import Optional, List
from pydantic import *
from ..base import *

class ChargeItemDefinition_PropertyGroup_PriceComponent(BackboneElement):
    code: Optional[CodeableConcept] = None
    type: str
    amount: Optional[Money] = None
    factor: Optional[float] = None

class ChargeItemDefinition_PropertyGroup(BackboneElement):
    applicability: Optional[List[Reference]] = None
    price_component: Optional[List[ChargeItemDefinition_PropertyGroup_PriceComponent]] = None

class ChargeItemDefinition_Applicability(BackboneElement):
    language: Optional[str] = None
    expression: Optional[str] = None
    description: Optional[str] = None

class ChargeItemDefinition(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    property_group: Optional[List[ChargeItemDefinition_PropertyGroup]] = None
    instance: Optional[List[Reference]] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    title: Optional[str] = None
    derived_from_uri: Optional[List[str]] = None
    status: str
    url: str
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    last_review_date: Optional[str] = None
    replaces: Optional[List[str]] = None
    part_of: Optional[List[str]] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = None
    applicability: Optional[List[ChargeItemDefinition_Applicability]] = None
    effective_period: Optional[Period] = None