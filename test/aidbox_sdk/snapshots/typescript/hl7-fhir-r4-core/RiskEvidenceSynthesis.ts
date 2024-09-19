import { UsageContext } from "./UsageContext";
import { Annotation } from "./Annotation";
import { Period } from "./Period";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { RelatedArtifact } from "./RelatedArtifact";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type RiskEvidenceSynthesisSampleSize = BackboneElement & {
    description?: string;
    numberOfStudies?: number;
    numberOfParticipants?: number;
};

export type RiskEvidenceSynthesisCertaintyCertaintySubcomponent = BackboneElement & {
    note?: Annotation[];
    type?: CodeableConcept;
    rating?: CodeableConcept[];
};

export type RiskEvidenceSynthesisCertainty = BackboneElement & {
    note?: Annotation[];
    rating?: CodeableConcept[];
    certaintySubcomponent?: RiskEvidenceSynthesisCertaintyCertaintySubcomponent[];
};

export type RiskEvidenceSynthesisRiskEstimatePrecisionEstimate = BackboneElement & {
    to?: number;
    from_?: number;
    type?: CodeableConcept;
    level?: number;
};

export type RiskEvidenceSynthesisRiskEstimate = BackboneElement & {
    type?: CodeableConcept;
    value?: number;
    description?: string;
    unitOfMeasure?: CodeableConcept;
    numeratorCount?: number;
    denominatorCount?: number;
    precisionEstimate?: RiskEvidenceSynthesisRiskEstimatePrecisionEstimate[];
};

export type RiskEvidenceSynthesis = DomainResource & {
    description?: string;
    date?: string;
    endorser?: ContactDetail[];
    publisher?: string;
    approvalDate?: string;
    jurisdiction?: CodeableConcept[];
    sampleSize?: RiskEvidenceSynthesisSampleSize;
    name?: string;
    useContext?: UsageContext[];
    copyright?: string;
    studyType?: CodeableConcept;
    outcome: Reference;
    topic?: CodeableConcept[];
    title?: string;
    note?: Annotation[];
    author?: ContactDetail[];
    synthesisType?: CodeableConcept;
    status: string;
    population: Reference;
    url?: string;
    identifier?: Identifier[];
    lastReviewDate?: string;
    editor?: ContactDetail[];
    certainty?: RiskEvidenceSynthesisCertainty[];
    reviewer?: ContactDetail[];
    exposure?: Reference;
    version?: string;
    relatedArtifact?: RelatedArtifact[];
    contact?: ContactDetail[];
    riskEstimate?: RiskEvidenceSynthesisRiskEstimate;
    effectivePeriod?: Period;
};