from typing import Optional, List
from base import Address
from base import CodeableConcept
from base import Coding
from base import ContactPoint
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

class Location_HoursOfOperation(BackboneElement):
    all_day: Optional[bool] = None
    days_of_week: Optional[List[str]] = None
    closing_time: Optional[str] = None
    opening_time: Optional[str] = None

class Location_Position(BackboneElement):
    altitude: Optional[float] = None
    latitude: float
    longitude: float

class Location(DomainResource):
    description: Optional[str] = None
    address: Optional[Address] = None
    managing_organization: Optional[Reference] = None
    name: Optional[str] = None
    mode: Optional[str] = None
    type: Optional[List[CodeableConcept]] = None
    alias: Optional[List[str]] = None
    status: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    hours_of_operation: Optional[List[Location_HoursOfOperation]] = None
    availability_exceptions: Optional[str] = None
    position: Optional[Location_Position] = None
    telecom: Optional[List[ContactPoint]] = None
    operational_status: Optional[Coding] = None
    part_of: Optional[Reference] = None
    physical_type: Optional[CodeableConcept] = None
    endpoint: Optional[List[Reference]] = None