from typing import Optional, List
from pydantic import *
from ..base import *

class DiagnosticReport_Media(BackboneElement):
    link: Reference
    comment: Optional[str] = None

class DiagnosticReport(DomainResource):
    category: Optional[List[CodeableConcept]] = None
    conclusion_code: Optional[List[CodeableConcept]] = None
    conclusion: Optional[str] = None
    encounter: Optional[Reference] = None
    specimen: Optional[List[Reference]] = None
    effective_date_time: Optional[str] = None
    results_interpreter: Optional[List[Reference]] = None
    status: str
    result: Optional[List[Reference]] = None
    code: CodeableConcept
    identifier: Optional[List[Identifier]] = None
    issued: Optional[str] = None
    presented_form: Optional[List[Attachment]] = None
    based_on: Optional[List[Reference]] = None
    imaging_study: Optional[List[Reference]] = None
    media: Optional[List[DiagnosticReport_Media]] = None
    subject: Optional[Reference] = None
    performer: Optional[List[Reference]] = None
    effective_period: Optional[Period] = None