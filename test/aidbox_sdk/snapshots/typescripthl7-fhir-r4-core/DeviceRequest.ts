import { Annotation } from "./Annotation";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Range } from "./Range";
import { Timing } from "./Timing";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type DeviceRequestParameter = BackboneElement & {
    code?: CodeableConcept;
    value?: Range | boolean | Quantity | CodeableConcept;
};

export type DeviceRequest = DomainResource & {
    performerType?: CodeableConcept;
    insurance?: Reference[];
    instantiatesCanonical?: string[];
    instantiatesUri?: string[];
    relevantHistory?: Reference[];
    supportingInfo?: Reference[];
    encounter?: Reference;
    priorRequest?: Reference[];
    reasonCode?: CodeableConcept[];
    authoredOn?: string;
    note?: Annotation[];
    requester?: Reference;
    priority?: string;
    status?: string;
    groupIdentifier?: Identifier;
    code?: Reference | CodeableConcept;
    identifier?: Identifier[];
    intent: string;
    basedOn?: Reference[];
    subject: Reference;
    parameter?: DeviceRequestParameter[];
    occurrence?: Timing | Period | string;
    performer?: Reference;
    reasonReference?: Reference[];
};