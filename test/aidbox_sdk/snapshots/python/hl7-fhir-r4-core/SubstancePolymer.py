from typing import Optional, List
from pydantic import *
from ..base import *

class SubstancePolymer_Repeat_RepeatUnit_DegreeOfPolymerisation(BackboneElement):
    amount: Optional[SubstanceAmount] = None
    degree: Optional[CodeableConcept] = None

class SubstancePolymer_Repeat_RepeatUnit_StructuralRepresentation(BackboneElement):
    type: Optional[CodeableConcept] = None
    attachment: Optional[Attachment] = None
    representation: Optional[str] = None

class SubstancePolymer_Repeat_RepeatUnit(BackboneElement):
    amount: Optional[SubstanceAmount] = None
    repeat_unit: Optional[str] = None
    degree_of_polymerisation: Optional[List[SubstancePolymer_Repeat_RepeatUnit_DegreeOfPolymerisation]] = None
    structural_representation: Optional[List[SubstancePolymer_Repeat_RepeatUnit_StructuralRepresentation]] = None
    orientation_of_polymerisation: Optional[CodeableConcept] = None

class SubstancePolymer_Repeat(BackboneElement):
    repeat_unit: Optional[List[SubstancePolymer_Repeat_RepeatUnit]] = None
    number_of_units: Optional[int] = None
    repeat_unit_amount_type: Optional[CodeableConcept] = None
    average_molecular_formula: Optional[str] = None

class SubstancePolymer_MonomerSet_StartingMaterial(BackboneElement):
    type: Optional[CodeableConcept] = None
    amount: Optional[SubstanceAmount] = None
    material: Optional[CodeableConcept] = None
    is_defining: Optional[bool] = None

class SubstancePolymer_MonomerSet(BackboneElement):
    ratio_type: Optional[CodeableConcept] = None
    starting_material: Optional[List[SubstancePolymer_MonomerSet_StartingMaterial]] = None

class SubstancePolymer(DomainResource):
    class: Optional[CodeableConcept] = None
    repeat: Optional[List[SubstancePolymer_Repeat]] = None
    geometry: Optional[CodeableConcept] = None
    monomer_set: Optional[List[SubstancePolymer_MonomerSet]] = None
    modification: Optional[List[str]] = None
    copolymer_connectivity: Optional[List[CodeableConcept]] = None