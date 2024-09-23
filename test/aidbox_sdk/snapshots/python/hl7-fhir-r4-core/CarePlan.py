from typing import Optional, List
from pydantic import *
from ..base.Annotation import Annotation
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.Timing import Timing
from ..base.Quantity import Quantity
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class CarePlan_Activity_Detail(BackboneElement):
    description: Optional[str] = None
    instantiates_canonical: Optional[List[str]] = None
    instantiates_uri: Optional[List[str]] = None
    product_codeable_concept: Optional[CodeableConcept] = None
    product_reference: Optional[Reference] = None
    scheduled_period: Optional[Period] = None
    goal: Optional[List[Reference]] = None
    reason_code: Optional[List[CodeableConcept]] = None
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
    performer: Optional[List[Reference]] = None
    reason_reference: Optional[List[Reference]] = None

class CarePlan_Activity(BackboneElement):
    detail: Optional[CarePlan_Activity_Detail] = None
    progress: Optional[List[Annotation]] = None
    reference: Optional[Reference] = None
    outcome_reference: Optional[List[Reference]] = None
    outcome_codeable_concept: Optional[List[CodeableConcept]] = None

class CarePlan(DomainResource):
    description: Optional[str] = None
    category: Optional[List[CodeableConcept]] = None
    addresses: Optional[List[Reference]] = None
    instantiates_canonical: Optional[List[str]] = None
    instantiates_uri: Optional[List[str]] = None
    supporting_info: Optional[List[Reference]] = None
    encounter: Optional[Reference] = None
    goal: Optional[List[Reference]] = None
    created: Optional[str] = None
    title: Optional[str] = None
    note: Optional[List[Annotation]] = None
    author: Optional[Reference] = None
    activity: Optional[List[CarePlan_Activity]] = None
    contributor: Optional[List[Reference]] = None
    status: str
    identifier: Optional[List[Identifier]] = None
    intent: str
    replaces: Optional[List[Reference]] = None
    period: Optional[Period] = None
    based_on: Optional[List[Reference]] = None
    part_of: Optional[List[Reference]] = None
    subject: Reference
    care_team: Optional[List[Reference]] = None