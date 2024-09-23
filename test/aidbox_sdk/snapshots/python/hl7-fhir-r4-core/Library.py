from typing import Optional, List
from pydantic import *
from ..base.UsageContext import UsageContext
from ..base.Attachment import Attachment
from ..base.Period import Period
from ..base.ContactDetail import ContactDetail
from ..base.DataRequirement import DataRequirement
from ..base.CodeableConcept import CodeableConcept
from ..base.RelatedArtifact import RelatedArtifact
from ..base.DomainResource import DomainResource
from ..base.ParameterDefinition import ParameterDefinition
from ..base.Reference import Reference
from ..base.Identifier import Identifier

class Library(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    data_requirement: Optional[List[DataRequirement]] = None
    endorser: Optional[List[ContactDetail]] = None
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    purpose: Optional[str] = None
    content: Optional[List[Attachment]] = None
    subject_codeable_concept: Optional[CodeableConcept] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    type: CodeableConcept
    experimental: Optional[bool] = None
    topic: Optional[List[CodeableConcept]] = None
    title: Optional[str] = None
    author: Optional[List[ContactDetail]] = None
    usage: Optional[str] = None
    status: str
    subtitle: Optional[str] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = None
    reviewer: Optional[List[ContactDetail]] = None
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = None
    contact: Optional[List[ContactDetail]] = None
    subject_reference: Optional[Reference] = None
    parameter: Optional[List[ParameterDefinition]] = None
    effective_period: Optional[Period] = None