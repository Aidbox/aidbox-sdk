from typing import Optional, List
from pydantic import *
from base.Period import Period
from base.CodeableConcept import CodeableConcept
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier

class Schedule(DomainResource):
    actor: list[Reference] = []
    active: Optional[bool] = None
    comment: Optional[str] = None
    specialty: Optional[List[CodeableConcept]] = None
    identifier: Optional[List[Identifier]] = None
    service_type: Optional[List[CodeableConcept]] = None
    planning_horizon: Optional[Period] = None
    service_category: Optional[List[CodeableConcept]] = None