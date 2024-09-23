from typing import Optional, List
from pydantic import *
from ..base.Address import Address
from ..base.UsageContext import UsageContext
from ..base.Annotation import Annotation
from ..base.Age import Age
from ..base.Attachment import Attachment
from ..base.Period import Period
from ..base.ContactDetail import ContactDetail
from ..base.DataRequirement import DataRequirement
from ..base.CodeableConcept import CodeableConcept
from ..base.TriggerDefinition import TriggerDefinition
from ..base.Count import Count
from ..base.Expression import Expression
from ..base.Coding import Coding
from ..base.Dosage import Dosage
from ..base.Range import Range
from ..base.ContactPoint import ContactPoint
from ..base.Signature import Signature
from ..base.RelatedArtifact import RelatedArtifact
from ..base.Timing import Timing
from ..base.Meta import Meta
from ..base.Quantity import Quantity
from ..base.Distance import Distance
from ..base.HumanName import HumanName
from ..base.Duration import Duration
from ..base.DomainResource import DomainResource
from ..base.Money import Money
from ..base.SampledData import SampledData
from ..base.Ratio import Ratio
from ..base.ParameterDefinition import ParameterDefinition
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement
from ..base.Contributor import Contributor

class StructureMap_Group_Rule_Source(BackboneElement):
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

class StructureMap_Group_Rule_Target_Parameter(BackboneElement):
    value_id: Optional[str] = None
    value_string: Optional[str] = None
    value_boolean: Optional[bool] = None
    value_decimal: Optional[float] = None
    value_integer: Optional[int] = None

class StructureMap_Group_Rule_Target(BackboneElement):
    context: Optional[str] = None
    element: Optional[str] = None
    list_mode: Optional[List[str]] = None
    variable: Optional[str] = None
    parameter: Optional[List[StructureMap_Group_Rule_Target_Parameter]] = None
    transform: Optional[str] = None
    list_rule_id: Optional[str] = None
    context_type: Optional[str] = None

class StructureMap_Group_Rule_Dependent(BackboneElement):
    name: str
    variable: list[str] = []

class StructureMap_Group_Rule(BackboneElement):
    name: str
    rule: Optional[List[Reference]] = None
    source: list[StructureMap_Group_Rule_Source] = []
    target: Optional[List[StructureMap_Group_Rule_Target]] = None
    dependent: Optional[List[StructureMap_Group_Rule_Dependent]] = None
    documentation: Optional[str] = None

class StructureMap_Group_Input(BackboneElement):
    mode: str
    name: str
    type: Optional[str] = None
    documentation: Optional[str] = None

class StructureMap_Group(BackboneElement):
    name: str
    rule: list[StructureMap_Group_Rule] = []
    input: list[StructureMap_Group_Input] = []
    extends: Optional[str] = None
    type_mode: str
    documentation: Optional[str] = None

class StructureMap_Structure(BackboneElement):
    url: str
    mode: str
    alias: Optional[str] = None
    documentation: Optional[str] = None

class StructureMap(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    group: list[StructureMap_Group] = []
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    purpose: Optional[str] = None
    name: str
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    title: Optional[str] = None
    structure: Optional[List[StructureMap_Structure]] = None
    status: str
    url: str
    identifier: Optional[List[Identifier]] = None
    version: Optional[str] = None
    import_: Optional[List[str]] = None
    contact: Optional[List[ContactDetail]] = None