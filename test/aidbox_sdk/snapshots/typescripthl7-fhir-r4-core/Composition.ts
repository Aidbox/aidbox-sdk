import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";
import { Narrative } from "./Narrative";

export type CompositionSection = BackboneElement & {
    orderedBy?: CodeableConcept;
    section?: Reference[];
    mode?: string;
    title?: string;
    emptyReason?: CodeableConcept;
    author?: Reference[];
    code?: CodeableConcept;
    focus?: Reference;
    entry?: Reference[];
    text?: Narrative;
};

export type CompositionAttester = BackboneElement & {
    mode: string;
    time?: string;
    party?: Reference;
};

export type CompositionEvent = BackboneElement & {
    code?: CodeableConcept[];
    detail?: Reference[];
    period?: Period;
};

export type CompositionRelatesTo = BackboneElement & {
    code: string;
    target?: Reference | Identifier;
};

export type Composition = DomainResource & {
    category?: CodeableConcept[];
    date: string;
    encounter?: Reference;
    section?: CompositionSection[];
    attester?: CompositionAttester[];
    type: CodeableConcept;
    title: string;
    author: Reference[];
    event?: CompositionEvent[];
    custodian?: Reference;
    status: string;
    identifier?: Identifier;
    relatesTo?: CompositionRelatesTo[];
    subject?: Reference;
    confidentiality?: string;
};