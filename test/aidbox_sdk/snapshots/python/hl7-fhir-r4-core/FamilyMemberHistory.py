from typing import Optional, List
from pydantic import *
from base.Annotation import Annotation
from base.Age import Age
from base.Period import Period
from base.CodeableConcept import CodeableConcept
from base.Range import Range
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier
from base.BackboneElement import BackboneElement

class FamilyMemberHistory_Condition(BackboneElement):
    onset_range: Optional[Range] = None
    onset_age: Optional[Age] = None
    contributed_to_death: Optional[bool] = None
    onset_period: Optional[Period] = None
    outcome: Optional[CodeableConcept] = None
    note: Optional[List[Annotation]] = None
    onset_string: Optional[str] = None
    code: CodeableConcept

class FamilyMemberHistory(DomainResource):
    deceased_age: Optional[Age] = None
    patient: Reference
    date: Optional[str] = None
    instantiates_canonical: Optional[List[str]] = None
    instantiates_uri: Optional[List[str]] = None
    sex: Optional[CodeableConcept] = None
    age_range: Optional[Range] = None
    born_string: Optional[str] = None
    deceased_boolean: Optional[bool] = None
    name: Optional[str] = None
    relationship: CodeableConcept
    reason_code: Optional[List[CodeableConcept]] = None
    note: Optional[List[Annotation]] = None
    status: str
    condition: Optional[List[FamilyMemberHistory_Condition]] = None
    identifier: Optional[List[Identifier]] = None
    age_string: Optional[str] = None
    deceased_range: Optional[Range] = None
    deceased_date: Optional[str] = None
    born_period: Optional[Period] = None
    deceased_string: Optional[str] = None
    age_age: Optional[Age] = None
    born_date: Optional[str] = None
    data_absent_reason: Optional[CodeableConcept] = None
    reason_reference: Optional[List[Reference]] = None
    estimated_age: Optional[bool] = None