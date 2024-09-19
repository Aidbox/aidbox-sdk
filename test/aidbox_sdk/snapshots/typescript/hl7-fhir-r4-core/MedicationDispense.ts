import { Annotation } from "./Annotation";
import { CodeableConcept } from "./CodeableConcept";
import { Dosage } from "./Dosage";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type MedicationDispenseSubstitution = BackboneElement & {
    type?: CodeableConcept;
    reason?: CodeableConcept[];
    wasSubstituted: boolean;
    responsibleParty?: Reference[];
};

export type MedicationDispensePerformer = BackboneElement & {
    actor: Reference;
    function?: CodeableConcept;
};

export type MedicationDispense = DomainResource & {
    category?: CodeableConcept;
    whenHandedOver?: string;
    whenPrepared?: string;
    eventHistory?: Reference[];
    substitution?: MedicationDispenseSubstitution;
    detectedIssue?: Reference[];
    type?: CodeableConcept;
    statusReason?: Reference | CodeableConcept;
    note?: Annotation[];
    supportingInformation?: Reference[];
    status: string;
    dosageInstruction?: Dosage[];
    daysSupply?: Quantity;
    identifier?: Identifier[];
    context?: Reference;
    quantity?: Quantity;
    partOf?: Reference[];
    location?: Reference;
    authorizingPrescription?: Reference[];
    receiver?: Reference[];
    subject?: Reference;
    destination?: Reference;
    performer?: MedicationDispensePerformer[];
    medication?: CodeableConcept | Reference;
};