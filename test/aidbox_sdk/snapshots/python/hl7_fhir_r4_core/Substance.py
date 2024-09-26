from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import Quantity
from base import DomainResource
from base import Ratio
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class SubstanceInstance(BackboneElement):
    expiry: Optional[str] = None
    quantity: Optional[Quantity] = None
    identifier: Optional[Identifier] = None

@dataclass(kw_only=True)
class SubstanceIngredient(BackboneElement):
    quantity: Optional[Ratio] = None
    substance_reference: Optional[Reference] = None
    substance_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class Substance(DomainResource):
    code: CodeableConcept
    status: Optional[str] = None
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    instance: Optional[List[SubstanceInstance]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    ingredient: Optional[List[SubstanceIngredient]] = field(default_factory=list)
    description: Optional[str] = None