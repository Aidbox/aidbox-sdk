import { UsageContext } from "./UsageContext";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { BackboneElement } from "./BackboneElement";

export type TerminologyCapabilitiesExpansionParameter = BackboneElement & {
    name: string;
    documentation?: string;
};

export type TerminologyCapabilitiesExpansion = BackboneElement & {
    paging?: boolean;
    parameter?: TerminologyCapabilitiesExpansionParameter[];
    incomplete?: boolean;
    textFilter?: string;
    hierarchical?: boolean;
};

export type TerminologyCapabilitiesValidateCode = BackboneElement & {
    translations: boolean;
};

export type TerminologyCapabilitiesTranslation = BackboneElement & {
    needsMap: boolean;
};

export type TerminologyCapabilitiesCodeSystemVersionFilter = BackboneElement & {
    op: string[];
    code: string;
};

export type TerminologyCapabilitiesCodeSystemVersion = BackboneElement & {
    code?: string;
    filter?: TerminologyCapabilitiesCodeSystemVersionFilter[];
    language?: string[];
    property?: string[];
    isDefault?: boolean;
    compositional?: boolean;
};

export type TerminologyCapabilitiesCodeSystem = BackboneElement & {
    uri?: string;
    version?: TerminologyCapabilitiesCodeSystemVersion[];
    subsumption?: boolean;
};

export type TerminologyCapabilitiesSoftware = BackboneElement & {
    name: string;
    version?: string;
};

export type TerminologyCapabilitiesImplementation = BackboneElement & {
    url?: string;
    description: string;
};

export type TerminologyCapabilitiesClosure = BackboneElement & {
    translation?: boolean;
};

export type TerminologyCapabilities = DomainResource & {
    description?: string;
    date: string;
    publisher?: string;
    jurisdiction?: CodeableConcept[];
    purpose?: string;
    name?: string;
    useContext?: UsageContext[];
    copyright?: string;
    experimental?: boolean;
    expansion?: TerminologyCapabilitiesExpansion;
    title?: string;
    status: string;
    validateCode?: TerminologyCapabilitiesValidateCode;
    kind: string;
    translation?: TerminologyCapabilitiesTranslation;
    url?: string;
    codeSystem?: TerminologyCapabilitiesCodeSystem[];
    software?: TerminologyCapabilitiesSoftware;
    version?: string;
    contact?: ContactDetail[];
    implementation?: TerminologyCapabilitiesImplementation;
    codeSearch?: string;
    lockedDate?: boolean;
    closure?: TerminologyCapabilitiesClosure;
};