import { CodeableConcept } from "./CodeableConcept";
import { Dosage } from "./Dosage";
import { Quantity } from "./Quantity";
import { Duration } from "./Duration";
import { DomainResource } from "./DomainResource";
import { Money } from "./Money";
import { Ratio } from "./Ratio";
import { Reference } from "./Reference";
import { BackboneElement } from "./BackboneElement";

export type MedicationKnowledgeMonograph = BackboneElement & {
    type?: CodeableConcept;
    source?: Reference;
};

export type MedicationKnowledgeRegulatorySchedule = BackboneElement & {
    schedule: CodeableConcept;
};

export type MedicationKnowledgeRegulatoryMaxDispense = BackboneElement & {
    period?: Duration;
    quantity: Quantity;
};

export type MedicationKnowledgeRegulatorySubstitution = BackboneElement & {
    type: CodeableConcept;
    allowed: boolean;
};

export type MedicationKnowledgeRegulatory = BackboneElement & {
    schedule?: MedicationKnowledgeRegulatorySchedule[];
    maxDispense?: MedicationKnowledgeRegulatoryMaxDispense;
    substitution?: MedicationKnowledgeRegulatorySubstitution[];
    regulatoryAuthority: Reference;
};

export type MedicationKnowledgeDrugCharacteristic = BackboneElement & {
    type?: CodeableConcept;
    value?: string | Quantity | CodeableConcept;
};

export type MedicationKnowledgePackaging = BackboneElement & {
    type?: CodeableConcept;
    quantity?: Quantity;
};

export type MedicationKnowledgeRelatedMedicationKnowledge = BackboneElement & {
    type: CodeableConcept;
    reference: Reference[];
};

export type MedicationKnowledgeMedicineClassification = BackboneElement & {
    type: CodeableConcept;
    classification?: CodeableConcept[];
};

export type MedicationKnowledgeKinetics = BackboneElement & {
    lethalDose50?: Quantity[];
    areaUnderCurve?: Quantity[];
    halfLifePeriod?: Duration;
};

export type MedicationKnowledgeIngredient = BackboneElement & {
    item?: Reference | CodeableConcept;
    isActive?: boolean;
    strength?: Ratio;
};

export type MedicationKnowledgeMonitoringProgram = BackboneElement & {
    name?: string;
    type?: CodeableConcept;
};

export type MedicationKnowledgeAdministrationGuidelinesDosage = BackboneElement & {
    type: CodeableConcept;
    dosage: Dosage[];
};

export type MedicationKnowledgeAdministrationGuidelinesPatientCharacteristics = BackboneElement & {
    value?: string[];
    characteristic?: Quantity | CodeableConcept;
};

export type MedicationKnowledgeAdministrationGuidelines = BackboneElement & {
    dosage?: MedicationKnowledgeAdministrationGuidelinesDosage[];
    indication?: Reference | CodeableConcept;
    patientCharacteristics?: MedicationKnowledgeAdministrationGuidelinesPatientCharacteristics[];
};

export type MedicationKnowledgeCost = BackboneElement & {
    cost: Money;
    type: CodeableConcept;
    source?: string;
};

export type MedicationKnowledge = DomainResource & {
    preparationInstruction?: string;
    amount?: Quantity;
    monograph?: MedicationKnowledgeMonograph[];
    regulatory?: MedicationKnowledgeRegulatory[];
    doseForm?: CodeableConcept;
    intendedRoute?: CodeableConcept[];
    drugCharacteristic?: MedicationKnowledgeDrugCharacteristic[];
    packaging?: MedicationKnowledgePackaging;
    relatedMedicationKnowledge?: MedicationKnowledgeRelatedMedicationKnowledge[];
    medicineClassification?: MedicationKnowledgeMedicineClassification[];
    kinetics?: MedicationKnowledgeKinetics[];
    associatedMedication?: Reference[];
    ingredient?: MedicationKnowledgeIngredient[];
    monitoringProgram?: MedicationKnowledgeMonitoringProgram[];
    contraindication?: Reference[];
    status?: string;
    productType?: CodeableConcept[];
    synonym?: string[];
    code?: CodeableConcept;
    administrationGuidelines?: MedicationKnowledgeAdministrationGuidelines[];
    manufacturer?: Reference;
    cost?: MedicationKnowledgeCost[];
};