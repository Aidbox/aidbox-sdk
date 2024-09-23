from typing import Optional, List
from pydantic import *
from base.Annotation import Annotation
from base.CodeableConcept import CodeableConcept
from base.Quantity import Quantity
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier
from base.BackboneElement import BackboneElement

class VisionPrescription_LensSpecification_Prism(BackboneElement):
    base: str
    amount: float

class VisionPrescription_LensSpecification(BackboneElement):
    sphere: Optional[float] = None
    color: Optional[str] = None
    eye: str
    diameter: Optional[float] = None
    duration: Optional[Quantity] = None
    brand: Optional[str] = None
    note: Optional[List[Annotation]] = None
    power: Optional[float] = None
    product: CodeableConcept
    cylinder: Optional[float] = None
    prism: Optional[List[VisionPrescription_LensSpecification_Prism]] = None
    axis: Optional[int] = None
    add: Optional[float] = None
    back_curve: Optional[float] = None

class VisionPrescription(DomainResource):
    status: str
    created: str
    patient: Reference
    encounter: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = None
    prescriber: Reference
    date_written: str
    lens_specification: list[VisionPrescription_LensSpecification] = []