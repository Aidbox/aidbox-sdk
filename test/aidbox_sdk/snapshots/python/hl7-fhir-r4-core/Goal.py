from typing import Optional, List
from pydantic import *
from base.Annotation import Annotation
from base.CodeableConcept import CodeableConcept
from base.Range import Range
from base.Quantity import Quantity
from base.Duration import Duration
from base.DomainResource import DomainResource
from base.Ratio import Ratio
from base.Reference import Reference
from base.Identifier import Identifier
from base.BackboneElement import BackboneElement

class Goal_Target(BackboneElement):
    detail_range: Optional[Range] = None
    detail_quantity: Optional[Quantity] = None
    detail_integer: Optional[int] = None
    detail_string: Optional[str] = None
    measure: Optional[CodeableConcept] = None
    detail_ratio: Optional[Ratio] = None
    detail_codeable_concept: Optional[CodeableConcept] = None
    due_date: Optional[str] = None
    detail_boolean: Optional[bool] = None
    due_duration: Optional[Duration] = None

class Goal(DomainResource):
    description: CodeableConcept
    category: Optional[List[CodeableConcept]] = None
    addresses: Optional[List[Reference]] = None
    expressed_by: Optional[Reference] = None
    start_date: Optional[str] = None
    achievement_status: Optional[CodeableConcept] = None
    status_reason: Optional[str] = None
    note: Optional[List[Annotation]] = None
    start_codeable_concept: Optional[CodeableConcept] = None
    priority: Optional[CodeableConcept] = None
    outcome_code: Optional[List[CodeableConcept]] = None
    identifier: Optional[List[Identifier]] = None
    status_date: Optional[str] = None
    target: Optional[List[Goal_Target]] = None
    outcome_reference: Optional[List[Reference]] = None
    subject: Reference
    lifecycle_status: str