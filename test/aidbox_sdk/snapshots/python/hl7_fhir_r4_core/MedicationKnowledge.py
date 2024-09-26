from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import Dosage
from base import Quantity
from base import Duration
from base import DomainResource
from base import Money
from base import Ratio
from base import Reference
from base import BackboneElement

@dataclass(kw_only=True)
class MedicationKnowledgeMonograph(BackboneElement):
    type: Optional[CodeableConcept] = None
    source: Optional[Reference] = None

@dataclass(kw_only=True)
class MedicationKnowledgeRegulatorySchedule(BackboneElement):
    schedule: CodeableConcept

@dataclass(kw_only=True)
class MedicationKnowledgeRegulatoryMaxDispense(BackboneElement):
    period: Optional[Duration] = None
    quantity: Quantity

@dataclass(kw_only=True)
class MedicationKnowledgeRegulatorySubstitution(BackboneElement):
    type: CodeableConcept
    allowed: bool

@dataclass(kw_only=True)
class MedicationKnowledgeRegulatory(BackboneElement):
    schedule: Optional[List[MedicationKnowledgeRegulatorySchedule]] = field(default_factory=list)
    max_dispense: Optional[MedicationKnowledgeRegulatoryMaxDispense] = None
    substitution: Optional[List[MedicationKnowledgeRegulatorySubstitution]] = field(default_factory=list)
    regulatory_authority: Reference

@dataclass(kw_only=True)
class MedicationKnowledgeDrugCharacteristic(BackboneElement):
    type: Optional[CodeableConcept] = None
    value_string: Optional[str] = None
    value_quantity: Optional[Quantity] = None
    value_base64_binary: Optional[str] = None
    value_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class MedicationKnowledgePackaging(BackboneElement):
    type: Optional[CodeableConcept] = None
    quantity: Optional[Quantity] = None

@dataclass(kw_only=True)
class MedicationKnowledgeRelatedMedicationKnowledge(BackboneElement):
    type: CodeableConcept
    reference: list[Reference] = field(default_factory=list)

@dataclass(kw_only=True)
class MedicationKnowledgeMedicineClassification(BackboneElement):
    type: CodeableConcept
    classification: Optional[List[CodeableConcept]] = field(default_factory=list)

@dataclass(kw_only=True)
class MedicationKnowledgeKinetics(BackboneElement):
    lethal_dose50: Optional[List[Quantity]] = field(default_factory=list)
    area_under_curve: Optional[List[Quantity]] = field(default_factory=list)
    half_life_period: Optional[Duration] = None

@dataclass(kw_only=True)
class MedicationKnowledgeIngredient(BackboneElement):
    is_active: Optional[bool] = None
    strength: Optional[Ratio] = None
    item_reference: Optional[Reference] = None
    item_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class MedicationKnowledgeMonitoringProgram(BackboneElement):
    name: Optional[str] = None
    type: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class MedicationKnowledgeAdministrationGuidelinesDosage(BackboneElement):
    type: CodeableConcept
    dosage: list[Dosage] = field(default_factory=list)

@dataclass(kw_only=True)
class MedicationKnowledgeAdministrationGuidelinesPatientCharacteristics(BackboneElement):
    value: Optional[List[str]] = field(default_factory=list)
    characteristic_quantity: Optional[Quantity] = None
    characteristic_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class MedicationKnowledgeAdministrationGuidelines(BackboneElement):
    dosage: Optional[List[MedicationKnowledgeAdministrationGuidelinesDosage]] = field(default_factory=list)
    indication_reference: Optional[Reference] = None
    patient_characteristics: Optional[List[MedicationKnowledgeAdministrationGuidelinesPatientCharacteristics]] = field(default_factory=list)
    indication_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class MedicationKnowledgeCost(BackboneElement):
    cost: Money
    type: CodeableConcept
    source: Optional[str] = None

@dataclass(kw_only=True)
class MedicationKnowledge(DomainResource):
    preparation_instruction: Optional[str] = None
    amount: Optional[Quantity] = None
    monograph: Optional[List[MedicationKnowledgeMonograph]] = field(default_factory=list)
    regulatory: Optional[List[MedicationKnowledgeRegulatory]] = field(default_factory=list)
    dose_form: Optional[CodeableConcept] = None
    intended_route: Optional[List[CodeableConcept]] = field(default_factory=list)
    drug_characteristic: Optional[List[MedicationKnowledgeDrugCharacteristic]] = field(default_factory=list)
    packaging: Optional[MedicationKnowledgePackaging] = None
    related_medication_knowledge: Optional[List[MedicationKnowledgeRelatedMedicationKnowledge]] = field(default_factory=list)
    medicine_classification: Optional[List[MedicationKnowledgeMedicineClassification]] = field(default_factory=list)
    kinetics: Optional[List[MedicationKnowledgeKinetics]] = field(default_factory=list)
    associated_medication: Optional[List[Reference]] = field(default_factory=list)
    ingredient: Optional[List[MedicationKnowledgeIngredient]] = field(default_factory=list)
    monitoring_program: Optional[List[MedicationKnowledgeMonitoringProgram]] = field(default_factory=list)
    contraindication: Optional[List[Reference]] = field(default_factory=list)
    status: Optional[str] = None
    product_type: Optional[List[CodeableConcept]] = field(default_factory=list)
    synonym: Optional[List[str]] = field(default_factory=list)
    code: Optional[CodeableConcept] = None
    administration_guidelines: Optional[List[MedicationKnowledgeAdministrationGuidelines]] = field(default_factory=list)
    manufacturer: Optional[Reference] = None
    cost: Optional[List[MedicationKnowledgeCost]] = field(default_factory=list)