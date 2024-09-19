import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type Schedule = DomainResource & {
    actor: Reference[];
    active?: boolean;
    comment?: string;
    specialty?: CodeableConcept[];
    identifier?: Identifier[];
    serviceType?: CodeableConcept[];
    planningHorizon?: Period;
    serviceCategory?: CodeableConcept[];
};