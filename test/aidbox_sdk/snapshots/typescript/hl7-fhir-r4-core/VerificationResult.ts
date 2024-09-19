import { CodeableConcept } from "./CodeableConcept";
import { Signature } from "./Signature";
import { Timing } from "./Timing";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { BackboneElement } from "./BackboneElement";

export type VerificationResultValidator = BackboneElement & {
    organization: Reference;
    identityCertificate?: string;
    attestationSignature?: Signature;
};

export type VerificationResultPrimarySource = BackboneElement & {
    who?: Reference;
    type?: CodeableConcept[];
    canPushUpdates?: CodeableConcept;
    validationDate?: string;
    validationStatus?: CodeableConcept;
    pushTypeAvailable?: CodeableConcept[];
    communicationMethod?: CodeableConcept[];
};

export type VerificationResultAttestation = BackboneElement & {
    who?: Reference;
    date?: string;
    onBehalfOf?: Reference;
    proxySignature?: Signature;
    sourceSignature?: Signature;
    communicationMethod?: CodeableConcept;
    proxyIdentityCertificate?: string;
    sourceIdentityCertificate?: string;
};

export type VerificationResult = DomainResource & {
    failureAction?: CodeableConcept;
    validationType?: CodeableConcept;
    targetLocation?: string[];
    validator?: VerificationResultValidator[];
    need?: CodeableConcept;
    frequency?: Timing;
    nextScheduled?: string;
    primarySource?: VerificationResultPrimarySource[];
    attestation?: VerificationResultAttestation;
    status: string;
    validationProcess?: CodeableConcept[];
    statusDate?: string;
    target?: Reference[];
    lastPerformed?: string;
};