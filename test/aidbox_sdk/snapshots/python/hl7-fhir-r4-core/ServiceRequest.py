from typing import Optional, List
from pydantic import *
from ..base.Annotation import Annotation
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.Range import Range
from ..base.Timing import Timing
from ..base.Quantity import Quantity
from ..base.DomainResource import DomainResource
from ..base.Ratio import Ratio
from ..base.Reference import Reference
from ..base.Identifier import Identifier

class ServiceRequest(DomainResource):
    performer_type: Optional[CodeableConcept] = None
    category: Optional[List[CodeableConcept]] = None
    insurance: Optional[List[Reference]] = None
    instantiates_canonical: Optional[List[str]] = None
    instantiates_uri: Optional[List[str]] = None
    relevant_history: Optional[List[Reference]] = None
    supporting_info: Optional[List[Reference]] = None
    encounter: Optional[Reference] = None
    patient_instruction: Optional[str] = None
    specimen: Optional[List[Reference]] = None
    reason_code: Optional[List[CodeableConcept]] = None
    authored_on: Optional[str] = None
    occurrence_timing: Optional[Timing] = None
    note: Optional[List[Annotation]] = None
    as_needed_boolean: Optional[bool] = None
    requisition: Optional[Identifier] = None
    location_reference: Optional[List[Reference]] = None
    requester: Optional[Reference] = None
    priority: Optional[str] = None
    occurrence_period: Optional[Period] = None
    status: str
    quantity_ratio: Optional[Ratio] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    do_not_perform: Optional[bool] = None
    body_site: Optional[List[CodeableConcept]] = None
    intent: str
    quantity_range: Optional[Range] = None
    quantity_quantity: Optional[Quantity] = None
    replaces: Optional[List[Reference]] = None
    order_detail: Optional[List[CodeableConcept]] = None
    based_on: Optional[List[Reference]] = None
    location_code: Optional[List[CodeableConcept]] = None
    occurrence_date_time: Optional[str] = None
    subject: Reference
    as_needed_codeable_concept: Optional[CodeableConcept] = None
    performer: Optional[List[Reference]] = None
    reason_reference: Optional[List[Reference]] = None