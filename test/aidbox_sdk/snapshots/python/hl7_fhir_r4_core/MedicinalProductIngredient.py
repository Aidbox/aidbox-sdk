from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import DomainResource
from base import Ratio
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class MedicinalProductIngredientSubstance(BackboneElement):
    code: CodeableConcept
    strength: Optional[List[Reference]] = field(default_factory=list)

@dataclass(kw_only=True)
class MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrength(BackboneElement):
    country: Optional[List[CodeableConcept]] = field(default_factory=list)
    strength: Ratio
    substance: Optional[CodeableConcept] = None
    measurement_point: Optional[str] = None
    strength_low_limit: Optional[Ratio] = None

@dataclass(kw_only=True)
class MedicinalProductIngredientSpecifiedSubstanceStrength(BackboneElement):
    country: Optional[List[CodeableConcept]] = field(default_factory=list)
    presentation: Ratio
    concentration: Optional[Ratio] = None
    measurement_point: Optional[str] = None
    reference_strength: Optional[List[MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrength]] = field(default_factory=list)
    presentation_low_limit: Optional[Ratio] = None
    concentration_low_limit: Optional[Ratio] = None

@dataclass(kw_only=True)
class MedicinalProductIngredientSpecifiedSubstance(BackboneElement):
    code: CodeableConcept
    group: CodeableConcept
    strength: Optional[List[MedicinalProductIngredientSpecifiedSubstanceStrength]] = field(default_factory=list)
    confidentiality: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class MedicinalProductIngredient(DomainResource):
    role: CodeableConcept
    substance: Optional[MedicinalProductIngredientSubstance] = None
    identifier: Optional[Identifier] = None
    manufacturer: Optional[List[Reference]] = field(default_factory=list)
    specified_substance: Optional[List[MedicinalProductIngredientSpecifiedSubstance]] = field(default_factory=list)
    allergenic_indicator: Optional[bool] = None