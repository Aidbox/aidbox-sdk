import { Annotation } from "./Annotation";
import { DataRequirement } from "./DataRequirement";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type GuidanceResponse = DomainResource & {
    dataRequirement?: DataRequirement[];
    encounter?: Reference;
    reasonCode?: CodeableConcept[];
    outputParameters?: Reference;
    evaluationMessage?: Reference[];
    requestIdentifier?: Identifier;
    module?: string | CodeableConcept;
    note?: Annotation[];
    status: string;
    result?: Reference;
    identifier?: Identifier[];
    occurrenceDateTime?: string;
    subject?: Reference;
    performer?: Reference;
    reasonReference?: Reference[];
};