from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import BackboneElement

@dataclass(kw_only=True)
class OperationDefinitionOverload(BackboneElement):
    comment: Optional[str] = None
    parameter_name: Optional[List[str]] = field(default_factory=list)

@dataclass(kw_only=True)
class OperationDefinitionParameterReferencedFrom(BackboneElement):
    source: str
    source_id: Optional[str] = None

@dataclass(kw_only=True)
class OperationDefinitionParameterBinding(BackboneElement):
    strength: str
    value_set: str

@dataclass(kw_only=True)
class OperationDefinitionParameter(BackboneElement):
    min: int
    search_type: Optional[str] = None
    use: str
    name: str
    part: Optional[List[Reference]] = field(default_factory=list)
    type: Optional[str] = None
    referenced_from: Optional[List[OperationDefinitionParameterReferencedFrom]] = field(default_factory=list)
    documentation: Optional[str] = None
    binding: Optional[OperationDefinitionParameterBinding] = None
    max: str
    target_profile: Optional[List[str]] = field(default_factory=list)

@dataclass(kw_only=True)
class OperationDefinition(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    system: bool
    publisher: Optional[str] = None
    instance: bool
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    purpose: Optional[str] = None
    name: str
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    type: bool
    overload: Optional[List[OperationDefinitionOverload]] = field(default_factory=list)
    experimental: Optional[bool] = None
    output_profile: Optional[str] = None
    title: Optional[str] = None
    status: str
    resource: Optional[List[str]] = field(default_factory=list)
    affects_state: Optional[bool] = None
    kind: str
    comment: Optional[str] = None
    url: Optional[str] = None
    code: str
    base: Optional[str] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    input_profile: Optional[str] = None
    parameter: Optional[List[OperationDefinitionParameter]] = field(default_factory=list)