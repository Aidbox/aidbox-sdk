from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Age
from base import Period
from base import CodeableConcept
from base import Range
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ProcedureFocalDevice(BackboneElement):
    action: Optional[CodeableConcept] = None
    manipulated: Reference

@dataclass(kw_only=True)
class ProcedurePerformer(BackboneElement):
    actor: Reference
    function: Optional[CodeableConcept] = None
    on_behalf_of: Optional[Reference] = None

@dataclass(kw_only=True)
class Procedure(DomainResource):
    category: Optional[CodeableConcept] = None
    report: Optional[List[Reference]] = field(default_factory=list)
    used_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    used_reference: Optional[List[Reference]] = field(default_factory=list)
    instantiates_canonical: Optional[List[str]] = field(default_factory=list)
    instantiates_uri: Optional[List[str]] = field(default_factory=list)
    focal_device: Optional[List[ProcedureFocalDevice]] = field(default_factory=list)
    encounter: Optional[Reference] = None
    performed_age: Optional[Age] = None
    complication_detail: Optional[List[Reference]] = field(default_factory=list)
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    performed_string: Optional[str] = None
    status_reason: Optional[CodeableConcept] = None
    outcome: Optional[CodeableConcept] = None
    asserter: Optional[Reference] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    performed_range: Optional[Range] = None
    complication: Optional[List[CodeableConcept]] = field(default_factory=list)
    status: str
    performed_date_time: Optional[str] = None
    recorder: Optional[Reference] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    body_site: Optional[List[CodeableConcept]] = field(default_factory=list)
    based_on: Optional[List[Reference]] = field(default_factory=list)
    part_of: Optional[List[Reference]] = field(default_factory=list)
    performed_period: Optional[Period] = None
    location: Optional[Reference] = None
    follow_up: Optional[List[CodeableConcept]] = field(default_factory=list)
    subject: Reference
    performer: Optional[List[ProcedurePerformer]] = field(default_factory=list)
    reason_reference: Optional[List[Reference]] = field(default_factory=list)