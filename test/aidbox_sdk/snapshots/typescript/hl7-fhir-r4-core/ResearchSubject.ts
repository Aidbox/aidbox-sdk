import { Period } from "./Period";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type ResearchSubject = DomainResource & {
    study: Reference;
    period?: Period;
    status: string;
    consent?: Reference;
    actualArm?: string;
    identifier?: Identifier[];
    individual: Reference;
    assignedArm?: string;
};