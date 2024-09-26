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
class CodeSystemProperty(BackboneElement):
    uri: Optional[str] = None
    code: str
    type: str
    description: Optional[str] = None

@dataclass(kw_only=True)
class CodeSystemFilter(BackboneElement):
    code: str
    value: str
    operator: list[str] = field(default_factory=list)
    description: Optional[str] = None

@dataclass(kw_only=True)
class CodeSystemConceptProperty(BackboneElement):
    value_code: Optional[str] = None
    value_decimal: Optional[float] = None
    value_string: Optional[str] = None
    value_boolean: Optional[bool] = None
    value_date_time: Optional[str] = None
    value_coding: Optional[Coding] = None
    code: str
    value_integer: Optional[int] = None

@dataclass(kw_only=True)
class CodeSystemConceptDesignation(BackboneElement):
    use: Optional[Coding] = None
    value: str
    language: Optional[str] = None

@dataclass(kw_only=True)
class CodeSystemConcept(BackboneElement):
    code: str
    concept: Optional[List[Reference]] = field(default_factory=list)
    display: Optional[str] = None
    property: Optional[List[CodeSystemConceptProperty]] = field(default_factory=list)
    definition: Optional[str] = None
    designation: Optional[List[CodeSystemConceptDesignation]] = field(default_factory=list)

@dataclass(kw_only=True)
class CodeSystem(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    version_needed: Optional[bool] = None
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    purpose: Optional[str] = None
    content: str
    property: Optional[List[CodeSystemProperty]] = field(default_factory=list)
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    title: Optional[str] = None
    filter: Optional[List[CodeSystemFilter]] = field(default_factory=list)
    supplements: Optional[str] = None
    compositional: Optional[bool] = None
    status: str
    hierarchy_meaning: Optional[str] = None
    value_set: Optional[str] = None
    count: Optional[int] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    concept: Optional[List[CodeSystemConcept]] = field(default_factory=list)
    case_sensitive: Optional[bool] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)