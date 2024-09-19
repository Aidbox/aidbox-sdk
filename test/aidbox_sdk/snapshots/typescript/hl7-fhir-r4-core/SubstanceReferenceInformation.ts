import { CodeableConcept } from "./CodeableConcept";
import { Range } from "./Range";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type SubstanceReferenceInformationGene = BackboneElement & {
    gene?: CodeableConcept;
    source?: Reference[];
    geneSequenceOrigin?: CodeableConcept;
};

export type SubstanceReferenceInformationTarget = BackboneElement & {
    amount?: Quantity | string | Range;
    organism?: CodeableConcept;
    organismType?: CodeableConcept;
    amountType?: CodeableConcept;
    type?: CodeableConcept;
    interaction?: CodeableConcept;
    source?: Reference[];
    target?: Identifier;
};

export type SubstanceReferenceInformationGeneElement = BackboneElement & {
    type?: CodeableConcept;
    source?: Reference[];
    element?: Identifier;
};

export type SubstanceReferenceInformationClassification = BackboneElement & {
    domain?: CodeableConcept;
    source?: Reference[];
    subtype?: CodeableConcept[];
    classification?: CodeableConcept;
};

export type SubstanceReferenceInformation = DomainResource & {
    gene?: SubstanceReferenceInformationGene[];
    target?: SubstanceReferenceInformationTarget[];
    comment?: string;
    geneElement?: SubstanceReferenceInformationGeneElement[];
    classification?: SubstanceReferenceInformationClassification[];
};