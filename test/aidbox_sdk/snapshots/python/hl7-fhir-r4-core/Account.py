from typing import Optional, List
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

class Account_Coverage(BackboneElement):
    coverage: Reference
    priority: Optional[int] = None

class Account_Guarantor(BackboneElement):
    party: Reference
    on_hold: Optional[bool] = None
    period: Optional[Period] = None

class Account(DomainResource):
    description: Optional[str] = None
    name: Optional[str] = None
    service_period: Optional[Period] = None
    coverage: Optional[List[Account_Coverage]] = None
    type: Optional[CodeableConcept] = None
    guarantor: Optional[List[Account_Guarantor]] = None
    status: str
    identifier: Optional[List[Identifier]] = None
    part_of: Optional[Reference] = None
    subject: Optional[List[Reference]] = None
    owner: Optional[Reference] = None