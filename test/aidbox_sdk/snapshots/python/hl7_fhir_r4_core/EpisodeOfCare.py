from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class EpisodeOfCareDiagnosis(BackboneElement):
    rank: Optional[int] = None
    role: Optional[CodeableConcept] = None
    condition: Reference

@dataclass(kw_only=True)
class EpisodeOfCareStatusHistory(BackboneElement):
    period: Period
    status: str

@dataclass(kw_only=True)
class EpisodeOfCare(DomainResource):
    patient: Reference
    diagnosis: Optional[List[EpisodeOfCareDiagnosis]] = field(default_factory=list)
    managing_organization: Optional[Reference] = None
    type: Optional[List[CodeableConcept]] = field(default_factory=list)
    account: Optional[List[Reference]] = field(default_factory=list)
    referral_request: Optional[List[Reference]] = field(default_factory=list)
    team: Optional[List[Reference]] = field(default_factory=list)
    status: str
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    period: Optional[Period] = None
    care_manager: Optional[Reference] = None
    status_history: Optional[List[EpisodeOfCareStatusHistory]] = field(default_factory=list)