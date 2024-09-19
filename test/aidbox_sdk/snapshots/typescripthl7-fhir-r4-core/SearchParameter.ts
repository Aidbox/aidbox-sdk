import { UsageContext } from "./UsageContext";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { BackboneElement } from "./BackboneElement";

export type SearchParameterComponent = BackboneElement & {
    definition: string;
    expression: string;
};

export type SearchParameter = DomainResource & {
    description: string;
    date?: string;
    expression?: string;
    modifier?: string[];
    publisher?: string;
    multipleAnd?: boolean;
    jurisdiction?: CodeableConcept[];
    derivedFrom?: string;
    purpose?: string;
    multipleOr?: boolean;
    name: string;
    useContext?: UsageContext[];
    xpath?: string;
    xpathUsage?: string;
    type: string;
    experimental?: boolean;
    component?: SearchParameterComponent[];
    status: string;
    chain?: string[];
    url: string;
    code: string;
    comparator?: string[];
    target?: string[];
    base: string[];
    version?: string;
    contact?: ContactDetail[];
};