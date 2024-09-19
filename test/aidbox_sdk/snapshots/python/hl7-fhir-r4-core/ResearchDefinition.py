from pydantic import *
from typing import Optional, List
from ..base import *

class ResearchDefinition(DomainResource):
    description: Optional[str] = None
    exposure_alternative: Optional[Reference] = None
    date: Optional[str] = None
    endorser: Optional[List[ContactDetail]] = None
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    purpose: Optional[str] = None
    subject_codeable_concept: Optional[CodeableConcept] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    outcome: Optional[Reference] = None
    topic: Optional[List[CodeableConcept]] = None
    title: Optional[str] = None
    library: Optional[List[str]] = None
    author: Optional[List[ContactDetail]] = None
    usage: Optional[str] = None
    status: str
    subtitle: Optional[str] = None
    population: Reference
    comment: Optional[List[str]] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = None
    reviewer: Optional[List[ContactDetail]] = None
    short_title: Optional[str] = None
    exposure: Optional[Reference] = None
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = None
    contact: Optional[List[ContactDetail]] = None
    subject_reference: Optional[Reference] = None
    effective_period: Optional[Period] = None