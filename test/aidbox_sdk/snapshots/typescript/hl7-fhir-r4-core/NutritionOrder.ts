import { Annotation } from "./Annotation";
import { CodeableConcept } from "./CodeableConcept";
import { Timing } from "./Timing";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Ratio } from "./Ratio";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type NutritionOrderOralDietTexture = BackboneElement & {
    foodType?: CodeableConcept;
    modifier?: CodeableConcept;
};

export type NutritionOrderOralDietNutrient = BackboneElement & {
    amount?: Quantity;
    modifier?: CodeableConcept;
};

export type NutritionOrderOralDiet = BackboneElement & {
    type?: CodeableConcept[];
    texture?: NutritionOrderOralDietTexture[];
    nutrient?: NutritionOrderOralDietNutrient[];
    schedule?: Timing[];
    instruction?: string;
    fluidConsistencyType?: CodeableConcept[];
};

export type NutritionOrderEnteralFormulaAdministration = BackboneElement & {
    rate?: Ratio | Quantity;
    quantity?: Quantity;
    schedule?: Timing;
};

export type NutritionOrderEnteralFormula = BackboneElement & {
    additiveType?: CodeableConcept;
    maxVolumeToDeliver?: Quantity;
    baseFormulaType?: CodeableConcept;
    routeofAdministration?: CodeableConcept;
    additiveProductName?: string;
    caloricDensity?: Quantity;
    administrationInstruction?: string;
    administration?: NutritionOrderEnteralFormulaAdministration[];
    baseFormulaProductName?: string;
};

export type NutritionOrderSupplement = BackboneElement & {
    type?: CodeableConcept;
    quantity?: Quantity;
    schedule?: Timing[];
    instruction?: string;
    productName?: string;
};

export type NutritionOrder = DomainResource & {
    patient: Reference;
    oralDiet?: NutritionOrderOralDiet;
    instantiatesCanonical?: string[];
    instantiatesUri?: string[];
    instantiates?: string[];
    encounter?: Reference;
    note?: Annotation[];
    dateTime: string;
    enteralFormula?: NutritionOrderEnteralFormula;
    foodPreferenceModifier?: CodeableConcept[];
    status: string;
    excludeFoodModifier?: CodeableConcept[];
    identifier?: Identifier[];
    intent: string;
    orderer?: Reference;
    supplement?: NutritionOrderSupplement[];
    allergyIntolerance?: Reference[];
};