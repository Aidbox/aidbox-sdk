from typing import Optional, List
from pydantic import *
from ..base.CodeableConcept import CodeableConcept
from ..base.DomainResource import DomainResource
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class SubstanceSourceMaterial_Organism_Author(BackboneElement):
    author_type: Optional[CodeableConcept] = None
    author_description: Optional[str] = None

class SubstanceSourceMaterial_Organism_Hybrid(BackboneElement):
    hybrid_type: Optional[CodeableConcept] = None
    maternal_organism_id: Optional[str] = None
    paternal_organism_id: Optional[str] = None
    maternal_organism_name: Optional[str] = None
    paternal_organism_name: Optional[str] = None

class SubstanceSourceMaterial_Organism_OrganismGeneral(BackboneElement):
    class_: Optional[CodeableConcept] = None
    order: Optional[CodeableConcept] = None
    phylum: Optional[CodeableConcept] = None
    kingdom: Optional[CodeableConcept] = None

class SubstanceSourceMaterial_Organism(BackboneElement):
    genus: Optional[CodeableConcept] = None
    author: Optional[List[SubstanceSourceMaterial_Organism_Author]] = None
    family: Optional[CodeableConcept] = None
    hybrid: Optional[SubstanceSourceMaterial_Organism_Hybrid] = None
    species: Optional[CodeableConcept] = None
    organism_general: Optional[SubstanceSourceMaterial_Organism_OrganismGeneral] = None
    intraspecific_type: Optional[CodeableConcept] = None
    intraspecific_description: Optional[str] = None

class SubstanceSourceMaterial_PartDescription(BackboneElement):
    part: Optional[CodeableConcept] = None
    part_location: Optional[CodeableConcept] = None

class SubstanceSourceMaterial_FractionDescription(BackboneElement):
    fraction: Optional[str] = None
    material_type: Optional[CodeableConcept] = None

class SubstanceSourceMaterial(DomainResource):
    parent_substance_name: Optional[List[str]] = None
    organism: Optional[SubstanceSourceMaterial_Organism] = None
    part_description: Optional[List[SubstanceSourceMaterial_PartDescription]] = None
    development_stage: Optional[CodeableConcept] = None
    fraction_description: Optional[List[SubstanceSourceMaterial_FractionDescription]] = None
    source_material_state: Optional[CodeableConcept] = None
    country_of_origin: Optional[List[CodeableConcept]] = None
    source_material_type: Optional[CodeableConcept] = None
    organism_id: Optional[Identifier] = None
    organism_name: Optional[str] = None
    parent_substance_id: Optional[List[Identifier]] = None
    geographical_location: Optional[List[str]] = None
    source_material_class: Optional[CodeableConcept] = None