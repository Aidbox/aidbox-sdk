from typing import Optional, List
from base import CodeableConcept
from base import DomainResource
from base import Ratio
from base import Reference
from base import Identifier
from base import BackboneElement

class MedicinalProductIngredient_Substance(BackboneElement):
    code: CodeableConcept
    strength: Optional[List[Reference]] = None

class MedicinalProductIngredient_SpecifiedSubstance_Strength_ReferenceStrength(BackboneElement):
    country: Optional[List[CodeableConcept]] = None
    strength: Ratio
    substance: Optional[CodeableConcept] = None
    measurement_point: Optional[str] = None
    strength_low_limit: Optional[Ratio] = None

class MedicinalProductIngredient_SpecifiedSubstance_Strength(BackboneElement):
    country: Optional[List[CodeableConcept]] = None
    presentation: Ratio
    concentration: Optional[Ratio] = None
    measurement_point: Optional[str] = None
    reference_strength: Optional[List[MedicinalProductIngredient_SpecifiedSubstance_Strength_ReferenceStrength]] = None
    presentation_low_limit: Optional[Ratio] = None
    concentration_low_limit: Optional[Ratio] = None

class MedicinalProductIngredient_SpecifiedSubstance(BackboneElement):
    code: CodeableConcept
    group: CodeableConcept
    strength: Optional[List[MedicinalProductIngredient_SpecifiedSubstance_Strength]] = None
    confidentiality: Optional[CodeableConcept] = None

class MedicinalProductIngredient(DomainResource):
    role: CodeableConcept
    substance: Optional[MedicinalProductIngredient_Substance] = None
    identifier: Optional[Identifier] = None
    manufacturer: Optional[List[Reference]] = None
    specified_substance: Optional[List[MedicinalProductIngredient_SpecifiedSubstance]] = None
    allergenic_indicator: Optional[bool] = None