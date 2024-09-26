from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import Population
from base import DomainResource
from base import Reference

@dataclass(kw_only=True)
class MedicinalProductUndesirableEffect(DomainResource):
    subject: Optional[List[Reference]] = field(default_factory=list)
    population: Optional[List[Population]] = field(default_factory=list)
    classification: Optional[CodeableConcept] = None
    frequency_of_occurrence: Optional[CodeableConcept] = None
    symptom_condition_effect: Optional[CodeableConcept] = None