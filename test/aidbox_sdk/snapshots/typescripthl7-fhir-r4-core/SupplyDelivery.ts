import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Timing } from "./Timing";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type SupplyDeliverySuppliedItem = BackboneElement & {
    item?: Reference | CodeableConcept;
    quantity?: Quantity;
};

export type SupplyDelivery = DomainResource & {
    patient?: Reference;
    supplier?: Reference;
    suppliedItem?: SupplyDeliverySuppliedItem;
    type?: CodeableConcept;
    status?: string;
    identifier?: Identifier[];
    basedOn?: Reference[];
    partOf?: Reference[];
    receiver?: Reference[];
    destination?: Reference;
    occurrence?: Timing | Period | string;
};