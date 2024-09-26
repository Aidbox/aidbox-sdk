from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import Quantity
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class MeasureReportGroupPopulation(BackboneElement):
    code: Optional[CodeableConcept] = None
    count: Optional[int] = None
    subject_results: Optional[Reference] = None

@dataclass(kw_only=True)
class MeasureReportGroupStratifierStratumComponent(BackboneElement):
    code: CodeableConcept
    value: CodeableConcept

@dataclass(kw_only=True)
class MeasureReportGroupStratifierStratumPopulation(BackboneElement):
    code: Optional[CodeableConcept] = None
    count: Optional[int] = None
    subject_results: Optional[Reference] = None

@dataclass(kw_only=True)
class MeasureReportGroupStratifierStratum(BackboneElement):
    value: Optional[CodeableConcept] = None
    component: Optional[List[MeasureReportGroupStratifierStratumComponent]] = field(default_factory=list)
    population: Optional[List[MeasureReportGroupStratifierStratumPopulation]] = field(default_factory=list)
    measure_score: Optional[Quantity] = None

@dataclass(kw_only=True)
class MeasureReportGroupStratifier(BackboneElement):
    code: Optional[List[CodeableConcept]] = field(default_factory=list)
    stratum: Optional[List[MeasureReportGroupStratifierStratum]] = field(default_factory=list)

@dataclass(kw_only=True)
class MeasureReportGroup(BackboneElement):
    code: Optional[CodeableConcept] = None
    population: Optional[List[MeasureReportGroupPopulation]] = field(default_factory=list)
    stratifier: Optional[List[MeasureReportGroupStratifier]] = field(default_factory=list)
    measure_score: Optional[Quantity] = None

@dataclass(kw_only=True)
class MeasureReport(DomainResource):
    evaluated_resource: Optional[List[Reference]] = field(default_factory=list)
    date: Optional[str] = None
    group: Optional[List[MeasureReportGroup]] = field(default_factory=list)
    type: str
    measure: str
    reporter: Optional[Reference] = None
    status: str
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    period: Period
    improvement_notation: Optional[CodeableConcept] = None
    subject: Optional[Reference] = None