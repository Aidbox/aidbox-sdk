import { Annotation } from "./Annotation";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Dosage } from "./Dosage";
import { Quantity } from "./Quantity";
import { Duration } from "./Duration";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type MedicationRequestSubstitution = BackboneElement & {
    reason?: CodeableConcept;
    allowed?: boolean | CodeableConcept;
};

export type MedicationRequestDispenseRequestInitialFill = BackboneElement & {
    duration?: Duration;
    quantity?: Quantity;
};

export type MedicationRequestDispenseRequest = BackboneElement & {
    quantity?: Quantity;
    performer?: Reference;
    initialFill?: MedicationRequestDispenseRequestInitialFill;
    validityPeriod?: Period;
    dispenseInterval?: Duration;
    expectedSupplyDuration?: Duration;
    numberOfRepeatsAllowed?: number;
};

export type MedicationRequest = DomainResource & {
    performerType?: CodeableConcept;
    category?: CodeableConcept[];
    insurance?: Reference[];
    instantiatesCanonical?: string[];
    eventHistory?: Reference[];
    instantiatesUri?: string[];
    substitution?: MedicationRequestSubstitution;
    detectedIssue?: Reference[];
    encounter?: Reference;
    dispenseRequest?: MedicationRequestDispenseRequest;
    reported?: Reference | boolean;
    reasonCode?: CodeableConcept[];
    statusReason?: CodeableConcept;
    authoredOn?: string;
    note?: Annotation[];
    requester?: Reference;
    supportingInformation?: Reference[];
    priority?: string;
    status: string;
    dosageInstruction?: Dosage[];
    groupIdentifier?: Identifier;
    recorder?: Reference;
    identifier?: Identifier[];
    doNotPerform?: boolean;
    intent: string;
    basedOn?: Reference[];
    priorPrescription?: Reference;
    courseOfTherapyType?: CodeableConcept;
    subject: Reference;
    performer?: Reference;
    medication?: CodeableConcept | Reference;
    reasonReference?: Reference[];
};