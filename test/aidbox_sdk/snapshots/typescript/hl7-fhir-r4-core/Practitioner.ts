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

export type PractitionerQualification = BackboneElement & {
    code: CodeableConcept;
    issuer?: Reference;
    period?: Period;
    identifier?: Identifier[];
};

export type Practitioner = DomainResource & {
    address?: Address[];
    name?: HumanName[];
    birthDate?: string;
    photo?: Attachment[];
    active?: boolean;
    communication?: CodeableConcept[];
    identifier?: Identifier[];
    qualification?: PractitionerQualification[];
    telecom?: ContactPoint[];
    gender?: string;
};