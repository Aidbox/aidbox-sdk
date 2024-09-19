import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Signature } from "./Signature";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { BackboneElement } from "./BackboneElement";

export type ProvenanceAgent = BackboneElement & {
    who: Reference;
    role?: CodeableConcept[];
    type?: CodeableConcept;
    onBehalfOf?: Reference;
};

export type ProvenanceEntity = BackboneElement & {
    role: string;
    what: Reference;
    agent?: Reference[];
};

export type Provenance = DomainResource & {
    occurred?: string | Period;
    signature?: Signature[];
    recorded: string;
    agent: ProvenanceAgent[];
    policy?: string[];
    reason?: CodeableConcept[];
    activity?: CodeableConcept;
    target: Reference[];
    location?: Reference;
    entity?: ProvenanceEntity[];
};