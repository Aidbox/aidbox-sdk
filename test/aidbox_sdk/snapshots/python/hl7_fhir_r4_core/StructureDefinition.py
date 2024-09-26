from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import Coding
from base import ElementDefinition
from base import DomainResource
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class StructureDefinitionMapping(BackboneElement):
    uri: Optional[str] = None
    name: Optional[str] = None
    comment: Optional[str] = None
    identity: str

@dataclass(kw_only=True)
class StructureDefinitionSnapshot(BackboneElement):
    element: list[ElementDefinition] = field(default_factory=list)

@dataclass(kw_only=True)
class StructureDefinitionContext(BackboneElement):
    type: str
    expression: str

@dataclass(kw_only=True)
class StructureDefinitionDifferential(BackboneElement):
    element: list[ElementDefinition] = field(default_factory=list)

@dataclass(kw_only=True)
class StructureDefinition(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    derivation: Optional[str] = None
    publisher: Optional[str] = None
    context_invariant: Optional[List[str]] = field(default_factory=list)
    fhir_version: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    purpose: Optional[str] = None
    name: str
    mapping: Optional[List[StructureDefinitionMapping]] = field(default_factory=list)
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    abstract: bool
    copyright: Optional[str] = None
    type: str
    experimental: Optional[bool] = None
    title: Optional[str] = None
    snapshot: Optional[StructureDefinitionSnapshot] = None
    keyword: Optional[List[Coding]] = field(default_factory=list)
    status: str
    kind: str
    url: str
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    context: Optional[List[StructureDefinitionContext]] = field(default_factory=list)
    version: Optional[str] = None
    differential: Optional[StructureDefinitionDifferential] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    base_definition: Optional[str] = None