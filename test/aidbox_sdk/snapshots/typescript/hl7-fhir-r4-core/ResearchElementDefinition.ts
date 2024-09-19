import { UsageContext } from "./UsageContext";
import { Period } from "./Period";
import { ContactDetail } from "./ContactDetail";
import { DataRequirement } from "./DataRequirement";
import { CodeableConcept } from "./CodeableConcept";
import { Expression } from "./Expression";
import { RelatedArtifact } from "./RelatedArtifact";
import { Timing } from "./Timing";
import { Duration } from "./Duration";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ResearchElementDefinitionCharacteristic = BackboneElement & {
    definition?: Expression | DataRequirement | string | CodeableConcept;
    exclude?: boolean;
    studyEffectiveGroupMeasure?: string;
    participantEffectiveGroupMeasure?: string;
    studyEffectiveDescription?: string;
    studyEffectiveTimeFromStart?: Duration;
    unitOfMeasure?: CodeableConcept;
    studyEffective?: Timing | Duration | Period | string;
    participantEffectiveDescription?: string;
    participantEffective?: Duration | Timing | string | Period;
    usageContext?: UsageContext[];
    participantEffectiveTimeFromStart?: Duration;
};

export type ResearchElementDefinition = DomainResource & {
    description?: string;
    date?: string;
    endorser?: ContactDetail[];
    publisher?: string;
    approvalDate?: string;
    variableType?: string;
    jurisdiction?: CodeableConcept[];
    purpose?: string;
    name?: string;
    useContext?: UsageContext[];
    copyright?: string;
    type: string;
    experimental?: boolean;
    topic?: CodeableConcept[];
    title?: string;
    library?: string[];
    author?: ContactDetail[];
    characteristic: ResearchElementDefinitionCharacteristic[];
    usage?: string;
    status: string;
    subtitle?: string;
    comment?: string[];
    url?: string;
    identifier?: Identifier[];
    lastReviewDate?: string;
    editor?: ContactDetail[];
    reviewer?: ContactDetail[];
    shortTitle?: string;
    version?: string;
    relatedArtifact?: RelatedArtifact[];
    contact?: ContactDetail[];
    subject?: CodeableConcept | Reference;
    effectivePeriod?: Period;
};