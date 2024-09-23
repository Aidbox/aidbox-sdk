from typing import Optional, List
from pydantic import *
from ..base.Annotation import Annotation
from ..base.Age import Age
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.Range import Range
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class AllergyIntolerance_Reaction(BackboneElement):
    note: Optional[List[Annotation]] = None
    onset: Optional[str] = None
    severity: Optional[str] = None
    substance: Optional[CodeableConcept] = None
    description: Optional[str] = None
    exposure_route: Optional[CodeableConcept] = None
    manifestation: list[CodeableConcept] = []

class AllergyIntolerance(DomainResource):
    patient: Reference
    category: Optional[List[str]] = None
    criticality: Optional[str] = None
    clinical_status: Optional[CodeableConcept] = None
    onset_range: Optional[Range] = None
    onset_age: Optional[Age] = None
    encounter: Optional[Reference] = None
    onset_period: Optional[Period] = None
    type: Optional[str] = None
    asserter: Optional[Reference] = None
    note: Optional[List[Annotation]] = None
    recorded_date: Optional[str] = None
    onset_string: Optional[str] = None
    recorder: Optional[Reference] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    onset_date_time: Optional[str] = None
    last_occurrence: Optional[str] = None
    verification_status: Optional[CodeableConcept] = None
    reaction: Optional[List[AllergyIntolerance_Reaction]] = None