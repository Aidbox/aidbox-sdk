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
class PatientLink(BackboneElement):
    type: str
    other: Reference

@dataclass(kw_only=True)
class PatientCommunication(BackboneElement):
    language: CodeableConcept
    preferred: Optional[bool] = None

@dataclass(kw_only=True)
class PatientContact(BackboneElement):
    name: Optional[HumanName] = None
    gender: Optional[str] = None
    period: Optional[Period] = None
    address: Optional[Address] = None
    telecom: Optional[List[ContactPoint]] = field(default_factory=list)
    organization: Optional[Reference] = None
    relationship: Optional[List[CodeableConcept]] = field(default_factory=list)

@dataclass(kw_only=True)
class Patient(DomainResource):
    multiple_birth_boolean: Optional[bool] = None
    address: Optional[List[Address]] = field(default_factory=list)
    deceased_date_time: Optional[str] = None
    managing_organization: Optional[Reference] = None
    deceased_boolean: Optional[bool] = None
    name: Optional[List[HumanName]] = field(default_factory=list)
    birth_date: Optional[str] = None
    multiple_birth_integer: Optional[int] = None
    photo: Optional[List[Attachment]] = field(default_factory=list)
    link: Optional[List[PatientLink]] = field(default_factory=list)
    active: Optional[bool] = None
    communication: Optional[List[PatientCommunication]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    telecom: Optional[List[ContactPoint]] = field(default_factory=list)
    general_practitioner: Optional[List[Reference]] = field(default_factory=list)
    gender: Optional[str] = None
    marital_status: Optional[CodeableConcept] = None
    contact: Optional[List[PatientContact]] = field(default_factory=list)