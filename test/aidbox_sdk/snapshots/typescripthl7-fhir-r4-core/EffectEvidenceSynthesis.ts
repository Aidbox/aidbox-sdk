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

export type EffectEvidenceSynthesisEffectEstimatePrecisionEstimate = BackboneElement & {
    to?: number;
    from_?: number;
    type?: CodeableConcept;
    level?: number;
};

export type EffectEvidenceSynthesisEffectEstimate = BackboneElement & {
    type?: CodeableConcept;
    value?: number;
    description?: string;
    variantState?: CodeableConcept;
    unitOfMeasure?: CodeableConcept;
    precisionEstimate?: EffectEvidenceSynthesisEffectEstimatePrecisionEstimate[];
};

export type EffectEvidenceSynthesisSampleSize = BackboneElement & {
    description?: string;
    numberOfStudies?: number;
    numberOfParticipants?: number;
};

export type EffectEvidenceSynthesisCertaintyCertaintySubcomponent = BackboneElement & {
    note?: Annotation[];
    type?: CodeableConcept;
    rating?: CodeableConcept[];
};

export type EffectEvidenceSynthesisCertainty = BackboneElement & {
    note?: Annotation[];
    rating?: CodeableConcept[];
    certaintySubcomponent?: EffectEvidenceSynthesisCertaintyCertaintySubcomponent[];
};

export type EffectEvidenceSynthesisResultsByExposure = BackboneElement & {
    description?: string;
    variantState?: CodeableConcept;
    exposureState?: string;
    riskEvidenceSynthesis: Reference;
};

export type EffectEvidenceSynthesis = DomainResource & {
    description?: string;
    exposureAlternative: Reference;
    date?: string;
    effectEstimate?: EffectEvidenceSynthesisEffectEstimate[];
    endorser?: ContactDetail[];
    publisher?: string;
    approvalDate?: string;
    jurisdiction?: CodeableConcept[];
    sampleSize?: EffectEvidenceSynthesisSampleSize;
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
    certainty?: EffectEvidenceSynthesisCertainty[];
    reviewer?: ContactDetail[];
    exposure: Reference;
    resultsByExposure?: EffectEvidenceSynthesisResultsByExposure[];
    version?: string;
    relatedArtifact?: RelatedArtifact[];
    contact?: ContactDetail[];
    effectivePeriod?: Period;
};