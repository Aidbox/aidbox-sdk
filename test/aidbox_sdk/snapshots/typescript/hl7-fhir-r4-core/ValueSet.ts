import { UsageContext } from "./UsageContext";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ValueSetComposeIncludeFilter = BackboneElement & {
    op: string;
    value: string;
    property: string;
};

export type ValueSetComposeIncludeConceptDesignation = BackboneElement & {
    use?: Coding;
    value: string;
    language?: string;
};

export type ValueSetComposeIncludeConcept = BackboneElement & {
    code: string;
    display?: string;
    designation?: ValueSetComposeIncludeConceptDesignation[];
};

export type ValueSetComposeInclude = BackboneElement & {
    filter?: ValueSetComposeIncludeFilter[];
    system?: string;
    concept?: ValueSetComposeIncludeConcept[];
    version?: string;
    valueSet?: string[];
};

export type ValueSetCompose = BackboneElement & {
    exclude?: Reference[];
    include: ValueSetComposeInclude[];
    inactive?: boolean;
    lockedDate?: string;
};

export type ValueSetExpansionContains = BackboneElement & {
    code?: string;
    system?: string;
    display?: string;
    version?: string;
    abstract?: boolean;
    contains?: Reference[];
    inactive?: boolean;
    designation?: Reference[];
};

export type ValueSetExpansionParameter = BackboneElement & {
    name: string;
    value?: string | number | boolean;
};

export type ValueSetExpansion = BackboneElement & {
    total?: number;
    offset?: number;
    contains?: ValueSetExpansionContains[];
    parameter?: ValueSetExpansionParameter[];
    timestamp: string;
    identifier?: string;
};

export type ValueSet = DomainResource & {
    description?: string;
    compose?: ValueSetCompose;
    date?: string;
    publisher?: string;
    jurisdiction?: CodeableConcept[];
    purpose?: string;
    name?: string;
    useContext?: UsageContext[];
    copyright?: string;
    experimental?: boolean;
    expansion?: ValueSetExpansion;
    title?: string;
    status: string;
    url?: string;
    identifier?: Identifier[];
    immutable?: boolean;
    version?: string;
    contact?: ContactDetail[];
};