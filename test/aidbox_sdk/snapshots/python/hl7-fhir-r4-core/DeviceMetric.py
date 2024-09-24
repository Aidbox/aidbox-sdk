from typing import Optional, List
from base import CodeableConcept
from base import Timing
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

class DeviceMetric_Calibration(BackboneElement):
    time: Optional[str] = None
    type: Optional[str] = None
    state: Optional[str] = None

class DeviceMetric(DomainResource):
    category: str
    measurement_period: Optional[Timing] = None
    color: Optional[str] = None
    parent: Optional[Reference] = None
    unit: Optional[CodeableConcept] = None
    type: CodeableConcept
    source: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = None
    calibration: Optional[List[DeviceMetric_Calibration]] = None
    operational_status: Optional[str] = None