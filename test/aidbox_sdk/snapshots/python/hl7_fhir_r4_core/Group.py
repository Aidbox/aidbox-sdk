from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import Range
from base import Quantity
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class GroupMember(BackboneElement):
    entity: Reference
    period: Optional[Period] = None
    inactive: Optional[bool] = None

@dataclass(kw_only=True)
class GroupCharacteristic(BackboneElement):
    exclude: bool
    value_reference: Optional[Reference] = None
    value_quantity: Optional[Quantity] = None
    value_boolean: Optional[bool] = None
    code: CodeableConcept
    value_codeable_concept: Optional[CodeableConcept] = None
    period: Optional[Period] = None
    value_range: Optional[Range] = None

@dataclass(kw_only=True)
class Group(DomainResource):
    name: Optional[str] = None
    type: str
    member: Optional[List[GroupMember]] = field(default_factory=list)
    characteristic: Optional[List[GroupCharacteristic]] = field(default_factory=list)
    active: Optional[bool] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    quantity: Optional[int] = None
    managing_entity: Optional[Reference] = None
    actual: bool