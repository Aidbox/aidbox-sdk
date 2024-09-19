import { Attachment } from "./Attachment";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type DocumentReferenceContent = BackboneElement & {
    format?: Coding;
    attachment: Attachment;
};

export type DocumentReferenceRelatesTo = BackboneElement & {
    code: string;
    target: Reference;
};

export type DocumentReferenceContext = BackboneElement & {
    event?: CodeableConcept[];
    period?: Period;
    related?: Reference[];
    encounter?: Reference[];
    facilityType?: CodeableConcept;
    practiceSetting?: CodeableConcept;
    sourcePatientInfo?: Reference;
};

export type DocumentReference = DomainResource & {
    description?: string;
    category?: CodeableConcept[];
    date?: string;
    docStatus?: string;
    content: DocumentReferenceContent[];
    type?: CodeableConcept;
    author?: Reference[];
    masterIdentifier?: Identifier;
    custodian?: Reference;
    status: string;
    identifier?: Identifier[];
    relatesTo?: DocumentReferenceRelatesTo[];
    context?: DocumentReferenceContext;
    securityLabel?: CodeableConcept[];
    subject?: Reference;
    authenticator?: Reference;
};