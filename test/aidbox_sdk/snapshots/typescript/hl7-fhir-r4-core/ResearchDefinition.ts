import { UsageContext } from "./UsageContext";
import { Period } from "./Period";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { RelatedArtifact } from "./RelatedArtifact";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type ResearchDefinition = DomainResource & {
    description?: string;
    exposureAlternative?: Reference;
    date?: string;
    endorser?: ContactDetail[];
    publisher?: string;
    approvalDate?: string;
    jurisdiction?: CodeableConcept[];
    purpose?: string;
    name?: string;
    useContext?: UsageContext[];
    copyright?: string;
    experimental?: boolean;
    outcome?: Reference;
    topic?: CodeableConcept[];
    title?: string;
    library?: string[];
    author?: ContactDetail[];
    usage?: string;
    status: string;
    subtitle?: string;
    population: Reference;
    comment?: string[];
    url?: string;
    identifier?: Identifier[];
    lastReviewDate?: string;
    editor?: ContactDetail[];
    reviewer?: ContactDetail[];
    shortTitle?: string;
    exposure?: Reference;
    version?: string;
    relatedArtifact?: RelatedArtifact[];
    contact?: ContactDetail[];
    subject?: CodeableConcept | Reference;
    effectivePeriod?: Period;
};