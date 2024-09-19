import { Annotation } from "./Annotation";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ClinicalImpressionInvestigation = BackboneElement & {
    code: CodeableConcept;
    item?: Reference[];
};

export type ClinicalImpressionFinding = BackboneElement & {
    basis?: string;
    itemReference?: Reference;
    itemCodeableConcept?: CodeableConcept;
};

export type ClinicalImpression = DomainResource & {
    description?: string;
    date?: string;
    investigation?: ClinicalImpressionInvestigation[];
    protocol?: string[];
    assessor?: Reference;
    supportingInfo?: Reference[];
    encounter?: Reference;
    problem?: Reference[];
    statusReason?: CodeableConcept;
    note?: Annotation[];
    summary?: string;
    prognosisCodeableConcept?: CodeableConcept[];
    status: string;
    effective?: string | Period;
    previous?: Reference;
    code?: CodeableConcept;
    identifier?: Identifier[];
    finding?: ClinicalImpressionFinding[];
    prognosisReference?: Reference[];
    subject: Reference;
};