from pydantic import *
from typing import Optional, List
from ..base import *

class MedicinalProductManufactured(DomainResource):
    quantity: Quantity
    ingredient: Optional[List[Reference]] = None
    manufacturer: Optional[List[Reference]] = None
    unit_of_presentation: Optional[CodeableConcept] = None
    manufactured_dose_form: CodeableConcept
    other_characteristics: Optional[List[CodeableConcept]] = None
    physical_characteristics: Optional[ProdCharacteristic] = None