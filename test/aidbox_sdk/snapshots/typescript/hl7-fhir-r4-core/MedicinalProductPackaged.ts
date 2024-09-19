import { CodeableConcept } from "./CodeableConcept";
import { MarketingStatus } from "./MarketingStatus";
import { ProdCharacteristic } from "./ProdCharacteristic";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { ProductShelfLife } from "./ProductShelfLife";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type MedicinalProductPackagedBatchIdentifier = BackboneElement & {
    outerPackaging: Identifier;
    immediatePackaging?: Identifier;
};

export type MedicinalProductPackagedPackageItem = BackboneElement & {
    manufacturedItem?: Reference[];
    otherCharacteristics?: CodeableConcept[];
    shelfLifeStorage?: ProductShelfLife[];
    alternateMaterial?: CodeableConcept[];
    type: CodeableConcept;
    material?: CodeableConcept[];
    identifier?: Identifier[];
    manufacturer?: Reference[];
    device?: Reference[];
    quantity: Quantity;
    physicalCharacteristics?: ProdCharacteristic;
    packageItem?: Reference[];
};

export type MedicinalProductPackaged = DomainResource & {
    description?: string;
    marketingStatus?: MarketingStatus[];
    marketingAuthorization?: Reference;
    identifier?: Identifier[];
    manufacturer?: Reference[];
    legalStatusOfSupply?: CodeableConcept;
    batchIdentifier?: MedicinalProductPackagedBatchIdentifier[];
    subject?: Reference[];
    packageItem: MedicinalProductPackagedPackageItem[];
};