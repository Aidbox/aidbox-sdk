from typing import Optional, List
from pydantic import *
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.BackboneElement import BackboneElement

class Linkage_Item(BackboneElement):
    type: str
    resource: Reference

class Linkage(DomainResource):
    item: list[Linkage_Item] = []
    active: Optional[bool] = None
    author: Optional[Reference] = None