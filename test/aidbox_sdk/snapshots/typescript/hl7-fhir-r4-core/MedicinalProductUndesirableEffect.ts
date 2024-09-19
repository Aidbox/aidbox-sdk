import { CodeableConcept } from "./CodeableConcept";
import { Population } from "./Population";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";

export type MedicinalProductUndesirableEffect = DomainResource & {
    subject?: Reference[];
    population?: Population[];
    classification?: CodeableConcept;
    frequencyOfOccurrence?: CodeableConcept;
    symptomConditionEffect?: CodeableConcept;
};