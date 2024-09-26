from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import DomainResource
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class SubstanceSourceMaterialOrganismAuthor(BackboneElement):
    author_type: Optional[CodeableConcept] = None
    author_description: Optional[str] = None

@dataclass(kw_only=True)
class SubstanceSourceMaterialOrganismHybrid(BackboneElement):
    hybrid_type: Optional[CodeableConcept] = None
    maternal_organism_id: Optional[str] = None
    paternal_organism_id: Optional[str] = None
    maternal_organism_name: Optional[str] = None
    paternal_organism_name: Optional[str] = None

@dataclass(kw_only=True)
class SubstanceSourceMaterialOrganismOrganismGeneral(BackboneElement):
    class_: Optional[CodeableConcept] = None
    order: Optional[CodeableConcept] = None
    phylum: Optional[CodeableConcept] = None
    kingdom: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class SubstanceSourceMaterialOrganism(BackboneElement):
    genus: Optional[CodeableConcept] = None
    author: Optional[List[SubstanceSourceMaterialOrganismAuthor]] = field(default_factory=list)
    family: Optional[CodeableConcept] = None
    hybrid: Optional[SubstanceSourceMaterialOrganismHybrid] = None
    species: Optional[CodeableConcept] = None
    organism_general: Optional[SubstanceSourceMaterialOrganismOrganismGeneral] = None
    intraspecific_type: Optional[CodeableConcept] = None
    intraspecific_description: Optional[str] = None

@dataclass(kw_only=True)
class SubstanceSourceMaterialPartDescription(BackboneElement):
    part: Optional[CodeableConcept] = None
    part_location: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class SubstanceSourceMaterialFractionDescription(BackboneElement):
    fraction: Optional[str] = None
    material_type: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class SubstanceSourceMaterial(DomainResource):
    parent_substance_name: Optional[List[str]] = field(default_factory=list)
    organism: Optional[SubstanceSourceMaterialOrganism] = None
    part_description: Optional[List[SubstanceSourceMaterialPartDescription]] = field(default_factory=list)
    development_stage: Optional[CodeableConcept] = None
    fraction_description: Optional[List[SubstanceSourceMaterialFractionDescription]] = field(default_factory=list)
    source_material_state: Optional[CodeableConcept] = None
    country_of_origin: Optional[List[CodeableConcept]] = field(default_factory=list)
    source_material_type: Optional[CodeableConcept] = None
    organism_id: Optional[Identifier] = None
    organism_name: Optional[str] = None
    parent_substance_id: Optional[List[Identifier]] = field(default_factory=list)
    geographical_location: Optional[List[str]] = field(default_factory=list)
    source_material_class: Optional[CodeableConcept] = None