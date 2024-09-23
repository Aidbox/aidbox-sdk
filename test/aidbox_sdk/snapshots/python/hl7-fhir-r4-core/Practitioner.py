from typing import Optional, List
from pydantic import *
from ..base import *

class Practitioner_Qualification(BackboneElement):
    code: CodeableConcept
    issuer: Optional[Reference] = None
    period: Optional[Period] = None
    identifier: Optional[List[Identifier]] = None

class Practitioner(DomainResource):
    address: Optional[List[Address]] = None
    name: Optional[List[HumanName]] = None
    birth_date: Optional[str] = None
    photo: Optional[List[Attachment]] = None
    active: Optional[bool] = None
    communication: Optional[List[CodeableConcept]] = None
    identifier: Optional[List[Identifier]] = None
    qualification: Optional[List[Practitioner_Qualification]] = None
    telecom: Optional[List[ContactPoint]] = None
    gender: Optional[str] = None