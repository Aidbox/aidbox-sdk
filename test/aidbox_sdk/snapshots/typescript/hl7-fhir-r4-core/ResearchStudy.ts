import { Annotation } from "./Annotation";
import { Period } from "./Period";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { RelatedArtifact } from "./RelatedArtifact";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ResearchStudyArm = BackboneElement & {
    name: string;
    type?: CodeableConcept;
    description?: string;
};

export type ResearchStudyObjective = BackboneElement & {
    name?: string;
    type?: CodeableConcept;
};

export type ResearchStudy = DomainResource & {
    description?: string;
    category?: CodeableConcept[];
    enrollment?: Reference[];
    arm?: ResearchStudyArm[];
    site?: Reference[];
    protocol?: Reference[];
    principalInvestigator?: Reference;
    phase?: CodeableConcept;
    reasonStopped?: CodeableConcept;
    title?: string;
    note?: Annotation[];
    keyword?: CodeableConcept[];
    status: string;
    condition?: CodeableConcept[];
    identifier?: Identifier[];
    primaryPurposeType?: CodeableConcept;
    focus?: CodeableConcept[];
    objective?: ResearchStudyObjective[];
    period?: Period;
    partOf?: Reference[];
    relatedArtifact?: RelatedArtifact[];
    location?: CodeableConcept[];
    contact?: ContactDetail[];
    sponsor?: Reference;
};