import { UsageContext } from "./UsageContext";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { BackboneElement } from "./BackboneElement";

export type GraphDefinitionLinkTargetCompartment = BackboneElement & {
    use: string;
    code: string;
    rule: string;
    expression?: string;
    description?: string;
};

export type GraphDefinitionLinkTarget = BackboneElement & {
    link?: Reference[];
    type: string;
    params?: string;
    profile?: string;
    compartment?: GraphDefinitionLinkTargetCompartment[];
};

export type GraphDefinitionLink = BackboneElement & {
    max?: string;
    min?: number;
    path?: string;
    target?: GraphDefinitionLinkTarget[];
    sliceName?: string;
    description?: string;
};

export type GraphDefinition = DomainResource & {
    description?: string;
    date?: string;
    publisher?: string;
    jurisdiction?: CodeableConcept[];
    purpose?: string;
    name: string;
    start: string;
    useContext?: UsageContext[];
    experimental?: boolean;
    status: string;
    link?: GraphDefinitionLink[];
    url?: string;
    version?: string;
    contact?: ContactDetail[];
    profile?: string;
};