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

export type ClaimInsurance = BackboneElement & {
    focal: boolean;
    coverage: Reference;
    sequence: number;
    identifier?: Identifier;
    preAuthRef?: string[];
    claimResponse?: Reference;
    businessArrangement?: string;
};

export type ClaimDiagnosis = BackboneElement & {
    type?: CodeableConcept[];
    sequence: number;
    diagnosis?: Reference | CodeableConcept;
    onAdmission?: CodeableConcept;
    packageCode?: CodeableConcept;
};

export type ClaimSupportingInfo = BackboneElement & {
    category: CodeableConcept;
    value?: Reference | Quantity | string | boolean | Attachment;
    reason?: CodeableConcept;
    timing?: Period | string;
    sequence: number;
    code?: CodeableConcept;
};

export type ClaimItemDetailSubDetail = BackboneElement & {
    category?: CodeableConcept;
    modifier?: CodeableConcept[];
    revenue?: CodeableConcept;
    net?: Money;
    productOrService: CodeableConcept;
    udi?: Reference[];
    programCode?: CodeableConcept[];
    factor?: number;
    sequence: number;
    quantity?: Quantity;
    unitPrice?: Money;
};

export type ClaimItemDetail = BackboneElement & {
    category?: CodeableConcept;
    modifier?: CodeableConcept[];
    revenue?: CodeableConcept;
    net?: Money;
    productOrService: CodeableConcept;
    udi?: Reference[];
    programCode?: CodeableConcept[];
    factor?: number;
    sequence: number;
    subDetail?: ClaimItemDetailSubDetail[];
    quantity?: Quantity;
    unitPrice?: Money;
};

export type ClaimItem = BackboneElement & {
    category?: CodeableConcept;
    diagnosisSequence?: number[];
    procedureSequence?: number[];
    modifier?: CodeableConcept[];
    revenue?: CodeableConcept;
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
    unitPrice?: Money;
    detail?: ClaimItemDetail[];
};

export type ClaimProcedure = BackboneElement & {
    udi?: Reference[];
    date?: string;
    type?: CodeableConcept[];
    sequence: number;
    procedure?: Reference | CodeableConcept;
};

export type ClaimRelated = BackboneElement & {
    claim?: Reference;
    reference?: Identifier;
    relationship?: CodeableConcept;
};

export type ClaimAccident = BackboneElement & {
    date: string;
    type?: CodeableConcept;
    location?: Address | Reference;
};

export type ClaimPayee = BackboneElement & {
    type: CodeableConcept;
    party?: Reference;
};

export type ClaimCareTeam = BackboneElement & {
    role?: CodeableConcept;
    provider: Reference;
    sequence: number;
    responsible?: boolean;
    qualification?: CodeableConcept;
};

export type Claim = DomainResource & {
    patient: Reference;
    insurance: ClaimInsurance[];
    facility?: Reference;
    diagnosis?: ClaimDiagnosis[];
    enterer?: Reference;
    supportingInfo?: ClaimSupportingInfo[];
    use: string;
    item?: ClaimItem[];
    type: CodeableConcept;
    created: string;
    procedure?: ClaimProcedure[];
    related?: ClaimRelated[];
    referral?: Reference;
    total?: Money;
    insurer?: Reference;
    fundsReserve?: CodeableConcept;
    priority: CodeableConcept;
    accident?: ClaimAccident;
    status: string;
    payee?: ClaimPayee;
    prescription?: Reference;
    billablePeriod?: Period;
    identifier?: Identifier[];
    subType?: CodeableConcept;
    provider: Reference;
    originalPrescription?: Reference;
    careTeam?: ClaimCareTeam[];
};