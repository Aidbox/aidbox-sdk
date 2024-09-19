import { Attachment } from "./Attachment";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { ContactPoint } from "./ContactPoint";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type HealthcareServiceAvailableTime = BackboneElement & {
    allDay?: boolean;
    daysOfWeek?: string[];
    availableEndTime?: string;
    availableStartTime?: string;
};

export type HealthcareServiceNotAvailable = BackboneElement & {
    during?: Period;
    description: string;
};

export type HealthcareServiceEligibility = BackboneElement & {
    code?: CodeableConcept;
    comment?: string;
};

export type HealthcareService = DomainResource & {
    coverageArea?: Reference[];
    category?: CodeableConcept[];
    availableTime?: HealthcareServiceAvailableTime[];
    specialty?: CodeableConcept[];
    name?: string;
    notAvailable?: HealthcareServiceNotAvailable[];
    providedBy?: Reference;
    type?: CodeableConcept[];
    eligibility?: HealthcareServiceEligibility[];
    extraDetails?: string;
    characteristic?: CodeableConcept[];
    photo?: Attachment;
    active?: boolean;
    communication?: CodeableConcept[];
    comment?: string;
    identifier?: Identifier[];
    serviceProvisionCode?: CodeableConcept[];
    availabilityExceptions?: string;
    appointmentRequired?: boolean;
    referralMethod?: CodeableConcept[];
    telecom?: ContactPoint[];
    location?: Reference[];
    program?: CodeableConcept[];
    endpoint?: Reference[];
};