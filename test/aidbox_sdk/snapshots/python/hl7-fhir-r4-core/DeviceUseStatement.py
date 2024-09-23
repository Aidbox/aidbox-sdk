from typing import Optional, List
from pydantic import *
from ..base.Annotation import Annotation
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.Timing import Timing
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier

class DeviceUseStatement(DomainResource):
    derived_from: Optional[List[Reference]] = None
    timing_period: Optional[Period] = None
    reason_code: Optional[List[CodeableConcept]] = None
    source: Optional[Reference] = None
    note: Optional[List[Annotation]] = None
    timing_date_time: Optional[str] = None
    timing_timing: Optional[Timing] = None
    status: str
    recorded_on: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    body_site: Optional[CodeableConcept] = None
    device: Reference
    based_on: Optional[List[Reference]] = None
    subject: Reference
    reason_reference: Optional[List[Reference]] = None