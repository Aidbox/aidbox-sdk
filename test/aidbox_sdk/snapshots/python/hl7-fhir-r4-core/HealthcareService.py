from pydantic import *
from typing import Optional, List
from ..base import *

class HealthcareService_AvailableTime(BackboneElement):
    all_day: Optional[bool] = None
    days_of_week: Optional[List[str]] = None
    available_end_time: Optional[str] = None
    available_start_time: Optional[str] = None

class HealthcareService_NotAvailable(BackboneElement):
    during: Optional[Period] = None
    description: str

class HealthcareService_Eligibility(BackboneElement):
    code: Optional[CodeableConcept] = None
    comment: Optional[str] = None

class HealthcareService(DomainResource):
    coverage_area: Optional[List[Reference]] = None
    category: Optional[List[CodeableConcept]] = None
    available_time: Optional[List[HealthcareService_AvailableTime]] = None
    specialty: Optional[List[CodeableConcept]] = None
    name: Optional[str] = None
    not_available: Optional[List[HealthcareService_NotAvailable]] = None
    provided_by: Optional[Reference] = None
    type: Optional[List[CodeableConcept]] = None
    eligibility: Optional[List[HealthcareService_Eligibility]] = None
    extra_details: Optional[str] = None
    characteristic: Optional[List[CodeableConcept]] = None
    photo: Optional[Attachment] = None
    active: Optional[bool] = None
    communication: Optional[List[CodeableConcept]] = None
    comment: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    service_provision_code: Optional[List[CodeableConcept]] = None
    availability_exceptions: Optional[str] = None
    appointment_required: Optional[bool] = None
    referral_method: Optional[List[CodeableConcept]] = None
    telecom: Optional[List[ContactPoint]] = None
    location: Optional[List[Reference]] = None
    program: Optional[List[CodeableConcept]] = None
    endpoint: Optional[List[Reference]] = None