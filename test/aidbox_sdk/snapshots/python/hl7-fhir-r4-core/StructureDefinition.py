from pydantic import *
from typing import Optional, List
from ..base import *

class StructureDefinition_Mapping(BackboneElement):
    uri: Optional[str] = None
    name: Optional[str] = None
    comment: Optional[str] = None
    identity: str

class StructureDefinition_Snapshot(BackboneElement):
    element: list[ElementDefinition] = []

class StructureDefinition_Context(BackboneElement):
    type: str
    expression: str

class StructureDefinition_Differential(BackboneElement):
    element: list[ElementDefinition] = []

class StructureDefinition(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    derivation: Optional[str] = None
    publisher: Optional[str] = None
    context_invariant: Optional[List[str]] = None
    fhir_version: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    purpose: Optional[str] = None
    name: str
    mapping: Optional[List[StructureDefinition_Mapping]] = None
    use_context: Optional[List[UsageContext]] = None
    abstract: bool
    copyright: Optional[str] = None
    type: str
    experimental: Optional[bool] = None
    title: Optional[str] = None
    snapshot: Optional[StructureDefinition_Snapshot] = None
    keyword: Optional[List[Coding]] = None
    status: str
    kind: str
    url: str
    identifier: Optional[List[Identifier]] = None
    context: Optional[List[StructureDefinition_Context]] = None
    version: Optional[str] = None
    differential: Optional[StructureDefinition_Differential] = None
    contact: Optional[List[ContactDetail]] = None
    base_definition: Optional[str] = None