from typing import Optional, List
from dataclasses import dataclass, field
from base import Attachment
from base import CodeableConcept
from base import Range
from base import Quantity
from base import DomainResource
from base import Ratio
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class SubstanceSpecificationProperty(BackboneElement):
    category: Optional[CodeableConcept] = None
    defining_substance_codeable_concept: Optional[CodeableConcept] = None
    defining_substance_reference: Optional[Reference] = None
    amount_quantity: Optional[Quantity] = None
    amount_string: Optional[str] = None
    code: Optional[CodeableConcept] = None
    parameters: Optional[str] = None

@dataclass(kw_only=True)
class SubstanceSpecificationNameOfficial(BackboneElement):
    date: Optional[str] = None
    status: Optional[CodeableConcept] = None
    authority: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class SubstanceSpecificationName(BackboneElement):
    official: Optional[List[SubstanceSpecificationNameOfficial]] = field(default_factory=list)
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    name: str
    type: Optional[CodeableConcept] = None
    source: Optional[List[Reference]] = field(default_factory=list)
    status: Optional[CodeableConcept] = None
    language: Optional[List[CodeableConcept]] = field(default_factory=list)
    synonym: Optional[List[Reference]] = field(default_factory=list)
    translation: Optional[List[Reference]] = field(default_factory=list)
    preferred: Optional[bool] = None
    domain: Optional[List[CodeableConcept]] = field(default_factory=list)

@dataclass(kw_only=True)
class SubstanceSpecificationRelationship(BackboneElement):
    substance_codeable_concept: Optional[CodeableConcept] = None
    amount_ratio_low_limit: Optional[Ratio] = None
    amount_type: Optional[CodeableConcept] = None
    relationship: Optional[CodeableConcept] = None
    source: Optional[List[Reference]] = field(default_factory=list)
    substance_reference: Optional[Reference] = None
    amount_ratio: Optional[Ratio] = None
    amount_quantity: Optional[Quantity] = None
    amount_string: Optional[str] = None
    is_defining: Optional[bool] = None
    amount_range: Optional[Range] = None

@dataclass(kw_only=True)
class SubstanceSpecificationMoiety(BackboneElement):
    role: Optional[CodeableConcept] = None
    name: Optional[str] = None
    molecular_formula: Optional[str] = None
    amount_quantity: Optional[Quantity] = None
    amount_string: Optional[str] = None
    optical_activity: Optional[CodeableConcept] = None
    identifier: Optional[Identifier] = None
    stereochemistry: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class SubstanceSpecificationStructureIsotopeMolecularWeight(BackboneElement):
    type: Optional[CodeableConcept] = None
    amount: Optional[Quantity] = None
    method: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class SubstanceSpecificationStructureIsotope(BackboneElement):
    name: Optional[CodeableConcept] = None
    half_life: Optional[Quantity] = None
    identifier: Optional[Identifier] = None
    substitution: Optional[CodeableConcept] = None
    molecular_weight: Optional[SubstanceSpecificationStructureIsotopeMolecularWeight] = None

@dataclass(kw_only=True)
class SubstanceSpecificationStructureRepresentation(BackboneElement):
    type: Optional[CodeableConcept] = None
    attachment: Optional[Attachment] = None
    representation: Optional[str] = None

@dataclass(kw_only=True)
class SubstanceSpecificationStructure(BackboneElement):
    source: Optional[List[Reference]] = field(default_factory=list)
    isotope: Optional[List[SubstanceSpecificationStructureIsotope]] = field(default_factory=list)
    representation: Optional[List[SubstanceSpecificationStructureRepresentation]] = field(default_factory=list)
    molecular_weight: Optional[Reference] = None
    optical_activity: Optional[CodeableConcept] = None
    stereochemistry: Optional[CodeableConcept] = None
    molecular_formula: Optional[str] = None
    molecular_formula_by_moiety: Optional[str] = None

@dataclass(kw_only=True)
class SubstanceSpecificationCode(BackboneElement):
    code: Optional[CodeableConcept] = None
    source: Optional[List[Reference]] = field(default_factory=list)
    status: Optional[CodeableConcept] = None
    comment: Optional[str] = None
    status_date: Optional[str] = None

@dataclass(kw_only=True)
class SubstanceSpecification(DomainResource):
    description: Optional[str] = None
    property: Optional[List[SubstanceSpecificationProperty]] = field(default_factory=list)
    name: Optional[List[SubstanceSpecificationName]] = field(default_factory=list)
    reference_information: Optional[Reference] = None
    relationship: Optional[List[SubstanceSpecificationRelationship]] = field(default_factory=list)
    type: Optional[CodeableConcept] = None
    moiety: Optional[List[SubstanceSpecificationMoiety]] = field(default_factory=list)
    source: Optional[List[Reference]] = field(default_factory=list)
    nucleic_acid: Optional[Reference] = None
    structure: Optional[SubstanceSpecificationStructure] = None
    status: Optional[CodeableConcept] = None
    comment: Optional[str] = None
    code: Optional[List[SubstanceSpecificationCode]] = field(default_factory=list)
    identifier: Optional[Identifier] = None
    molecular_weight: Optional[List[Reference]] = field(default_factory=list)
    polymer: Optional[Reference] = None
    protein: Optional[Reference] = None
    domain: Optional[CodeableConcept] = None
    source_material: Optional[Reference] = None