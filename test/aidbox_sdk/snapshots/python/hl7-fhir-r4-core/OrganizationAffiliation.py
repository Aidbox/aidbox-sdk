from typing import Optional, List
from pydantic import *
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.ContactPoint import ContactPoint
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier

class OrganizationAffiliation(DomainResource):
    specialty: Optional[List[CodeableConcept]] = None
    organization: Optional[Reference] = None
    participating_organization: Optional[Reference] = None
    active: Optional[bool] = None
    code: Optional[List[CodeableConcept]] = None
    identifier: Optional[List[Identifier]] = None
    telecom: Optional[List[ContactPoint]] = None
    network: Optional[List[Reference]] = None
    period: Optional[Period] = None
    location: Optional[List[Reference]] = None
    endpoint: Optional[List[Reference]] = None
    healthcare_service: Optional[List[Reference]] = None