from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import ContactPoint
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class PractitionerRoleAvailableTime(BackboneElement):
    all_day: Optional[bool] = None
    days_of_week: Optional[List[str]] = field(default_factory=list)
    available_end_time: Optional[str] = None
    available_start_time: Optional[str] = None

@dataclass(kw_only=True)
class PractitionerRoleNotAvailable(BackboneElement):
    during: Optional[Period] = None
    description: str

@dataclass(kw_only=True)
class PractitionerRole(DomainResource):
    available_time: Optional[List[PractitionerRoleAvailableTime]] = field(default_factory=list)
    specialty: Optional[List[CodeableConcept]] = field(default_factory=list)
    not_available: Optional[List[PractitionerRoleNotAvailable]] = field(default_factory=list)
    organization: Optional[Reference] = None
    active: Optional[bool] = None
    code: Optional[List[CodeableConcept]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    availability_exceptions: Optional[str] = None
    practitioner: Optional[Reference] = None
    telecom: Optional[List[ContactPoint]] = field(default_factory=list)
    period: Optional[Period] = None
    location: Optional[List[Reference]] = field(default_factory=list)
    endpoint: Optional[List[Reference]] = field(default_factory=list)
    healthcare_service: Optional[List[Reference]] = field(default_factory=list)