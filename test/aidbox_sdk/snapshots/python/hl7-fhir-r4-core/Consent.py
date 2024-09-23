from typing import Optional, List
from pydantic import *
from ..base.Attachment import Attachment
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.Coding import Coding
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class Consent_Provision_Actor(BackboneElement):
    role: CodeableConcept
    reference: Reference

class Consent_Provision_Data(BackboneElement):
    meaning: str
    reference: Reference

class Consent_Provision(BackboneElement):
    provision: Optional[List[Reference]] = None
    purpose: Optional[List[Coding]] = None
    data_period: Optional[Period] = None
    type: Optional[str] = None
    class_: Optional[List[Coding]] = None
    code: Optional[List[CodeableConcept]] = None
    action: Optional[List[CodeableConcept]] = None
    period: Optional[Period] = None
    security_label: Optional[List[Coding]] = None
    actor: Optional[List[Consent_Provision_Actor]] = None
    data: Optional[List[Consent_Provision_Data]] = None

class Consent_Verification(BackboneElement):
    verified: bool
    verified_with: Optional[Reference] = None
    verification_date: Optional[str] = None

class Consent_Policy(BackboneElement):
    uri: Optional[str] = None
    authority: Optional[str] = None

class Consent(DomainResource):
    patient: Optional[Reference] = None
    category: list[CodeableConcept] = []
    provision: Optional[Consent_Provision] = None
    source_attachment: Optional[Attachment] = None
    organization: Optional[List[Reference]] = None
    verification: Optional[List[Consent_Verification]] = None
    scope: CodeableConcept
    policy: Optional[List[Consent_Policy]] = None
    source_reference: Optional[Reference] = None
    date_time: Optional[str] = None
    status: str
    policy_rule: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    performer: Optional[List[Reference]] = None