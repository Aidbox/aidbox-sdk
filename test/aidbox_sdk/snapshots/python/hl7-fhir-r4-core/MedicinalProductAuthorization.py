from typing import Optional, List
from pydantic import *
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class MedicinalProductAuthorization_JurisdictionalAuthorization(BackboneElement):
    country: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    validity_period: Optional[Period] = None
    legal_status_of_supply: Optional[CodeableConcept] = None

class MedicinalProductAuthorization_Procedure(BackboneElement):
    type: CodeableConcept
    date_period: Optional[Period] = None
    identifier: Optional[Identifier] = None
    application: Optional[List[Reference]] = None
    date_date_time: Optional[str] = None

class MedicinalProductAuthorization(DomainResource):
    data_exclusivity_period: Optional[Period] = None
    restore_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    jurisdictional_authorization: Optional[List[MedicinalProductAuthorization_JurisdictionalAuthorization]] = None
    procedure: Optional[MedicinalProductAuthorization_Procedure] = None
    legal_basis: Optional[CodeableConcept] = None
    validity_period: Optional[Period] = None
    regulator: Optional[Reference] = None
    status: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    status_date: Optional[str] = None
    date_of_first_authorization: Optional[str] = None
    international_birth_date: Optional[str] = None
    holder: Optional[Reference] = None
    country: Optional[List[CodeableConcept]] = None
    subject: Optional[Reference] = None