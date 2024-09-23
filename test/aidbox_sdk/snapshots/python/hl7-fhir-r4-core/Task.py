from typing import Optional, List
from pydantic import *
from base.Address import Address
from base.UsageContext import UsageContext
from base.Annotation import Annotation
from base.Age import Age
from base.Attachment import Attachment
from base.Period import Period
from base.ContactDetail import ContactDetail
from base.DataRequirement import DataRequirement
from base.CodeableConcept import CodeableConcept
from base.TriggerDefinition import TriggerDefinition
from base.Count import Count
from base.Expression import Expression
from base.Coding import Coding
from base.Dosage import Dosage
from base.Range import Range
from base.ContactPoint import ContactPoint
from base.Signature import Signature
from base.RelatedArtifact import RelatedArtifact
from base.Timing import Timing
from base.Meta import Meta
from base.Quantity import Quantity
from base.Distance import Distance
from base.HumanName import HumanName
from base.Duration import Duration
from base.DomainResource import DomainResource
from base.Money import Money
from base.SampledData import SampledData
from base.Ratio import Ratio
from base.ParameterDefinition import ParameterDefinition
from base.Reference import Reference
from base.Identifier import Identifier
from base.BackboneElement import BackboneElement
from base.Contributor import Contributor

class Task_Restriction(BackboneElement):
    period: Optional[Period] = None
    recipient: Optional[List[Reference]] = None
    repetitions: Optional[int] = None

class Task_Output(BackboneElement):
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

class Task_Input(BackboneElement):
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

class Task(DomainResource):
    restriction: Optional[Task_Restriction] = None
    description: Optional[str] = None
    performer_type: Optional[List[CodeableConcept]] = None
    execution_period: Optional[Period] = None
    insurance: Optional[List[Reference]] = None
    instantiates_canonical: Optional[str] = None
    instantiates_uri: Optional[str] = None
    relevant_history: Optional[List[Reference]] = None
    encounter: Optional[Reference] = None
    reason_code: Optional[CodeableConcept] = None
    status_reason: Optional[CodeableConcept] = None
    authored_on: Optional[str] = None
    output: Optional[List[Task_Output]] = None
    business_status: Optional[CodeableConcept] = None
    note: Optional[List[Annotation]] = None
    for: Optional[Reference] = None
    requester: Optional[Reference] = None
    last_modified: Optional[str] = None
    priority: Optional[str] = None
    status: str
    group_identifier: Optional[Identifier] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    intent: str
    focus: Optional[Reference] = None
    input: Optional[List[Task_Input]] = None
    based_on: Optional[List[Reference]] = None
    part_of: Optional[List[Reference]] = None
    location: Optional[Reference] = None
    owner: Optional[Reference] = None
    reason_reference: Optional[Reference] = None