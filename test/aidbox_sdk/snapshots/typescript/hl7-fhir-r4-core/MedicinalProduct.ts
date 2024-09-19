import { CodeableConcept } from "./CodeableConcept";
import { MarketingStatus } from "./MarketingStatus";
import { Coding } from "./Coding";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type MedicinalProductManufacturingBusinessOperation = BackboneElement & {
    regulator?: Reference;
    manufacturer?: Reference[];
    effectiveDate?: string;
    operationType?: CodeableConcept;
    confidentialityIndicator?: CodeableConcept;
    authorisationReferenceNumber?: Identifier;
};

export type MedicinalProductNameNamePart = BackboneElement & {
    part: string;
    type: Coding;
};

export type MedicinalProductNameCountryLanguage = BackboneElement & {
    country: CodeableConcept;
    language: CodeableConcept;
    jurisdiction?: CodeableConcept;
};

export type MedicinalProductName = BackboneElement & {
    namePart?: MedicinalProductNameNamePart[];
    productName: string;
    countryLanguage?: MedicinalProductNameCountryLanguage[];
};

export type MedicinalProductSpecialDesignation = BackboneElement & {
    date?: string;
    indication?: CodeableConcept | Reference;
    species?: CodeableConcept;
    type?: CodeableConcept;
    intendedUse?: CodeableConcept;
    status?: CodeableConcept;
    identifier?: Identifier[];
};

export type MedicinalProduct = DomainResource & {
    additionalMonitoringIndicator?: CodeableConcept;
    manufacturingBusinessOperation?: MedicinalProductManufacturingBusinessOperation[];
    combinedPharmaceuticalDoseForm?: CodeableConcept;
    clinicalTrial?: Reference[];
    productClassification?: CodeableConcept[];
    name: MedicinalProductName[];
    masterFile?: Reference[];
    pharmaceuticalProduct?: Reference[];
    type?: CodeableConcept;
    marketingStatus?: MarketingStatus[];
    specialMeasures?: string[];
    specialDesignation?: MedicinalProductSpecialDesignation[];
    packagedMedicinalProduct?: Reference[];
    identifier?: Identifier[];
    crossReference?: Identifier[];
    attachedDocument?: Reference[];
    domain?: Coding;
    legalStatusOfSupply?: CodeableConcept;
    paediatricUseIndicator?: CodeableConcept;
    contact?: Reference[];
};