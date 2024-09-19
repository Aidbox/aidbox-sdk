import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { Range } from "./Range";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type GroupMember = BackboneElement & {
    entity: Reference;
    period?: Period;
    inactive?: boolean;
};

export type GroupCharacteristic = BackboneElement & {
    exclude: boolean;
    value?: Reference | Quantity | boolean | CodeableConcept | Range;
    code: CodeableConcept;
    period?: Period;
};

export type Group = DomainResource & {
    name?: string;
    type: string;
    member?: GroupMember[];
    characteristic?: GroupCharacteristic[];
    active?: boolean;
    code?: CodeableConcept;
    identifier?: Identifier[];
    quantity?: number;
    managingEntity?: Reference;
    actual: boolean;
};