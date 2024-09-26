from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import ContactDetail
from base import DomainResource
from base import BackboneElement

@dataclass(kw_only=True)
class CompartmentDefinitionResource(BackboneElement):
    code: str
    param: Optional[List[str]] = field(default_factory=list)
    documentation: Optional[str] = None

@dataclass(kw_only=True)
class CompartmentDefinition(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    publisher: Optional[str] = None
    purpose: Optional[str] = None
    name: str
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    experimental: Optional[bool] = None
    search: bool
    status: str
    resource: Optional[List[CompartmentDefinitionResource]] = field(default_factory=list)
    url: str
    code: str
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)