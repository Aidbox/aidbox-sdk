import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { BackboneElement } from "./BackboneElement";

export type AuditEventSource = BackboneElement & {
    site?: string;
    type?: Coding[];
    observer: Reference;
};

export type AuditEventAgentNetwork = BackboneElement & {
    type?: string;
    address?: string;
};

export type AuditEventAgent = BackboneElement & {
    role?: CodeableConcept[];
    requestor: boolean;
    who?: Reference;
    altId?: string;
    name?: string;
    type?: CodeableConcept;
    policy?: string[];
    purposeOfUse?: CodeableConcept[];
    network?: AuditEventAgentNetwork;
    location?: Reference;
    media?: Coding;
};

export type AuditEventEntityDetail = BackboneElement & {
    type: string;
    value?: string;
};

export type AuditEventEntity = BackboneElement & {
    role?: Coding;
    description?: string;
    name?: string;
    type?: Coding;
    lifecycle?: Coding;
    query?: string;
    securityLabel?: Coding[];
    what?: Reference;
    detail?: AuditEventEntityDetail[];
};

export type AuditEvent = DomainResource & {
    outcomeDesc?: string;
    type: Coding;
    outcome?: string;
    source: AuditEventSource;
    recorded: string;
    agent: AuditEventAgent[];
    purposeOfEvent?: CodeableConcept[];
    action?: string;
    period?: Period;
    entity?: AuditEventEntity[];
    subtype?: Coding[];
};