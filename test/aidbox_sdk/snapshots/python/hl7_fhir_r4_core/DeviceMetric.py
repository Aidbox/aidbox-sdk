from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import Timing
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class DeviceMetricCalibration(BackboneElement):
    time: Optional[str] = None
    type: Optional[str] = None
    state: Optional[str] = None

@dataclass(kw_only=True)
class DeviceMetric(DomainResource):
    category: str
    measurement_period: Optional[Timing] = None
    color: Optional[str] = None
    parent: Optional[Reference] = None
    unit: Optional[CodeableConcept] = None
    type: CodeableConcept
    source: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    calibration: Optional[List[DeviceMetricCalibration]] = field(default_factory=list)
    operational_status: Optional[str] = None