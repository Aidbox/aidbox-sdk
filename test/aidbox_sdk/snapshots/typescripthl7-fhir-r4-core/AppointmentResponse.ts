import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type AppointmentResponse = DomainResource & {
    end?: string;
    actor?: Reference;
    start?: string;
    comment?: string;
    identifier?: Identifier[];
    appointment: Reference;
    participantType?: CodeableConcept[];
    participantStatus: string;
};