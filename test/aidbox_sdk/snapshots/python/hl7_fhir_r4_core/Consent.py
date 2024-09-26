from typing import Optional, List
from dataclasses import dataclass, field
from base import Attachment
from base import Period
from base import CodeableConcept
from base import Coding
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ConsentProvisionActor(BackboneElement):
    role: CodeableConcept
    reference: Reference

@dataclass(kw_only=True)
class ConsentProvisionData(BackboneElement):
    meaning: str
    reference: Reference

@dataclass(kw_only=True)
class ConsentProvision(BackboneElement):
    provision: Optional[List[Reference]] = field(default_factory=list)
    purpose: Optional[List[Coding]] = field(default_factory=list)
    data_period: Optional[Period] = None
    type: Optional[str] = None
    class_: Optional[List[Coding]] = field(default_factory=list)
    code: Optional[List[CodeableConcept]] = field(default_factory=list)
    action: Optional[List[CodeableConcept]] = field(default_factory=list)
    period: Optional[Period] = None
    security_label: Optional[List[Coding]] = field(default_factory=list)
    actor: Optional[List[ConsentProvisionActor]] = field(default_factory=list)
    data: Optional[List[ConsentProvisionData]] = field(default_factory=list)

@dataclass(kw_only=True)
class ConsentVerification(BackboneElement):
    verified: bool
    verified_with: Optional[Reference] = None
    verification_date: Optional[str] = None

@dataclass(kw_only=True)
class ConsentPolicy(BackboneElement):
    uri: Optional[str] = None
    authority: Optional[str] = None

@dataclass(kw_only=True)
class Consent(DomainResource):
    patient: Optional[Reference] = None
    category: list[CodeableConcept] = field(default_factory=list)
    provision: Optional[ConsentProvision] = None
    source_attachment: Optional[Attachment] = None
    organization: Optional[List[Reference]] = field(default_factory=list)
    verification: Optional[List[ConsentVerification]] = field(default_factory=list)
    scope: CodeableConcept
    policy: Optional[List[ConsentPolicy]] = field(default_factory=list)
    source_reference: Optional[Reference] = None
    date_time: Optional[str] = None
    status: str
    policy_rule: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    performer: Optional[List[Reference]] = field(default_factory=list)