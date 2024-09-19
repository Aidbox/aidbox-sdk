import { Annotation } from "./Annotation";
import { CodeableConcept } from "./CodeableConcept";
import { ContactPoint } from "./ContactPoint";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type DeviceDeviceName = BackboneElement & {
    name: string;
    type: string;
};

export type DeviceProperty = BackboneElement & {
    type: CodeableConcept;
    valueCode?: CodeableConcept[];
    valueQuantity?: Quantity[];
};

export type DeviceSpecialization = BackboneElement & {
    version?: string;
    systemType: CodeableConcept;
};

export type DeviceVersion = BackboneElement & {
    type?: CodeableConcept;
    value: string;
    component?: Identifier;
};

export type DeviceUdiCarrier = BackboneElement & {
    issuer?: string;
    entryType?: string;
    carrierHRF?: string;
    carrierAIDC?: string;
    jurisdiction?: string;
    deviceIdentifier?: string;
};

export type Device = DomainResource & {
    patient?: Reference;
    definition?: Reference;
    serialNumber?: string;
    parent?: Reference;
    deviceName?: DeviceDeviceName[];
    property?: DeviceProperty[];
    partNumber?: string;
    modelNumber?: string;
    type?: CodeableConcept;
    statusReason?: CodeableConcept[];
    specialization?: DeviceSpecialization[];
    distinctIdentifier?: string;
    note?: Annotation[];
    status?: string;
    safety?: CodeableConcept[];
    lotNumber?: string;
    url?: string;
    identifier?: Identifier[];
    manufacturer?: string;
    version?: DeviceVersion[];
    location?: Reference;
    contact?: ContactPoint[];
    manufactureDate?: string;
    owner?: Reference;
    expirationDate?: string;
    udiCarrier?: DeviceUdiCarrier[];
};