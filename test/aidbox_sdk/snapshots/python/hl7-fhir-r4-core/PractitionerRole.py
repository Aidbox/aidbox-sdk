from typing import Optional, List
from pydantic import *
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.ContactPoint import ContactPoint
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class PractitionerRole_AvailableTime(BackboneElement):
    all_day: Optional[bool] = None
    days_of_week: Optional[List[str]] = None
    available_end_time: Optional[str] = None
    available_start_time: Optional[str] = None

class PractitionerRole_NotAvailable(BackboneElement):
    during: Optional[Period] = None
    description: str

class PractitionerRole(DomainResource):
    available_time: Optional[List[PractitionerRole_AvailableTime]] = None
    specialty: Optional[List[CodeableConcept]] = None
    not_available: Optional[List[PractitionerRole_NotAvailable]] = None
    organization: Optional[Reference] = None
    active: Optional[bool] = None
    code: Optional[List[CodeableConcept]] = None
    identifier: Optional[List[Identifier]] = None
    availability_exceptions: Optional[str] = None
    practitioner: Optional[Reference] = None
    telecom: Optional[List[ContactPoint]] = None
    period: Optional[Period] = None
    location: Optional[List[Reference]] = None
    endpoint: Optional[List[Reference]] = None
    healthcare_service: Optional[List[Reference]] = None