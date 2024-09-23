from typing import Optional, List
from pydantic import *
from base.Annotation import Annotation
from base.Attachment import Attachment
from base.Period import Period
from base.CodeableConcept import CodeableConcept
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier

class Media(DomainResource):
    device_name: Optional[str] = None
    encounter: Optional[Reference] = None
    content: Attachment
    frames: Optional[int] = None
    width: Optional[int] = None
    reason_code: Optional[List[CodeableConcept]] = None
    type: Optional[CodeableConcept] = None
    modality: Optional[CodeableConcept] = None
    duration: Optional[float] = None
    note: Optional[List[Annotation]] = None
    created_period: Optional[Period] = None
    status: str
    identifier: Optional[List[Identifier]] = None
    operator: Optional[Reference] = None
    body_site: Optional[CodeableConcept] = None
    issued: Optional[str] = None
    device: Optional[Reference] = None
    based_on: Optional[List[Reference]] = None
    part_of: Optional[List[Reference]] = None
    created_date_time: Optional[str] = None
    subject: Optional[Reference] = None
    view: Optional[CodeableConcept] = None
    height: Optional[int] = None