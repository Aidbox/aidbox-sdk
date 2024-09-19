import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Money } from "./Money";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type CoverageEligibilityRequestInsurance = BackboneElement & {
    focal?: boolean;
    coverage: Reference;
    businessArrangement?: string;
};

export type CoverageEligibilityRequestSupportingInfo = BackboneElement & {
    sequence: number;
    information: Reference;
    appliesToAll?: boolean;
};

export type CoverageEligibilityRequestItemDiagnosis = BackboneElement & {
    diagnosis?: Reference | CodeableConcept;
};

export type CoverageEligibilityRequestItem = BackboneElement & {
    category?: CodeableConcept;
    facility?: Reference;
    diagnosis?: CoverageEligibilityRequestItemDiagnosis[];
    modifier?: CodeableConcept[];
    productOrService?: CodeableConcept;
    quantity?: Quantity;
    provider?: Reference;
    supportingInfoSequence?: number[];
    unitPrice?: Money;
    detail?: Reference[];
};

export type CoverageEligibilityRequest = DomainResource & {
    patient: Reference;
    insurance?: CoverageEligibilityRequestInsurance[];
    facility?: Reference;
    enterer?: Reference;
    supportingInfo?: CoverageEligibilityRequestSupportingInfo[];
    purpose: string[];
    item?: CoverageEligibilityRequestItem[];
    created: string;
    serviced?: string | Period;
    insurer: Reference;
    priority?: CodeableConcept;
    status: string;
    identifier?: Identifier[];
    provider?: Reference;
};