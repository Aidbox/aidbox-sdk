import { Annotation } from "./Annotation";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Timing } from "./Timing";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type DeviceUseStatement = DomainResource & {
    derivedFrom?: Reference[];
    reasonCode?: CodeableConcept[];
    source?: Reference;
    note?: Annotation[];
    status: string;
    timing?: Period | string | Timing;
    recordedOn?: string;
    identifier?: Identifier[];
    bodySite?: CodeableConcept;
    device: Reference;
    basedOn?: Reference[];
    subject: Reference;
    reasonReference?: Reference[];
};