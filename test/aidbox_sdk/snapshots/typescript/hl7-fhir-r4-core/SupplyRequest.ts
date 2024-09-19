import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Range } from "./Range";
import { Timing } from "./Timing";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type SupplyRequestParameter = BackboneElement & {
    code?: CodeableConcept;
    value?: Range | boolean | Quantity | CodeableConcept;
};

export type SupplyRequest = DomainResource & {
    category?: CodeableConcept;
    supplier?: Reference[];
    deliverTo?: Reference;
    item?: Reference | CodeableConcept;
    reasonCode?: CodeableConcept[];
    authoredOn?: string;
    deliverFrom?: Reference;
    requester?: Reference;
    priority?: string;
    status?: string;
    identifier?: Identifier[];
    quantity: Quantity;
    parameter?: SupplyRequestParameter[];
    occurrence?: Timing | Period | string;
    reasonReference?: Reference[];
};