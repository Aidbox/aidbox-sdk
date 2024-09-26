from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ListEntry(BackboneElement):
    date: Optional[str] = None
    flag: Optional[CodeableConcept] = None
    item: Reference
    deleted: Optional[bool] = None

@dataclass(kw_only=True)
class FhirList(DomainResource):
    date: Optional[str] = None
    encounter: Optional[Reference] = None
    ordered_by: Optional[CodeableConcept] = None
    mode: str
    source: Optional[Reference] = None
    title: Optional[str] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    empty_reason: Optional[CodeableConcept] = None
    status: str
    code: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    entry: Optional[List[ListEntry]] = field(default_factory=list)
    subject: Optional[Reference] = None