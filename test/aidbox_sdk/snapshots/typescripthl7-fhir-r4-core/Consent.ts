import { Attachment } from "./Attachment";
import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ConsentProvisionActor = BackboneElement & {
    role: CodeableConcept;
    reference: Reference;
};

export type ConsentProvisionData = BackboneElement & {
    meaning: string;
    reference: Reference;
};

export type ConsentProvision = BackboneElement & {
    provision?: Reference[];
    purpose?: Coding[];
    dataPeriod?: Period;
    type?: string;
    class_?: Coding[];
    code?: CodeableConcept[];
    action?: CodeableConcept[];
    period?: Period;
    securityLabel?: Coding[];
    actor?: ConsentProvisionActor[];
    data?: ConsentProvisionData[];
};

export type ConsentVerification = BackboneElement & {
    verified: boolean;
    verifiedWith?: Reference;
    verificationDate?: string;
};

export type ConsentPolicy = BackboneElement & {
    uri?: string;
    authority?: string;
};

export type Consent = DomainResource & {
    patient?: Reference;
    category: CodeableConcept[];
    provision?: ConsentProvision;
    organization?: Reference[];
    verification?: ConsentVerification[];
    source?: Attachment | Reference;
    scope: CodeableConcept;
    policy?: ConsentPolicy[];
    dateTime?: string;
    status: string;
    policyRule?: CodeableConcept;
    identifier?: Identifier[];
    performer?: Reference[];
};