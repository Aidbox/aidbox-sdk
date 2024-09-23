from typing import Optional, List
from pydantic import *
from ..base.Annotation import Annotation
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class ClinicalImpression_Investigation(BackboneElement):
    code: CodeableConcept
    item: Optional[List[Reference]] = None

class ClinicalImpression_Finding(BackboneElement):
    basis: Optional[str] = None
    item_reference: Optional[Reference] = None
    item_codeable_concept: Optional[CodeableConcept] = None

class ClinicalImpression(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    investigation: Optional[List[ClinicalImpression_Investigation]] = None
    protocol: Optional[List[str]] = None
    assessor: Optional[Reference] = None
    supporting_info: Optional[List[Reference]] = None
    encounter: Optional[Reference] = None
    problem: Optional[List[Reference]] = None
    status_reason: Optional[CodeableConcept] = None
    note: Optional[List[Annotation]] = None
    summary: Optional[str] = None
    effective_date_time: Optional[str] = None
    prognosis_codeable_concept: Optional[List[CodeableConcept]] = None
    status: str
    previous: Optional[Reference] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    finding: Optional[List[ClinicalImpression_Finding]] = None
    prognosis_reference: Optional[List[Reference]] = None
    subject: Reference
    effective_period: Optional[Period] = None