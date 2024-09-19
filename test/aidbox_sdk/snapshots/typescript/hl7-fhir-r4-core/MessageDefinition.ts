import { UsageContext } from "./UsageContext";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { DomainResource } from "./DomainResource";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type MessageDefinitionAllowedResponse = BackboneElement & {
    message: string;
    situation?: string;
};

export type MessageDefinitionFocus = BackboneElement & {
    max?: string;
    min: number;
    code: string;
    profile?: string;
};

export type MessageDefinition = DomainResource & {
    description?: string;
    category?: string;
    date: string;
    publisher?: string;
    parent?: string[];
    jurisdiction?: CodeableConcept[];
    purpose?: string;
    name?: string;
    useContext?: UsageContext[];
    copyright?: string;
    experimental?: boolean;
    title?: string;
    event?: string | Coding;
    status: string;
    allowedResponse?: MessageDefinitionAllowedResponse[];
    graph?: string[];
    url?: string;
    identifier?: Identifier[];
    focus?: MessageDefinitionFocus[];
    replaces?: string[];
    responseRequired?: string;
    base?: string;
    version?: string;
    contact?: ContactDetail[];
};