from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import Signature
from base import Timing
from base import DomainResource
from base import Reference
from base import BackboneElement

@dataclass(kw_only=True)
class VerificationResultValidator(BackboneElement):
    organization: Reference
    identity_certificate: Optional[str] = None
    attestation_signature: Optional[Signature] = None

@dataclass(kw_only=True)
class VerificationResultPrimarySource(BackboneElement):
    who: Optional[Reference] = None
    type: Optional[List[CodeableConcept]] = field(default_factory=list)
    can_push_updates: Optional[CodeableConcept] = None
    validation_date: Optional[str] = None
    validation_status: Optional[CodeableConcept] = None
    push_type_available: Optional[List[CodeableConcept]] = field(default_factory=list)
    communication_method: Optional[List[CodeableConcept]] = field(default_factory=list)

@dataclass(kw_only=True)
class VerificationResultAttestation(BackboneElement):
    who: Optional[Reference] = None
    date: Optional[str] = None
    on_behalf_of: Optional[Reference] = None
    proxy_signature: Optional[Signature] = None
    source_signature: Optional[Signature] = None
    communication_method: Optional[CodeableConcept] = None
    proxy_identity_certificate: Optional[str] = None
    source_identity_certificate: Optional[str] = None

@dataclass(kw_only=True)
class VerificationResult(DomainResource):
    failure_action: Optional[CodeableConcept] = None
    validation_type: Optional[CodeableConcept] = None
    target_location: Optional[List[str]] = field(default_factory=list)
    validator: Optional[List[VerificationResultValidator]] = field(default_factory=list)
    need: Optional[CodeableConcept] = None
    frequency: Optional[Timing] = None
    next_scheduled: Optional[str] = None
    primary_source: Optional[List[VerificationResultPrimarySource]] = field(default_factory=list)
    attestation: Optional[VerificationResultAttestation] = None
    status: str
    validation_process: Optional[List[CodeableConcept]] = field(default_factory=list)
    status_date: Optional[str] = None
    target: Optional[List[Reference]] = field(default_factory=list)
    last_performed: Optional[str] = None