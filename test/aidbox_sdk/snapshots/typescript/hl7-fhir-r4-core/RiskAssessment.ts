import { Annotation } from "./Annotation";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Range } from "./Range";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type RiskAssessmentPrediction = BackboneElement & {
    relativeRisk?: number;
    when?: Range | Period;
    outcome?: CodeableConcept;
    probability?: Range | number;
    rationale?: string;
    qualitativeRisk?: CodeableConcept;
};

export type RiskAssessment = DomainResource & {
    parent?: Reference;
    encounter?: Reference;
    prediction?: RiskAssessmentPrediction[];
    method?: CodeableConcept;
    basis?: Reference[];
    reasonCode?: CodeableConcept[];
    mitigation?: string;
    note?: Annotation[];
    status: string;
    condition?: Reference;
    code?: CodeableConcept;
    identifier?: Identifier[];
    basedOn?: Reference;
    subject: Reference;
    occurrence?: Period | string;
    performer?: Reference;
    reasonReference?: Reference[];
};