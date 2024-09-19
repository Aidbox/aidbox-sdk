import { Attachment } from "./Attachment";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type DiagnosticReportMedia = BackboneElement & {
    link: Reference;
    comment?: string;
};

export type DiagnosticReport = DomainResource & {
    category?: CodeableConcept[];
    conclusionCode?: CodeableConcept[];
    conclusion?: string;
    encounter?: Reference;
    specimen?: Reference[];
    resultsInterpreter?: Reference[];
    status: string;
    result?: Reference[];
    effective?: string | Period;
    code: CodeableConcept;
    identifier?: Identifier[];
    issued?: string;
    presentedForm?: Attachment[];
    basedOn?: Reference[];
    imagingStudy?: Reference[];
    media?: DiagnosticReportMedia[];
    subject?: Reference;
    performer?: Reference[];
};