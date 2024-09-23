from typing import Optional, List
from pydantic import *
from ..base import *

class EpisodeOfCare_Diagnosis(BackboneElement):
    rank: Optional[int] = None
    role: Optional[CodeableConcept] = None
    condition: Reference

class EpisodeOfCare_StatusHistory(BackboneElement):
    period: Period
    status: str

class EpisodeOfCare(DomainResource):
    patient: Reference
    diagnosis: Optional[List[EpisodeOfCare_Diagnosis]] = None
    managing_organization: Optional[Reference] = None
    type: Optional[List[CodeableConcept]] = None
    account: Optional[List[Reference]] = None
    referral_request: Optional[List[Reference]] = None
    team: Optional[List[Reference]] = None
    status: str
    identifier: Optional[List[Identifier]] = None
    period: Optional[Period] = None
    care_manager: Optional[Reference] = None
    status_history: Optional[List[EpisodeOfCare_StatusHistory]] = None