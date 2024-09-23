from typing import Optional, List
from pydantic import *
from ..base import *

class GraphDefinition_Link_Target_Compartment(BackboneElement):
    use: str
    code: str
    rule: str
    expression: Optional[str] = None
    description: Optional[str] = None

class GraphDefinition_Link_Target(BackboneElement):
    link: Optional[List[Reference]] = None
    type: str
    params: Optional[str] = None
    profile: Optional[str] = None
    compartment: Optional[List[GraphDefinition_Link_Target_Compartment]] = None

class GraphDefinition_Link(BackboneElement):
    max: Optional[str] = None
    min: Optional[int] = None
    path: Optional[str] = None
    target: Optional[List[GraphDefinition_Link_Target]] = None
    slice_name: Optional[str] = None
    description: Optional[str] = None

class GraphDefinition(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    purpose: Optional[str] = None
    name: str
    start: str
    use_context: Optional[List[UsageContext]] = None
    experimental: Optional[bool] = None
    status: str
    link: Optional[List[GraphDefinition_Link]] = None
    url: Optional[str] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = None
    profile: Optional[str] = None