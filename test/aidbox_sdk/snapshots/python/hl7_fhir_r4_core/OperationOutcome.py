from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import DomainResource
from base import BackboneElement

@dataclass(kw_only=True)
class OperationOutcomeIssue(BackboneElement):
    code: str
    details: Optional[CodeableConcept] = None
    location: Optional[List[str]] = field(default_factory=list)
    severity: str
    expression: Optional[List[str]] = field(default_factory=list)
    diagnostics: Optional[str] = None

@dataclass(kw_only=True)
class OperationOutcome(DomainResource):
    issue: list[OperationOutcomeIssue] = field(default_factory=list)