from typing import Optional, List
from pydantic import *
from ..base.CodeableConcept import CodeableConcept
from ..base.Quantity import Quantity
from ..base.DomainResource import DomainResource
from ..base.Ratio import Ratio
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class Substance_Instance(BackboneElement):
    expiry: Optional[str] = None
    quantity: Optional[Quantity] = None
    identifier: Optional[Identifier] = None

class Substance_Ingredient(BackboneElement):
    quantity: Optional[Ratio] = None
    substance_reference: Optional[Reference] = None
    substance_codeable_concept: Optional[CodeableConcept] = None

class Substance(DomainResource):
    code: CodeableConcept
    status: Optional[str] = None
    category: Optional[List[CodeableConcept]] = None
    instance: Optional[List[Substance_Instance]] = None
    identifier: Optional[List[Identifier]] = None
    ingredient: Optional[List[Substance_Ingredient]] = None
    description: Optional[str] = None