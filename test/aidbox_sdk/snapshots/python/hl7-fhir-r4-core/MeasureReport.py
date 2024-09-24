from typing import Optional, List
from base import Period
from base import CodeableConcept
from base import Quantity
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

class MeasureReport_Group_Population(BackboneElement):
    code: Optional[CodeableConcept] = None
    count: Optional[int] = None
    subject_results: Optional[Reference] = None

class MeasureReport_Group_Stratifier_Stratum_Component(BackboneElement):
    code: CodeableConcept
    value: CodeableConcept

class MeasureReport_Group_Stratifier_Stratum_Population(BackboneElement):
    code: Optional[CodeableConcept] = None
    count: Optional[int] = None
    subject_results: Optional[Reference] = None

class MeasureReport_Group_Stratifier_Stratum(BackboneElement):
    value: Optional[CodeableConcept] = None
    component: Optional[List[MeasureReport_Group_Stratifier_Stratum_Component]] = None
    population: Optional[List[MeasureReport_Group_Stratifier_Stratum_Population]] = None
    measure_score: Optional[Quantity] = None

class MeasureReport_Group_Stratifier(BackboneElement):
    code: Optional[List[CodeableConcept]] = None
    stratum: Optional[List[MeasureReport_Group_Stratifier_Stratum]] = None

class MeasureReport_Group(BackboneElement):
    code: Optional[CodeableConcept] = None
    population: Optional[List[MeasureReport_Group_Population]] = None
    stratifier: Optional[List[MeasureReport_Group_Stratifier]] = None
    measure_score: Optional[Quantity] = None

class MeasureReport(DomainResource):
    evaluated_resource: Optional[List[Reference]] = None
    date: Optional[str] = None
    group: Optional[List[MeasureReport_Group]] = None
    type: str
    measure: str
    reporter: Optional[Reference] = None
    status: str
    identifier: Optional[List[Identifier]] = None
    period: Period
    improvement_notation: Optional[CodeableConcept] = None
    subject: Optional[Reference] = None