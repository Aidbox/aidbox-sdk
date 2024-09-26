from typing import Optional, List
from dataclasses import dataclass, field
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

@dataclass(kw_only=True)
class PractitionerQualification(BackboneElement):
    code: CodeableConcept
    issuer: Optional[Reference] = None
    period: Optional[Period] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)

@dataclass(kw_only=True)
class Practitioner(DomainResource):
    address: Optional[List[Address]] = field(default_factory=list)
    name: Optional[List[HumanName]] = field(default_factory=list)
    birth_date: Optional[str] = None
    photo: Optional[List[Attachment]] = field(default_factory=list)
    active: Optional[bool] = None
    communication: Optional[List[CodeableConcept]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    qualification: Optional[List[PractitionerQualification]] = field(default_factory=list)
    telecom: Optional[List[ContactPoint]] = field(default_factory=list)
    gender: Optional[str] = None