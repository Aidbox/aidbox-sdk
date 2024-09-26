from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Age
from base import Period
from base import CodeableConcept
from base import Range
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ConditionStage(BackboneElement):
    type: Optional[CodeableConcept] = None
    summary: Optional[CodeableConcept] = None
    assessment: Optional[List[Reference]] = field(default_factory=list)

@dataclass(kw_only=True)
class ConditionEvidence(BackboneElement):
    code: Optional[List[CodeableConcept]] = field(default_factory=list)
    detail: Optional[List[Reference]] = field(default_factory=list)

@dataclass(kw_only=True)
class Condition(DomainResource):
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    clinical_status: Optional[CodeableConcept] = None
    abatement_age: Optional[Age] = None
    onset_range: Optional[Range] = None
    onset_age: Optional[Age] = None
    stage: Optional[List[ConditionStage]] = field(default_factory=list)
    encounter: Optional[Reference] = None
    evidence: Optional[List[ConditionEvidence]] = field(default_factory=list)
    onset_period: Optional[Period] = None
    abatement_period: Optional[Period] = None
    asserter: Optional[Reference] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    abatement_string: Optional[str] = None
    abatement_range: Optional[Range] = None
    recorded_date: Optional[str] = None
    onset_string: Optional[str] = None
    recorder: Optional[Reference] = None
    severity: Optional[CodeableConcept] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    onset_date_time: Optional[str] = None
    body_site: Optional[List[CodeableConcept]] = field(default_factory=list)
    abatement_date_time: Optional[str] = None
    verification_status: Optional[CodeableConcept] = None
    subject: Reference