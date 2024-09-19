import { Annotation } from "./Annotation";
import { Attachment } from "./Attachment";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type CommunicationRequestPayload = BackboneElement & {
    content?: string | Reference | Attachment;
};

export type CommunicationRequest = DomainResource & {
    category?: CodeableConcept[];
    payload?: CommunicationRequestPayload[];
    encounter?: Reference;
    medium?: CodeableConcept[];
    recipient?: Reference[];
    reasonCode?: CodeableConcept[];
    statusReason?: CodeableConcept;
    authoredOn?: string;
    note?: Annotation[];
    requester?: Reference;
    priority?: string;
    status: string;
    groupIdentifier?: Identifier;
    sender?: Reference;
    identifier?: Identifier[];
    doNotPerform?: boolean;
    replaces?: Reference[];
    basedOn?: Reference[];
    subject?: Reference;
    occurrence?: Period | string;
    about?: Reference[];
    reasonReference?: Reference[];
};