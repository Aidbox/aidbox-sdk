from pydantic import *
from typing import Optional, List
from ..base import *

class List_Entry(BackboneElement):
    date: Optional[str] = None
    flag: Optional[CodeableConcept] = None
    item: Reference
    deleted: Optional[bool] = None

class List(DomainResource):
    date: Optional[str] = None
    encounter: Optional[Reference] = None
    ordered_by: Optional[CodeableConcept] = None
    mode: str
    source: Optional[Reference] = None
    title: Optional[str] = None
    note: Optional[List[Annotation]] = None
    empty_reason: Optional[CodeableConcept] = None
    status: str
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    entry: Optional[List[List_Entry]] = None
    subject: Optional[Reference] = None