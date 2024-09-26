from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import ProdCharacteristic
from base import Quantity
from base import DomainResource
from base import Reference

@dataclass(kw_only=True)
class MedicinalProductManufactured(DomainResource):
    quantity: Quantity
    ingredient: Optional[List[Reference]] = field(default_factory=list)
    manufacturer: Optional[List[Reference]] = field(default_factory=list)
    unit_of_presentation: Optional[CodeableConcept] = None
    manufactured_dose_form: CodeableConcept
    other_characteristics: Optional[List[CodeableConcept]] = field(default_factory=list)
    physical_characteristics: Optional[ProdCharacteristic] = None