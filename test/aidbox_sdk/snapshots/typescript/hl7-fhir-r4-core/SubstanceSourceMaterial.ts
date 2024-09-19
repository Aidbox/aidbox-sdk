import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type SubstanceSourceMaterialOrganismAuthor = BackboneElement & {
    authorType?: CodeableConcept;
    authorDescription?: string;
};

export type SubstanceSourceMaterialOrganismHybrid = BackboneElement & {
    hybridType?: CodeableConcept;
    maternalOrganismId?: string;
    paternalOrganismId?: string;
    maternalOrganismName?: string;
    paternalOrganismName?: string;
};

export type SubstanceSourceMaterialOrganismOrganismGeneral = BackboneElement & {
    class_?: CodeableConcept;
    order?: CodeableConcept;
    phylum?: CodeableConcept;
    kingdom?: CodeableConcept;
};

export type SubstanceSourceMaterialOrganism = BackboneElement & {
    genus?: CodeableConcept;
    author?: SubstanceSourceMaterialOrganismAuthor[];
    family?: CodeableConcept;
    hybrid?: SubstanceSourceMaterialOrganismHybrid;
    species?: CodeableConcept;
    organismGeneral?: SubstanceSourceMaterialOrganismOrganismGeneral;
    intraspecificType?: CodeableConcept;
    intraspecificDescription?: string;
};

export type SubstanceSourceMaterialPartDescription = BackboneElement & {
    part?: CodeableConcept;
    partLocation?: CodeableConcept;
};

export type SubstanceSourceMaterialFractionDescription = BackboneElement & {
    fraction?: string;
    materialType?: CodeableConcept;
};

export type SubstanceSourceMaterial = DomainResource & {
    parentSubstanceName?: string[];
    organism?: SubstanceSourceMaterialOrganism;
    partDescription?: SubstanceSourceMaterialPartDescription[];
    developmentStage?: CodeableConcept;
    fractionDescription?: SubstanceSourceMaterialFractionDescription[];
    sourceMaterialState?: CodeableConcept;
    countryOfOrigin?: CodeableConcept[];
    sourceMaterialType?: CodeableConcept;
    organismId?: Identifier;
    organismName?: string;
    parentSubstanceId?: Identifier[];
    geographicalLocation?: string[];
    sourceMaterialClass?: CodeableConcept;
};