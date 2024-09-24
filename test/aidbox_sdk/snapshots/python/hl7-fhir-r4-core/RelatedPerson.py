from typing import Optional, List
from base import Address
from base import Attachment
from base import Period
from base import CodeableConcept
from base import ContactPoint
from base import HumanName
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

class RelatedPerson_Communication(BackboneElement):
    language: CodeableConcept
    preferred: Optional[bool] = None

class RelatedPerson(DomainResource):
    patient: Reference
    address: Optional[List[Address]] = None
    name: Optional[List[HumanName]] = None
    birth_date: Optional[str] = None
    relationship: Optional[List[CodeableConcept]] = None
    photo: Optional[List[Attachment]] = None
    active: Optional[bool] = None
    communication: Optional[List[RelatedPerson_Communication]] = None
    identifier: Optional[List[Identifier]] = None
    telecom: Optional[List[ContactPoint]] = None
    gender: Optional[str] = None
    period: Optional[Period] = None