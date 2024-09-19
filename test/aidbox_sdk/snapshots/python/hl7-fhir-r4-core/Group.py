from pydantic import *
from typing import Optional, List
from ..base import *

class Group_Member(BackboneElement):
    entity: Reference
    period: Optional[Period] = None
    inactive: Optional[bool] = None

class Group_Characteristic(BackboneElement):
    exclude: bool
    value_reference: Optional[Reference] = None
    value_quantity: Optional[Quantity] = None
    value_boolean: Optional[bool] = None
    code: CodeableConcept
    value_codeable_concept: Optional[CodeableConcept] = None
    period: Optional[Period] = None
    value_range: Optional[Range] = None

class Group(DomainResource):
    name: Optional[str] = None
    type: str
    member: Optional[List[Group_Member]] = None
    characteristic: Optional[List[Group_Characteristic]] = None
    active: Optional[bool] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    quantity: Optional[int] = None
    managing_entity: Optional[Reference] = None
    actual: bool