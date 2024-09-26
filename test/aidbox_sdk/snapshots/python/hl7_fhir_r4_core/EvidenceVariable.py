from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import Annotation
from base import Period
from base import ContactDetail
from base import DataRequirement
from base import CodeableConcept
from base import TriggerDefinition
from base import Expression
from base import RelatedArtifact
from base import Timing
from base import Duration
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class EvidenceVariableCharacteristic(BackboneElement):
    description: Optional[str] = None
    exclude: Optional[bool] = None
    group_measure: Optional[str] = None
    definition_expression: Optional[Expression] = None
    time_from_start: Optional[Duration] = None
    participant_effective_duration: Optional[Duration] = None
    definition_data_requirement: Optional[DataRequirement] = None
    definition_trigger_definition: Optional[TriggerDefinition] = None
    definition_canonical: Optional[str] = None
    definition_reference: Optional[Reference] = None
    participant_effective_timing: Optional[Timing] = None
    participant_effective_date_time: Optional[str] = None
    participant_effective_period: Optional[Period] = None
    definition_codeable_concept: Optional[CodeableConcept] = None
    usage_context: Optional[List[UsageContext]] = field(default_factory=list)

@dataclass(kw_only=True)
class EvidenceVariable(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    endorser: Optional[List[ContactDetail]] = field(default_factory=list)
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    type: Optional[str] = None
    topic: Optional[List[CodeableConcept]] = field(default_factory=list)
    title: Optional[str] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    author: Optional[List[ContactDetail]] = field(default_factory=list)
    characteristic: list[EvidenceVariableCharacteristic] = field(default_factory=list)
    status: str
    subtitle: Optional[str] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = field(default_factory=list)
    reviewer: Optional[List[ContactDetail]] = field(default_factory=list)
    short_title: Optional[str] = None
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = field(default_factory=list)
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    effective_period: Optional[Period] = None