from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import CodeableConcept
from base import Coding
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ImagingStudySeriesInstance(BackboneElement):
    uid: str
    title: Optional[str] = None
    number: Optional[int] = None
    sop_class: Coding

@dataclass(kw_only=True)
class ImagingStudySeriesPerformer(BackboneElement):
    actor: Reference
    function: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class ImagingStudySeries(BackboneElement):
    description: Optional[str] = None
    started: Optional[str] = None
    laterality: Optional[Coding] = None
    instance: Optional[List[ImagingStudySeriesInstance]] = field(default_factory=list)
    number: Optional[int] = None
    uid: str
    specimen: Optional[List[Reference]] = field(default_factory=list)
    modality: Coding
    body_site: Optional[Coding] = None
    endpoint: Optional[List[Reference]] = field(default_factory=list)
    number_of_instances: Optional[int] = None
    performer: Optional[List[ImagingStudySeriesPerformer]] = field(default_factory=list)

@dataclass(kw_only=True)
class ImagingStudy(DomainResource):
    description: Optional[str] = None
    started: Optional[str] = None
    number_of_series: Optional[int] = None
    interpreter: Optional[List[Reference]] = field(default_factory=list)
    series: Optional[List[ImagingStudySeries]] = field(default_factory=list)
    procedure_reference: Optional[Reference] = None
    encounter: Optional[Reference] = None
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    modality: Optional[List[Coding]] = field(default_factory=list)
    note: Optional[List[Annotation]] = field(default_factory=list)
    referrer: Optional[Reference] = None
    status: str
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    based_on: Optional[List[Reference]] = field(default_factory=list)
    location: Optional[Reference] = None
    endpoint: Optional[List[Reference]] = field(default_factory=list)
    subject: Reference
    number_of_instances: Optional[int] = None
    reason_reference: Optional[List[Reference]] = field(default_factory=list)
    procedure_code: Optional[List[CodeableConcept]] = field(default_factory=list)