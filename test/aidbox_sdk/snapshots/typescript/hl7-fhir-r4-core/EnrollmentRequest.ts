import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type EnrollmentRequest = DomainResource & {
    status?: string;
    created?: string;
    insurer?: Reference;
    coverage?: Reference;
    provider?: Reference;
    candidate?: Reference;
    identifier?: Identifier[];
};