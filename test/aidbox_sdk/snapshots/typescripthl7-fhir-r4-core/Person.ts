import { Address } from "./Address";
import { Attachment } from "./Attachment";
import { ContactPoint } from "./ContactPoint";
import { HumanName } from "./HumanName";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type PersonLink = BackboneElement & {
    target: Reference;
    assurance?: string;
};

export type Person = DomainResource & {
    address?: Address[];
    managingOrganization?: Reference;
    name?: HumanName[];
    birthDate?: string;
    photo?: Attachment;
    link?: PersonLink[];
    active?: boolean;
    identifier?: Identifier[];
    telecom?: ContactPoint[];
    gender?: string;
};