from typing import Optional, List
from dataclasses import dataclass, field
from base import DomainResource
from base import Reference
from base import BackboneElement

@dataclass(kw_only=True)
class LinkageItem(BackboneElement):
    type: str
    resource: Reference

@dataclass(kw_only=True)
class Linkage(DomainResource):
    item: list[LinkageItem] = field(default_factory=list)
    active: Optional[bool] = None
    author: Optional[Reference] = None