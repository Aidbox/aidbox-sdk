from typing import Optional, List
from base import CodeableConcept
from base import DomainResource
from base import Ratio
from base import Reference
from base import Identifier
from base import BackboneElement

class Medication_Batch(BackboneElement):
    lot_number: Optional[str] = None
    expiration_date: Optional[str] = None

class Medication_Ingredient(BackboneElement):
    is_active: Optional[bool] = None
    strength: Optional[Ratio] = None
    item_reference: Optional[Reference] = None
    item_codeable_concept: Optional[CodeableConcept] = None

class Medication(DomainResource):
    code: Optional[CodeableConcept] = None
    form: Optional[CodeableConcept] = None
    batch: Optional[Medication_Batch] = None
    amount: Optional[Ratio] = None
    status: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    ingredient: Optional[List[Medication_Ingredient]] = None
    manufacturer: Optional[Reference] = None