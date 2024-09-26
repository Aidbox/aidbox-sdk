from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Period
from base import CodeableConcept
from base import Timing
from base import DomainResource
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class DeviceUseStatement(DomainResource):
    derived_from: Optional[List[Reference]] = field(default_factory=list)
    timing_period: Optional[Period] = None
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    source: Optional[Reference] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    timing_date_time: Optional[str] = None
    timing_timing: Optional[Timing] = None
    status: str
    recorded_on: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    body_site: Optional[CodeableConcept] = None
    device: Reference
    based_on: Optional[List[Reference]] = field(default_factory=list)
    subject: Reference
    reason_reference: Optional[List[Reference]] = field(default_factory=list)