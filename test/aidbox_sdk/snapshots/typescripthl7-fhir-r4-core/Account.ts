import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type AccountCoverage = BackboneElement & {
    coverage: Reference;
    priority?: number;
};

export type AccountGuarantor = BackboneElement & {
    party: Reference;
    onHold?: boolean;
    period?: Period;
};

export type Account = DomainResource & {
    description?: string;
    name?: string;
    servicePeriod?: Period;
    coverage?: AccountCoverage[];
    type?: CodeableConcept;
    guarantor?: AccountGuarantor[];
    status: string;
    identifier?: Identifier[];
    partOf?: Reference;
    subject?: Reference[];
    owner?: Reference;
};