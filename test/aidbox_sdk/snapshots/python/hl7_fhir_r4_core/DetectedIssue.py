from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class DetectedIssueEvidence(BackboneElement):
    code: Optional[List[CodeableConcept]] = field(default_factory=list)
    detail: Optional[List[Reference]] = field(default_factory=list)

@dataclass(kw_only=True)
class DetectedIssueMitigation(BackboneElement):
    date: Optional[str] = None
    action: CodeableConcept
    author: Optional[Reference] = None

@dataclass(kw_only=True)
class DetectedIssue(DomainResource):
    patient: Optional[Reference] = None
    evidence: Optional[List[DetectedIssueEvidence]] = field(default_factory=list)
    mitigation: Optional[List[DetectedIssueMitigation]] = field(default_factory=list)
    author: Optional[Reference] = None
    identified_date_time: Optional[str] = None
    reference: Optional[str] = None
    status: str
    severity: Optional[str] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    implicated: Optional[List[Reference]] = field(default_factory=list)
    identified_period: Optional[Period] = None
    detail: Optional[str] = None