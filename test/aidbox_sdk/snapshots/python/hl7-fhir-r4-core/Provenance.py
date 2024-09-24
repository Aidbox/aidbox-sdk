from typing import Optional, List
from base import Period
from base import CodeableConcept
from base import Signature
from base import DomainResource
from base import Reference
from base import BackboneElement

class Provenance_Agent(BackboneElement):
    who: Reference
    role: Optional[List[CodeableConcept]] = None
    type: Optional[CodeableConcept] = None
    on_behalf_of: Optional[Reference] = None

class Provenance_Entity(BackboneElement):
    role: str
    what: Reference
    agent: Optional[List[Reference]] = None

class Provenance(DomainResource):
    signature: Optional[List[Signature]] = None
    occurred_date_time: Optional[str] = None
    recorded: str
    agent: list[Provenance_Agent] = []
    policy: Optional[List[str]] = None
    reason: Optional[List[CodeableConcept]] = None
    activity: Optional[CodeableConcept] = None
    target: list[Reference] = []
    location: Optional[Reference] = None
    entity: Optional[List[Provenance_Entity]] = None
    occurred_period: Optional[Period] = None