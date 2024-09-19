import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Ratio } from "./Ratio";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type MedicationBatch = BackboneElement & {
    lotNumber?: string;
    expirationDate?: string;
};

export type MedicationIngredient = BackboneElement & {
    item?: Reference | CodeableConcept;
    isActive?: boolean;
    strength?: Ratio;
};

export type Medication = DomainResource & {
    code?: CodeableConcept;
    form?: CodeableConcept;
    batch?: MedicationBatch;
    amount?: Ratio;
    status?: string;
    identifier?: Identifier[];
    ingredient?: MedicationIngredient[];
    manufacturer?: Reference;
};