from typing import Optional, List
from pydantic import *
from ..base import *

class MedicinalProductInteraction_Interactant(BackboneElement):
    item_reference: Optional[Reference] = None
    item_codeable_concept: Optional[CodeableConcept] = None

class MedicinalProductInteraction(DomainResource):
    type: Optional[CodeableConcept] = None
    effect: Optional[CodeableConcept] = None
    subject: Optional[List[Reference]] = None
    incidence: Optional[CodeableConcept] = None
    management: Optional[CodeableConcept] = None
    description: Optional[str] = None
    interactant: Optional[List[MedicinalProductInteraction_Interactant]] = None