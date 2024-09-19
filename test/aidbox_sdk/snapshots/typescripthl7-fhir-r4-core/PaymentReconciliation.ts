import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Money } from "./Money";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type PaymentReconciliationProcessNote = BackboneElement & {
    text?: string;
    type?: string;
};

export type PaymentReconciliationDetail = BackboneElement & {
    response?: Reference;
    amount?: Money;
    date?: string;
    request?: Reference;
    type: CodeableConcept;
    responsible?: Reference;
    payee?: Reference;
    predecessor?: Identifier;
    identifier?: Identifier;
    submitter?: Reference;
};

export type PaymentReconciliation = DomainResource & {
    requestor?: Reference;
    request?: Reference;
    paymentAmount: Money;
    processNote?: PaymentReconciliationProcessNote[];
    created: string;
    outcome?: string;
    disposition?: string;
    paymentIdentifier?: Identifier;
    status: string;
    paymentDate: string;
    identifier?: Identifier[];
    period?: Period;
    paymentIssuer?: Reference;
    formCode?: CodeableConcept;
    detail?: PaymentReconciliationDetail[];
};