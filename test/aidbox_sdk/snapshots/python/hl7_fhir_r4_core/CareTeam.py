from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Period
from base import CodeableConcept
from base import ContactPoint
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class CareTeamParticipant(BackboneElement):
    role: Optional[List[CodeableConcept]] = field(default_factory=list)
    member: Optional[Reference] = None
    period: Optional[Period] = None
    on_behalf_of: Optional[Reference] = None

@dataclass(kw_only=True)
class CareTeam(DomainResource):
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    managing_organization: Optional[List[Reference]] = field(default_factory=list)
    encounter: Optional[Reference] = None
    name: Optional[str] = None
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    participant: Optional[List[CareTeamParticipant]] = field(default_factory=list)
    note: Optional[List[Annotation]] = field(default_factory=list)
    status: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    telecom: Optional[List[ContactPoint]] = field(default_factory=list)
    period: Optional[Period] = None
    subject: Optional[Reference] = None
    reason_reference: Optional[List[Reference]] = field(default_factory=list)