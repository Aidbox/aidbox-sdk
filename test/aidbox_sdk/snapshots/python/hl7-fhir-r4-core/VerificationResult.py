from typing import Optional, List
from base import CodeableConcept
from base import Signature
from base import Timing
from base import DomainResource
from base import Reference
from base import BackboneElement

class VerificationResult_Validator(BackboneElement):
    organization: Reference
    identity_certificate: Optional[str] = None
    attestation_signature: Optional[Signature] = None

class VerificationResult_PrimarySource(BackboneElement):
    who: Optional[Reference] = None
    type: Optional[List[CodeableConcept]] = None
    can_push_updates: Optional[CodeableConcept] = None
    validation_date: Optional[str] = None
    validation_status: Optional[CodeableConcept] = None
    push_type_available: Optional[List[CodeableConcept]] = None
    communication_method: Optional[List[CodeableConcept]] = None

class VerificationResult_Attestation(BackboneElement):
    who: Optional[Reference] = None
    date: Optional[str] = None
    on_behalf_of: Optional[Reference] = None
    proxy_signature: Optional[Signature] = None
    source_signature: Optional[Signature] = None
    communication_method: Optional[CodeableConcept] = None
    proxy_identity_certificate: Optional[str] = None
    source_identity_certificate: Optional[str] = None

class VerificationResult(DomainResource):
    failure_action: Optional[CodeableConcept] = None
    validation_type: Optional[CodeableConcept] = None
    target_location: Optional[List[str]] = None
    validator: Optional[List[VerificationResult_Validator]] = None
    need: Optional[CodeableConcept] = None
    frequency: Optional[Timing] = None
    next_scheduled: Optional[str] = None
    primary_source: Optional[List[VerificationResult_PrimarySource]] = None
    attestation: Optional[VerificationResult_Attestation] = None
    status: str
    validation_process: Optional[List[CodeableConcept]] = None
    status_date: Optional[str] = None
    target: Optional[List[Reference]] = None
    last_performed: Optional[str] = None