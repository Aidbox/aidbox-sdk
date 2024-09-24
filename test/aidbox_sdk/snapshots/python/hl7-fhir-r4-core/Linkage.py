from typing import Optional, List
from base import DomainResource
from base import Reference
from base import BackboneElement

class Linkage_Item(BackboneElement):
    type: str
    resource: Reference

class Linkage(DomainResource):
    item: list[Linkage_Item] = []
    active: Optional[bool] = None
    author: Optional[Reference] = None