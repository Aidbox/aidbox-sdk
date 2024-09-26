from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class CatalogEntryRelatedEntry(BackboneElement):
    item: Reference
    relationtype: str

@dataclass(kw_only=True)
class CatalogEntry(DomainResource):
    additional_characteristic: Optional[List[CodeableConcept]] = field(default_factory=list)
    additional_classification: Optional[List[CodeableConcept]] = field(default_factory=list)
    referenced_item: Reference
    type: Optional[CodeableConcept] = None
    classification: Optional[List[CodeableConcept]] = field(default_factory=list)
    validity_period: Optional[Period] = None
    orderable: bool
    status: Optional[str] = None
    valid_to: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    additional_identifier: Optional[List[Identifier]] = field(default_factory=list)
    last_updated: Optional[str] = None
    related_entry: Optional[List[CatalogEntryRelatedEntry]] = field(default_factory=list)