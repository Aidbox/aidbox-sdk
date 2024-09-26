from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Age
from base import Period
from base import CodeableConcept
from base import Expression
from base import Range
from base import RelatedArtifact
from base import Timing
from base import Duration
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class RequestGroupActionRelatedAction(BackboneElement):
    action_id: str
    offset_range: Optional[Range] = None
    relationship: str
    offset_duration: Optional[Duration] = None

@dataclass(kw_only=True)
class RequestGroupActionCondition(BackboneElement):
    kind: str
    expression: Optional[Expression] = None

@dataclass(kw_only=True)
class RequestGroupAction(BackboneElement):
    timing_range: Optional[Range] = None
    description: Optional[str] = None
    text_equivalent: Optional[str] = None
    timing_period: Optional[Period] = None
    related_action: Optional[List[RequestGroupActionRelatedAction]] = field(default_factory=list)
    type: Optional[CodeableConcept] = None
    participant: Optional[List[Reference]] = field(default_factory=list)
    title: Optional[str] = None
    documentation: Optional[List[RelatedArtifact]] = field(default_factory=list)
    prefix: Optional[str] = None
    selection_behavior: Optional[str] = None
    timing_date_time: Optional[str] = None
    timing_timing: Optional[Timing] = None
    timing_duration: Optional[Duration] = None
    priority: Optional[str] = None
    required_behavior: Optional[str] = None
    condition: Optional[List[RequestGroupActionCondition]] = field(default_factory=list)
    resource: Optional[Reference] = None
    grouping_behavior: Optional[str] = None
    code: Optional[List[CodeableConcept]] = field(default_factory=list)
    timing_age: Optional[Age] = None
    action: Optional[List[Reference]] = field(default_factory=list)
    precheck_behavior: Optional[str] = None
    cardinality_behavior: Optional[str] = None

@dataclass(kw_only=True)
class RequestGroup(DomainResource):
    instantiates_canonical: Optional[List[str]] = field(default_factory=list)
    instantiates_uri: Optional[List[str]] = field(default_factory=list)
    encounter: Optional[Reference] = None
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    authored_on: Optional[str] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    author: Optional[Reference] = None
    priority: Optional[str] = None
    status: str
    group_identifier: Optional[Identifier] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    intent: str
    action: Optional[List[RequestGroupAction]] = field(default_factory=list)
    replaces: Optional[List[Reference]] = field(default_factory=list)
    based_on: Optional[List[Reference]] = field(default_factory=list)
    subject: Optional[Reference] = None
    reason_reference: Optional[List[Reference]] = field(default_factory=list)