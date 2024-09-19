import { UsageContext } from "./UsageContext";
import { Age } from "./Age";
import { Period } from "./Period";
import { ContactDetail } from "./ContactDetail";
import { DataRequirement } from "./DataRequirement";
import { CodeableConcept } from "./CodeableConcept";
import { TriggerDefinition } from "./TriggerDefinition";
import { Expression } from "./Expression";
import { Range } from "./Range";
import { RelatedArtifact } from "./RelatedArtifact";
import { Timing } from "./Timing";
import { Quantity } from "./Quantity";
import { Duration } from "./Duration";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type PlanDefinitionGoalTarget = BackboneElement & {
    due?: Duration;
    detail?: Range | Quantity | CodeableConcept;
    measure?: CodeableConcept;
};

export type PlanDefinitionGoal = BackboneElement & {
    start?: CodeableConcept;
    target?: PlanDefinitionGoalTarget[];
    category?: CodeableConcept;
    priority?: CodeableConcept;
    addresses?: CodeableConcept[];
    description: CodeableConcept;
    documentation?: RelatedArtifact[];
};

export type PlanDefinitionActionRelatedAction = BackboneElement & {
    offset?: Range | Duration;
    actionId: string;
    relationship: string;
};

export type PlanDefinitionActionParticipant = BackboneElement & {
    role?: CodeableConcept;
    type: string;
};

export type PlanDefinitionActionCondition = BackboneElement & {
    kind: string;
    expression?: Expression;
};

export type PlanDefinitionActionDynamicValue = BackboneElement & {
    path?: string;
    expression?: Expression;
};

export type PlanDefinitionAction = BackboneElement & {
    description?: string;
    definition?: string;
    transform?: string;
    textEquivalent?: string;
    goalId?: string[];
    relatedAction?: PlanDefinitionActionRelatedAction[];
    type?: CodeableConcept;
    participant?: PlanDefinitionActionParticipant[];
    output?: DataRequirement[];
    title?: string;
    documentation?: RelatedArtifact[];
    prefix?: string;
    selectionBehavior?: string;
    reason?: CodeableConcept[];
    priority?: string;
    requiredBehavior?: string;
    condition?: PlanDefinitionActionCondition[];
    timing?: Range | Period | string | Timing | Duration | Age;
    groupingBehavior?: string;
    dynamicValue?: PlanDefinitionActionDynamicValue[];
    code?: CodeableConcept[];
    action?: Reference[];
    precheckBehavior?: string;
    input?: DataRequirement[];
    trigger?: TriggerDefinition[];
    subject?: CodeableConcept | Reference;
    cardinalityBehavior?: string;
};

export type PlanDefinition = DomainResource & {
    description?: string;
    date?: string;
    endorser?: ContactDetail[];
    publisher?: string;
    approvalDate?: string;
    jurisdiction?: CodeableConcept[];
    purpose?: string;
    name?: string;
    useContext?: UsageContext[];
    goal?: PlanDefinitionGoal[];
    copyright?: string;
    type?: CodeableConcept;
    experimental?: boolean;
    topic?: CodeableConcept[];
    title?: string;
    library?: string[];
    author?: ContactDetail[];
    usage?: string;
    status: string;
    subtitle?: string;
    url?: string;
    identifier?: Identifier[];
    lastReviewDate?: string;
    editor?: ContactDetail[];
    action?: PlanDefinitionAction[];
    reviewer?: ContactDetail[];
    version?: string;
    relatedArtifact?: RelatedArtifact[];
    contact?: ContactDetail[];
    subject?: CodeableConcept | Reference;
    effectivePeriod?: Period;
};