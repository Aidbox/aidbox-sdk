from typing import Optional, List
from pydantic import *
from base.UsageContext import UsageContext
from base.Age import Age
from base.Period import Period
from base.ContactDetail import ContactDetail
from base.CodeableConcept import CodeableConcept
from base.Expression import Expression
from base.Dosage import Dosage
from base.Range import Range
from base.RelatedArtifact import RelatedArtifact
from base.Timing import Timing
from base.Quantity import Quantity
from base.Duration import Duration
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier
from base.BackboneElement import BackboneElement

class ActivityDefinition_Participant(BackboneElement):
    role: Optional[CodeableConcept] = None
    type: str

class ActivityDefinition_DynamicValue(BackboneElement):
    path: str
    expression: Expression

class ActivityDefinition(DomainResource):
    observation_result_requirement: Optional[List[Reference]] = None
    timing_range: Optional[Range] = None
    description: Optional[str] = None
    date: Optional[str] = None
    transform: Optional[str] = None
    endorser: Optional[List[ContactDetail]] = None
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    dosage: Optional[List[Dosage]] = None
    observation_requirement: Optional[List[Reference]] = None
    purpose: Optional[str] = None
    subject_codeable_concept: Optional[CodeableConcept] = None
    product_codeable_concept: Optional[CodeableConcept] = None
    name: Optional[str] = None
    product_reference: Optional[Reference] = None
    timing_period: Optional[Period] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    topic: Optional[List[CodeableConcept]] = None
    participant: Optional[List[ActivityDefinition_Participant]] = None
    title: Optional[str] = None
    library: Optional[List[str]] = None
    author: Optional[List[ContactDetail]] = None
    timing_date_time: Optional[str] = None
    timing_timing: Optional[Timing] = None
    usage: Optional[str] = None
    timing_duration: Optional[Duration] = None
    priority: Optional[str] = None
    status: str
    subtitle: Optional[str] = None
    kind: Optional[str] = None
    dynamic_value: Optional[List[ActivityDefinition_DynamicValue]] = None
    url: Optional[str] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = None
    do_not_perform: Optional[bool] = None
    body_site: Optional[List[CodeableConcept]] = None
    timing_age: Optional[Age] = None
    intent: Optional[str] = None
    specimen_requirement: Optional[List[Reference]] = None
    reviewer: Optional[List[ContactDetail]] = None
    quantity: Optional[Quantity] = None
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = None
    location: Optional[Reference] = None
    contact: Optional[List[ContactDetail]] = None
    subject_reference: Optional[Reference] = None
    profile: Optional[str] = None
    effective_period: Optional[Period] = None