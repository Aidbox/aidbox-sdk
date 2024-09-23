from typing import Optional, List
from pydantic import *
from base.UsageContext import UsageContext
from base.Annotation import Annotation
from base.Period import Period
from base.ContactDetail import ContactDetail
from base.DataRequirement import DataRequirement
from base.CodeableConcept import CodeableConcept
from base.TriggerDefinition import TriggerDefinition
from base.Expression import Expression
from base.RelatedArtifact import RelatedArtifact
from base.Timing import Timing
from base.Duration import Duration
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier
from base.BackboneElement import BackboneElement

class EvidenceVariable_Characteristic(BackboneElement):
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
    usage_context: Optional[List[UsageContext]] = None

class EvidenceVariable(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    endorser: Optional[List[ContactDetail]] = None
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    type: Optional[str] = None
    topic: Optional[List[CodeableConcept]] = None
    title: Optional[str] = None
    note: Optional[List[Annotation]] = None
    author: Optional[List[ContactDetail]] = None
    characteristic: list[EvidenceVariable_Characteristic] = []
    status: str
    subtitle: Optional[str] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = None
    reviewer: Optional[List[ContactDetail]] = None
    short_title: Optional[str] = None
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = None
    contact: Optional[List[ContactDetail]] = None
    effective_period: Optional[Period] = None