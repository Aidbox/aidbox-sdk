from typing import Optional, List
from dataclasses import dataclass, field
from base import Address
from base import UsageContext
from base import Annotation
from base import Age
from base import Attachment
from base import Period
from base import ContactDetail
from base import DataRequirement
from base import CodeableConcept
from base import TriggerDefinition
from base import Count
from base import Expression
from base import Coding
from base import Dosage
from base import Range
from base import ContactPoint
from base import Signature
from base import RelatedArtifact
from base import Timing
from base import Meta
from base import Quantity
from base import Distance
from base import HumanName
from base import Duration
from base import DomainResource
from base import Money
from base import SampledData
from base import Ratio
from base import ParameterDefinition
from base import Reference
from base import Identifier
from base import BackboneElement
from base import Contributor

@dataclass(kw_only=True)
class TaskRestriction(BackboneElement):
    period: Optional[Period] = None
    recipient: Optional[List[Reference]] = field(default_factory=list)
    repetitions: Optional[int] = None

@dataclass(kw_only=True)
class TaskOutput(BackboneElement):
    value_base64_binary: Optional[str] = None
    value_age: Optional[Age] = None
    value_parameter_definition: Optional[ParameterDefinition] = None
    value_timing: Optional[Timing] = None
    value_code: Optional[str] = None
    value_reference: Optional[Reference] = None
    value_contributor: Optional[Contributor] = None
    value_contact_detail: Optional[ContactDetail] = None
    value_uri: Optional[str] = None
    value_usage_context: Optional[UsageContext] = None
    value_time: Optional[str] = None
    value_decimal: Optional[float] = None
    value_canonical: Optional[str] = None
    value_markdown: Optional[str] = None
    value_identifier: Optional[Identifier] = None
    value_trigger_definition: Optional[TriggerDefinition] = None
    value_quantity: Optional[Quantity] = None
    value_count: Optional[Count] = None
    value_string: Optional[str] = None
    value_ratio: Optional[Ratio] = None
    value_boolean: Optional[bool] = None
    value_instant: Optional[str] = None
    value_date_time: Optional[str] = None
    value_date: Optional[str] = None
    type: CodeableConcept
    value_duration: Optional[Duration] = None
    value_data_requirement: Optional[DataRequirement] = None
    value_meta: Optional[Meta] = None
    value_money: Optional[Money] = None
    value_coding: Optional[Coding] = None
    value_expression: Optional[Expression] = None
    value_sampled_data: Optional[SampledData] = None
    value_dosage: Optional[Dosage] = None
    value_contact_point: Optional[ContactPoint] = None
    value_codeable_concept: Optional[CodeableConcept] = None
    value_annotation: Optional[Annotation] = None
    value_period: Optional[Period] = None
    value_distance: Optional[Distance] = None
    value_range: Optional[Range] = None
    value_signature: Optional[Signature] = None
    value_uuid: Optional[str] = None
    value_integer: Optional[int] = None
    value_human_name: Optional[HumanName] = None
    value_unsigned_int: Optional[int] = None
    value_attachment: Optional[Attachment] = None
    value_oid: Optional[str] = None
    value_address: Optional[Address] = None
    value_related_artifact: Optional[RelatedArtifact] = None
    value_positive_int: Optional[int] = None
    value_id: Optional[str] = None
    value_url: Optional[str] = None

@dataclass(kw_only=True)
class TaskInput(BackboneElement):
    value_base64_binary: Optional[str] = None
    value_age: Optional[Age] = None
    value_parameter_definition: Optional[ParameterDefinition] = None
    value_timing: Optional[Timing] = None
    value_code: Optional[str] = None
    value_reference: Optional[Reference] = None
    value_contributor: Optional[Contributor] = None
    value_contact_detail: Optional[ContactDetail] = None
    value_uri: Optional[str] = None
    value_usage_context: Optional[UsageContext] = None
    value_time: Optional[str] = None
    value_decimal: Optional[float] = None
    value_canonical: Optional[str] = None
    value_markdown: Optional[str] = None
    value_identifier: Optional[Identifier] = None
    value_trigger_definition: Optional[TriggerDefinition] = None
    value_quantity: Optional[Quantity] = None
    value_count: Optional[Count] = None
    value_string: Optional[str] = None
    value_ratio: Optional[Ratio] = None
    value_boolean: Optional[bool] = None
    value_instant: Optional[str] = None
    value_date_time: Optional[str] = None
    value_date: Optional[str] = None
    type: CodeableConcept
    value_duration: Optional[Duration] = None
    value_data_requirement: Optional[DataRequirement] = None
    value_meta: Optional[Meta] = None
    value_money: Optional[Money] = None
    value_coding: Optional[Coding] = None
    value_expression: Optional[Expression] = None
    value_sampled_data: Optional[SampledData] = None
    value_dosage: Optional[Dosage] = None
    value_contact_point: Optional[ContactPoint] = None
    value_codeable_concept: Optional[CodeableConcept] = None
    value_annotation: Optional[Annotation] = None
    value_period: Optional[Period] = None
    value_distance: Optional[Distance] = None
    value_range: Optional[Range] = None
    value_signature: Optional[Signature] = None
    value_uuid: Optional[str] = None
    value_integer: Optional[int] = None
    value_human_name: Optional[HumanName] = None
    value_unsigned_int: Optional[int] = None
    value_attachment: Optional[Attachment] = None
    value_oid: Optional[str] = None
    value_address: Optional[Address] = None
    value_related_artifact: Optional[RelatedArtifact] = None
    value_positive_int: Optional[int] = None
    value_id: Optional[str] = None
    value_url: Optional[str] = None

@dataclass(kw_only=True)
class Task(DomainResource):
    restriction: Optional[TaskRestriction] = None
    description: Optional[str] = None
    performer_type: Optional[List[CodeableConcept]] = field(default_factory=list)
    execution_period: Optional[Period] = None
    insurance: Optional[List[Reference]] = field(default_factory=list)
    instantiates_canonical: Optional[str] = None
    instantiates_uri: Optional[str] = None
    relevant_history: Optional[List[Reference]] = field(default_factory=list)
    encounter: Optional[Reference] = None
    reason_code: Optional[CodeableConcept] = None
    status_reason: Optional[CodeableConcept] = None
    authored_on: Optional[str] = None
    output: Optional[List[TaskOutput]] = field(default_factory=list)
    business_status: Optional[CodeableConcept] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    for_: Optional[Reference] = None
    requester: Optional[Reference] = None
    last_modified: Optional[str] = None
    priority: Optional[str] = None
    status: str
    group_identifier: Optional[Identifier] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    intent: str
    focus: Optional[Reference] = None
    input: Optional[List[TaskInput]] = field(default_factory=list)
    based_on: Optional[List[Reference]] = field(default_factory=list)
    part_of: Optional[List[Reference]] = field(default_factory=list)
    location: Optional[Reference] = None
    owner: Optional[Reference] = None
    reason_reference: Optional[Reference] = None