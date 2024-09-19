import { Annotation } from "./Annotation";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Money } from "./Money";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type InvoiceParticipant = BackboneElement & {
    role?: CodeableConcept;
    actor: Reference;
};

export type InvoiceLineItemPriceComponent = BackboneElement & {
    code?: CodeableConcept;
    type: string;
    amount?: Money;
    factor?: number;
};

export type InvoiceLineItem = BackboneElement & {
    sequence?: number;
    chargeItem?: Reference | CodeableConcept;
    priceComponent?: InvoiceLineItemPriceComponent[];
};

export type Invoice = DomainResource & {
    date?: string;
    totalNet?: Money;
    recipient?: Reference;
    totalPriceComponent?: Reference[];
    type?: CodeableConcept;
    totalGross?: Money;
    participant?: InvoiceParticipant[];
    note?: Annotation[];
    account?: Reference;
    status: string;
    lineItem?: InvoiceLineItem[];
    identifier?: Identifier[];
    issuer?: Reference;
    cancelledReason?: string;
    paymentTerms?: string;
    subject?: Reference;
};