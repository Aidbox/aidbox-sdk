import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { ContactPoint } from "./ContactPoint";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type Endpoint = DomainResource & {
    connectionType: Coding;
    address: string;
    managingOrganization?: Reference;
    name?: string;
    payloadMimeType?: string[];
    payloadType: CodeableConcept[];
    header?: string[];
    status: string;
    identifier?: Identifier[];
    period?: Period;
    contact?: ContactPoint[];
};