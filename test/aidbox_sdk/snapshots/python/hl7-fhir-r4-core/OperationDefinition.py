from typing import Optional, List
from pydantic import *
from ..base import *

class OperationDefinition_Overload(BackboneElement):
    comment: Optional[str] = None
    parameter_name: Optional[List[str]] = None

class OperationDefinition_Parameter_ReferencedFrom(BackboneElement):
    source: str
    source_id: Optional[str] = None

class OperationDefinition_Parameter_Binding(BackboneElement):
    strength: str
    value_set: str

class OperationDefinition_Parameter(BackboneElement):
    min: int
    search_type: Optional[str] = None
    use: str
    name: str
    part: Optional[List[Reference]] = None
    type: Optional[str] = None
    referenced_from: Optional[List[OperationDefinition_Parameter_ReferencedFrom]] = None
    documentation: Optional[str] = None
    binding: Optional[OperationDefinition_Parameter_Binding] = None
    max: str
    target_profile: Optional[List[str]] = None

class OperationDefinition(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    system: bool
    publisher: Optional[str] = None
    instance: bool
    jurisdiction: Optional[List[CodeableConcept]] = None
    purpose: Optional[str] = None
    name: str
    use_context: Optional[List[UsageContext]] = None
    type: bool
    overload: Optional[List[OperationDefinition_Overload]] = None
    experimental: Optional[bool] = None
    output_profile: Optional[str] = None
    title: Optional[str] = None
    status: str
    resource: Optional[List[str]] = None
    affects_state: Optional[bool] = None
    kind: str
    comment: Optional[str] = None
    url: Optional[str] = None
    code: str
    base: Optional[str] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = None
    input_profile: Optional[str] = None
    parameter: Optional[List[OperationDefinition_Parameter]] = None