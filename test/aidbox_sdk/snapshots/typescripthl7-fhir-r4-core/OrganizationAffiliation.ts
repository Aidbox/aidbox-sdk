import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { ContactPoint } from "./ContactPoint";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type OrganizationAffiliation = DomainResource & {
    specialty?: CodeableConcept[];
    organization?: Reference;
    participatingOrganization?: Reference;
    active?: boolean;
    code?: CodeableConcept[];
    identifier?: Identifier[];
    telecom?: ContactPoint[];
    network?: Reference[];
    period?: Period;
    location?: Reference[];
    endpoint?: Reference[];
    healthcareService?: Reference[];
};