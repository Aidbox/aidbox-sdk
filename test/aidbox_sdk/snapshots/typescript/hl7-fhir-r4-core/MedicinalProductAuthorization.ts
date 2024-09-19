import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type MedicinalProductAuthorizationJurisdictionalAuthorization = BackboneElement & {
    country?: CodeableConcept;
    identifier?: Identifier[];
    jurisdiction?: CodeableConcept[];
    validityPeriod?: Period;
    legalStatusOfSupply?: CodeableConcept;
};

export type MedicinalProductAuthorizationProcedure = BackboneElement & {
    date?: Period | string;
    type: CodeableConcept;
    identifier?: Identifier;
    application?: Reference[];
};

export type MedicinalProductAuthorization = DomainResource & {
    dataExclusivityPeriod?: Period;
    restoreDate?: string;
    jurisdiction?: CodeableConcept[];
    jurisdictionalAuthorization?: MedicinalProductAuthorizationJurisdictionalAuthorization[];
    procedure?: MedicinalProductAuthorizationProcedure;
    legalBasis?: CodeableConcept;
    validityPeriod?: Period;
    regulator?: Reference;
    status?: CodeableConcept;
    identifier?: Identifier[];
    statusDate?: string;
    dateOfFirstAuthorization?: string;
    internationalBirthDate?: string;
    holder?: Reference;
    country?: CodeableConcept[];
    subject?: Reference;
};