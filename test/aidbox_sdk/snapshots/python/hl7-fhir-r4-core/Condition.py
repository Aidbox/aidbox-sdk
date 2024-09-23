from typing import Optional, List
from pydantic import *
from ..base import *

class Condition_Stage(BackboneElement):
    type: Optional[CodeableConcept] = None
    summary: Optional[CodeableConcept] = None
    assessment: Optional[List[Reference]] = None

class Condition_Evidence(BackboneElement):
    code: Optional[List[CodeableConcept]] = None
    detail: Optional[List[Reference]] = None

class Condition(DomainResource):
    category: Optional[List[CodeableConcept]] = None
    clinical_status: Optional[CodeableConcept] = None
    abatement_age: Optional[Age] = None
    onset_range: Optional[Range] = None
    onset_age: Optional[Age] = None
    stage: Optional[List[Condition_Stage]] = None
    encounter: Optional[Reference] = None
    evidence: Optional[List[Condition_Evidence]] = None
    onset_period: Optional[Period] = None
    abatement_period: Optional[Period] = None
    asserter: Optional[Reference] = None
    note: Optional[List[Annotation]] = None
    abatement_string: Optional[str] = None
    abatement_range: Optional[Range] = None
    recorded_date: Optional[str] = None
    onset_string: Optional[str] = None
    recorder: Optional[Reference] = None
    severity: Optional[CodeableConcept] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    onset_date_time: Optional[str] = None
    body_site: Optional[List[CodeableConcept]] = None
    abatement_date_time: Optional[str] = None
    verification_status: Optional[CodeableConcept] = None
    subject: Reference