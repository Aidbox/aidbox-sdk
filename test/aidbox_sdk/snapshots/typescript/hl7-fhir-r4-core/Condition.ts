import { Annotation } from "./Annotation";
import { Age } from "./Age";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Range } from "./Range";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ConditionStage = BackboneElement & {
    type?: CodeableConcept;
    summary?: CodeableConcept;
    assessment?: Reference[];
};

export type ConditionEvidence = BackboneElement & {
    code?: CodeableConcept[];
    detail?: Reference[];
};

export type Condition = DomainResource & {
    onset?: Range | Age | Period | string;
    category?: CodeableConcept[];
    clinicalStatus?: CodeableConcept;
    stage?: ConditionStage[];
    encounter?: Reference;
    evidence?: ConditionEvidence[];
    abatement?: Age | Period | string | Range;
    asserter?: Reference;
    note?: Annotation[];
    recordedDate?: string;
    recorder?: Reference;
    severity?: CodeableConcept;
    code?: CodeableConcept;
    identifier?: Identifier[];
    bodySite?: CodeableConcept[];
    verificationStatus?: CodeableConcept;
    subject: Reference;
};