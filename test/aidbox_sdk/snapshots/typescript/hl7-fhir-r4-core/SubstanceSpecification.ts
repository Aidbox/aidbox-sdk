import { Attachment } from "./Attachment";
import { CodeableConcept } from "./CodeableConcept";
import { Range } from "./Range";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Ratio } from "./Ratio";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type SubstanceSpecificationProperty = BackboneElement & {
    category?: CodeableConcept;
    amount?: Quantity | string;
    definingSubstance?: CodeableConcept | Reference;
    code?: CodeableConcept;
    parameters?: string;
};

export type SubstanceSpecificationNameOfficial = BackboneElement & {
    date?: string;
    status?: CodeableConcept;
    authority?: CodeableConcept;
};

export type SubstanceSpecificationName = BackboneElement & {
    official?: SubstanceSpecificationNameOfficial[];
    jurisdiction?: CodeableConcept[];
    name: string;
    type?: CodeableConcept;
    source?: Reference[];
    status?: CodeableConcept;
    language?: CodeableConcept[];
    synonym?: Reference[];
    translation?: Reference[];
    preferred?: boolean;
    domain?: CodeableConcept[];
};

export type SubstanceSpecificationRelationship = BackboneElement & {
    amount?: Ratio | Quantity | string | Range;
    amountRatioLowLimit?: Ratio;
    amountType?: CodeableConcept;
    relationship?: CodeableConcept;
    source?: Reference[];
    substance?: CodeableConcept | Reference;
    isDefining?: boolean;
};

export type SubstanceSpecificationMoiety = BackboneElement & {
    role?: CodeableConcept;
    amount?: Quantity | string;
    name?: string;
    molecularFormula?: string;
    opticalActivity?: CodeableConcept;
    identifier?: Identifier;
    stereochemistry?: CodeableConcept;
};

export type SubstanceSpecificationStructureIsotopeMolecularWeight = BackboneElement & {
    type?: CodeableConcept;
    amount?: Quantity;
    method?: CodeableConcept;
};

export type SubstanceSpecificationStructureIsotope = BackboneElement & {
    name?: CodeableConcept;
    halfLife?: Quantity;
    identifier?: Identifier;
    substitution?: CodeableConcept;
    molecularWeight?: SubstanceSpecificationStructureIsotopeMolecularWeight;
};

export type SubstanceSpecificationStructureRepresentation = BackboneElement & {
    type?: CodeableConcept;
    attachment?: Attachment;
    representation?: string;
};

export type SubstanceSpecificationStructure = BackboneElement & {
    source?: Reference[];
    isotope?: SubstanceSpecificationStructureIsotope[];
    representation?: SubstanceSpecificationStructureRepresentation[];
    molecularWeight?: Reference;
    opticalActivity?: CodeableConcept;
    stereochemistry?: CodeableConcept;
    molecularFormula?: string;
    molecularFormulaByMoiety?: string;
};

export type SubstanceSpecificationCode = BackboneElement & {
    code?: CodeableConcept;
    source?: Reference[];
    status?: CodeableConcept;
    comment?: string;
    statusDate?: string;
};

export type SubstanceSpecification = DomainResource & {
    description?: string;
    property?: SubstanceSpecificationProperty[];
    name?: SubstanceSpecificationName[];
    referenceInformation?: Reference;
    relationship?: SubstanceSpecificationRelationship[];
    type?: CodeableConcept;
    moiety?: SubstanceSpecificationMoiety[];
    source?: Reference[];
    nucleicAcid?: Reference;
    structure?: SubstanceSpecificationStructure;
    status?: CodeableConcept;
    comment?: string;
    code?: SubstanceSpecificationCode[];
    identifier?: Identifier;
    molecularWeight?: Reference[];
    polymer?: Reference;
    protein?: Reference;
    domain?: CodeableConcept;
    sourceMaterial?: Reference;
};