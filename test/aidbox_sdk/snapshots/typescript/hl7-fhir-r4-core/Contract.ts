import { Annotation } from "./Annotation";
import { Attachment } from "./Attachment";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { Signature } from "./Signature";
import { Timing } from "./Timing";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Money } from "./Money";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ContractRule = BackboneElement & {
    content?: Reference | Attachment;
};

export type ContractLegal = BackboneElement & {
    content?: Reference | Attachment;
};

export type ContractContentDefinition = BackboneElement & {
    type: CodeableConcept;
    subType?: CodeableConcept;
    copyright?: string;
    publisher?: Reference;
    publicationDate?: string;
    publicationStatus: string;
};

export type ContractSigner = BackboneElement & {
    type: Coding;
    party: Reference;
    signature: Signature[];
};

export type ContractTermOfferParty = BackboneElement & {
    role: CodeableConcept;
    reference: Reference[];
};

export type ContractTermOfferAnswer = BackboneElement & {
    value?: Reference | string | number | Quantity | boolean | Coding | Attachment;
};

export type ContractTermOffer = BackboneElement & {
    party?: ContractTermOfferParty[];
    linkId?: string[];
    decisionMode?: CodeableConcept[];
    type?: CodeableConcept;
    topic?: Reference;
    securityLabelNumber?: number[];
    answer?: ContractTermOfferAnswer[];
    identifier?: Identifier[];
    decision?: CodeableConcept;
    text?: string;
};

export type ContractTermActionSubject = BackboneElement & {
    role?: CodeableConcept;
    reference: Reference[];
};

export type ContractTermAction = BackboneElement & {
    requesterLinkId?: string[];
    performerType?: CodeableConcept[];
    linkId?: string[];
    performerRole?: CodeableConcept;
    reasonLinkId?: string[];
    reasonCode?: CodeableConcept[];
    type: CodeableConcept;
    note?: Annotation[];
    reason?: string[];
    requester?: Reference[];
    securityLabelNumber?: number[];
    status: CodeableConcept;
    doNotPerform?: boolean;
    context?: Reference;
    intent: CodeableConcept;
    performerLinkId?: string[];
    subject?: ContractTermActionSubject[];
    occurrence?: Timing | Period | string;
    performer?: Reference;
    contextLinkId?: string[];
    reasonReference?: Reference[];
};

export type ContractTermSecurityLabel = BackboneElement & {
    number?: number[];
    control?: Coding[];
    category?: Coding[];
    classification: Coding;
};

export type ContractTermAssetContext = BackboneElement & {
    code?: CodeableConcept[];
    text?: string;
    reference?: Reference;
};

export type ContractTermAssetValuedItem = BackboneElement & {
    linkId?: string[];
    payment?: string;
    recipient?: Reference;
    net?: Money;
    points?: number;
    responsible?: Reference;
    securityLabelNumber?: number[];
    factor?: number;
    paymentDate?: string;
    identifier?: Identifier;
    effectiveTime?: string;
    quantity?: Quantity;
    entity?: CodeableConcept | Reference;
    unitPrice?: Money;
};

export type ContractTermAsset = BackboneElement & {
    periodType?: CodeableConcept[];
    usePeriod?: Period[];
    linkId?: string[];
    relationship?: Coding;
    type?: CodeableConcept[];
    scope?: CodeableConcept;
    securityLabelNumber?: number[];
    typeReference?: Reference[];
    condition?: string;
    answer?: Reference[];
    context?: ContractTermAssetContext[];
    period?: Period[];
    valuedItem?: ContractTermAssetValuedItem[];
    subtype?: CodeableConcept[];
    text?: string;
};

export type ContractTerm = BackboneElement & {
    group?: Reference[];
    applies?: Period;
    offer: ContractTermOffer;
    type?: CodeableConcept;
    topic?: CodeableConcept | Reference;
    identifier?: Identifier;
    action?: ContractTermAction[];
    issued?: string;
    subType?: CodeableConcept;
    securityLabel?: ContractTermSecurityLabel[];
    asset?: ContractTermAsset[];
    text?: string;
};

export type ContractFriendly = BackboneElement & {
    content?: Reference | Attachment;
};

export type Contract = DomainResource & {
    instantiatesCanonical?: Reference;
    instantiatesUri?: string;
    site?: Reference[];
    relevantHistory?: Reference[];
    supportingInfo?: Reference[];
    applies?: Period;
    name?: string;
    authority?: Reference[];
    rule?: ContractRule[];
    type?: CodeableConcept;
    legal?: ContractLegal[];
    contentDerivative?: CodeableConcept;
    topic?: CodeableConcept | Reference;
    legalState?: CodeableConcept;
    contentDefinition?: ContractContentDefinition;
    scope?: CodeableConcept;
    title?: string;
    signer?: ContractSigner[];
    author?: Reference;
    term?: ContractTerm[];
    friendly?: ContractFriendly[];
    alias?: string[];
    status?: string;
    subtitle?: string;
    url?: string;
    identifier?: Identifier[];
    expirationType?: CodeableConcept;
    issued?: string;
    domain?: Reference[];
    subType?: CodeableConcept[];
    version?: string;
    subject?: Reference[];
    legallyBinding?: Attachment | Reference;
};