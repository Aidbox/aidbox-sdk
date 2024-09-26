from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import Coding
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ValueSetComposeIncludeFilter(BackboneElement):
    op: str
    value: str
    property: str

@dataclass(kw_only=True)
class ValueSetComposeIncludeConceptDesignation(BackboneElement):
    use: Optional[Coding] = None
    value: str
    language: Optional[str] = None

@dataclass(kw_only=True)
class ValueSetComposeIncludeConcept(BackboneElement):
    code: str
    display: Optional[str] = None
    designation: Optional[List[ValueSetComposeIncludeConceptDesignation]] = field(default_factory=list)

@dataclass(kw_only=True)
class ValueSetComposeInclude(BackboneElement):
    filter: Optional[List[ValueSetComposeIncludeFilter]] = field(default_factory=list)
    system: Optional[str] = None
    concept: Optional[List[ValueSetComposeIncludeConcept]] = field(default_factory=list)
    version: Optional[str] = None
    value_set: Optional[List[str]] = field(default_factory=list)

@dataclass(kw_only=True)
class ValueSetCompose(BackboneElement):
    exclude: Optional[List[Reference]] = field(default_factory=list)
    include: list[ValueSetComposeInclude] = field(default_factory=list)
    inactive: Optional[bool] = None
    locked_date: Optional[str] = None

@dataclass(kw_only=True)
class ValueSetExpansionContains(BackboneElement):
    code: Optional[str] = None
    system: Optional[str] = None
    display: Optional[str] = None
    version: Optional[str] = None
    abstract: Optional[bool] = None
    contains: Optional[List[Reference]] = field(default_factory=list)
    inactive: Optional[bool] = None
    designation: Optional[List[Reference]] = field(default_factory=list)

@dataclass(kw_only=True)
class ValueSetExpansionParameter(BackboneElement):
    value_code: Optional[str] = None
    value_uri: Optional[str] = None
    value_decimal: Optional[float] = None
    name: str
    value_string: Optional[str] = None
    value_boolean: Optional[bool] = None
    value_date_time: Optional[str] = None
    value_integer: Optional[int] = None

@dataclass(kw_only=True)
class ValueSetExpansion(BackboneElement):
    total: Optional[int] = None
    offset: Optional[int] = None
    contains: Optional[List[ValueSetExpansionContains]] = field(default_factory=list)
    parameter: Optional[List[ValueSetExpansionParameter]] = field(default_factory=list)
    timestamp: str
    identifier: Optional[str] = None

@dataclass(kw_only=True)
class ValueSet(DomainResource):
    description: Optional[str] = None
    compose: Optional[ValueSetCompose] = None
    date: Optional[str] = None
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    purpose: Optional[str] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    expansion: Optional[ValueSetExpansion] = None
    title: Optional[str] = None
    status: str
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    immutable: Optional[bool] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)