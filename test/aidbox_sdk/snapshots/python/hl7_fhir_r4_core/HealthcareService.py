from typing import Optional, List
from dataclasses import dataclass, field
from base import Attachment
from base import Period
from base import CodeableConcept
from base import ContactPoint
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class HealthcareServiceAvailableTime(BackboneElement):
    all_day: Optional[bool] = None
    days_of_week: Optional[List[str]] = field(default_factory=list)
    available_end_time: Optional[str] = None
    available_start_time: Optional[str] = None

@dataclass(kw_only=True)
class HealthcareServiceNotAvailable(BackboneElement):
    during: Optional[Period] = None
    description: str

@dataclass(kw_only=True)
class HealthcareServiceEligibility(BackboneElement):
    code: Optional[CodeableConcept] = None
    comment: Optional[str] = None

@dataclass(kw_only=True)
class HealthcareService(DomainResource):
    coverage_area: Optional[List[Reference]] = field(default_factory=list)
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    available_time: Optional[List[HealthcareServiceAvailableTime]] = field(default_factory=list)
    specialty: Optional[List[CodeableConcept]] = field(default_factory=list)
    name: Optional[str] = None
    not_available: Optional[List[HealthcareServiceNotAvailable]] = field(default_factory=list)
    provided_by: Optional[Reference] = None
    type: Optional[List[CodeableConcept]] = field(default_factory=list)
    eligibility: Optional[List[HealthcareServiceEligibility]] = field(default_factory=list)
    extra_details: Optional[str] = None
    characteristic: Optional[List[CodeableConcept]] = field(default_factory=list)
    photo: Optional[Attachment] = None
    active: Optional[bool] = None
    communication: Optional[List[CodeableConcept]] = field(default_factory=list)
    comment: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    service_provision_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    availability_exceptions: Optional[str] = None
    appointment_required: Optional[bool] = None
    referral_method: Optional[List[CodeableConcept]] = field(default_factory=list)
    telecom: Optional[List[ContactPoint]] = field(default_factory=list)
    location: Optional[List[Reference]] = field(default_factory=list)
    program: Optional[List[CodeableConcept]] = field(default_factory=list)
    endpoint: Optional[List[Reference]] = field(default_factory=list)