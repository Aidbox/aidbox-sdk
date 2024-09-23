from typing import Optional, List
from pydantic import *
from base.CodeableConcept import CodeableConcept
from base.Population import Population
from base.Quantity import Quantity
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.BackboneElement import BackboneElement

class MedicinalProductIndication_OtherTherapy(BackboneElement):
    medication_reference: Optional[Reference] = None
    therapy_relationship_type: CodeableConcept
    medication_codeable_concept: Optional[CodeableConcept] = None

class MedicinalProductIndication(DomainResource):
    disease_symptom_procedure: Optional[CodeableConcept] = None
    undesirable_effect: Optional[List[Reference]] = None
    duration: Optional[Quantity] = None
    other_therapy: Optional[List[MedicinalProductIndication_OtherTherapy]] = None
    comorbidity: Optional[List[CodeableConcept]] = None
    intended_effect: Optional[CodeableConcept] = None
    population: Optional[List[Population]] = None
    disease_status: Optional[CodeableConcept] = None
    subject: Optional[List[Reference]] = None