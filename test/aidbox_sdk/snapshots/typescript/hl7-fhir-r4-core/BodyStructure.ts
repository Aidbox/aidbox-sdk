import { Attachment } from "./Attachment";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type BodyStructure = DomainResource & {
    image?: Attachment[];
    active?: boolean;
    patient: Reference;
    location?: CodeableConcept;
    identifier?: Identifier[];
    morphology?: CodeableConcept;
    description?: string;
    locationQualifier?: CodeableConcept[];
};