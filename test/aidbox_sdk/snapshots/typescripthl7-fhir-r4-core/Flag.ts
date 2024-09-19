import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type Flag = DomainResource & {
    code: CodeableConcept;
    author?: Reference;
    period?: Period;
    status: string;
    subject: Reference;
    category?: CodeableConcept[];
    encounter?: Reference;
    identifier?: Identifier[];
};