import { Annotation } from "./Annotation";
import { CodeableConcept } from "./CodeableConcept";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ImmunizationProtocolApplied = BackboneElement & {
    series?: string;
    doseNumber?: number | string;
    authority?: Reference;
    seriesDoses?: number | string;
    targetDisease?: CodeableConcept[];
};

export type ImmunizationEducation = BackboneElement & {
    reference?: string;
    documentType?: string;
    publicationDate?: string;
    presentationDate?: string;
};

export type ImmunizationReaction = BackboneElement & {
    date?: string;
    detail?: Reference;
    reported?: boolean;
};

export type ImmunizationPerformer = BackboneElement & {
    actor: Reference;
    function?: CodeableConcept;
};

export type Immunization = DomainResource & {
    patient: Reference;
    isSubpotent?: boolean;
    reportOrigin?: CodeableConcept;
    protocolApplied?: ImmunizationProtocolApplied[];
    site?: CodeableConcept;
    encounter?: Reference;
    vaccineCode: CodeableConcept;
    doseQuantity?: Quantity;
    reasonCode?: CodeableConcept[];
    statusReason?: CodeableConcept;
    route?: CodeableConcept;
    recorded?: string;
    programEligibility?: CodeableConcept[];
    note?: Annotation[];
    primarySource?: boolean;
    status: string;
    lotNumber?: string;
    identifier?: Identifier[];
    manufacturer?: Reference;
    education?: ImmunizationEducation[];
    reaction?: ImmunizationReaction[];
    location?: Reference;
    fundingSource?: CodeableConcept;
    subpotentReason?: CodeableConcept[];
    occurrence?: string;
    expirationDate?: string;
    performer?: ImmunizationPerformer[];
    reasonReference?: Reference[];
};