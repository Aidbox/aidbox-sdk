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
class FamilyMemberHistoryCondition(BackboneElement):
    onset_range: Optional[Range] = None
    onset_age: Optional[Age] = None
    contributed_to_death: Optional[bool] = None
    onset_period: Optional[Period] = None
    outcome: Optional[CodeableConcept] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    onset_string: Optional[str] = None
    code: CodeableConcept

@dataclass(kw_only=True)
class FamilyMemberHistory(DomainResource):
    deceased_age: Optional[Age] = None
    patient: Reference
    date: Optional[str] = None
    instantiates_canonical: Optional[List[str]] = field(default_factory=list)
    instantiates_uri: Optional[List[str]] = field(default_factory=list)
    sex: Optional[CodeableConcept] = None
    age_range: Optional[Range] = None
    born_string: Optional[str] = None
    deceased_boolean: Optional[bool] = None
    name: Optional[str] = None
    relationship: CodeableConcept
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    note: Optional[List[Annotation]] = field(default_factory=list)
    status: str
    condition: Optional[List[FamilyMemberHistoryCondition]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    age_string: Optional[str] = None
    deceased_range: Optional[Range] = None
    deceased_date: Optional[str] = None
    born_period: Optional[Period] = None
    deceased_string: Optional[str] = None
    age_age: Optional[Age] = None
    born_date: Optional[str] = None
    data_absent_reason: Optional[CodeableConcept] = None
    reason_reference: Optional[List[Reference]] = field(default_factory=list)
    estimated_age: Optional[bool] = None