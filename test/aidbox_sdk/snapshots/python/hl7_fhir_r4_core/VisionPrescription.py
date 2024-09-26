from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import CodeableConcept
from base import Quantity
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class VisionPrescriptionLensSpecificationPrism(BackboneElement):
    base: str
    amount: float

@dataclass(kw_only=True)
class VisionPrescriptionLensSpecification(BackboneElement):
    sphere: Optional[float] = None
    color: Optional[str] = None
    eye: str
    diameter: Optional[float] = None
    duration: Optional[Quantity] = None
    brand: Optional[str] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    power: Optional[float] = None
    product: CodeableConcept
    cylinder: Optional[float] = None
    prism: Optional[List[VisionPrescriptionLensSpecificationPrism]] = field(default_factory=list)
    axis: Optional[int] = None
    add: Optional[float] = None
    back_curve: Optional[float] = None

@dataclass(kw_only=True)
class VisionPrescription(DomainResource):
    status: str
    created: str
    patient: Reference
    encounter: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    prescriber: Reference
    date_written: str
    lens_specification: list[VisionPrescriptionLensSpecification] = field(default_factory=list)