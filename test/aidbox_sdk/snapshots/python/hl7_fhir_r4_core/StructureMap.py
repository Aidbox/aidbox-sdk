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
class StructureMapGroupRuleSource(BackboneElement):
    default_value_time: Optional[str] = None
    default_value_data_requirement: Optional[DataRequirement] = None
    min: Optional[int] = None
    default_value_money: Optional[Money] = None
    default_value_contact_point: Optional[ContactPoint] = None
    default_value_meta: Optional[Meta] = None
    default_value_coding: Optional[Coding] = None
    variable: Optional[str] = None
    default_value_code: Optional[str] = None
    element: Optional[str] = None
    default_value_sampled_data: Optional[SampledData] = None
    default_value_markdown: Optional[str] = None
    default_value_human_name: Optional[HumanName] = None
    default_value_duration: Optional[Duration] = None
    default_value_decimal: Optional[float] = None
    default_value_uri: Optional[str] = None
    check: Optional[str] = None
    default_value_quantity: Optional[Quantity] = None
    default_value_count: Optional[Count] = None
    default_value_id: Optional[str] = None
    default_value_base64_binary: Optional[str] = None
    default_value_contact_detail: Optional[ContactDetail] = None
    type: Optional[str] = None
    default_value_boolean: Optional[bool] = None
    default_value_period: Optional[Period] = None
    default_value_trigger_definition: Optional[TriggerDefinition] = None
    log_message: Optional[str] = None
    default_value_date: Optional[str] = None
    default_value_reference: Optional[Reference] = None
    default_value_dosage: Optional[Dosage] = None
    default_value_range: Optional[Range] = None
    default_value_instant: Optional[str] = None
    default_value_attachment: Optional[Attachment] = None
    default_value_unsigned_int: Optional[int] = None
    default_value_distance: Optional[Distance] = None
    max: Optional[str] = None
    default_value_contributor: Optional[Contributor] = None
    condition: Optional[str] = None
    default_value_ratio: Optional[Ratio] = None
    default_value_canonical: Optional[str] = None
    default_value_expression: Optional[Expression] = None
    default_value_signature: Optional[Signature] = None
    default_value_url: Optional[str] = None
    context: str
    default_value_annotation: Optional[Annotation] = None
    default_value_uuid: Optional[str] = None
    default_value_address: Optional[Address] = None
    default_value_string: Optional[str] = None
    default_value_age: Optional[Age] = None
    default_value_oid: Optional[str] = None
    default_value_usage_context: Optional[UsageContext] = None
    list_mode: Optional[str] = None
    default_value_parameter_definition: Optional[ParameterDefinition] = None
    default_value_date_time: Optional[str] = None
    default_value_positive_int: Optional[int] = None
    default_value_integer: Optional[int] = None
    default_value_timing: Optional[Timing] = None
    default_value_related_artifact: Optional[RelatedArtifact] = None
    default_value_identifier: Optional[Identifier] = None
    default_value_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class StructureMapGroupRuleTargetParameter(BackboneElement):
    value_id: Optional[str] = None
    value_string: Optional[str] = None
    value_boolean: Optional[bool] = None
    value_decimal: Optional[float] = None
    value_integer: Optional[int] = None

@dataclass(kw_only=True)
class StructureMapGroupRuleTarget(BackboneElement):
    context: Optional[str] = None
    element: Optional[str] = None
    list_mode: Optional[List[str]] = field(default_factory=list)
    variable: Optional[str] = None
    parameter: Optional[List[StructureMapGroupRuleTargetParameter]] = field(default_factory=list)
    transform: Optional[str] = None
    list_rule_id: Optional[str] = None
    context_type: Optional[str] = None

@dataclass(kw_only=True)
class StructureMapGroupRuleDependent(BackboneElement):
    name: str
    variable: list[str] = field(default_factory=list)

@dataclass(kw_only=True)
class StructureMapGroupRule(BackboneElement):
    name: str
    rule: Optional[List[Reference]] = field(default_factory=list)
    source: list[StructureMapGroupRuleSource] = field(default_factory=list)
    target: Optional[List[StructureMapGroupRuleTarget]] = field(default_factory=list)
    dependent: Optional[List[StructureMapGroupRuleDependent]] = field(default_factory=list)
    documentation: Optional[str] = None

@dataclass(kw_only=True)
class StructureMapGroupInput(BackboneElement):
    mode: str
    name: str
    type: Optional[str] = None
    documentation: Optional[str] = None

@dataclass(kw_only=True)
class StructureMapGroup(BackboneElement):
    name: str
    rule: list[StructureMapGroupRule] = field(default_factory=list)
    input: list[StructureMapGroupInput] = field(default_factory=list)
    extends: Optional[str] = None
    type_mode: str
    documentation: Optional[str] = None

@dataclass(kw_only=True)
class StructureMapStructure(BackboneElement):
    url: str
    mode: str
    alias: Optional[str] = None
    documentation: Optional[str] = None

@dataclass(kw_only=True)
class StructureMap(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    group: list[StructureMapGroup] = field(default_factory=list)
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    purpose: Optional[str] = None
    name: str
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    title: Optional[str] = None
    structure: Optional[List[StructureMapStructure]] = field(default_factory=list)
    status: str
    url: str
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    version: Optional[str] = None
    import_: Optional[List[str]] = field(default_factory=list)
    contact: Optional[List[ContactDetail]] = field(default_factory=list)