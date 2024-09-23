from typing import Optional, List
from pydantic import *
from ..base import *

class MedicationKnowledge_Monograph(BackboneElement):
    type: Optional[CodeableConcept] = None
    source: Optional[Reference] = None

class MedicationKnowledge_Regulatory_Schedule(BackboneElement):
    schedule: CodeableConcept

class MedicationKnowledge_Regulatory_MaxDispense(BackboneElement):
    period: Optional[Duration] = None
    quantity: Quantity

class MedicationKnowledge_Regulatory_Substitution(BackboneElement):
    type: CodeableConcept
    allowed: bool

class MedicationKnowledge_Regulatory(BackboneElement):
    schedule: Optional[List[MedicationKnowledge_Regulatory_Schedule]] = None
    max_dispense: Optional[MedicationKnowledge_Regulatory_MaxDispense] = None
    substitution: Optional[List[MedicationKnowledge_Regulatory_Substitution]] = None
    regulatory_authority: Reference

class MedicationKnowledge_DrugCharacteristic(BackboneElement):
    type: Optional[CodeableConcept] = None
    value_string: Optional[str] = None
    value_quantity: Optional[Quantity] = None
    value_base64_binary: Optional[str] = None
    value_codeable_concept: Optional[CodeableConcept] = None

class MedicationKnowledge_Packaging(BackboneElement):
    type: Optional[CodeableConcept] = None
    quantity: Optional[Quantity] = None

class MedicationKnowledge_RelatedMedicationKnowledge(BackboneElement):
    type: CodeableConcept
    reference: list[Reference] = []

class MedicationKnowledge_MedicineClassification(BackboneElement):
    type: CodeableConcept
    classification: Optional[List[CodeableConcept]] = None

class MedicationKnowledge_Kinetics(BackboneElement):
    lethal_dose50: Optional[List[Quantity]] = None
    area_under_curve: Optional[List[Quantity]] = None
    half_life_period: Optional[Duration] = None

class MedicationKnowledge_Ingredient(BackboneElement):
    is_active: Optional[bool] = None
    strength: Optional[Ratio] = None
    item_reference: Optional[Reference] = None
    item_codeable_concept: Optional[CodeableConcept] = None

class MedicationKnowledge_MonitoringProgram(BackboneElement):
    name: Optional[str] = None
    type: Optional[CodeableConcept] = None

class MedicationKnowledge_AdministrationGuidelines_Dosage(BackboneElement):
    type: CodeableConcept
    dosage: list[Dosage] = []

class MedicationKnowledge_AdministrationGuidelines_PatientCharacteristics(BackboneElement):
    value: Optional[List[str]] = None
    characteristic_quantity: Optional[Quantity] = None
    characteristic_codeable_concept: Optional[CodeableConcept] = None

class MedicationKnowledge_AdministrationGuidelines(BackboneElement):
    dosage: Optional[List[MedicationKnowledge_AdministrationGuidelines_Dosage]] = None
    indication_reference: Optional[Reference] = None
    patient_characteristics: Optional[List[MedicationKnowledge_AdministrationGuidelines_PatientCharacteristics]] = None
    indication_codeable_concept: Optional[CodeableConcept] = None

class MedicationKnowledge_Cost(BackboneElement):
    cost: Money
    type: CodeableConcept
    source: Optional[str] = None

class MedicationKnowledge(DomainResource):
    preparation_instruction: Optional[str] = None
    amount: Optional[Quantity] = None
    monograph: Optional[List[MedicationKnowledge_Monograph]] = None
    regulatory: Optional[List[MedicationKnowledge_Regulatory]] = None
    dose_form: Optional[CodeableConcept] = None
    intended_route: Optional[List[CodeableConcept]] = None
    drug_characteristic: Optional[List[MedicationKnowledge_DrugCharacteristic]] = None
    packaging: Optional[MedicationKnowledge_Packaging] = None
    related_medication_knowledge: Optional[List[MedicationKnowledge_RelatedMedicationKnowledge]] = None
    medicine_classification: Optional[List[MedicationKnowledge_MedicineClassification]] = None
    kinetics: Optional[List[MedicationKnowledge_Kinetics]] = None
    associated_medication: Optional[List[Reference]] = None
    ingredient: Optional[List[MedicationKnowledge_Ingredient]] = None
    monitoring_program: Optional[List[MedicationKnowledge_MonitoringProgram]] = None
    contraindication: Optional[List[Reference]] = None
    status: Optional[str] = None
    product_type: Optional[List[CodeableConcept]] = None
    synonym: Optional[List[str]] = None
    code: Optional[CodeableConcept] = None
    administration_guidelines: Optional[List[MedicationKnowledge_AdministrationGuidelines]] = None
    manufacturer: Optional[Reference] = None
    cost: Optional[List[MedicationKnowledge_Cost]] = None