from pydantic import *
from typing import Optional, List
from ..base import *

class SubstanceSpecification_Property(BackboneElement):
    category: Optional[CodeableConcept] = None
    defining_substance_codeable_concept: Optional[CodeableConcept] = None
    defining_substance_reference: Optional[Reference] = None
    amount_quantity: Optional[Quantity] = None
    amount_string: Optional[str] = None
    code: Optional[CodeableConcept] = None
    parameters: Optional[str] = None

class SubstanceSpecification_Name_Official(BackboneElement):
    date: Optional[str] = None
    status: Optional[CodeableConcept] = None
    authority: Optional[CodeableConcept] = None

class SubstanceSpecification_Name(BackboneElement):
    official: Optional[List[SubstanceSpecification_Name_Official]] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    name: str
    type: Optional[CodeableConcept] = None
    source: Optional[List[Reference]] = None
    status: Optional[CodeableConcept] = None
    language: Optional[List[CodeableConcept]] = None
    synonym: Optional[List[Reference]] = None
    translation: Optional[List[Reference]] = None
    preferred: Optional[bool] = None
    domain: Optional[List[CodeableConcept]] = None

class SubstanceSpecification_Relationship(BackboneElement):
    substance_codeable_concept: Optional[CodeableConcept] = None
    amount_ratio_low_limit: Optional[Ratio] = None
    amount_type: Optional[CodeableConcept] = None
    relationship: Optional[CodeableConcept] = None
    source: Optional[List[Reference]] = None
    substance_reference: Optional[Reference] = None
    amount_ratio: Optional[Ratio] = None
    amount_quantity: Optional[Quantity] = None
    amount_string: Optional[str] = None
    is_defining: Optional[bool] = None
    amount_range: Optional[Range] = None

class SubstanceSpecification_Moiety(BackboneElement):
    role: Optional[CodeableConcept] = None
    name: Optional[str] = None
    molecular_formula: Optional[str] = None
    amount_quantity: Optional[Quantity] = None
    amount_string: Optional[str] = None
    optical_activity: Optional[CodeableConcept] = None
    identifier: Optional[Identifier] = None
    stereochemistry: Optional[CodeableConcept] = None

class SubstanceSpecification_Structure_Isotope_MolecularWeight(BackboneElement):
    type: Optional[CodeableConcept] = None
    amount: Optional[Quantity] = None
    method: Optional[CodeableConcept] = None

class SubstanceSpecification_Structure_Isotope(BackboneElement):
    name: Optional[CodeableConcept] = None
    half_life: Optional[Quantity] = None
    identifier: Optional[Identifier] = None
    substitution: Optional[CodeableConcept] = None
    molecular_weight: Optional[SubstanceSpecification_Structure_Isotope_MolecularWeight] = None

class SubstanceSpecification_Structure_Representation(BackboneElement):
    type: Optional[CodeableConcept] = None
    attachment: Optional[Attachment] = None
    representation: Optional[str] = None

class SubstanceSpecification_Structure(BackboneElement):
    source: Optional[List[Reference]] = None
    isotope: Optional[List[SubstanceSpecification_Structure_Isotope]] = None
    representation: Optional[List[SubstanceSpecification_Structure_Representation]] = None
    molecular_weight: Optional[Reference] = None
    optical_activity: Optional[CodeableConcept] = None
    stereochemistry: Optional[CodeableConcept] = None
    molecular_formula: Optional[str] = None
    molecular_formula_by_moiety: Optional[str] = None

class SubstanceSpecification_Code(BackboneElement):
    code: Optional[CodeableConcept] = None
    source: Optional[List[Reference]] = None
    status: Optional[CodeableConcept] = None
    comment: Optional[str] = None
    status_date: Optional[str] = None

class SubstanceSpecification(DomainResource):
    description: Optional[str] = None
    property: Optional[List[SubstanceSpecification_Property]] = None
    name: Optional[List[SubstanceSpecification_Name]] = None
    reference_information: Optional[Reference] = None
    relationship: Optional[List[SubstanceSpecification_Relationship]] = None
    type: Optional[CodeableConcept] = None
    moiety: Optional[List[SubstanceSpecification_Moiety]] = None
    source: Optional[List[Reference]] = None
    nucleic_acid: Optional[Reference] = None
    structure: Optional[SubstanceSpecification_Structure] = None
    status: Optional[CodeableConcept] = None
    comment: Optional[str] = None
    code: Optional[List[SubstanceSpecification_Code]] = None
    identifier: Optional[Identifier] = None
    molecular_weight: Optional[List[Reference]] = None
    polymer: Optional[Reference] = None
    protein: Optional[Reference] = None
    domain: Optional[CodeableConcept] = None
    source_material: Optional[Reference] = None