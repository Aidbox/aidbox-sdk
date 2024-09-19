import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type Slot = DomainResource & {
    schedule: Reference;
    serviceCategory?: CodeableConcept[];
    specialty?: CodeableConcept[];
    start: string;
    serviceType?: CodeableConcept[];
    appointmentType?: CodeableConcept;
    status: string;
    comment?: string;
    identifier?: Identifier[];
    end: string;
    overbooked?: boolean;
};