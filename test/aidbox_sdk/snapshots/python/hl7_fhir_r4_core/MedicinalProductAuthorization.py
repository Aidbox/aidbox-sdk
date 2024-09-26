from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class MedicinalProductAuthorizationJurisdictionalAuthorization(BackboneElement):
    country: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    validity_period: Optional[Period] = None
    legal_status_of_supply: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class MedicinalProductAuthorizationProcedure(BackboneElement):
    type: CodeableConcept
    date_period: Optional[Period] = None
    identifier: Optional[Identifier] = None
    application: Optional[List[Reference]] = field(default_factory=list)
    date_date_time: Optional[str] = None

@dataclass(kw_only=True)
class MedicinalProductAuthorization(DomainResource):
    data_exclusivity_period: Optional[Period] = None
    restore_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    jurisdictional_authorization: Optional[List[MedicinalProductAuthorizationJurisdictionalAuthorization]] = field(default_factory=list)
    procedure: Optional[MedicinalProductAuthorizationProcedure] = None
    legal_basis: Optional[CodeableConcept] = None
    validity_period: Optional[Period] = None
    regulator: Optional[Reference] = None
    status: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    status_date: Optional[str] = None
    date_of_first_authorization: Optional[str] = None
    international_birth_date: Optional[str] = None
    holder: Optional[Reference] = None
    country: Optional[List[CodeableConcept]] = field(default_factory=list)
    subject: Optional[Reference] = None