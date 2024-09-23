from typing import Optional, List
from pydantic import *
from ..base import *

class PlanDefinition_Goal_Target(BackboneElement):
    due: Optional[Duration] = None
    measure: Optional[CodeableConcept] = None
    detail_range: Optional[Range] = None
    detail_quantity: Optional[Quantity] = None
    detail_codeable_concept: Optional[CodeableConcept] = None

class PlanDefinition_Goal(BackboneElement):
    start: Optional[CodeableConcept] = None
    target: Optional[List[PlanDefinition_Goal_Target]] = None
    category: Optional[CodeableConcept] = None
    priority: Optional[CodeableConcept] = None
    addresses: Optional[List[CodeableConcept]] = None
    description: CodeableConcept
    documentation: Optional[List[RelatedArtifact]] = None

class PlanDefinition_Action_RelatedAction(BackboneElement):
    action_id: str
    offset_range: Optional[Range] = None
    relationship: str
    offset_duration: Optional[Duration] = None

class PlanDefinition_Action_Participant(BackboneElement):
    role: Optional[CodeableConcept] = None
    type: str

class PlanDefinition_Action_Condition(BackboneElement):
    kind: str
    expression: Optional[Expression] = None

class PlanDefinition_Action_DynamicValue(BackboneElement):
    path: Optional[str] = None
    expression: Optional[Expression] = None

class PlanDefinition_Action(BackboneElement):
    timing_range: Optional[Range] = None
    description: Optional[str] = None
    transform: Optional[str] = None
    text_equivalent: Optional[str] = None
    definition_uri: Optional[str] = None
    goal_id: Optional[List[str]] = None
    subject_codeable_concept: Optional[CodeableConcept] = None
    timing_period: Optional[Period] = None
    definition_canonical: Optional[str] = None
    related_action: Optional[List[PlanDefinition_Action_RelatedAction]] = None
    type: Optional[CodeableConcept] = None
    participant: Optional[List[PlanDefinition_Action_Participant]] = None
    output: Optional[List[DataRequirement]] = None
    title: Optional[str] = None
    documentation: Optional[List[RelatedArtifact]] = None
    prefix: Optional[str] = None
    selection_behavior: Optional[str] = None
    reason: Optional[List[CodeableConcept]] = None
    timing_date_time: Optional[str] = None
    timing_timing: Optional[Timing] = None
    timing_duration: Optional[Duration] = None
    priority: Optional[str] = None
    required_behavior: Optional[str] = None
    condition: Optional[List[PlanDefinition_Action_Condition]] = None
    grouping_behavior: Optional[str] = None
    dynamic_value: Optional[List[PlanDefinition_Action_DynamicValue]] = None
    code: Optional[List[CodeableConcept]] = None
    timing_age: Optional[Age] = None
    action: Optional[List[Reference]] = None
    precheck_behavior: Optional[str] = None
    input: Optional[List[DataRequirement]] = None
    trigger: Optional[List[TriggerDefinition]] = None
    subject_reference: Optional[Reference] = None
    cardinality_behavior: Optional[str] = None

class PlanDefinition(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    endorser: Optional[List[ContactDetail]] = None
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    purpose: Optional[str] = None
    subject_codeable_concept: Optional[CodeableConcept] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = None
    goal: Optional[List[PlanDefinition_Goal]] = None
    copyright: Optional[str] = None
    type: Optional[CodeableConcept] = None
    experimental: Optional[bool] = None
    topic: Optional[List[CodeableConcept]] = None
    title: Optional[str] = None
    library: Optional[List[str]] = None
    author: Optional[List[ContactDetail]] = None
    usage: Optional[str] = None
    status: str
    subtitle: Optional[str] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = None
    action: Optional[List[PlanDefinition_Action]] = None
    reviewer: Optional[List[ContactDetail]] = None
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = None
    contact: Optional[List[ContactDetail]] = None
    subject_reference: Optional[Reference] = None
    effective_period: Optional[Period] = None