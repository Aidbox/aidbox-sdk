import { UsageContext } from "./UsageContext";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { BackboneElement } from "./BackboneElement";

export type ImplementationGuideDefinitionPage = BackboneElement & {
    name?: string | Reference;
    page?: Reference[];
    title: string;
    generation: string;
};

export type ImplementationGuideDefinitionGrouping = BackboneElement & {
    name: string;
    description?: string;
};

export type ImplementationGuideDefinitionResource = BackboneElement & {
    name?: string;
    example?: boolean | string;
    reference: Reference;
    groupingId?: string;
    description?: string;
    fhirVersion?: string[];
};

export type ImplementationGuideDefinitionTemplate = BackboneElement & {
    code: string;
    scope?: string;
    source: string;
};

export type ImplementationGuideDefinitionParameter = BackboneElement & {
    code: string;
    value: string;
};

export type ImplementationGuideDefinition = BackboneElement & {
    page?: ImplementationGuideDefinitionPage;
    grouping?: ImplementationGuideDefinitionGrouping[];
    resource: ImplementationGuideDefinitionResource[];
    template?: ImplementationGuideDefinitionTemplate[];
    parameter?: ImplementationGuideDefinitionParameter[];
};

export type ImplementationGuideGlobal = BackboneElement & {
    type: string;
    profile: string;
};

export type ImplementationGuideDependsOn = BackboneElement & {
    uri: string;
    version?: string;
    packageId?: string;
};

export type ImplementationGuideManifestPage = BackboneElement & {
    name: string;
    title?: string;
    anchor?: string[];
};

export type ImplementationGuideManifestResource = BackboneElement & {
    example?: boolean | string;
    reference: Reference;
    relativePath?: string;
};

export type ImplementationGuideManifest = BackboneElement & {
    page?: ImplementationGuideManifestPage[];
    image?: string[];
    other?: string[];
    resource: ImplementationGuideManifestResource[];
    rendering?: string;
};

export type ImplementationGuide = DomainResource & {
    description?: string;
    definition?: ImplementationGuideDefinition;
    date?: string;
    publisher?: string;
    fhirVersion: string[];
    license?: string;
    jurisdiction?: CodeableConcept[];
    global_?: ImplementationGuideGlobal[];
    dependsOn?: ImplementationGuideDependsOn[];
    name: string;
    useContext?: UsageContext[];
    copyright?: string;
    experimental?: boolean;
    manifest?: ImplementationGuideManifest;
    title?: string;
    status: string;
    url: string;
    version?: string;
    packageId: string;
    contact?: ContactDetail[];
};