import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type DetectedIssueEvidence = BackboneElement & {
    code?: CodeableConcept[];
    detail?: Reference[];
};

export type DetectedIssueMitigation = BackboneElement & {
    date?: string;
    action: CodeableConcept;
    author?: Reference;
};

export type DetectedIssue = DomainResource & {
    patient?: Reference;
    evidence?: DetectedIssueEvidence[];
    mitigation?: DetectedIssueMitigation[];
    author?: Reference;
    reference?: string;
    status: string;
    severity?: string;
    code?: CodeableConcept;
    identifier?: Identifier[];
    identified?: string | Period;
    implicated?: Reference[];
    detail?: string;
};