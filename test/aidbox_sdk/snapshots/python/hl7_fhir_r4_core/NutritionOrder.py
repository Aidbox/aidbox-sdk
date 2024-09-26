from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import CodeableConcept
from base import Timing
from base import Quantity
from base import DomainResource
from base import Ratio
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class NutritionOrderOralDietTexture(BackboneElement):
    food_type: Optional[CodeableConcept] = None
    modifier: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class NutritionOrderOralDietNutrient(BackboneElement):
    amount: Optional[Quantity] = None
    modifier: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class NutritionOrderOralDiet(BackboneElement):
    type: Optional[List[CodeableConcept]] = field(default_factory=list)
    texture: Optional[List[NutritionOrderOralDietTexture]] = field(default_factory=list)
    nutrient: Optional[List[NutritionOrderOralDietNutrient]] = field(default_factory=list)
    schedule: Optional[List[Timing]] = field(default_factory=list)
    instruction: Optional[str] = None
    fluid_consistency_type: Optional[List[CodeableConcept]] = field(default_factory=list)

@dataclass(kw_only=True)
class NutritionOrderEnteralFormulaAdministration(BackboneElement):
    quantity: Optional[Quantity] = None
    schedule: Optional[Timing] = None
    rate_ratio: Optional[Ratio] = None
    rate_quantity: Optional[Quantity] = None

@dataclass(kw_only=True)
class NutritionOrderEnteralFormula(BackboneElement):
    additive_type: Optional[CodeableConcept] = None
    max_volume_to_deliver: Optional[Quantity] = None
    base_formula_type: Optional[CodeableConcept] = None
    routeof_administration: Optional[CodeableConcept] = None
    additive_product_name: Optional[str] = None
    caloric_density: Optional[Quantity] = None
    administration_instruction: Optional[str] = None
    administration: Optional[List[NutritionOrderEnteralFormulaAdministration]] = field(default_factory=list)
    base_formula_product_name: Optional[str] = None

@dataclass(kw_only=True)
class NutritionOrderSupplement(BackboneElement):
    type: Optional[CodeableConcept] = None
    quantity: Optional[Quantity] = None
    schedule: Optional[List[Timing]] = field(default_factory=list)
    instruction: Optional[str] = None
    product_name: Optional[str] = None

@dataclass(kw_only=True)
class NutritionOrder(DomainResource):
    patient: Reference
    oral_diet: Optional[NutritionOrderOralDiet] = None
    instantiates_canonical: Optional[List[str]] = field(default_factory=list)
    instantiates_uri: Optional[List[str]] = field(default_factory=list)
    instantiates: Optional[List[str]] = field(default_factory=list)
    encounter: Optional[Reference] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    date_time: str
    enteral_formula: Optional[NutritionOrderEnteralFormula] = None
    food_preference_modifier: Optional[List[CodeableConcept]] = field(default_factory=list)
    status: str
    exclude_food_modifier: Optional[List[CodeableConcept]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    intent: str
    orderer: Optional[Reference] = None
    supplement: Optional[List[NutritionOrderSupplement]] = field(default_factory=list)
    allergy_intolerance: Optional[List[Reference]] = field(default_factory=list)