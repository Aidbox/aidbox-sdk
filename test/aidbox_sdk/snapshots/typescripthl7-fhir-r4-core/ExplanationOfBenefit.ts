import { Address } from "./Address";
import { Attachment } from "./Attachment";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Money } from "./Money";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ExplanationOfBenefitInsurance = BackboneElement & {
    focal: boolean;
    coverage: Reference;
    preAuthRef?: string[];
};

export type ExplanationOfBenefitBenefitBalanceFinancial = BackboneElement & {
    type: CodeableConcept;
    used?: Money | number;
    allowed?: Money | string | number;
};

export type ExplanationOfBenefitBenefitBalance = BackboneElement & {
    name?: string;
    term?: CodeableConcept;
    unit?: CodeableConcept;
    network?: CodeableConcept;
    category: CodeableConcept;
    excluded?: boolean;
    financial?: ExplanationOfBenefitBenefitBalanceFinancial[];
    description?: string;
};

export type ExplanationOfBenefitProcessNote = BackboneElement & {
    text?: string;
    type?: string;
    number?: number;
    language?: CodeableConcept;
};

export type ExplanationOfBenefitDiagnosis = BackboneElement & {
    type?: CodeableConcept[];
    sequence: number;
    diagnosis?: Reference | CodeableConcept;
    onAdmission?: CodeableConcept;
    packageCode?: CodeableConcept;
};

export type ExplanationOfBenefitSupportingInfo = BackboneElement & {
    category: CodeableConcept;
    value?: Reference | Quantity | string | boolean | Attachment;
    reason?: Coding;
    timing?: Period | string;
    sequence: number;
    code?: CodeableConcept;
};

export type ExplanationOfBenefitPayment = BackboneElement & {
    date?: string;
    type?: CodeableConcept;
    amount?: Money;
    adjustment?: Money;
    identifier?: Identifier;
    adjustmentReason?: CodeableConcept;
};

export type ExplanationOfBenefitItemAdjudication = BackboneElement & {
    value?: number;
    amount?: Money;
    reason?: CodeableConcept;
    category: CodeableConcept;
};

export type ExplanationOfBenefitItemDetailSubDetail = BackboneElement & {
    category?: CodeableConcept;
    modifier?: CodeableConcept[];
    revenue?: CodeableConcept;
    adjudication?: Reference[];
    net?: Money;
    productOrService: CodeableConcept;
    udi?: Reference[];
    programCode?: CodeableConcept[];
    factor?: number;
    sequence: number;
    quantity?: Quantity;
    noteNumber?: number[];
    unitPrice?: Money;
};

export type ExplanationOfBenefitItemDetail = BackboneElement & {
    category?: CodeableConcept;
    modifier?: CodeableConcept[];
    revenue?: CodeableConcept;
    adjudication?: Reference[];
    net?: Money;
    productOrService: CodeableConcept;
    udi?: Reference[];
    programCode?: CodeableConcept[];
    factor?: number;
    sequence: number;
    subDetail?: ExplanationOfBenefitItemDetailSubDetail[];
    quantity?: Quantity;
    noteNumber?: number[];
    unitPrice?: Money;
};

export type ExplanationOfBenefitItem = BackboneElement & {
    category?: CodeableConcept;
    diagnosisSequence?: number[];
    procedureSequence?: number[];
    modifier?: CodeableConcept[];
    revenue?: CodeableConcept;
    adjudication?: ExplanationOfBenefitItemAdjudication[];
    encounter?: Reference[];
    net?: Money;
    serviced?: string | Period;
    subSite?: CodeableConcept[];
    careTeamSequence?: number[];
    productOrService: CodeableConcept;
    udi?: Reference[];
    informationSequence?: number[];
    programCode?: CodeableConcept[];
    factor?: number;
    sequence: number;
    bodySite?: CodeableConcept;
    quantity?: Quantity;
    location?: Address | CodeableConcept | Reference;
    noteNumber?: number[];
    unitPrice?: Money;
    detail?: ExplanationOfBenefitItemDetail[];
};

export type ExplanationOfBenefitProcedure = BackboneElement & {
    udi?: Reference[];
    date?: string;
    type?: CodeableConcept[];
    sequence: number;
    procedure?: Reference | CodeableConcept;
};

export type ExplanationOfBenefitRelated = BackboneElement & {
    claim?: Reference;
    reference?: Identifier;
    relationship?: CodeableConcept;
};

export type ExplanationOfBenefitTotal = BackboneElement & {
    amount: Money;
    category: CodeableConcept;
};

export type ExplanationOfBenefitAccident = BackboneElement & {
    date?: string;
    type?: CodeableConcept;
    location?: Address | Reference;
};

export type ExplanationOfBenefitPayee = BackboneElement & {
    type?: CodeableConcept;
    party?: Reference;
};

export type ExplanationOfBenefitAddItemDetailSubDetail = BackboneElement & {
    net?: Money;
    factor?: number;
    modifier?: CodeableConcept[];
    quantity?: Quantity;
    unitPrice?: Money;
    noteNumber?: number[];
    adjudication?: Reference[];
    productOrService: CodeableConcept;
};

export type ExplanationOfBenefitAddItemDetail = BackboneElement & {
    modifier?: CodeableConcept[];
    adjudication?: Reference[];
    net?: Money;
    productOrService: CodeableConcept;
    factor?: number;
    subDetail?: ExplanationOfBenefitAddItemDetailSubDetail[];
    quantity?: Quantity;
    noteNumber?: number[];
    unitPrice?: Money;
};

export type ExplanationOfBenefitAddItem = BackboneElement & {
    modifier?: CodeableConcept[];
    adjudication?: Reference[];
    itemSequence?: number[];
    net?: Money;
    serviced?: string | Period;
    detailSequence?: number[];
    subSite?: CodeableConcept[];
    productOrService: CodeableConcept;
    programCode?: CodeableConcept[];
    factor?: number;
    subDetailSequence?: number[];
    bodySite?: CodeableConcept;
    quantity?: Quantity;
    location?: Address | CodeableConcept | Reference;
    provider?: Reference[];
    noteNumber?: number[];
    unitPrice?: Money;
    detail?: ExplanationOfBenefitAddItemDetail[];
};

export type ExplanationOfBenefitCareTeam = BackboneElement & {
    role?: CodeableConcept;
    provider: Reference;
    sequence: number;
    responsible?: boolean;
    qualification?: CodeableConcept;
};

export type ExplanationOfBenefit = DomainResource & {
    patient: Reference;
    claimResponse?: Reference;
    insurance: ExplanationOfBenefitInsurance[];
    benefitBalance?: ExplanationOfBenefitBenefitBalance[];
    facility?: Reference;
    processNote?: ExplanationOfBenefitProcessNote[];
    diagnosis?: ExplanationOfBenefitDiagnosis[];
    preAuthRef?: string[];
    adjudication?: Reference[];
    enterer?: Reference;
    supportingInfo?: ExplanationOfBenefitSupportingInfo[];
    use: string;
    payment?: ExplanationOfBenefitPayment;
    item?: ExplanationOfBenefitItem[];
    type: CodeableConcept;
    created: string;
    procedure?: ExplanationOfBenefitProcedure[];
    outcome: string;
    related?: ExplanationOfBenefitRelated[];
    disposition?: string;
    referral?: Reference;
    preAuthRefPeriod?: Period[];
    total?: ExplanationOfBenefitTotal[];
    insurer: Reference;
    fundsReserve?: CodeableConcept;
    priority?: CodeableConcept;
    accident?: ExplanationOfBenefitAccident;
    status: string;
    payee?: ExplanationOfBenefitPayee;
    prescription?: Reference;
    billablePeriod?: Period;
    identifier?: Identifier[];
    form?: Attachment;
    subType?: CodeableConcept;
    fundsReserveRequested?: CodeableConcept;
    benefitPeriod?: Period;
    precedence?: number;
    formCode?: CodeableConcept;
    provider: Reference;
    addItem?: ExplanationOfBenefitAddItem[];
    originalPrescription?: Reference;
    careTeam?: ExplanationOfBenefitCareTeam[];
    claim?: Reference;
};