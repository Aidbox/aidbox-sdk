from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import DomainResource
from base import BackboneElement

@dataclass(kw_only=True)
class SearchParameterComponent(BackboneElement):
    definition: str
    expression: str

@dataclass(kw_only=True)
class SearchParameter(DomainResource):
    description: str
    date: Optional[str] = None
    expression: Optional[str] = None
    modifier: Optional[List[str]] = field(default_factory=list)
    publisher: Optional[str] = None
    multiple_and: Optional[bool] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    derived_from: Optional[str] = None
    purpose: Optional[str] = None
    multiple_or: Optional[bool] = None
    name: str
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    xpath: Optional[str] = None
    xpath_usage: Optional[str] = None
    type: str
    experimental: Optional[bool] = None
    component: Optional[List[SearchParameterComponent]] = field(default_factory=list)
    status: str
    chain: Optional[List[str]] = field(default_factory=list)
    url: str
    code: str
    comparator: Optional[List[str]] = field(default_factory=list)
    target: Optional[List[str]] = field(default_factory=list)
    base: list[str] = field(default_factory=list)
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)