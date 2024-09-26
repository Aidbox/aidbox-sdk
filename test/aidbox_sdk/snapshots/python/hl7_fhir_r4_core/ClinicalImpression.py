from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ClinicalImpressionInvestigation(BackboneElement):
    code: CodeableConcept
    item: Optional[List[Reference]] = field(default_factory=list)

@dataclass(kw_only=True)
class ClinicalImpressionFinding(BackboneElement):
    basis: Optional[str] = None
    item_reference: Optional[Reference] = None
    item_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class ClinicalImpression(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    investigation: Optional[List[ClinicalImpressionInvestigation]] = field(default_factory=list)
    protocol: Optional[List[str]] = field(default_factory=list)
    assessor: Optional[Reference] = None
    supporting_info: Optional[List[Reference]] = field(default_factory=list)
    encounter: Optional[Reference] = None
    problem: Optional[List[Reference]] = field(default_factory=list)
    status_reason: Optional[CodeableConcept] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    summary: Optional[str] = None
    effective_date_time: Optional[str] = None
    prognosis_codeable_concept: Optional[List[CodeableConcept]] = field(default_factory=list)
    status: str
    previous: Optional[Reference] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    finding: Optional[List[ClinicalImpressionFinding]] = field(default_factory=list)
    prognosis_reference: Optional[List[Reference]] = field(default_factory=list)
    subject: Reference
    effective_period: Optional[Period] = None