from typing import Optional, List
from base import CodeableConcept
from base import ProdCharacteristic
from base import Quantity
from base import DomainResource
from base import Reference

class MedicinalProductManufactured(DomainResource):
    quantity: Quantity
    ingredient: Optional[List[Reference]] = None
    manufacturer: Optional[List[Reference]] = None
    unit_of_presentation: Optional[CodeableConcept] = None
    manufactured_dose_form: CodeableConcept
    other_characteristics: Optional[List[CodeableConcept]] = None
    physical_characteristics: Optional[ProdCharacteristic] = None