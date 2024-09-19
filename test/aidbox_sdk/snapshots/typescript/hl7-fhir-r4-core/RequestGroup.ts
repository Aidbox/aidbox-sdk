import { Annotation } from "./Annotation";
import { Age } from "./Age";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Expression } from "./Expression";
import { Range } from "./Range";
import { RelatedArtifact } from "./RelatedArtifact";
import { Timing } from "./Timing";
import { Duration } from "./Duration";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type RequestGroupActionRelatedAction = BackboneElement & {
    offset?: Range | Duration;
    actionId: string;
    relationship: string;
};

export type RequestGroupActionCondition = BackboneElement & {
    kind: string;
    expression?: Expression;
};

export type RequestGroupAction = BackboneElement & {
    description?: string;
    textEquivalent?: string;
    relatedAction?: RequestGroupActionRelatedAction[];
    type?: CodeableConcept;
    participant?: Reference[];
    title?: string;
    documentation?: RelatedArtifact[];
    prefix?: string;
    selectionBehavior?: string;
    priority?: string;
    requiredBehavior?: string;
    condition?: RequestGroupActionCondition[];
    resource?: Reference;
    timing?: Range | Period | string | Timing | Duration | Age;
    groupingBehavior?: string;
    code?: CodeableConcept[];
    action?: Reference[];
    precheckBehavior?: string;
    cardinalityBehavior?: string;
};

export type RequestGroup = DomainResource & {
    instantiatesCanonical?: string[];
    instantiatesUri?: string[];
    encounter?: Reference;
    reasonCode?: CodeableConcept[];
    authoredOn?: string;
    note?: Annotation[];
    author?: Reference;
    priority?: string;
    status: string;
    groupIdentifier?: Identifier;
    code?: CodeableConcept;
    identifier?: Identifier[];
    intent: string;
    action?: RequestGroupAction[];
    replaces?: Reference[];
    basedOn?: Reference[];
    subject?: Reference;
    reasonReference?: Reference[];
};