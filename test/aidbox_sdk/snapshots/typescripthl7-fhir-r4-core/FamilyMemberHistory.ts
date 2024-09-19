import { Annotation } from "./Annotation";
import { Age } from "./Age";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Range } from "./Range";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type FamilyMemberHistoryCondition = BackboneElement & {
    onset?: Range | Age | Period | string;
    contributedToDeath?: boolean;
    outcome?: CodeableConcept;
    note?: Annotation[];
    code: CodeableConcept;
};

export type FamilyMemberHistory = DomainResource & {
    patient: Reference;
    date?: string;
    instantiatesCanonical?: string[];
    instantiatesUri?: string[];
    age?: Range | string | Age;
    sex?: CodeableConcept;
    name?: string;
    relationship: CodeableConcept;
    reasonCode?: CodeableConcept[];
    deceased?: Age | boolean | Range | string;
    note?: Annotation[];
    status: string;
    condition?: FamilyMemberHistoryCondition[];
    identifier?: Identifier[];
    born?: string | Period;
    dataAbsentReason?: CodeableConcept;
    reasonReference?: Reference[];
    estimatedAge?: boolean;
};