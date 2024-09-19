import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { BackboneElement } from "./BackboneElement";

export type MedicinalProductInteractionInteractant = BackboneElement & {
    item?: Reference | CodeableConcept;
};

export type MedicinalProductInteraction = DomainResource & {
    type?: CodeableConcept;
    effect?: CodeableConcept;
    subject?: Reference[];
    incidence?: CodeableConcept;
    management?: CodeableConcept;
    description?: string;
    interactant?: MedicinalProductInteractionInteractant[];
};