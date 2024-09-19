import { Annotation } from "./Annotation";
import { Attachment } from "./Attachment";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type CommunicationPayload = BackboneElement & {
    content?: string | Reference | Attachment;
};

export type Communication = DomainResource & {
    category?: CodeableConcept[];
    received?: string;
    instantiatesCanonical?: string[];
    payload?: CommunicationPayload[];
    instantiatesUri?: string[];
    encounter?: Reference;
    medium?: CodeableConcept[];
    recipient?: Reference[];
    reasonCode?: CodeableConcept[];
    statusReason?: CodeableConcept;
    topic?: CodeableConcept;
    sent?: string;
    note?: Annotation[];
    priority?: string;
    status: string;
    sender?: Reference;
    identifier?: Identifier[];
    inResponseTo?: Reference[];
    basedOn?: Reference[];
    partOf?: Reference[];
    subject?: Reference;
    about?: Reference[];
    reasonReference?: Reference[];
};