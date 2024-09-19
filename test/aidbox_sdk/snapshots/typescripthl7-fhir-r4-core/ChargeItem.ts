import { Annotation } from "./Annotation";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Timing } from "./Timing";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Money } from "./Money";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ChargeItemPerformer = BackboneElement & {
    actor: Reference;
    function?: CodeableConcept;
};

export type ChargeItem = DomainResource & {
    service?: Reference[];
    definitionUri?: string[];
    enterer?: Reference;
    requestingOrganization?: Reference;
    definitionCanonical?: string[];
    bodysite?: CodeableConcept[];
    costCenter?: Reference;
    note?: Annotation[];
    account?: Reference[];
    reason?: CodeableConcept[];
    product?: CodeableConcept | Reference;
    supportingInformation?: Reference[];
    status: string;
    code: CodeableConcept;
    identifier?: Identifier[];
    context?: Reference;
    quantity?: Quantity;
    partOf?: Reference[];
    priceOverride?: Money;
    enteredDate?: string;
    overrideReason?: string;
    performingOrganization?: Reference;
    subject: Reference;
    factorOverride?: number;
    occurrence?: Timing | Period | string;
    performer?: ChargeItemPerformer[];
};