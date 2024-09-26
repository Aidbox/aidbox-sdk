from typing import Optional, List
from dataclasses import dataclass, field
from base import Attachment
from base import CodeableConcept
from base import SubstanceAmount
from base import DomainResource
from base import BackboneElement

@dataclass(kw_only=True)
class SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisation(BackboneElement):
    amount: Optional[SubstanceAmount] = None
    degree: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class SubstancePolymerRepeatRepeatUnitStructuralRepresentation(BackboneElement):
    type: Optional[CodeableConcept] = None
    attachment: Optional[Attachment] = None
    representation: Optional[str] = None

@dataclass(kw_only=True)
class SubstancePolymerRepeatRepeatUnit(BackboneElement):
    amount: Optional[SubstanceAmount] = None
    repeat_unit: Optional[str] = None
    degree_of_polymerisation: Optional[List[SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisation]] = field(default_factory=list)
    structural_representation: Optional[List[SubstancePolymerRepeatRepeatUnitStructuralRepresentation]] = field(default_factory=list)
    orientation_of_polymerisation: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class SubstancePolymerRepeat(BackboneElement):
    repeat_unit: Optional[List[SubstancePolymerRepeatRepeatUnit]] = field(default_factory=list)
    number_of_units: Optional[int] = None
    repeat_unit_amount_type: Optional[CodeableConcept] = None
    average_molecular_formula: Optional[str] = None

@dataclass(kw_only=True)
class SubstancePolymerMonomerSetStartingMaterial(BackboneElement):
    type: Optional[CodeableConcept] = None
    amount: Optional[SubstanceAmount] = None
    material: Optional[CodeableConcept] = None
    is_defining: Optional[bool] = None

@dataclass(kw_only=True)
class SubstancePolymerMonomerSet(BackboneElement):
    ratio_type: Optional[CodeableConcept] = None
    starting_material: Optional[List[SubstancePolymerMonomerSetStartingMaterial]] = field(default_factory=list)

@dataclass(kw_only=True)
class SubstancePolymer(DomainResource):
    class_: Optional[CodeableConcept] = None
    repeat: Optional[List[SubstancePolymerRepeat]] = field(default_factory=list)
    geometry: Optional[CodeableConcept] = None
    monomer_set: Optional[List[SubstancePolymerMonomerSet]] = field(default_factory=list)
    modification: Optional[List[str]] = field(default_factory=list)
    copolymer_connectivity: Optional[List[CodeableConcept]] = field(default_factory=list)