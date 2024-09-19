import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type BiologicallyDerivedProductProcessing = BackboneElement & {
    time?: Period | string;
    additive?: Reference;
    procedure?: CodeableConcept;
    description?: string;
};

export type BiologicallyDerivedProductStorage = BackboneElement & {
    scale?: string;
    duration?: Period;
    description?: string;
    temperature?: number;
};

export type BiologicallyDerivedProductManipulation = BackboneElement & {
    time?: Period | string;
    description?: string;
};

export type BiologicallyDerivedProductCollection = BackboneElement & {
    source?: Reference;
    collected?: Period | string;
    collector?: Reference;
};

export type BiologicallyDerivedProduct = DomainResource & {
    request?: Reference[];
    processing?: BiologicallyDerivedProductProcessing[];
    parent?: Reference[];
    status?: string;
    identifier?: Identifier[];
    productCode?: CodeableConcept;
    storage?: BiologicallyDerivedProductStorage[];
    quantity?: number;
    productCategory?: string;
    manipulation?: BiologicallyDerivedProductManipulation;
    collection?: BiologicallyDerivedProductCollection;
};