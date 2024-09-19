import { UsageContext } from "./UsageContext";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { BackboneElement } from "./BackboneElement";

export type OperationDefinitionOverload = BackboneElement & {
    comment?: string;
    parameterName?: string[];
};

export type OperationDefinitionParameterReferencedFrom = BackboneElement & {
    source: string;
    sourceId?: string;
};

export type OperationDefinitionParameterBinding = BackboneElement & {
    strength: string;
    valueSet: string;
};

export type OperationDefinitionParameter = BackboneElement & {
    min: number;
    searchType?: string;
    use: string;
    name: string;
    part?: Reference[];
    type?: string;
    referencedFrom?: OperationDefinitionParameterReferencedFrom[];
    documentation?: string;
    binding?: OperationDefinitionParameterBinding;
    max: string;
    targetProfile?: string[];
};

export type OperationDefinition = DomainResource & {
    description?: string;
    date?: string;
    system: boolean;
    publisher?: string;
    instance: boolean;
    jurisdiction?: CodeableConcept[];
    purpose?: string;
    name: string;
    useContext?: UsageContext[];
    type: boolean;
    overload?: OperationDefinitionOverload[];
    experimental?: boolean;
    outputProfile?: string;
    title?: string;
    status: string;
    resource?: string[];
    affectsState?: boolean;
    kind: string;
    comment?: string;
    url?: string;
    code: string;
    base?: string;
    version?: string;
    contact?: ContactDetail[];
    inputProfile?: string;
    parameter?: OperationDefinitionParameter[];
};