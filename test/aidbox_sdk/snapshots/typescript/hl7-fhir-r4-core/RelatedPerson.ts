import { Address } from "./Address";
import { Attachment } from "./Attachment";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { ContactPoint } from "./ContactPoint";
import { HumanName } from "./HumanName";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type RelatedPersonCommunication = BackboneElement & {
    language: CodeableConcept;
    preferred?: boolean;
};

export type RelatedPerson = DomainResource & {
    patient: Reference;
    address?: Address[];
    name?: HumanName[];
    birthDate?: string;
    relationship?: CodeableConcept[];
    photo?: Attachment[];
    active?: boolean;
    communication?: RelatedPersonCommunication[];
    identifier?: Identifier[];
    telecom?: ContactPoint[];
    gender?: string;
    period?: Period;
};