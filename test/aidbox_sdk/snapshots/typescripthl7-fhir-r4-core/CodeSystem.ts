import { UsageContext } from "./UsageContext";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type CodeSystemProperty = BackboneElement & {
    uri?: string;
    code: string;
    type: string;
    description?: string;
};

export type CodeSystemFilter = BackboneElement & {
    code: string;
    value: string;
    operator: string[];
    description?: string;
};

export type CodeSystemConceptProperty = BackboneElement & {
    value?: string | number | boolean | Coding;
    code: string;
};

export type CodeSystemConceptDesignation = BackboneElement & {
    use?: Coding;
    value: string;
    language?: string;
};

export type CodeSystemConcept = BackboneElement & {
    code: string;
    concept?: Reference[];
    display?: string;
    property?: CodeSystemConceptProperty[];
    definition?: string;
    designation?: CodeSystemConceptDesignation[];
};

export type CodeSystem = DomainResource & {
    description?: string;
    date?: string;
    versionNeeded?: boolean;
    publisher?: string;
    jurisdiction?: CodeableConcept[];
    purpose?: string;
    content: string;
    property?: CodeSystemProperty[];
    name?: string;
    useContext?: UsageContext[];
    copyright?: string;
    experimental?: boolean;
    title?: string;
    filter?: CodeSystemFilter[];
    supplements?: string;
    compositional?: boolean;
    status: string;
    hierarchyMeaning?: string;
    valueSet?: string;
    count?: number;
    url?: string;
    identifier?: Identifier[];
    concept?: CodeSystemConcept[];
    caseSensitive?: boolean;
    version?: string;
    contact?: ContactDetail[];
};