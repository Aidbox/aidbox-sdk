import { Annotation } from "./Annotation";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Dosage } from "./Dosage";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type MedicationStatement = DomainResource & {
    category?: CodeableConcept;
    dosage?: Dosage[];
    derivedFrom?: Reference[];
    reasonCode?: CodeableConcept[];
    statusReason?: CodeableConcept[];
    note?: Annotation[];
    status: string;
    effective?: string | Period;
    identifier?: Identifier[];
    context?: Reference;
    dateAsserted?: string;
    basedOn?: Reference[];
    partOf?: Reference[];
    informationSource?: Reference;
    subject: Reference;
    medication?: CodeableConcept | Reference;
    reasonReference?: Reference[];
};