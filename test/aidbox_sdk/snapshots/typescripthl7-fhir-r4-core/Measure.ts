import { UsageContext } from "./UsageContext";
import { Period } from "./Period";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { Expression } from "./Expression";
import { RelatedArtifact } from "./RelatedArtifact";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type MeasureGroupPopulation = BackboneElement & {
    code?: CodeableConcept;
    criteria: Expression;
    description?: string;
};

export type MeasureGroupStratifierComponent = BackboneElement & {
    code?: CodeableConcept;
    criteria: Expression;
    description?: string;
};

export type MeasureGroupStratifier = BackboneElement & {
    code?: CodeableConcept;
    criteria?: Expression;
    component?: MeasureGroupStratifierComponent[];
    description?: string;
};

export type MeasureGroup = BackboneElement & {
    code?: CodeableConcept;
    population?: MeasureGroupPopulation[];
    stratifier?: MeasureGroupStratifier[];
    description?: string;
};

export type MeasureSupplementalData = BackboneElement & {
    code?: CodeableConcept;
    usage?: CodeableConcept[];
    criteria: Expression;
    description?: string;
};

export type Measure = DomainResource & {
    description?: string;
    definition?: string[];
    date?: string;
    group?: MeasureGroup[];
    endorser?: ContactDetail[];
    publisher?: string;
    approvalDate?: string;
    compositeScoring?: CodeableConcept;
    disclaimer?: string;
    jurisdiction?: CodeableConcept[];
    purpose?: string;
    name?: string;
    useContext?: UsageContext[];
    copyright?: string;
    guidance?: string;
    type?: CodeableConcept[];
    experimental?: boolean;
    topic?: CodeableConcept[];
    title?: string;
    supplementalData?: MeasureSupplementalData[];
    library?: string[];
    author?: ContactDetail[];
    usage?: string;
    rationale?: string;
    status: string;
    subtitle?: string;
    url?: string;
    identifier?: Identifier[];
    lastReviewDate?: string;
    editor?: ContactDetail[];
    riskAdjustment?: string;
    scoring?: CodeableConcept;
    reviewer?: ContactDetail[];
    version?: string;
    relatedArtifact?: RelatedArtifact[];
    contact?: ContactDetail[];
    improvementNotation?: CodeableConcept;
    subject?: CodeableConcept | Reference;
    rateAggregation?: string;
    effectivePeriod?: Period;
    clinicalRecommendationStatement?: string;
};