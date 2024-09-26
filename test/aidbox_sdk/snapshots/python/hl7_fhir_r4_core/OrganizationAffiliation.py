from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import ContactPoint
from base import DomainResource
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class OrganizationAffiliation(DomainResource):
    specialty: Optional[List[CodeableConcept]] = field(default_factory=list)
    organization: Optional[Reference] = None
    participating_organization: Optional[Reference] = None
    active: Optional[bool] = None
    code: Optional[List[CodeableConcept]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    telecom: Optional[List[ContactPoint]] = field(default_factory=list)
    network: Optional[List[Reference]] = field(default_factory=list)
    period: Optional[Period] = None
    location: Optional[List[Reference]] = field(default_factory=list)
    endpoint: Optional[List[Reference]] = field(default_factory=list)
    healthcare_service: Optional[List[Reference]] = field(default_factory=list)