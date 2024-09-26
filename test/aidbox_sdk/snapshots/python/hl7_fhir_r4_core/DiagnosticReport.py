from typing import Optional, List
from dataclasses import dataclass, field
from base import Attachment
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class DiagnosticReportMedia(BackboneElement):
    link: Reference
    comment: Optional[str] = None

@dataclass(kw_only=True)
class DiagnosticReport(DomainResource):
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    conclusion_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    conclusion: Optional[str] = None
    encounter: Optional[Reference] = None
    specimen: Optional[List[Reference]] = field(default_factory=list)
    effective_date_time: Optional[str] = None
    results_interpreter: Optional[List[Reference]] = field(default_factory=list)
    status: str
    result: Optional[List[Reference]] = field(default_factory=list)
    code: CodeableConcept
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    issued: Optional[str] = None
    presented_form: Optional[List[Attachment]] = field(default_factory=list)
    based_on: Optional[List[Reference]] = field(default_factory=list)
    imaging_study: Optional[List[Reference]] = field(default_factory=list)
    media: Optional[List[DiagnosticReportMedia]] = field(default_factory=list)
    subject: Optional[Reference] = None
    performer: Optional[List[Reference]] = field(default_factory=list)
    effective_period: Optional[Period] = None