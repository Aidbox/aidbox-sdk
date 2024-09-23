from typing import Optional, List
from pydantic import *
from ..base.Annotation import Annotation
from ..base.CodeableConcept import CodeableConcept
from ..base.Timing import Timing
from ..base.Quantity import Quantity
from ..base.DomainResource import DomainResource
from ..base.Ratio import Ratio
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class NutritionOrder_OralDiet_Texture(BackboneElement):
    food_type: Optional[CodeableConcept] = None
    modifier: Optional[CodeableConcept] = None

class NutritionOrder_OralDiet_Nutrient(BackboneElement):
    amount: Optional[Quantity] = None
    modifier: Optional[CodeableConcept] = None

class NutritionOrder_OralDiet(BackboneElement):
    type: Optional[List[CodeableConcept]] = None
    texture: Optional[List[NutritionOrder_OralDiet_Texture]] = None
    nutrient: Optional[List[NutritionOrder_OralDiet_Nutrient]] = None
    schedule: Optional[List[Timing]] = None
    instruction: Optional[str] = None
    fluid_consistency_type: Optional[List[CodeableConcept]] = None

class NutritionOrder_EnteralFormula_Administration(BackboneElement):
    quantity: Optional[Quantity] = None
    schedule: Optional[Timing] = None
    rate_ratio: Optional[Ratio] = None
    rate_quantity: Optional[Quantity] = None

class NutritionOrder_EnteralFormula(BackboneElement):
    additive_type: Optional[CodeableConcept] = None
    max_volume_to_deliver: Optional[Quantity] = None
    base_formula_type: Optional[CodeableConcept] = None
    routeof_administration: Optional[CodeableConcept] = None
    additive_product_name: Optional[str] = None
    caloric_density: Optional[Quantity] = None
    administration_instruction: Optional[str] = None
    administration: Optional[List[NutritionOrder_EnteralFormula_Administration]] = None
    base_formula_product_name: Optional[str] = None

class NutritionOrder_Supplement(BackboneElement):
    type: Optional[CodeableConcept] = None
    quantity: Optional[Quantity] = None
    schedule: Optional[List[Timing]] = None
    instruction: Optional[str] = None
    product_name: Optional[str] = None

class NutritionOrder(DomainResource):
    patient: Reference
    oral_diet: Optional[NutritionOrder_OralDiet] = None
    instantiates_canonical: Optional[List[str]] = None
    instantiates_uri: Optional[List[str]] = None
    instantiates: Optional[List[str]] = None
    encounter: Optional[Reference] = None
    note: Optional[List[Annotation]] = None
    date_time: str
    enteral_formula: Optional[NutritionOrder_EnteralFormula] = None
    food_preference_modifier: Optional[List[CodeableConcept]] = None
    status: str
    exclude_food_modifier: Optional[List[CodeableConcept]] = None
    identifier: Optional[List[Identifier]] = None
    intent: str
    orderer: Optional[Reference] = None
    supplement: Optional[List[NutritionOrder_Supplement]] = None
    allergy_intolerance: Optional[List[Reference]] = None