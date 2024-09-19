import { UsageContext } from "./UsageContext";
import { Period } from "./Period";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Money } from "./Money";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ChargeItemDefinitionPropertyGroupPriceComponent = BackboneElement & {
    code?: CodeableConcept;
    type: string;
    amount?: Money;
    factor?: number;
};

export type ChargeItemDefinitionPropertyGroup = BackboneElement & {
    applicability?: Reference[];
    priceComponent?: ChargeItemDefinitionPropertyGroupPriceComponent[];
};

export type ChargeItemDefinitionApplicability = BackboneElement & {
    language?: string;
    expression?: string;
    description?: string;
};

export type ChargeItemDefinition = DomainResource & {
    description?: string;
    date?: string;
    publisher?: string;
    approvalDate?: string;
    propertyGroup?: ChargeItemDefinitionPropertyGroup[];
    instance?: Reference[];
    jurisdiction?: CodeableConcept[];
    useContext?: UsageContext[];
    copyright?: string;
    experimental?: boolean;
    title?: string;
    derivedFromUri?: string[];
    status: string;
    url: string;
    code?: CodeableConcept;
    identifier?: Identifier[];
    lastReviewDate?: string;
    replaces?: string[];
    partOf?: string[];
    version?: string;
    contact?: ContactDetail[];
    applicability?: ChargeItemDefinitionApplicability[];
    effectivePeriod?: Period;
};