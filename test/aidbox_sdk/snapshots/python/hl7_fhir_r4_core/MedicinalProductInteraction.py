from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import BackboneElement

@dataclass(kw_only=True)
class MedicinalProductInteractionInteractant(BackboneElement):
    item_reference: Optional[Reference] = None
    item_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class MedicinalProductInteraction(DomainResource):
    type: Optional[CodeableConcept] = None
    effect: Optional[CodeableConcept] = None
    subject: Optional[List[Reference]] = field(default_factory=list)
    incidence: Optional[CodeableConcept] = None
    management: Optional[CodeableConcept] = None
    description: Optional[str] = None
    interactant: Optional[List[MedicinalProductInteractionInteractant]] = field(default_factory=list)