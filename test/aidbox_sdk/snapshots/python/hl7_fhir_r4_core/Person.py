from typing import Optional, List
from dataclasses import dataclass, field
from base import Address
from base import Attachment
from base import ContactPoint
from base import HumanName
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class PersonLink(BackboneElement):
    target: Reference
    assurance: Optional[str] = None

@dataclass(kw_only=True)
class Person(DomainResource):
    address: Optional[List[Address]] = field(default_factory=list)
    managing_organization: Optional[Reference] = None
    name: Optional[List[HumanName]] = field(default_factory=list)
    birth_date: Optional[str] = None
    photo: Optional[Attachment] = None
    link: Optional[List[PersonLink]] = field(default_factory=list)
    active: Optional[bool] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    telecom: Optional[List[ContactPoint]] = field(default_factory=list)
    gender: Optional[str] = None