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

class Patient_Link(BackboneElement):
    type: str
    other: Reference

class Patient_Communication(BackboneElement):
    language: CodeableConcept
    preferred: Optional[bool] = None

class Patient_Contact(BackboneElement):
    name: Optional[HumanName] = None
    gender: Optional[str] = None
    period: Optional[Period] = None
    address: Optional[Address] = None
    telecom: Optional[List[ContactPoint]] = None
    organization: Optional[Reference] = None
    relationship: Optional[List[CodeableConcept]] = None

class Patient(DomainResource):
    multiple_birth_boolean: Optional[bool] = None
    address: Optional[List[Address]] = None
    deceased_date_time: Optional[str] = None
    managing_organization: Optional[Reference] = None
    deceased_boolean: Optional[bool] = None
    name: Optional[List[HumanName]] = None
    birth_date: Optional[str] = None
    multiple_birth_integer: Optional[int] = None
    photo: Optional[List[Attachment]] = None
    link: Optional[List[Patient_Link]] = None
    active: Optional[bool] = None
    communication: Optional[List[Patient_Communication]] = None
    identifier: Optional[List[Identifier]] = None
    telecom: Optional[List[ContactPoint]] = None
    general_practitioner: Optional[List[Reference]] = None
    gender: Optional[str] = None
    marital_status: Optional[CodeableConcept] = None
    contact: Optional[List[Patient_Contact]] = None