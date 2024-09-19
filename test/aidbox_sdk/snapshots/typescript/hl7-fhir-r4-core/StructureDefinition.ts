import { UsageContext } from "./UsageContext";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { ElementDefinition } from "./ElementDefinition";
import { DomainResource } from "./DomainResource";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type StructureDefinitionMapping = BackboneElement & {
    uri?: string;
    name?: string;
    comment?: string;
    identity: string;
};

export type StructureDefinitionSnapshot = BackboneElement & {
    element: ElementDefinition[];
};

export type StructureDefinitionContext = BackboneElement & {
    type: string;
    expression: string;
};

export type StructureDefinitionDifferential = BackboneElement & {
    element: ElementDefinition[];
};

export type StructureDefinition = DomainResource & {
    description?: string;
    date?: string;
    derivation?: string;
    publisher?: string;
    contextInvariant?: string[];
    fhirVersion?: string;
    jurisdiction?: CodeableConcept[];
    purpose?: string;
    name: string;
    mapping?: StructureDefinitionMapping[];
    useContext?: UsageContext[];
    abstract: boolean;
    copyright?: string;
    type: string;
    experimental?: boolean;
    title?: string;
    snapshot?: StructureDefinitionSnapshot;
    keyword?: Coding[];
    status: string;
    kind: string;
    url: string;
    identifier?: Identifier[];
    context?: StructureDefinitionContext[];
    version?: string;
    differential?: StructureDefinitionDifferential;
    contact?: ContactDetail[];
    baseDefinition?: string;
};