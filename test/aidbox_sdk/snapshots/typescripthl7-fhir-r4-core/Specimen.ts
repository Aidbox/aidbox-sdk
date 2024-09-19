import { Annotation } from "./Annotation";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Quantity } from "./Quantity";
import { Duration } from "./Duration";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type SpecimenProcessing = BackboneElement & {
    time?: Period | string;
    additive?: Reference[];
    procedure?: CodeableConcept;
    description?: string;
};

export type SpecimenContainer = BackboneElement & {
    type?: CodeableConcept;
    additive?: Reference | CodeableConcept;
    capacity?: Quantity;
    identifier?: Identifier[];
    description?: string;
    specimenQuantity?: Quantity;
};

export type SpecimenCollection = BackboneElement & {
    fastingStatus?: CodeableConcept | Duration;
    method?: CodeableConcept;
    duration?: Duration;
    collector?: Reference;
    bodySite?: CodeableConcept;
    quantity?: Quantity;
    collected?: string | Period;
};

export type Specimen = DomainResource & {
    request?: Reference[];
    receivedTime?: string;
    processing?: SpecimenProcessing[];
    parent?: Reference[];
    type?: CodeableConcept;
    note?: Annotation[];
    status?: string;
    condition?: CodeableConcept[];
    container?: SpecimenContainer[];
    identifier?: Identifier[];
    accessionIdentifier?: Identifier;
    collection?: SpecimenCollection;
    subject?: Reference;
};