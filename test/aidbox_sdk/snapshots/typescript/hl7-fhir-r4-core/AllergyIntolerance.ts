import { Annotation } from "./Annotation";
import { Age } from "./Age";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Range } from "./Range";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type AllergyIntoleranceReaction = BackboneElement & {
    note?: Annotation[];
    onset?: string;
    severity?: string;
    substance?: CodeableConcept;
    description?: string;
    exposureRoute?: CodeableConcept;
    manifestation: CodeableConcept[];
};

export type AllergyIntolerance = DomainResource & {
    patient: Reference;
    onset?: Range | Age | Period | string;
    category?: string[];
    criticality?: string;
    clinicalStatus?: CodeableConcept;
    encounter?: Reference;
    type?: string;
    asserter?: Reference;
    note?: Annotation[];
    recordedDate?: string;
    recorder?: Reference;
    code?: CodeableConcept;
    identifier?: Identifier[];
    lastOccurrence?: string;
    verificationStatus?: CodeableConcept;
    reaction?: AllergyIntoleranceReaction[];
};