import { Annotation } from "./Annotation";
import { CodeableConcept } from "./CodeableConcept";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type VisionPrescriptionLensSpecificationPrism = BackboneElement & {
    base: string;
    amount: number;
};

export type VisionPrescriptionLensSpecification = BackboneElement & {
    sphere?: number;
    color?: string;
    eye: string;
    diameter?: number;
    duration?: Quantity;
    brand?: string;
    note?: Annotation[];
    power?: number;
    product: CodeableConcept;
    cylinder?: number;
    prism?: VisionPrescriptionLensSpecificationPrism[];
    axis?: number;
    add?: number;
    backCurve?: number;
};

export type VisionPrescription = DomainResource & {
    status: string;
    created: string;
    patient: Reference;
    encounter?: Reference;
    identifier?: Identifier[];
    prescriber: Reference;
    dateWritten: string;
    lensSpecification: VisionPrescriptionLensSpecification[];
};