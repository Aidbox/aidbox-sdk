import { Annotation } from "./Annotation";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ListEntry = BackboneElement & {
    date?: string;
    flag?: CodeableConcept;
    item: Reference;
    deleted?: boolean;
};

export type List = DomainResource & {
    date?: string;
    encounter?: Reference;
    orderedBy?: CodeableConcept;
    mode: string;
    source?: Reference;
    title?: string;
    note?: Annotation[];
    emptyReason?: CodeableConcept;
    status: string;
    code?: CodeableConcept;
    identifier?: Identifier[];
    entry?: ListEntry[];
    subject?: Reference;
};