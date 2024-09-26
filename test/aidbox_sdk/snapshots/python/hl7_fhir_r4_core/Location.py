from typing import Optional, List
from dataclasses import dataclass, field
from base import Address
from base import CodeableConcept
from base import Coding
from base import ContactPoint
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class LocationHoursOfOperation(BackboneElement):
    all_day: Optional[bool] = None
    days_of_week: Optional[List[str]] = field(default_factory=list)
    closing_time: Optional[str] = None
    opening_time: Optional[str] = None

@dataclass(kw_only=True)
class LocationPosition(BackboneElement):
    altitude: Optional[float] = None
    latitude: float
    longitude: float

@dataclass(kw_only=True)
class Location(DomainResource):
    description: Optional[str] = None
    address: Optional[Address] = None
    managing_organization: Optional[Reference] = None
    name: Optional[str] = None
    mode: Optional[str] = None
    type: Optional[List[CodeableConcept]] = field(default_factory=list)
    alias: Optional[List[str]] = field(default_factory=list)
    status: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    hours_of_operation: Optional[List[LocationHoursOfOperation]] = field(default_factory=list)
    availability_exceptions: Optional[str] = None
    position: Optional[LocationPosition] = None
    telecom: Optional[List[ContactPoint]] = field(default_factory=list)
    operational_status: Optional[Coding] = None
    part_of: Optional[Reference] = None
    physical_type: Optional[CodeableConcept] = None
    endpoint: Optional[List[Reference]] = field(default_factory=list)