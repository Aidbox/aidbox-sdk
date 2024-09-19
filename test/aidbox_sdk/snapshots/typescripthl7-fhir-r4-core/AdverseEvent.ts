import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type AdverseEventSuspectEntityCausality = BackboneElement & {
    author?: Reference;
    method?: CodeableConcept;
    assessment?: CodeableConcept;
    productRelatedness?: string;
};

export type AdverseEventSuspectEntity = BackboneElement & {
    instance: Reference;
    causality?: AdverseEventSuspectEntityCausality[];
};

export type AdverseEvent = DomainResource & {
    category?: CodeableConcept[];
    actuality: string;
    date?: string;
    study?: Reference[];
    encounter?: Reference;
    suspectEntity?: AdverseEventSuspectEntity[];
    referenceDocument?: Reference[];
    outcome?: CodeableConcept;
    recordedDate?: string;
    event?: CodeableConcept;
    contributor?: Reference[];
    subjectMedicalHistory?: Reference[];
    recorder?: Reference;
    seriousness?: CodeableConcept;
    severity?: CodeableConcept;
    identifier?: Identifier;
    detected?: string;
    location?: Reference;
    subject: Reference;
    resultingCondition?: Reference[];
};