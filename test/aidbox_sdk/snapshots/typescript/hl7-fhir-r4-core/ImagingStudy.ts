import { Annotation } from "./Annotation";
import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ImagingStudySeriesInstance = BackboneElement & {
    uid: string;
    title?: string;
    number?: number;
    sopClass: Coding;
};

export type ImagingStudySeriesPerformer = BackboneElement & {
    actor: Reference;
    function?: CodeableConcept;
};

export type ImagingStudySeries = BackboneElement & {
    description?: string;
    started?: string;
    laterality?: Coding;
    instance?: ImagingStudySeriesInstance[];
    number?: number;
    uid: string;
    specimen?: Reference[];
    modality: Coding;
    bodySite?: Coding;
    endpoint?: Reference[];
    numberOfInstances?: number;
    performer?: ImagingStudySeriesPerformer[];
};

export type ImagingStudy = DomainResource & {
    description?: string;
    started?: string;
    numberOfSeries?: number;
    interpreter?: Reference[];
    series?: ImagingStudySeries[];
    procedureReference?: Reference;
    encounter?: Reference;
    reasonCode?: CodeableConcept[];
    modality?: Coding[];
    note?: Annotation[];
    referrer?: Reference;
    status: string;
    identifier?: Identifier[];
    basedOn?: Reference[];
    location?: Reference;
    endpoint?: Reference[];
    subject: Reference;
    numberOfInstances?: number;
    reasonReference?: Reference[];
    procedureCode?: CodeableConcept[];
};