from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import CodeableConcept
from base import Range
from base import Quantity
from base import Duration
from base import DomainResource
from base import Ratio
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class GoalTarget(BackboneElement):
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

@dataclass(kw_only=True)
class Goal(DomainResource):
    description: CodeableConcept
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    addresses: Optional[List[Reference]] = field(default_factory=list)
    expressed_by: Optional[Reference] = None
    start_date: Optional[str] = None
    achievement_status: Optional[CodeableConcept] = None
    status_reason: Optional[str] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    start_codeable_concept: Optional[CodeableConcept] = None
    priority: Optional[CodeableConcept] = None
    outcome_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    status_date: Optional[str] = None
    target: Optional[List[GoalTarget]] = field(default_factory=list)
    outcome_reference: Optional[List[Reference]] = field(default_factory=list)
    subject: Reference
    lifecycle_status: str