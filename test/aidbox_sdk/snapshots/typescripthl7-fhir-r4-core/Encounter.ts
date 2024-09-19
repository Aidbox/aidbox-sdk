import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { Duration } from "./Duration";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type EncounterDiagnosis = BackboneElement & {
    use?: CodeableConcept;
    rank?: number;
    condition: Reference;
};

export type EncounterParticipant = BackboneElement & {
    type?: CodeableConcept[];
    period?: Period;
    individual?: Reference;
};

export type EncounterClassHistory = BackboneElement & {
    class_: Coding;
    period: Period;
};

export type EncounterHospitalization = BackboneElement & {
    dischargeDisposition?: CodeableConcept;
    preAdmissionIdentifier?: Identifier;
    specialArrangement?: CodeableConcept[];
    dietPreference?: CodeableConcept[];
    admitSource?: CodeableConcept;
    specialCourtesy?: CodeableConcept[];
    reAdmission?: CodeableConcept;
    origin?: Reference;
    destination?: Reference;
};

export type EncounterLocation = BackboneElement & {
    period?: Period;
    status?: string;
    location: Reference;
    physicalType?: CodeableConcept;
};

export type EncounterStatusHistory = BackboneElement & {
    period: Period;
    status: string;
};

export type Encounter = DomainResource & {
    appointment?: Reference[];
    diagnosis?: EncounterDiagnosis[];
    serviceProvider?: Reference;
    episodeOfCare?: Reference[];
    reasonCode?: CodeableConcept[];
    type?: CodeableConcept[];
    participant?: EncounterParticipant[];
    serviceType?: CodeableConcept;
    account?: Reference[];
    classHistory?: EncounterClassHistory[];
    priority?: CodeableConcept;
    status: string;
    class_: Coding;
    length?: Duration;
    identifier?: Identifier[];
    hospitalization?: EncounterHospitalization;
    period?: Period;
    basedOn?: Reference[];
    partOf?: Reference;
    location?: EncounterLocation[];
    subject?: Reference;
    statusHistory?: EncounterStatusHistory[];
    reasonReference?: Reference[];
};