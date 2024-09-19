import { Attachment } from "./Attachment";
import { CodeableConcept } from "./CodeableConcept";
import { SubstanceAmount } from "./SubstanceAmount";
import { DomainResource } from "./DomainResource";
import { BackboneElement } from "./BackboneElement";

export type SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisation = BackboneElement & {
    amount?: SubstanceAmount;
    degree?: CodeableConcept;
};

export type SubstancePolymerRepeatRepeatUnitStructuralRepresentation = BackboneElement & {
    type?: CodeableConcept;
    attachment?: Attachment;
    representation?: string;
};

export type SubstancePolymerRepeatRepeatUnit = BackboneElement & {
    amount?: SubstanceAmount;
    repeatUnit?: string;
    degreeOfPolymerisation?: SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisation[];
    structuralRepresentation?: SubstancePolymerRepeatRepeatUnitStructuralRepresentation[];
    orientationOfPolymerisation?: CodeableConcept;
};

export type SubstancePolymerRepeat = BackboneElement & {
    repeatUnit?: SubstancePolymerRepeatRepeatUnit[];
    numberOfUnits?: number;
    repeatUnitAmountType?: CodeableConcept;
    averageMolecularFormula?: string;
};

export type SubstancePolymerMonomerSetStartingMaterial = BackboneElement & {
    type?: CodeableConcept;
    amount?: SubstanceAmount;
    material?: CodeableConcept;
    isDefining?: boolean;
};

export type SubstancePolymerMonomerSet = BackboneElement & {
    ratioType?: CodeableConcept;
    startingMaterial?: SubstancePolymerMonomerSetStartingMaterial[];
};

export type SubstancePolymer = DomainResource & {
    class_?: CodeableConcept;
    repeat?: SubstancePolymerRepeat[];
    geometry?: CodeableConcept;
    monomerSet?: SubstancePolymerMonomerSet[];
    modification?: string[];
    copolymerConnectivity?: CodeableConcept[];
};