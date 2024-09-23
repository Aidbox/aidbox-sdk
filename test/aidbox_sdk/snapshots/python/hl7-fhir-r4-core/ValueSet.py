from typing import Optional, List
from pydantic import *
from ..base import *

class ValueSet_Compose_Include_Filter(BackboneElement):
    op: str
    value: str
    property: str

class ValueSet_Compose_Include_Concept_Designation(BackboneElement):
    use: Optional[Coding] = None
    value: str
    language: Optional[str] = None

class ValueSet_Compose_Include_Concept(BackboneElement):
    code: str
    display: Optional[str] = None
    designation: Optional[List[ValueSet_Compose_Include_Concept_Designation]] = None

class ValueSet_Compose_Include(BackboneElement):
    filter: Optional[List[ValueSet_Compose_Include_Filter]] = None
    system: Optional[str] = None
    concept: Optional[List[ValueSet_Compose_Include_Concept]] = None
    version: Optional[str] = None
    value_set: Optional[List[str]] = None

class ValueSet_Compose(BackboneElement):
    exclude: Optional[List[Reference]] = None
    include: list[ValueSet_Compose_Include] = []
    inactive: Optional[bool] = None
    locked_date: Optional[str] = None

class ValueSet_Expansion_Contains(BackboneElement):
    code: Optional[str] = None
    system: Optional[str] = None
    display: Optional[str] = None
    version: Optional[str] = None
    abstract: Optional[bool] = None
    contains: Optional[List[Reference]] = None
    inactive: Optional[bool] = None
    designation: Optional[List[Reference]] = None

class ValueSet_Expansion_Parameter(BackboneElement):
    value_code: Optional[str] = None
    value_uri: Optional[str] = None
    value_decimal: Optional[float] = None
    name: str
    value_string: Optional[str] = None
    value_boolean: Optional[bool] = None
    value_date_time: Optional[str] = None
    value_integer: Optional[int] = None

class ValueSet_Expansion(BackboneElement):
    total: Optional[int] = None
    offset: Optional[int] = None
    contains: Optional[List[ValueSet_Expansion_Contains]] = None
    parameter: Optional[List[ValueSet_Expansion_Parameter]] = None
    timestamp: str
    identifier: Optional[str] = None

class ValueSet(DomainResource):
    description: Optional[str] = None
    compose: Optional[ValueSet_Compose] = None
    date: Optional[str] = None
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    purpose: Optional[str] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    expansion: Optional[ValueSet_Expansion] = None
    title: Optional[str] = None
    status: str
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    immutable: Optional[bool] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = None