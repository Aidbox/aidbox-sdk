import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { ContactPoint } from "./ContactPoint";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { BackboneElement } from "./BackboneElement";

export type MessageHeaderResponse = BackboneElement & {
    code: string;
    details?: Reference;
    identifier: string;
};

export type MessageHeaderSource = BackboneElement & {
    name?: string;
    contact?: ContactPoint;
    version?: string;
    endpoint: string;
    software?: string;
};

export type MessageHeaderDestination = BackboneElement & {
    name?: string;
    target?: Reference;
    endpoint: string;
    receiver?: Reference;
};

export type MessageHeader = DomainResource & {
    response?: MessageHeaderResponse;
    definition?: string;
    enterer?: Reference;
    source: MessageHeaderSource;
    author?: Reference;
    reason?: CodeableConcept;
    responsible?: Reference;
    event?: string | Coding;
    sender?: Reference;
    focus?: Reference[];
    destination?: MessageHeaderDestination[];
};