from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Period
from base import CodeableConcept
from base import Timing
from base import Quantity
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class CarePlanActivityDetail(BackboneElement):
    description: Optional[str] = None
    instantiates_canonical: Optional[List[str]] = field(default_factory=list)
    instantiates_uri: Optional[List[str]] = field(default_factory=list)
    product_codeable_concept: Optional[CodeableConcept] = None
    product_reference: Optional[Reference] = None
    scheduled_period: Optional[Period] = None
    goal: Optional[List[Reference]] = field(default_factory=list)
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    status_reason: Optional[CodeableConcept] = None
    scheduled_timing: Optional[Timing] = None
    daily_amount: Optional[Quantity] = None
    scheduled_string: Optional[str] = None
    status: str
    kind: Optional[str] = None
    code: Optional[CodeableConcept] = None
    do_not_perform: Optional[bool] = None
    quantity: Optional[Quantity] = None
    location: Optional[Reference] = None
    performer: Optional[List[Reference]] = field(default_factory=list)
    reason_reference: Optional[List[Reference]] = field(default_factory=list)

@dataclass(kw_only=True)
class CarePlanActivity(BackboneElement):
    detail: Optional[CarePlanActivityDetail] = None
    progress: Optional[List[Annotation]] = field(default_factory=list)
    reference: Optional[Reference] = None
    outcome_reference: Optional[List[Reference]] = field(default_factory=list)
    outcome_codeable_concept: Optional[List[CodeableConcept]] = field(default_factory=list)

@dataclass(kw_only=True)
class CarePlan(DomainResource):
    description: Optional[str] = None
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    addresses: Optional[List[Reference]] = field(default_factory=list)
    instantiates_canonical: Optional[List[str]] = field(default_factory=list)
    instantiates_uri: Optional[List[str]] = field(default_factory=list)
    supporting_info: Optional[List[Reference]] = field(default_factory=list)
    encounter: Optional[Reference] = None
    goal: Optional[List[Reference]] = field(default_factory=list)
    created: Optional[str] = None
    title: Optional[str] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    author: Optional[Reference] = None
    activity: Optional[List[CarePlanActivity]] = field(default_factory=list)
    contributor: Optional[List[Reference]] = field(default_factory=list)
    status: str
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    intent: str
    replaces: Optional[List[Reference]] = field(default_factory=list)
    period: Optional[Period] = None
    based_on: Optional[List[Reference]] = field(default_factory=list)
    part_of: Optional[List[Reference]] = field(default_factory=list)
    subject: Reference
    care_team: Optional[List[Reference]] = field(default_factory=list)