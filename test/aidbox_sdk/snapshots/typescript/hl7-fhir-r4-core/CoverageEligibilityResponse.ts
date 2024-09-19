import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Money } from "./Money";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type CoverageEligibilityResponseInsuranceItemBenefit = BackboneElement & {
    type: CodeableConcept;
    allowed?: Money | number | string;
    used?: string | number | Money;
};

export type CoverageEligibilityResponseInsuranceItem = BackboneElement & {
    description?: string;
    category?: CodeableConcept;
    authorizationRequired?: boolean;
    modifier?: CodeableConcept[];
    authorizationSupporting?: CodeableConcept[];
    unit?: CodeableConcept;
    excluded?: boolean;
    name?: string;
    productOrService?: CodeableConcept;
    term?: CodeableConcept;
    benefit?: CoverageEligibilityResponseInsuranceItemBenefit[];
    authorizationUrl?: string;
    network?: CodeableConcept;
    provider?: Reference;
};

export type CoverageEligibilityResponseInsurance = BackboneElement & {
    item?: CoverageEligibilityResponseInsuranceItem[];
    inforce?: boolean;
    coverage: Reference;
    benefitPeriod?: Period;
};

export type CoverageEligibilityResponseError = BackboneElement & {
    code: CodeableConcept;
};

export type CoverageEligibilityResponse = DomainResource & {
    patient: Reference;
    requestor?: Reference;
    insurance?: CoverageEligibilityResponseInsurance[];
    request: Reference;
    preAuthRef?: string;
    purpose: string[];
    created: string;
    serviced?: string | Period;
    outcome: string;
    disposition?: string;
    insurer: Reference;
    status: string;
    identifier?: Identifier[];
    error?: CoverageEligibilityResponseError[];
    form?: CodeableConcept;
};