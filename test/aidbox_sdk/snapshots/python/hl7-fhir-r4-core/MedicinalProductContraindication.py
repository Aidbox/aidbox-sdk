from typing import Optional, List
from base import CodeableConcept
from base import Population
from base import DomainResource
from base import Reference
from base import BackboneElement

class MedicinalProductContraindication_OtherTherapy(BackboneElement):
    medication_reference: Optional[Reference] = None
    therapy_relationship_type: CodeableConcept
    medication_codeable_concept: Optional[CodeableConcept] = None

class MedicinalProductContraindication(DomainResource):
    disease: Optional[CodeableConcept] = None
    subject: Optional[List[Reference]] = None
    population: Optional[List[Population]] = None
    comorbidity: Optional[List[CodeableConcept]] = None
    other_therapy: Optional[List[MedicinalProductContraindication_OtherTherapy]] = None
    disease_status: Optional[CodeableConcept] = None
    therapeutic_indication: Optional[List[Reference]] = None