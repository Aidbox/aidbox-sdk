from typing import Optional, List
from pydantic import *
from ..base.CodeableConcept import CodeableConcept
from ..base.ProdCharacteristic import ProdCharacteristic
from ..base.Quantity import Quantity
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference

class MedicinalProductManufactured(DomainResource):
    quantity: Quantity
    ingredient: Optional[List[Reference]] = None
    manufacturer: Optional[List[Reference]] = None
    unit_of_presentation: Optional[CodeableConcept] = None
    manufactured_dose_form: CodeableConcept
    other_characteristics: Optional[List[CodeableConcept]] = None
    physical_characteristics: Optional[ProdCharacteristic] = None