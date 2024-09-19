import { Annotation } from "./Annotation";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Range } from "./Range";
import { Timing } from "./Timing";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { SampledData } from "./SampledData";
import { Ratio } from "./Ratio";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ObservationReferenceRange = BackboneElement & {
    age?: Range;
    low?: Quantity;
    high?: Quantity;
    text?: string;
    type?: CodeableConcept;
    appliesTo?: CodeableConcept[];
};

export type ObservationComponent = BackboneElement & {
    referenceRange?: Reference[];
    interpretation?: CodeableConcept[];
    value?: string | Quantity | Ratio | boolean | SampledData | CodeableConcept | Period | Range | number;
    code: CodeableConcept;
    dataAbsentReason?: CodeableConcept;
};

export type Observation = DomainResource & {
    category?: CodeableConcept[];
    referenceRange?: ObservationReferenceRange[];
    hasMember?: Reference[];
    derivedFrom?: Reference[];
    interpretation?: CodeableConcept[];
    encounter?: Reference;
    method?: CodeableConcept;
    specimen?: Reference;
    value?: string | Quantity | Ratio | boolean | SampledData | CodeableConcept | Period | Range | number;
    component?: ObservationComponent[];
    note?: Annotation[];
    status: string;
    effective?: string | Timing | Period;
    code: CodeableConcept;
    identifier?: Identifier[];
    bodySite?: CodeableConcept;
    focus?: Reference[];
    issued?: string;
    device?: Reference;
    basedOn?: Reference[];
    partOf?: Reference[];
    subject?: Reference;
    performer?: Reference[];
    dataAbsentReason?: CodeableConcept;
};