import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type EnrollmentResponse = DomainResource & {
    status?: string;
    created?: string;
    outcome?: string;
    request?: Reference;
    identifier?: Identifier[];
    disposition?: string;
    organization?: Reference;
    requestProvider?: Reference;
};