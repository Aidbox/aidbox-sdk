from typing import Optional, List
from pydantic import *
from ..base import *

class MedicinalProductUndesirableEffect(DomainResource):
    subject: Optional[List[Reference]] = None
    population: Optional[List[Population]] = None
    classification: Optional[CodeableConcept] = None
    frequency_of_occurrence: Optional[CodeableConcept] = None
    symptom_condition_effect: Optional[CodeableConcept] = None