from typing import Optional, List
from pydantic import *
from base.CodeableConcept import CodeableConcept
from base.DomainResource import DomainResource
from base.BackboneElement import BackboneElement

class OperationOutcome_Issue(BackboneElement):
    code: str
    details: Optional[CodeableConcept] = None
    location: Optional[List[str]] = None
    severity: str
    expression: Optional[List[str]] = None
    diagnostics: Optional[str] = None

class OperationOutcome(DomainResource):
    issue: list[OperationOutcome_Issue] = []