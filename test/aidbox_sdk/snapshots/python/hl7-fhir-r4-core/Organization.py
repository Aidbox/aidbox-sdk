from typing import Optional, List
from base import Address
from base import CodeableConcept
from base import ContactPoint
from base import HumanName
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

class Organization_Contact(BackboneElement):
    name: Optional[HumanName] = None
    address: Optional[Address] = None
    purpose: Optional[CodeableConcept] = None
    telecom: Optional[List[ContactPoint]] = None

class Organization(DomainResource):
    address: Optional[List[Address]] = None
    name: Optional[str] = None
    type: Optional[List[CodeableConcept]] = None
    alias: Optional[List[str]] = None
    active: Optional[bool] = None
    identifier: Optional[List[Identifier]] = None
    telecom: Optional[List[ContactPoint]] = None
    part_of: Optional[Reference] = None
    endpoint: Optional[List[Reference]] = None
    contact: Optional[List[Organization_Contact]] = None