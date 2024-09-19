import { Attachment } from "./Attachment";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type SubstanceProteinSubunit = BackboneElement & {
    length?: number;
    subunit?: number;
    sequence?: string;
    sequenceAttachment?: Attachment;
    cTerminalModification?: string;
    nTerminalModification?: string;
    cTerminalModificationId?: Identifier;
    nTerminalModificationId?: Identifier;
};

export type SubstanceProtein = DomainResource & {
    subunit?: SubstanceProteinSubunit[];
    sequenceType?: CodeableConcept;
    disulfideLinkage?: string[];
    numberOfSubunits?: number;
};