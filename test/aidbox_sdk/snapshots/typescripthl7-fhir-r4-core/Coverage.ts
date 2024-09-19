import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Money } from "./Money";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type CoverageCostToBeneficiaryException = BackboneElement & {
    type: CodeableConcept;
    period?: Period;
};

export type CoverageCostToBeneficiary = BackboneElement & {
    type?: CodeableConcept;
    value?: Money | Quantity;
    exception?: CoverageCostToBeneficiaryException[];
};

export type CoverageClass = BackboneElement & {
    name?: string;
    type: CodeableConcept;
    value: string;
};

export type Coverage = DomainResource & {
    policyHolder?: Reference;
    beneficiary: Reference;
    contract?: Reference[];
    relationship?: CodeableConcept;
    type?: CodeableConcept;
    costToBeneficiary?: CoverageCostToBeneficiary[];
    subrogation?: boolean;
    subscriber?: Reference;
    payor: Reference[];
    status: string;
    class_?: CoverageClass[];
    identifier?: Identifier[];
    order?: number;
    network?: string;
    period?: Period;
    dependent?: string;
    subscriberId?: string;
};