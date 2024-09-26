from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import Population
from base import Quantity
from base import DomainResource
from base import Reference
from base import BackboneElement

@dataclass(kw_only=True)
class MedicinalProductIndicationOtherTherapy(BackboneElement):
    medication_reference: Optional[Reference] = None
    therapy_relationship_type: CodeableConcept
    medication_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class MedicinalProductIndication(DomainResource):
    disease_symptom_procedure: Optional[CodeableConcept] = None
    undesirable_effect: Optional[List[Reference]] = field(default_factory=list)
    duration: Optional[Quantity] = None
    other_therapy: Optional[List[MedicinalProductIndicationOtherTherapy]] = field(default_factory=list)
    comorbidity: Optional[List[CodeableConcept]] = field(default_factory=list)
    intended_effect: Optional[CodeableConcept] = None
    population: Optional[List[Population]] = field(default_factory=list)
    disease_status: Optional[CodeableConcept] = None
    subject: Optional[List[Reference]] = field(default_factory=list)