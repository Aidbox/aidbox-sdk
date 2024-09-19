import { Annotation } from "./Annotation";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Ratio } from "./Ratio";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type MedicationAdministrationDosage = BackboneElement & {
    dose?: Quantity;
    rate?: Ratio | Quantity;
    site?: CodeableConcept;
    text?: string;
    route?: CodeableConcept;
    method?: CodeableConcept;
};

export type MedicationAdministrationPerformer = BackboneElement & {
    actor: Reference;
    function?: CodeableConcept;
};

export type MedicationAdministration = DomainResource & {
    category?: CodeableConcept;
    request?: Reference;
    eventHistory?: Reference[];
    dosage?: MedicationAdministrationDosage;
    instantiates?: string[];
    reasonCode?: CodeableConcept[];
    statusReason?: CodeableConcept[];
    note?: Annotation[];
    supportingInformation?: Reference[];
    status: string;
    effective?: string | Period;
    identifier?: Identifier[];
    context?: Reference;
    device?: Reference[];
    partOf?: Reference[];
    subject: Reference;
    performer?: MedicationAdministrationPerformer[];
    medication?: CodeableConcept | Reference;
    reasonReference?: Reference[];
};