from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import Population
from base import DomainResource
from base import Reference
from base import BackboneElement

@dataclass(kw_only=True)
class MedicinalProductContraindicationOtherTherapy(BackboneElement):
    medication_reference: Optional[Reference] = None
    therapy_relationship_type: CodeableConcept
    medication_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class MedicinalProductContraindication(DomainResource):
    disease: Optional[CodeableConcept] = None
    subject: Optional[List[Reference]] = field(default_factory=list)
    population: Optional[List[Population]] = field(default_factory=list)
    comorbidity: Optional[List[CodeableConcept]] = field(default_factory=list)
    other_therapy: Optional[List[MedicinalProductContraindicationOtherTherapy]] = field(default_factory=list)
    disease_status: Optional[CodeableConcept] = None
    therapeutic_indication: Optional[List[Reference]] = field(default_factory=list)