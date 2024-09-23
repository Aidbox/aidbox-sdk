from typing import Optional, List
from pydantic import *
from ..base.Annotation import Annotation
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.ContactPoint import ContactPoint
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class CareTeam_Participant(BackboneElement):
    role: Optional[List[CodeableConcept]] = None
    member: Optional[Reference] = None
    period: Optional[Period] = None
    on_behalf_of: Optional[Reference] = None

class CareTeam(DomainResource):
    category: Optional[List[CodeableConcept]] = None
    managing_organization: Optional[List[Reference]] = None
    encounter: Optional[Reference] = None
    name: Optional[str] = None
    reason_code: Optional[List[CodeableConcept]] = None
    participant: Optional[List[CareTeam_Participant]] = None
    note: Optional[List[Annotation]] = None
    status: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    telecom: Optional[List[ContactPoint]] = None
    period: Optional[Period] = None
    subject: Optional[Reference] = None
    reason_reference: Optional[List[Reference]] = None