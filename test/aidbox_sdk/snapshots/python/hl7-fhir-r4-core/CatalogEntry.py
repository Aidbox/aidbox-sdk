from pydantic import *
from typing import Optional, List
from ..base import *

class CatalogEntry_RelatedEntry(BackboneElement):
    item: Reference
    relationtype: str

class CatalogEntry(DomainResource):
    additional_characteristic: Optional[List[CodeableConcept]] = None
    additional_classification: Optional[List[CodeableConcept]] = None
    referenced_item: Reference
    type: Optional[CodeableConcept] = None
    classification: Optional[List[CodeableConcept]] = None
    validity_period: Optional[Period] = None
    orderable: bool
    status: Optional[str] = None
    valid_to: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    additional_identifier: Optional[List[Identifier]] = None
    last_updated: Optional[str] = None
    related_entry: Optional[List[CatalogEntry_RelatedEntry]] = None