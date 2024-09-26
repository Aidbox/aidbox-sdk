from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Period
from base import CodeableConcept
from base import Range
from base import Timing
from base import Quantity
from base import DomainResource
from base import Ratio
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class ServiceRequest(DomainResource):
    performer_type: Optional[CodeableConcept] = None
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    insurance: Optional[List[Reference]] = field(default_factory=list)
    instantiates_canonical: Optional[List[str]] = field(default_factory=list)
    instantiates_uri: Optional[List[str]] = field(default_factory=list)
    relevant_history: Optional[List[Reference]] = field(default_factory=list)
    supporting_info: Optional[List[Reference]] = field(default_factory=list)
    encounter: Optional[Reference] = None
    patient_instruction: Optional[str] = None
    specimen: Optional[List[Reference]] = field(default_factory=list)
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    authored_on: Optional[str] = None
    occurrence_timing: Optional[Timing] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    as_needed_boolean: Optional[bool] = None
    requisition: Optional[Identifier] = None
    location_reference: Optional[List[Reference]] = field(default_factory=list)
    requester: Optional[Reference] = None
    priority: Optional[str] = None
    occurrence_period: Optional[Period] = None
    status: str
    quantity_ratio: Optional[Ratio] = None
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    do_not_perform: Optional[bool] = None
    body_site: Optional[List[CodeableConcept]] = field(default_factory=list)
    intent: str
    quantity_range: Optional[Range] = None
    quantity_quantity: Optional[Quantity] = None
    replaces: Optional[List[Reference]] = field(default_factory=list)
    order_detail: Optional[List[CodeableConcept]] = field(default_factory=list)
    based_on: Optional[List[Reference]] = field(default_factory=list)
    location_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    occurrence_date_time: Optional[str] = None
    subject: Reference
    as_needed_codeable_concept: Optional[CodeableConcept] = None
    performer: Optional[List[Reference]] = field(default_factory=list)
    reason_reference: Optional[List[Reference]] = field(default_factory=list)