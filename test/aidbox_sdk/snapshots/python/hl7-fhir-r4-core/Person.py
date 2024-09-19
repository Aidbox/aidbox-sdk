from pydantic import *
from typing import Optional, List
from ..base import *

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