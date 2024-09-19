import { Address } from "./Address";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { ContactPoint } from "./ContactPoint";
import { Quantity } from "./Quantity";
import { HumanName } from "./HumanName";
import { DomainResource } from "./DomainResource";
import { Money } from "./Money";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type InsurancePlanCoverageBenefitLimit = BackboneElement & {
    code?: CodeableConcept;
    value?: Quantity;
};

export type InsurancePlanCoverageBenefit = BackboneElement & {
    type: CodeableConcept;
    limit?: InsurancePlanCoverageBenefitLimit[];
    requirement?: string;
};

export type InsurancePlanCoverage = BackboneElement & {
    type: CodeableConcept;
    benefit: InsurancePlanCoverageBenefit[];
    network?: Reference[];
};

export type InsurancePlanPlanGeneralCost = BackboneElement & {
    cost?: Money;
    type?: CodeableConcept;
    comment?: string;
    groupSize?: number;
};

export type InsurancePlanPlanSpecificCostBenefitCost = BackboneElement & {
    type: CodeableConcept;
    value?: Quantity;
    qualifiers?: CodeableConcept[];
    applicability?: CodeableConcept;
};

export type InsurancePlanPlanSpecificCostBenefit = BackboneElement & {
    cost?: InsurancePlanPlanSpecificCostBenefitCost[];
    type: CodeableConcept;
};

export type InsurancePlanPlanSpecificCost = BackboneElement & {
    benefit?: InsurancePlanPlanSpecificCostBenefit[];
    category: CodeableConcept;
};

export type InsurancePlanPlan = BackboneElement & {
    type?: CodeableConcept;
    network?: Reference[];
    identifier?: Identifier[];
    generalCost?: InsurancePlanPlanGeneralCost[];
    coverageArea?: Reference[];
    specificCost?: InsurancePlanPlanSpecificCost[];
};

export type InsurancePlanContact = BackboneElement & {
    name?: HumanName;
    address?: Address;
    purpose?: CodeableConcept;
    telecom?: ContactPoint[];
};

export type InsurancePlan = DomainResource & {
    coverageArea?: Reference[];
    name?: string;
    coverage?: InsurancePlanCoverage[];
    type?: CodeableConcept[];
    alias?: string[];
    status?: string;
    identifier?: Identifier[];
    administeredBy?: Reference;
    ownedBy?: Reference;
    network?: Reference[];
    period?: Period;
    plan?: InsurancePlanPlan[];
    endpoint?: Reference[];
    contact?: InsurancePlanContact[];
};