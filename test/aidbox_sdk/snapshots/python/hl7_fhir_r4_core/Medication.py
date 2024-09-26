from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import DomainResource
from base import Ratio
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class MedicationBatch(BackboneElement):
    lot_number: Optional[str] = None
    expiration_date: Optional[str] = None

@dataclass(kw_only=True)
class MedicationIngredient(BackboneElement):
    is_active: Optional[bool] = None
    strength: Optional[Ratio] = None
    item_reference: Optional[Reference] = None
    item_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class Medication(DomainResource):
    code: Optional[CodeableConcept] = None
    form: Optional[CodeableConcept] = None
    batch: Optional[MedicationBatch] = None
    amount: Optional[Ratio] = None
    status: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    ingredient: Optional[List[MedicationIngredient]] = field(default_factory=list)
    manufacturer: Optional[Reference] = None