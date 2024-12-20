import { UsageContext } from "./UsageContext";
import { Attachment } from "./Attachment";
import { Period } from "./Period";
import { ContactDetail } from "./ContactDetail";
import { DataRequirement } from "./DataRequirement";
import { CodeableConcept } from "./CodeableConcept";
import { RelatedArtifact } from "./RelatedArtifact";
import { DomainResource } from "./DomainResource";
import { ParameterDefinition } from "./ParameterDefinition";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type Library = DomainResource & {
    description?: string;
    date?: string;
    dataRequirement?: DataRequirement[];
    endorser?: ContactDetail[];
    publisher?: string;
    approvalDate?: string;
    jurisdiction?: CodeableConcept[];
    purpose?: string;
    content?: Attachment[];
    name?: string;
    useContext?: UsageContext[];
    copyright?: string;
    type: CodeableConcept;
    experimental?: boolean;
    topic?: CodeableConcept[];
    title?: string;
    author?: ContactDetail[];
    usage?: string;
    status: string;
    subtitle?: string;
    url?: string;
    identifier?: Identifier[];
    lastReviewDate?: string;
    editor?: ContactDetail[];
    reviewer?: ContactDetail[];
    version?: string;
    relatedArtifact?: RelatedArtifact[];
    contact?: ContactDetail[];
    subject?: CodeableConcept | Reference;
    parameter?: ParameterDefinition[];
    effectivePeriod?: Period;
};