import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ImmunizationRecommendationRecommendationDateCriterion = BackboneElement & {
    code: CodeableConcept;
    value: string;
};

export type ImmunizationRecommendationRecommendation = BackboneElement & {
    description?: string;
    contraindicatedVaccineCode?: CodeableConcept[];
    series?: string;
    doseNumber?: number | string;
    vaccineCode?: CodeableConcept[];
    seriesDoses?: number | string;
    forecastStatus: CodeableConcept;
    forecastReason?: CodeableConcept[];
    dateCriterion?: ImmunizationRecommendationRecommendationDateCriterion[];
    targetDisease?: CodeableConcept;
    supportingImmunization?: Reference[];
    supportingPatientInformation?: Reference[];
};

export type ImmunizationRecommendation = DomainResource & {
    date: string;
    patient: Reference;
    authority?: Reference;
    identifier?: Identifier[];
    recommendation: ImmunizationRecommendationRecommendation[];
};