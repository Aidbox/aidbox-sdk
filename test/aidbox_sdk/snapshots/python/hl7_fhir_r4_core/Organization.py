from typing import Optional, List
from dataclasses import dataclass, field
from base import Address
from base import CodeableConcept
from base import ContactPoint
from base import HumanName
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class OrganizationContact(BackboneElement):
    name: Optional[HumanName] = None
    address: Optional[Address] = None
    purpose: Optional[CodeableConcept] = None
    telecom: Optional[List[ContactPoint]] = field(default_factory=list)

@dataclass(kw_only=True)
class Organization(DomainResource):
    address: Optional[List[Address]] = field(default_factory=list)
    name: Optional[str] = None
    type: Optional[List[CodeableConcept]] = field(default_factory=list)
    alias: Optional[List[str]] = field(default_factory=list)
    active: Optional[bool] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    telecom: Optional[List[ContactPoint]] = field(default_factory=list)
    part_of: Optional[Reference] = None
    endpoint: Optional[List[Reference]] = field(default_factory=list)
    contact: Optional[List[OrganizationContact]] = field(default_factory=list)