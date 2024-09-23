from typing import Optional, List
from pydantic import *
from base.Address import Address
from base.Attachment import Attachment
from base.Period import Period
from base.CodeableConcept import CodeableConcept
from base.ContactPoint import ContactPoint
from base.HumanName import HumanName
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier
from base.BackboneElement import BackboneElement

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