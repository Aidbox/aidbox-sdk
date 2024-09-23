from typing import Optional, List
from pydantic import *
from ..base.Annotation import Annotation
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.Range import Range
from ..base.Timing import Timing
from ..base.Quantity import Quantity
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class DeviceRequest_Parameter(BackboneElement):
    code: Optional[CodeableConcept] = None
    value_range: Optional[Range] = None
    value_boolean: Optional[bool] = None
    value_quantity: Optional[Quantity] = None
    value_codeable_concept: Optional[CodeableConcept] = None

class DeviceRequest(DomainResource):
    performer_type: Optional[CodeableConcept] = None
    insurance: Optional[List[Reference]] = None
    instantiates_canonical: Optional[List[str]] = None
    instantiates_uri: Optional[List[str]] = None
    relevant_history: Optional[List[Reference]] = None
    supporting_info: Optional[List[Reference]] = None
    encounter: Optional[Reference] = None
    prior_request: Optional[List[Reference]] = None
    reason_code: Optional[List[CodeableConcept]] = None
    authored_on: Optional[str] = None
    occurrence_timing: Optional[Timing] = None
    note: Optional[List[Annotation]] = None
    code_reference: Optional[Reference] = None
    requester: Optional[Reference] = None
    priority: Optional[str] = None
    occurrence_period: Optional[Period] = None
    status: Optional[str] = None
    code_codeable_concept: Optional[CodeableConcept] = None
    group_identifier: Optional[Identifier] = None
    identifier: Optional[List[Identifier]] = None
    intent: str
    based_on: Optional[List[Reference]] = None
    occurrence_date_time: Optional[str] = None
    subject: Reference
    parameter: Optional[List[DeviceRequest_Parameter]] = None
    performer: Optional[Reference] = None
    reason_reference: Optional[List[Reference]] = None