from typing import Optional, List
from pydantic import *
from ..base import *

class RequestGroup_Action_RelatedAction(BackboneElement):
    action_id: str
    offset_range: Optional[Range] = None
    relationship: str
    offset_duration: Optional[Duration] = None

class RequestGroup_Action_Condition(BackboneElement):
    kind: str
    expression: Optional[Expression] = None

class RequestGroup_Action(BackboneElement):
    timing_range: Optional[Range] = None
    description: Optional[str] = None
    text_equivalent: Optional[str] = None
    timing_period: Optional[Period] = None
    related_action: Optional[List[RequestGroup_Action_RelatedAction]] = None
    type: Optional[CodeableConcept] = None
    participant: Optional[List[Reference]] = None
    title: Optional[str] = None
    documentation: Optional[List[RelatedArtifact]] = None
    prefix: Optional[str] = None
    selection_behavior: Optional[str] = None
    timing_date_time: Optional[str] = None
    timing_timing: Optional[Timing] = None
    timing_duration: Optional[Duration] = None
    priority: Optional[str] = None
    required_behavior: Optional[str] = None
    condition: Optional[List[RequestGroup_Action_Condition]] = None
    resource: Optional[Reference] = None
    grouping_behavior: Optional[str] = None
    code: Optional[List[CodeableConcept]] = None
    timing_age: Optional[Age] = None
    action: Optional[List[Reference]] = None
    precheck_behavior: Optional[str] = None
    cardinality_behavior: Optional[str] = None

class RequestGroup(DomainResource):
    instantiates_canonical: Optional[List[str]] = None
    instantiates_uri: Optional[List[str]] = None
    encounter: Optional[Reference] = None
    reason_code: Optional[List[CodeableConcept]] = None
    authored_on: Optional[str] = None
    note: Optional[List[Annotation]] = None
    author: Optional[Reference] = None
    priority: Optional[str] = None
    status: str
    group_identifier: Optional[Identifier] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    intent: str
    action: Optional[List[RequestGroup_Action]] = None
    replaces: Optional[List[Reference]] = None
    based_on: Optional[List[Reference]] = None
    subject: Optional[Reference] = None
    reason_reference: Optional[List[Reference]] = None