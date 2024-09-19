import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Ratio } from "./Ratio";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type MedicinalProductIngredientSubstance = BackboneElement & {
    code: CodeableConcept;
    strength?: Reference[];
};

export type MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrength = BackboneElement & {
    country?: CodeableConcept[];
    strength: Ratio;
    substance?: CodeableConcept;
    measurementPoint?: string;
    strengthLowLimit?: Ratio;
};

export type MedicinalProductIngredientSpecifiedSubstanceStrength = BackboneElement & {
    country?: CodeableConcept[];
    presentation: Ratio;
    concentration?: Ratio;
    measurementPoint?: string;
    referenceStrength?: MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrength[];
    presentationLowLimit?: Ratio;
    concentrationLowLimit?: Ratio;
};

export type MedicinalProductIngredientSpecifiedSubstance = BackboneElement & {
    code: CodeableConcept;
    group: CodeableConcept;
    strength?: MedicinalProductIngredientSpecifiedSubstanceStrength[];
    confidentiality?: CodeableConcept;
};

export type MedicinalProductIngredient = DomainResource & {
    role: CodeableConcept;
    substance?: MedicinalProductIngredientSubstance;
    identifier?: Identifier;
    manufacturer?: Reference[];
    specifiedSubstance?: MedicinalProductIngredientSpecifiedSubstance[];
    allergenicIndicator?: boolean;
};