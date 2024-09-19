import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type EpisodeOfCareDiagnosis = BackboneElement & {
    rank?: number;
    role?: CodeableConcept;
    condition: Reference;
};

export type EpisodeOfCareStatusHistory = BackboneElement & {
    period: Period;
    status: string;
};

export type EpisodeOfCare = DomainResource & {
    patient: Reference;
    diagnosis?: EpisodeOfCareDiagnosis[];
    managingOrganization?: Reference;
    type?: CodeableConcept[];
    account?: Reference[];
    referralRequest?: Reference[];
    team?: Reference[];
    status: string;
    identifier?: Identifier[];
    period?: Period;
    careManager?: Reference;
    statusHistory?: EpisodeOfCareStatusHistory[];
};