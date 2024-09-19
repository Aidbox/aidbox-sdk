import { Period } from "./Period";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type CatalogEntryRelatedEntry = BackboneElement & {
    item: Reference;
    relationtype: string;
};

export type CatalogEntry = DomainResource & {
    additionalCharacteristic?: CodeableConcept[];
    additionalClassification?: CodeableConcept[];
    referencedItem: Reference;
    type?: CodeableConcept;
    classification?: CodeableConcept[];
    validityPeriod?: Period;
    orderable: boolean;
    status?: string;
    validTo?: string;
    identifier?: Identifier[];
    additionalIdentifier?: Identifier[];
    lastUpdated?: string;
    relatedEntry?: CatalogEntryRelatedEntry[];
};