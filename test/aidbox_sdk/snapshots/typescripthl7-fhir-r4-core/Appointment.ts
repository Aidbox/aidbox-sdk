import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type AppointmentParticipant = BackboneElement & {
    type?: CodeableConcept[];
    actor?: Reference;
    period?: Period;
    status: string;
    required?: string;
};

export type Appointment = DomainResource & {
    description?: string;
    serviceCategory?: CodeableConcept[];
    slot?: Reference[];
    specialty?: CodeableConcept[];
    cancelationReason?: CodeableConcept;
    requestedPeriod?: Period[];
    patientInstruction?: string;
    start?: string;
    reasonCode?: CodeableConcept[];
    created?: string;
    participant: AppointmentParticipant[];
    serviceType?: CodeableConcept[];
    supportingInformation?: Reference[];
    priority?: number;
    appointmentType?: CodeableConcept;
    status: string;
    comment?: string;
    minutesDuration?: number;
    identifier?: Identifier[];
    basedOn?: Reference[];
    end?: string;
    reasonReference?: Reference[];
};