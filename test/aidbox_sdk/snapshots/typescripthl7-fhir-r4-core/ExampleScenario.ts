import { UsageContext } from "./UsageContext";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ExampleScenarioInstanceVersion = BackboneElement & {
    versionId: string;
    description: string;
};

export type ExampleScenarioInstanceContainedInstance = BackboneElement & {
    versionId?: string;
    resourceId: string;
};

export type ExampleScenarioInstance = BackboneElement & {
    name?: string;
    version?: ExampleScenarioInstanceVersion[];
    resourceId: string;
    description?: string;
    resourceType: string;
    containedInstance?: ExampleScenarioInstanceContainedInstance[];
};

export type ExampleScenarioProcessStepOperation = BackboneElement & {
    response?: Reference;
    description?: string;
    request?: Reference;
    number: string;
    name?: string;
    initiator?: string;
    type?: string;
    receiverActive?: boolean;
    initiatorActive?: boolean;
    receiver?: string;
};

export type ExampleScenarioProcessStepAlternative = BackboneElement & {
    step?: Reference[];
    title: string;
    description?: string;
};

export type ExampleScenarioProcessStep = BackboneElement & {
    pause?: boolean;
    process?: Reference[];
    operation?: ExampleScenarioProcessStepOperation;
    alternative?: ExampleScenarioProcessStepAlternative[];
};

export type ExampleScenarioProcess = BackboneElement & {
    step?: ExampleScenarioProcessStep[];
    title: string;
    description?: string;
    preConditions?: string;
    postConditions?: string;
};

export type ExampleScenarioActor = BackboneElement & {
    name?: string;
    type: string;
    actorId: string;
    description?: string;
};

export type ExampleScenario = DomainResource & {
    date?: string;
    publisher?: string;
    instance?: ExampleScenarioInstance[];
    jurisdiction?: CodeableConcept[];
    purpose?: string;
    name?: string;
    process?: ExampleScenarioProcess[];
    useContext?: UsageContext[];
    copyright?: string;
    experimental?: boolean;
    workflow?: string[];
    status: string;
    url?: string;
    identifier?: Identifier[];
    version?: string;
    contact?: ContactDetail[];
    actor?: ExampleScenarioActor[];
};