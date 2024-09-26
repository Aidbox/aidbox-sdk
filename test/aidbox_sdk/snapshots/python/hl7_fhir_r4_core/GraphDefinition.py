from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import BackboneElement

@dataclass(kw_only=True)
class GraphDefinitionLinkTargetCompartment(BackboneElement):
    use: str
    code: str
    rule: str
    expression: Optional[str] = None
    description: Optional[str] = None

@dataclass(kw_only=True)
class GraphDefinitionLinkTarget(BackboneElement):
    link: Optional[List[Reference]] = field(default_factory=list)
    type: str
    params: Optional[str] = None
    profile: Optional[str] = None
    compartment: Optional[List[GraphDefinitionLinkTargetCompartment]] = field(default_factory=list)

@dataclass(kw_only=True)
class GraphDefinitionLink(BackboneElement):
    max: Optional[str] = None
    min: Optional[int] = None
    path: Optional[str] = None
    target: Optional[List[GraphDefinitionLinkTarget]] = field(default_factory=list)
    slice_name: Optional[str] = None
    description: Optional[str] = None

@dataclass(kw_only=True)
class GraphDefinition(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    purpose: Optional[str] = None
    name: str
    start: str
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    experimental: Optional[bool] = None
    status: str
    link: Optional[List[GraphDefinitionLink]] = field(default_factory=list)
    url: Optional[str] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    profile: Optional[str] = None