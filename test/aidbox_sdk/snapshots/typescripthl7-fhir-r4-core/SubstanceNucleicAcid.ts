import { Attachment } from "./Attachment";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type SubstanceNucleicAcidSubunitSugar = BackboneElement & {
    name?: string;
    identifier?: Identifier;
    residueSite?: string;
};

export type SubstanceNucleicAcidSubunitLinkage = BackboneElement & {
    name?: string;
    identifier?: Identifier;
    residueSite?: string;
    connectivity?: string;
};

export type SubstanceNucleicAcidSubunit = BackboneElement & {
    sugar?: SubstanceNucleicAcidSubunitSugar[];
    length?: number;
    linkage?: SubstanceNucleicAcidSubunitLinkage[];
    subunit?: number;
    sequence?: string;
    fivePrime?: CodeableConcept;
    threePrime?: CodeableConcept;
    sequenceAttachment?: Attachment;
};

export type SubstanceNucleicAcid = DomainResource & {
    subunit?: SubstanceNucleicAcidSubunit[];
    sequenceType?: CodeableConcept;
    numberOfSubunits?: number;
    areaOfHybridisation?: string;
    oligoNucleotideType?: CodeableConcept;
};