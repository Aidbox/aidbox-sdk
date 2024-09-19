import { CodeableConcept } from "./CodeableConcept";
import { Population } from "./Population";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { BackboneElement } from "./BackboneElement";

export type MedicinalProductIndicationOtherTherapy = BackboneElement & {
    medication?: Reference | CodeableConcept;
    therapyRelationshipType: CodeableConcept;
};

export type MedicinalProductIndication = DomainResource & {
    diseaseSymptomProcedure?: CodeableConcept;
    undesirableEffect?: Reference[];
    duration?: Quantity;
    otherTherapy?: MedicinalProductIndicationOtherTherapy[];
    comorbidity?: CodeableConcept[];
    intendedEffect?: CodeableConcept;
    population?: Population[];
    diseaseStatus?: CodeableConcept;
    subject?: Reference[];
};