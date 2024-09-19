import { CodeableConcept } from "./CodeableConcept";
import { Population } from "./Population";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { BackboneElement } from "./BackboneElement";

export type MedicinalProductContraindicationOtherTherapy = BackboneElement & {
    medication?: Reference | CodeableConcept;
    therapyRelationshipType: CodeableConcept;
};

export type MedicinalProductContraindication = DomainResource & {
    disease?: CodeableConcept;
    subject?: Reference[];
    population?: Population[];
    comorbidity?: CodeableConcept[];
    otherTherapy?: MedicinalProductContraindicationOtherTherapy[];
    diseaseStatus?: CodeableConcept;
    therapeuticIndication?: Reference[];
};