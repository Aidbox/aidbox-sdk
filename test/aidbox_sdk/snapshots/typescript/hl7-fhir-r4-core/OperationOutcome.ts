import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { BackboneElement } from "./BackboneElement";

export type OperationOutcomeIssue = BackboneElement & {
    code: string;
    details?: CodeableConcept;
    location?: string[];
    severity: string;
    expression?: string[];
    diagnostics?: string;
};

export type OperationOutcome = DomainResource & {
    issue: OperationOutcomeIssue[];
};