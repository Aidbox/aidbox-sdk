import { Annotation } from "./Annotation";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Timing } from "./Timing";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type CarePlanActivityDetail = BackboneElement & {
    description?: string;
    instantiatesCanonical?: string[];
    instantiatesUri?: string[];
    goal?: Reference[];
    reasonCode?: CodeableConcept[];
    statusReason?: CodeableConcept;
    dailyAmount?: Quantity;
    product?: CodeableConcept | Reference;
    status: string;
    kind?: string;
    code?: CodeableConcept;
    doNotPerform?: boolean;
    scheduled?: Period | Timing | string;
    quantity?: Quantity;
    location?: Reference;
    performer?: Reference[];
    reasonReference?: Reference[];
};

export type CarePlanActivity = BackboneElement & {
    detail?: CarePlanActivityDetail;
    progress?: Annotation[];
    reference?: Reference;
    outcomeReference?: Reference[];
    outcomeCodeableConcept?: CodeableConcept[];
};

export type CarePlan = DomainResource & {
    description?: string;
    category?: CodeableConcept[];
    addresses?: Reference[];
    instantiatesCanonical?: string[];
    instantiatesUri?: string[];
    supportingInfo?: Reference[];
    encounter?: Reference;
    goal?: Reference[];
    created?: string;
    title?: string;
    note?: Annotation[];
    author?: Reference;
    activity?: CarePlanActivity[];
    contributor?: Reference[];
    status: string;
    identifier?: Identifier[];
    intent: string;
    replaces?: Reference[];
    period?: Period;
    basedOn?: Reference[];
    partOf?: Reference[];
    subject: Reference;
    careTeam?: Reference[];
};