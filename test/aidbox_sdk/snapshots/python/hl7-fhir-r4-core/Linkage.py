from typing import Optional, List
from pydantic import *
from ..base import *

class Linkage_Item(BackboneElement):
    type: str
    resource: Reference

class Linkage(DomainResource):
    item: list[Linkage_Item] = []
    active: Optional[bool] = None
    author: Optional[Reference] = None