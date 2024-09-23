from typing import Optional, List
from pydantic import *
from base.CodeableConcept import CodeableConcept
from base.Population import Population
from base.DomainResource import DomainResource
from base.Reference import Reference

class MedicinalProductUndesirableEffect(DomainResource):
    subject: Optional[List[Reference]] = None
    population: Optional[List[Population]] = None
    classification: Optional[CodeableConcept] = None
    frequency_of_occurrence: Optional[CodeableConcept] = None
    symptom_condition_effect: Optional[CodeableConcept] = None