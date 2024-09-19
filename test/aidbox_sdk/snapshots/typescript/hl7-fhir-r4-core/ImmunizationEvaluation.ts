import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type ImmunizationEvaluation = DomainResource & {
    patient: Reference;
    description?: string;
    date?: string;
    series?: string;
    doseNumber?: number | string;
    authority?: Reference;
    seriesDoses?: number | string;
    doseStatusReason?: CodeableConcept[];
    immunizationEvent: Reference;
    status: string;
    identifier?: Identifier[];
    targetDisease: CodeableConcept;
    doseStatus: CodeableConcept;
};