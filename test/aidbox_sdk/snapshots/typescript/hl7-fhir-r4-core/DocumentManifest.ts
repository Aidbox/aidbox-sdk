import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type DocumentManifestRelated = BackboneElement & {
    ref?: Reference;
    identifier?: Identifier;
};

export type DocumentManifest = DomainResource & {
    description?: string;
    content: Reference[];
    recipient?: Reference[];
    type?: CodeableConcept;
    created?: string;
    related?: DocumentManifestRelated[];
    source?: string;
    author?: Reference[];
    masterIdentifier?: Identifier;
    status: string;
    identifier?: Identifier[];
    subject?: Reference;
};