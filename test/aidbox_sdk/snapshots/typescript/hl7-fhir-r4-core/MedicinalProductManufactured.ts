import { CodeableConcept } from "./CodeableConcept";
import { ProdCharacteristic } from "./ProdCharacteristic";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";

export type MedicinalProductManufactured = DomainResource & {
    quantity: Quantity;
    ingredient?: Reference[];
    manufacturer?: Reference[];
    unitOfPresentation?: CodeableConcept;
    manufacturedDoseForm: CodeableConcept;
    otherCharacteristics?: CodeableConcept[];
    physicalCharacteristics?: ProdCharacteristic;
};