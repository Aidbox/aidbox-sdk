import { Annotation } from "./Annotation";
import { CodeableConcept } from "./CodeableConcept";
import { ContactPoint } from "./ContactPoint";
import { ProdCharacteristic } from "./ProdCharacteristic";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { ProductShelfLife } from "./ProductShelfLife";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type DeviceDefinitionDeviceName = BackboneElement & {
    name: string;
    type: string;
};

export type DeviceDefinitionProperty = BackboneElement & {
    type: CodeableConcept;
    valueCode?: CodeableConcept[];
    valueQuantity?: Quantity[];
};

export type DeviceDefinitionUdiDeviceIdentifier = BackboneElement & {
    issuer: string;
    jurisdiction: string;
    deviceIdentifier: string;
};

export type DeviceDefinitionCapability = BackboneElement & {
    type: CodeableConcept;
    description?: CodeableConcept[];
};

export type DeviceDefinitionSpecialization = BackboneElement & {
    version?: string;
    systemType: string;
};

export type DeviceDefinitionMaterial = BackboneElement & {
    alternate?: boolean;
    substance: CodeableConcept;
    allergenicIndicator?: boolean;
};

export type DeviceDefinition = DomainResource & {
    deviceName?: DeviceDefinitionDeviceName[];
    shelfLifeStorage?: ProductShelfLife[];
    property?: DeviceDefinitionProperty[];
    modelNumber?: string;
    udiDeviceIdentifier?: DeviceDefinitionUdiDeviceIdentifier[];
    type?: CodeableConcept;
    capability?: DeviceDefinitionCapability[];
    specialization?: DeviceDefinitionSpecialization[];
    parentDevice?: Reference;
    note?: Annotation[];
    languageCode?: CodeableConcept[];
    safety?: CodeableConcept[];
    material?: DeviceDefinitionMaterial[];
    url?: string;
    identifier?: Identifier[];
    manufacturer?: string | Reference;
    quantity?: Quantity;
    version?: string[];
    contact?: ContactPoint[];
    owner?: Reference;
    onlineInformation?: string;
    physicalCharacteristics?: ProdCharacteristic;
};