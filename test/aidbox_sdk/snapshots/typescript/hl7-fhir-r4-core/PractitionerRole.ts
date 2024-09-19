import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { ContactPoint } from "./ContactPoint";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type PractitionerRoleAvailableTime = BackboneElement & {
    allDay?: boolean;
    daysOfWeek?: string[];
    availableEndTime?: string;
    availableStartTime?: string;
};

export type PractitionerRoleNotAvailable = BackboneElement & {
    during?: Period;
    description: string;
};

export type PractitionerRole = DomainResource & {
    availableTime?: PractitionerRoleAvailableTime[];
    specialty?: CodeableConcept[];
    notAvailable?: PractitionerRoleNotAvailable[];
    organization?: Reference;
    active?: boolean;
    code?: CodeableConcept[];
    identifier?: Identifier[];
    availabilityExceptions?: string;
    practitioner?: Reference;
    telecom?: ContactPoint[];
    period?: Period;
    location?: Reference[];
    endpoint?: Reference[];
    healthcareService?: Reference[];
};