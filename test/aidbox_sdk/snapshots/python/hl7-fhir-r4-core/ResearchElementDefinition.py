from typing import Optional, List
from pydantic import *
from base.UsageContext import UsageContext
from base.Period import Period
from base.ContactDetail import ContactDetail
from base.DataRequirement import DataRequirement
from base.CodeableConcept import CodeableConcept
from base.Expression import Expression
from base.RelatedArtifact import RelatedArtifact
from base.Timing import Timing
from base.Duration import Duration
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier
from base.BackboneElement import BackboneElement

class ResearchElementDefinition_Characteristic(BackboneElement):
    study_effective_timing: Optional[Timing] = None
    exclude: Optional[bool] = None
    definition_expression: Optional[Expression] = None
    participant_effective_duration: Optional[Duration] = None
    study_effective_duration: Optional[Duration] = None
    definition_data_requirement: Optional[DataRequirement] = None
    definition_canonical: Optional[str] = None
    study_effective_group_measure: Optional[str] = None
    participant_effective_timing: Optional[Timing] = None
    participant_effective_group_measure: Optional[str] = None
    study_effective_description: Optional[str] = None
    participant_effective_date_time: Optional[str] = None
    study_effective_time_from_start: Optional[Duration] = None
    unit_of_measure: Optional[CodeableConcept] = None
    participant_effective_period: Optional[Period] = None
    participant_effective_description: Optional[str] = None
    definition_codeable_concept: Optional[CodeableConcept] = None
    usage_context: Optional[List[UsageContext]] = None
    study_effective_period: Optional[Period] = None
    participant_effective_time_from_start: Optional[Duration] = None
    study_effective_date_time: Optional[str] = None

class ResearchElementDefinition(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    endorser: Optional[List[ContactDetail]] = None
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    variable_type: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    purpose: Optional[str] = None
    subject_codeable_concept: Optional[CodeableConcept] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    type: str
    experimental: Optional[bool] = None
    topic: Optional[List[CodeableConcept]] = None
    title: Optional[str] = None
    library: Optional[List[str]] = None
    author: Optional[List[ContactDetail]] = None
    characteristic: list[ResearchElementDefinition_Characteristic] = []
    usage: Optional[str] = None
    status: str
    subtitle: Optional[str] = None
    comment: Optional[List[str]] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = None
    reviewer: Optional[List[ContactDetail]] = None
    short_title: Optional[str] = None
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = None
    contact: Optional[List[ContactDetail]] = None
    subject_reference: Optional[Reference] = None
    effective_period: Optional[Period] = None