import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type Basic = DomainResource & {
    code: CodeableConcept;
    author?: Reference;
    created?: string;
    subject?: Reference;
    identifier?: Identifier[];
};