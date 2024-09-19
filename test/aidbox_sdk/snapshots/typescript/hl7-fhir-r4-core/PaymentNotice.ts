import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Money } from "./Money";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";

export type PaymentNotice = DomainResource & {
    response?: Reference;
    amount: Money;
    request?: Reference;
    payment: Reference;
    recipient: Reference;
    created: string;
    paymentStatus?: CodeableConcept;
    status: string;
    payee?: Reference;
    paymentDate?: string;
    identifier?: Identifier[];
    provider?: Reference;
};