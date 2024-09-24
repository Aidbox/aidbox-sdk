from typing import Optional, List
from base import Annotation
from base import DataRequirement
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier

class GuidanceResponse(DomainResource):
    data_requirement: Optional[List[DataRequirement]] = None
    module_canonical: Optional[str] = None
    encounter: Optional[Reference] = None
    reason_code: Optional[List[CodeableConcept]] = None
    output_parameters: Optional[Reference] = None
    evaluation_message: Optional[List[Reference]] = None
    request_identifier: Optional[Identifier] = None
    note: Optional[List[Annotation]] = None
    status: str
    result: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = None
    module_codeable_concept: Optional[CodeableConcept] = None
    module_uri: Optional[str] = None
    occurrence_date_time: Optional[str] = None
    subject: Optional[Reference] = None
    performer: Optional[Reference] = None
    reason_reference: Optional[List[Reference]] = None