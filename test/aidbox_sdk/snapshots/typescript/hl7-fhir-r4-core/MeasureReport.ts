import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type MeasureReportGroupPopulation = BackboneElement & {
    code?: CodeableConcept;
    count?: number;
    subjectResults?: Reference;
};

export type MeasureReportGroupStratifierStratumComponent = BackboneElement & {
    code: CodeableConcept;
    value: CodeableConcept;
};

export type MeasureReportGroupStratifierStratumPopulation = BackboneElement & {
    code?: CodeableConcept;
    count?: number;
    subjectResults?: Reference;
};

export type MeasureReportGroupStratifierStratum = BackboneElement & {
    value?: CodeableConcept;
    component?: MeasureReportGroupStratifierStratumComponent[];
    population?: MeasureReportGroupStratifierStratumPopulation[];
    measureScore?: Quantity;
};

export type MeasureReportGroupStratifier = BackboneElement & {
    code?: CodeableConcept[];
    stratum?: MeasureReportGroupStratifierStratum[];
};

export type MeasureReportGroup = BackboneElement & {
    code?: CodeableConcept;
    population?: MeasureReportGroupPopulation[];
    stratifier?: MeasureReportGroupStratifier[];
    measureScore?: Quantity;
};

export type MeasureReport = DomainResource & {
    evaluatedResource?: Reference[];
    date?: string;
    group?: MeasureReportGroup[];
    type: string;
    measure: string;
    reporter?: Reference;
    status: string;
    identifier?: Identifier[];
    period: Period;
    improvementNotation?: CodeableConcept;
    subject?: Reference;
};