from typing import Optional, List
from base import Address
from base import Attachment
from base import ContactPoint
from base import HumanName
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

class Person_Link(BackboneElement):
    target: Reference
    assurance: Optional[str] = None

class Person(DomainResource):
    address: Optional[List[Address]] = None
    managing_organization: Optional[Reference] = None
    name: Optional[List[HumanName]] = None
    birth_date: Optional[str] = None
    photo: Optional[Attachment] = None
    link: Optional[List[Person_Link]] = None
    active: Optional[bool] = None
    identifier: Optional[List[Identifier]] = None
    telecom: Optional[List[ContactPoint]] = None
    gender: Optional[str] = None