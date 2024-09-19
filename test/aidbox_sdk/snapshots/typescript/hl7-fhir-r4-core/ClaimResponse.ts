import { Address } from "./Address";
import { Attachment } from "./Attachment";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Money } from "./Money";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ClaimResponseInsurance = BackboneElement & {
    focal: boolean;
    coverage: Reference;
    sequence: number;
    claimResponse?: Reference;
    businessArrangement?: string;
};

export type ClaimResponseProcessNote = BackboneElement & {
    text: string;
    type?: string;
    number?: number;
    language?: CodeableConcept;
};

export type ClaimResponsePayment = BackboneElement & {
    date?: string;
    type: CodeableConcept;
    amount: Money;
    adjustment?: Money;
    identifier?: Identifier;
    adjustmentReason?: CodeableConcept;
};

export type ClaimResponseItemDetailSubDetail = BackboneElement & {
    noteNumber?: number[];
    adjudication?: Reference[];
    subDetailSequence: number;
};

export type ClaimResponseItemDetail = BackboneElement & {
    subDetail?: ClaimResponseItemDetailSubDetail[];
    noteNumber?: number[];
    adjudication: Reference[];
    detailSequence: number;
};

export type ClaimResponseItemAdjudication = BackboneElement & {
    value?: number;
    amount?: Money;
    reason?: CodeableConcept;
    category: CodeableConcept;
};

export type ClaimResponseItem = BackboneElement & {
    detail?: ClaimResponseItemDetail[];
    noteNumber?: number[];
    adjudication: ClaimResponseItemAdjudication[];
    itemSequence: number;
};

export type ClaimResponseTotal = BackboneElement & {
    amount: Money;
    category: CodeableConcept;
};

export type ClaimResponseError = BackboneElement & {
    code: CodeableConcept;
    itemSequence?: number;
    detailSequence?: number;
    subDetailSequence?: number;
};

export type ClaimResponseAddItemDetailSubDetail = BackboneElement & {
    net?: Money;
    factor?: number;
    modifier?: CodeableConcept[];
    quantity?: Quantity;
    unitPrice?: Money;
    noteNumber?: number[];
    adjudication: Reference[];
    productOrService: CodeableConcept;
};

export type ClaimResponseAddItemDetail = BackboneElement & {
    modifier?: CodeableConcept[];
    adjudication: Reference[];
    net?: Money;
    productOrService: CodeableConcept;
    factor?: number;
    subDetail?: ClaimResponseAddItemDetailSubDetail[];
    quantity?: Quantity;
    noteNumber?: number[];
    unitPrice?: Money;
};

export type ClaimResponseAddItem = BackboneElement & {
    modifier?: CodeableConcept[];
    adjudication: Reference[];
    subdetailSequence?: number[];
    itemSequence?: number[];
    net?: Money;
    serviced?: string | Period;
    detailSequence?: number[];
    subSite?: CodeableConcept[];
    productOrService: CodeableConcept;
    programCode?: CodeableConcept[];
    factor?: number;
    bodySite?: CodeableConcept;
    quantity?: Quantity;
    location?: Address | CodeableConcept | Reference;
    provider?: Reference[];
    noteNumber?: number[];
    unitPrice?: Money;
    detail?: ClaimResponseAddItemDetail[];
};

export type ClaimResponse = DomainResource & {
    patient: Reference;
    requestor?: Reference;
    payeeType?: CodeableConcept;
    insurance?: ClaimResponseInsurance[];
    request?: Reference;
    processNote?: ClaimResponseProcessNote[];
    preAuthRef?: string;
    adjudication?: Reference[];
    use: string;
    payment?: ClaimResponsePayment;
    item?: ClaimResponseItem[];
    type: CodeableConcept;
    created: string;
    preAuthPeriod?: Period;
    outcome: string;
    disposition?: string;
    communicationRequest?: Reference[];
    total?: ClaimResponseTotal[];
    insurer: Reference;
    fundsReserve?: CodeableConcept;
    status: string;
    identifier?: Identifier[];
    error?: ClaimResponseError[];
    form?: Attachment;
    subType?: CodeableConcept;
    formCode?: CodeableConcept;
    addItem?: ClaimResponseAddItem[];
};