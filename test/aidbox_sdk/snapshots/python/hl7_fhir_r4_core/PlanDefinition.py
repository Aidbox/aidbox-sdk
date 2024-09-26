from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import Age
from base import Period
from base import ContactDetail
from base import DataRequirement
from base import CodeableConcept
from base import TriggerDefinition
from base import Expression
from base import Range
from base import RelatedArtifact
from base import Timing
from base import Quantity
from base import Duration
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class PlanDefinitionGoalTarget(BackboneElement):
    due: Optional[Duration] = None
    measure: Optional[CodeableConcept] = None
    detail_range: Optional[Range] = None
    detail_quantity: Optional[Quantity] = None
    detail_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class PlanDefinitionGoal(BackboneElement):
    start: Optional[CodeableConcept] = None
    target: Optional[List[PlanDefinitionGoalTarget]] = field(default_factory=list)
    category: Optional[CodeableConcept] = None
    priority: Optional[CodeableConcept] = None
    addresses: Optional[List[CodeableConcept]] = field(default_factory=list)
    description: CodeableConcept
    documentation: Optional[List[RelatedArtifact]] = field(default_factory=list)

@dataclass(kw_only=True)
class PlanDefinitionActionRelatedAction(BackboneElement):
    action_id: str
    offset_range: Optional[Range] = None
    relationship: str
    offset_duration: Optional[Duration] = None

@dataclass(kw_only=True)
class PlanDefinitionActionParticipant(BackboneElement):
    role: Optional[CodeableConcept] = None
    type: str

@dataclass(kw_only=True)
class PlanDefinitionActionCondition(BackboneElement):
    kind: str
    expression: Optional[Expression] = None

@dataclass(kw_only=True)
class PlanDefinitionActionDynamicValue(BackboneElement):
    path: Optional[str] = None
    expression: Optional[Expression] = None

@dataclass(kw_only=True)
class PlanDefinitionAction(BackboneElement):
    timing_range: Optional[Range] = None
    description: Optional[str] = None
    transform: Optional[str] = None
    text_equivalent: Optional[str] = None
    definition_uri: Optional[str] = None
    goal_id: Optional[List[str]] = field(default_factory=list)
    subject_codeable_concept: Optional[CodeableConcept] = None
    timing_period: Optional[Period] = None
    definition_canonical: Optional[str] = None
    related_action: Optional[List[PlanDefinitionActionRelatedAction]] = field(default_factory=list)
    type: Optional[CodeableConcept] = None
    participant: Optional[List[PlanDefinitionActionParticipant]] = field(default_factory=list)
    output: Optional[List[DataRequirement]] = field(default_factory=list)
    title: Optional[str] = None
    documentation: Optional[List[RelatedArtifact]] = field(default_factory=list)
    prefix: Optional[str] = None
    selection_behavior: Optional[str] = None
    reason: Optional[List[CodeableConcept]] = field(default_factory=list)
    timing_date_time: Optional[str] = None
    timing_timing: Optional[Timing] = None
    timing_duration: Optional[Duration] = None
    priority: Optional[str] = None
    required_behavior: Optional[str] = None
    condition: Optional[List[PlanDefinitionActionCondition]] = field(default_factory=list)
    grouping_behavior: Optional[str] = None
    dynamic_value: Optional[List[PlanDefinitionActionDynamicValue]] = field(default_factory=list)
    code: Optional[List[CodeableConcept]] = field(default_factory=list)
    timing_age: Optional[Age] = None
    action: Optional[List[Reference]] = field(default_factory=list)
    precheck_behavior: Optional[str] = None
    input: Optional[List[DataRequirement]] = field(default_factory=list)
    trigger: Optional[List[TriggerDefinition]] = field(default_factory=list)
    subject_reference: Optional[Reference] = None
    cardinality_behavior: Optional[str] = None

@dataclass(kw_only=True)
class PlanDefinition(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    endorser: Optional[List[ContactDetail]] = field(default_factory=list)
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    purpose: Optional[str] = None
    subject_codeable_concept: Optional[CodeableConcept] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    goal: Optional[List[PlanDefinitionGoal]] = field(default_factory=list)
    copyright: Optional[str] = None
    type: Optional[CodeableConcept] = None
    experimental: Optional[bool] = None
    topic: Optional[List[CodeableConcept]] = field(default_factory=list)
    title: Optional[str] = None
    library: Optional[List[str]] = field(default_factory=list)
    author: Optional[List[ContactDetail]] = field(default_factory=list)
    usage: Optional[str] = None
    status: str
    subtitle: Optional[str] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = field(default_factory=list)
    action: Optional[List[PlanDefinitionAction]] = field(default_factory=list)
    reviewer: Optional[List[ContactDetail]] = field(default_factory=list)
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = field(default_factory=list)
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    subject_reference: Optional[Reference] = None
    effective_period: Optional[Period] = None