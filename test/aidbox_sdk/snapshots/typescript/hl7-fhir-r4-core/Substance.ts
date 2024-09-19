import { CodeableConcept } from "./CodeableConcept";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Ratio } from "./Ratio";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type SubstanceInstance = BackboneElement & {
    expiry?: string;
    quantity?: Quantity;
    identifier?: Identifier;
};

export type SubstanceIngredient = BackboneElement & {
    quantity?: Ratio;
    substance?: Reference | CodeableConcept;
};

export type Substance = DomainResource & {
    code: CodeableConcept;
    status?: string;
    category?: CodeableConcept[];
    instance?: SubstanceInstance[];
    identifier?: Identifier[];
    ingredient?: SubstanceIngredient[];
    description?: string;
};