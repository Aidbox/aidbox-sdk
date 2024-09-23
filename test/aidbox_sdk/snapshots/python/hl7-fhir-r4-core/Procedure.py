from typing import Optional, List
from pydantic import *
from ..base.Annotation import Annotation
from ..base.Age import Age
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.Range import Range
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class Procedure_FocalDevice(BackboneElement):
    action: Optional[CodeableConcept] = None
    manipulated: Reference

class Procedure_Performer(BackboneElement):
    actor: Reference
    function: Optional[CodeableConcept] = None
    on_behalf_of: Optional[Reference] = None

class Procedure(DomainResource):
    category: Optional[CodeableConcept] = None
    report: Optional[List[Reference]] = None
    used_code: Optional[List[CodeableConcept]] = None
    used_reference: Optional[List[Reference]] = None
    instantiates_canonical: Optional[List[str]] = None
    instantiates_uri: Optional[List[str]] = None
    focal_device: Optional[List[Procedure_FocalDevice]] = None
    encounter: Optional[Reference] = None
    performed_age: Optional[Age] = None
    complication_detail: Optional[List[Reference]] = None
    reason_code: Optional[List[CodeableConcept]] = None
    performed_string: Optional[str] = None
    status_reason: Optional[CodeableConcept] = None
    outcome: Optional[CodeableConcept] = None
    asserter: Optional[Reference] = None
    note: Optional[List[Annotation]] = None
    performed_range: Optional[Range] = None
    complication: Optional[List[CodeableConcept]] = None
    status: str
    performed_date_time: Optional[str] = None
    recorder: Optional[Reference] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    body_site: Optional[List[CodeableConcept]] = None
    based_on: Optional[List[Reference]] = None
    part_of: Optional[List[Reference]] = None
    performed_period: Optional[Period] = None
    location: Optional[Reference] = None
    follow_up: Optional[List[CodeableConcept]] = None
    subject: Reference
    performer: Optional[List[Procedure_Performer]] = None
    reason_reference: Optional[List[Reference]] = None