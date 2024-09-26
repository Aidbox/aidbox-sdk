from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ConceptMapGroupElementTargetDependsOn(BackboneElement):
    value: str
    system: Optional[str] = None
    display: Optional[str] = None
    property: str

@dataclass(kw_only=True)
class ConceptMapGroupElementTarget(BackboneElement):
    code: Optional[str] = None
    comment: Optional[str] = None
    display: Optional[str] = None
    product: Optional[List[Reference]] = field(default_factory=list)
    depends_on: Optional[List[ConceptMapGroupElementTargetDependsOn]] = field(default_factory=list)
    equivalence: str

@dataclass(kw_only=True)
class ConceptMapGroupElement(BackboneElement):
    code: Optional[str] = None
    target: Optional[List[ConceptMapGroupElementTarget]] = field(default_factory=list)
    display: Optional[str] = None

@dataclass(kw_only=True)
class ConceptMapGroupUnmapped(BackboneElement):
    url: Optional[str] = None
    code: Optional[str] = None
    mode: str
    display: Optional[str] = None

@dataclass(kw_only=True)
class ConceptMapGroup(BackboneElement):
    source: Optional[str] = None
    target: Optional[str] = None
    element: list[ConceptMapGroupElement] = field(default_factory=list)
    unmapped: Optional[ConceptMapGroupUnmapped] = None
    source_version: Optional[str] = None
    target_version: Optional[str] = None

@dataclass(kw_only=True)
class ConceptMap(DomainResource):
    description: Optional[str] = None
    source_canonical: Optional[str] = None
    date: Optional[str] = None
    target_uri: Optional[str] = None
    group: Optional[List[ConceptMapGroup]] = field(default_factory=list)
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    purpose: Optional[str] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    title: Optional[str] = None
    target_canonical: Optional[str] = None
    status: str
    source_uri: Optional[str] = None
    url: Optional[str] = None
    identifier: Optional[Identifier] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)