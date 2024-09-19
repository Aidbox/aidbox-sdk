import { UsageContext } from "./UsageContext";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ConceptMapGroupElementTargetDependsOn = BackboneElement & {
    value: string;
    system?: string;
    display?: string;
    property: string;
};

export type ConceptMapGroupElementTarget = BackboneElement & {
    code?: string;
    comment?: string;
    display?: string;
    product?: Reference[];
    dependsOn?: ConceptMapGroupElementTargetDependsOn[];
    equivalence: string;
};

export type ConceptMapGroupElement = BackboneElement & {
    code?: string;
    target?: ConceptMapGroupElementTarget[];
    display?: string;
};

export type ConceptMapGroupUnmapped = BackboneElement & {
    url?: string;
    code?: string;
    mode: string;
    display?: string;
};

export type ConceptMapGroup = BackboneElement & {
    source?: string;
    target?: string;
    element: ConceptMapGroupElement[];
    unmapped?: ConceptMapGroupUnmapped;
    sourceVersion?: string;
    targetVersion?: string;
};

export type ConceptMap = DomainResource & {
    description?: string;
    date?: string;
    group?: ConceptMapGroup[];
    publisher?: string;
    jurisdiction?: CodeableConcept[];
    purpose?: string;
    name?: string;
    useContext?: UsageContext[];
    copyright?: string;
    experimental?: boolean;
    source?: string;
    title?: string;
    status: string;
    url?: string;
    identifier?: Identifier;
    target?: string;
    version?: string;
    contact?: ContactDetail[];
};