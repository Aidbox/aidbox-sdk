from typing import Optional, List
from pydantic import *
from base.UsageContext import UsageContext
from base.Period import Period
from base.ContactDetail import ContactDetail
from base.CodeableConcept import CodeableConcept
from base.DomainResource import DomainResource
from base.BackboneElement import BackboneElement

class NamingSystem_UniqueId(BackboneElement):
    type: str
    value: str
    period: Optional[Period] = None
    comment: Optional[str] = None
    preferred: Optional[bool] = None

class NamingSystem(DomainResource):
    description: Optional[str] = None
    date: str
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    name: str
    use_context: Optional[List[UsageContext]] = None
    type: Optional[CodeableConcept] = None
    responsible: Optional[str] = None
    usage: Optional[str] = None
    status: str
    kind: str
    unique_id: list[NamingSystem_UniqueId] = []
    contact: Optional[List[ContactDetail]] = None