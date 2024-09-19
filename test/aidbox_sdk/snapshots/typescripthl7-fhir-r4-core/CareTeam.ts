import { Annotation } from "./Annotation";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { ContactPoint } from "./ContactPoint";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type CareTeamParticipant = BackboneElement & {
    role?: CodeableConcept[];
    member?: Reference;
    period?: Period;
    onBehalfOf?: Reference;
};

export type CareTeam = DomainResource & {
    category?: CodeableConcept[];
    managingOrganization?: Reference[];
    encounter?: Reference;
    name?: string;
    reasonCode?: CodeableConcept[];
    participant?: CareTeamParticipant[];
    note?: Annotation[];
    status?: string;
    identifier?: Identifier[];
    telecom?: ContactPoint[];
    period?: Period;
    subject?: Reference;
    reasonReference?: Reference[];
};