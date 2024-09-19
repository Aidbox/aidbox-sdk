import { Address } from "./Address";
import { CodeableConcept } from "./CodeableConcept";
import { ContactPoint } from "./ContactPoint";
import { HumanName } from "./HumanName";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type OrganizationContact = BackboneElement & {
    name?: HumanName;
    address?: Address;
    purpose?: CodeableConcept;
    telecom?: ContactPoint[];
};

export type Organization = DomainResource & {
    address?: Address[];
    name?: string;
    type?: CodeableConcept[];
    alias?: string[];
    active?: boolean;
    identifier?: Identifier[];
    telecom?: ContactPoint[];
    partOf?: Reference;
    endpoint?: Reference[];
    contact?: OrganizationContact[];
};