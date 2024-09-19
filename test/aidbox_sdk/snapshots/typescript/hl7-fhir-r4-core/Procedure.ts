import { Annotation } from "./Annotation";
import { Age } from "./Age";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Range } from "./Range";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ProcedureFocalDevice = BackboneElement & {
    action?: CodeableConcept;
    manipulated: Reference;
};

export type ProcedurePerformer = BackboneElement & {
    actor: Reference;
    function?: CodeableConcept;
    onBehalfOf?: Reference;
};

export type Procedure = DomainResource & {
    category?: CodeableConcept;
    report?: Reference[];
    usedCode?: CodeableConcept[];
    usedReference?: Reference[];
    instantiatesCanonical?: string[];
    instantiatesUri?: string[];
    focalDevice?: ProcedureFocalDevice[];
    encounter?: Reference;
    complicationDetail?: Reference[];
    reasonCode?: CodeableConcept[];
    statusReason?: CodeableConcept;
    performed?: Age | string | Range | Period;
    outcome?: CodeableConcept;
    asserter?: Reference;
    note?: Annotation[];
    complication?: CodeableConcept[];
    status: string;
    recorder?: Reference;
    code?: CodeableConcept;
    identifier?: Identifier[];
    bodySite?: CodeableConcept[];
    basedOn?: Reference[];
    partOf?: Reference[];
    location?: Reference;
    followUp?: CodeableConcept[];
    subject: Reference;
    performer?: ProcedurePerformer[];
    reasonReference?: Reference[];
};