from typing import Optional, List
from pydantic import *
from ..base.Address import Address
from ..base.CodeableConcept import CodeableConcept
from ..base.ContactPoint import ContactPoint
from ..base.HumanName import HumanName
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

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