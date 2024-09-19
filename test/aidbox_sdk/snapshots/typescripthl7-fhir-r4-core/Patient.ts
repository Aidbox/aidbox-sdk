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

export type PatientLink = BackboneElement & {
    type: string;
    other: Reference;
};

export type PatientCommunication = BackboneElement & {
    language: CodeableConcept;
    preferred?: boolean;
};

export type PatientContact = BackboneElement & {
    name?: HumanName;
    gender?: string;
    period?: Period;
    address?: Address;
    telecom?: ContactPoint[];
    organization?: Reference;
    relationship?: CodeableConcept[];
};

export type Patient = DomainResource & {
    address?: Address[];
    managingOrganization?: Reference;
    name?: HumanName[];
    birthDate?: string;
    multipleBirth?: boolean | number;
    deceased?: string | boolean;
    photo?: Attachment[];
    link?: PatientLink[];
    active?: boolean;
    communication?: PatientCommunication[];
    identifier?: Identifier[];
    telecom?: ContactPoint[];
    generalPractitioner?: Reference[];
    gender?: string;
    maritalStatus?: CodeableConcept;
    contact?: PatientContact[];
};