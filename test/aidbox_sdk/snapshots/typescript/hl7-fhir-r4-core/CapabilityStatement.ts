import { UsageContext } from "./UsageContext";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { BackboneElement } from "./BackboneElement";

export type CapabilityStatementDocument = BackboneElement & {
    mode: string;
    profile: string;
    documentation?: string;
};

export type CapabilityStatementMessagingEndpoint = BackboneElement & {
    address: string;
    protocol: Coding;
};

export type CapabilityStatementMessagingSupportedMessage = BackboneElement & {
    mode: string;
    definition: string;
};

export type CapabilityStatementMessaging = BackboneElement & {
    endpoint?: CapabilityStatementMessagingEndpoint[];
    documentation?: string;
    reliableCache?: number;
    supportedMessage?: CapabilityStatementMessagingSupportedMessage[];
};

export type CapabilityStatementSoftware = BackboneElement & {
    name: string;
    version?: string;
    releaseDate?: string;
};

export type CapabilityStatementImplementation = BackboneElement & {
    url?: string;
    custodian?: Reference;
    description: string;
};

export type CapabilityStatementRestResourceSearchParam = BackboneElement & {
    name: string;
    type: string;
    definition?: string;
    documentation?: string;
};

export type CapabilityStatementRestResourceOperation = BackboneElement & {
    name: string;
    definition: string;
    documentation?: string;
};

export type CapabilityStatementRestResourceInteraction = BackboneElement & {
    code: string;
    documentation?: string;
};

export type CapabilityStatementRestResource = BackboneElement & {
    searchRevInclude?: string[];
    searchParam?: CapabilityStatementRestResourceSearchParam[];
    conditionalUpdate?: boolean;
    conditionalRead?: string;
    operation?: CapabilityStatementRestResourceOperation[];
    referencePolicy?: string[];
    readHistory?: boolean;
    type: string;
    interaction?: CapabilityStatementRestResourceInteraction[];
    documentation?: string;
    updateCreate?: boolean;
    conditionalCreate?: boolean;
    supportedProfile?: string[];
    searchInclude?: string[];
    versioning?: string;
    profile?: string;
    conditionalDelete?: string;
};

export type CapabilityStatementRestSecurity = BackboneElement & {
    cors?: boolean;
    service?: CodeableConcept[];
    description?: string;
};

export type CapabilityStatementRestInteraction = BackboneElement & {
    code: string;
    documentation?: string;
};

export type CapabilityStatementRest = BackboneElement & {
    mode: string;
    resource?: CapabilityStatementRestResource[];
    security?: CapabilityStatementRestSecurity;
    operation?: Reference[];
    compartment?: string[];
    interaction?: CapabilityStatementRestInteraction[];
    searchParam?: Reference[];
    documentation?: string;
};

export type CapabilityStatement = DomainResource & {
    description?: string;
    format: string[];
    date: string;
    publisher?: string;
    patchFormat?: string[];
    fhirVersion: string;
    jurisdiction?: CodeableConcept[];
    instantiates?: string[];
    purpose?: string;
    name?: string;
    useContext?: UsageContext[];
    copyright?: string;
    experimental?: boolean;
    imports?: string[];
    title?: string;
    document?: CapabilityStatementDocument[];
    status: string;
    messaging?: CapabilityStatementMessaging[];
    kind: string;
    implementationGuide?: string[];
    url?: string;
    software?: CapabilityStatementSoftware;
    version?: string;
    contact?: ContactDetail[];
    implementation?: CapabilityStatementImplementation;
    rest?: CapabilityStatementRest[];
};