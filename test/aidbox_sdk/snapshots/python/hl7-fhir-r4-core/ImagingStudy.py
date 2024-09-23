from typing import Optional, List
from pydantic import *
from ..base.Annotation import Annotation
from ..base.CodeableConcept import CodeableConcept
from ..base.Coding import Coding
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class ImagingStudy_Series_Instance(BackboneElement):
    uid: str
    title: Optional[str] = None
    number: Optional[int] = None
    sop_class: Coding

class ImagingStudy_Series_Performer(BackboneElement):
    actor: Reference
    function: Optional[CodeableConcept] = None

class ImagingStudy_Series(BackboneElement):
    description: Optional[str] = None
    started: Optional[str] = None
    laterality: Optional[Coding] = None
    instance: Optional[List[ImagingStudy_Series_Instance]] = None
    number: Optional[int] = None
    uid: str
    specimen: Optional[List[Reference]] = None
    modality: Coding
    body_site: Optional[Coding] = None
    endpoint: Optional[List[Reference]] = None
    number_of_instances: Optional[int] = None
    performer: Optional[List[ImagingStudy_Series_Performer]] = None

class ImagingStudy(DomainResource):
    description: Optional[str] = None
    started: Optional[str] = None
    number_of_series: Optional[int] = None
    interpreter: Optional[List[Reference]] = None
    series: Optional[List[ImagingStudy_Series]] = None
    procedure_reference: Optional[Reference] = None
    encounter: Optional[Reference] = None
    reason_code: Optional[List[CodeableConcept]] = None
    modality: Optional[List[Coding]] = None
    note: Optional[List[Annotation]] = None
    referrer: Optional[Reference] = None
    status: str
    identifier: Optional[List[Identifier]] = None
    based_on: Optional[List[Reference]] = None
    location: Optional[Reference] = None
    endpoint: Optional[List[Reference]] = None
    subject: Reference
    number_of_instances: Optional[int] = None
    reason_reference: Optional[List[Reference]] = None
    procedure_code: Optional[List[CodeableConcept]] = None