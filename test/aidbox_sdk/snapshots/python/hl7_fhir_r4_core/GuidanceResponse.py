from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import DataRequirement
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier

@dataclass(kw_only=True)
class GuidanceResponse(DomainResource):
    data_requirement: Optional[List[DataRequirement]] = field(default_factory=list)
    module_canonical: Optional[str] = None
    encounter: Optional[Reference] = None
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    output_parameters: Optional[Reference] = None
    evaluation_message: Optional[List[Reference]] = field(default_factory=list)
    request_identifier: Optional[Identifier] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    status: str
    result: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    module_codeable_concept: Optional[CodeableConcept] = None
    module_uri: Optional[str] = None
    occurrence_date_time: Optional[str] = None
    subject: Optional[Reference] = None
    performer: Optional[Reference] = None
    reason_reference: Optional[List[Reference]] = field(default_factory=list)