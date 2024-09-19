from pydantic import *
from typing import Optional, List
from ..base import *

class SearchParameter_Component(BackboneElement):
    definition: str
    expression: str

class SearchParameter(DomainResource):
    description: str
    date: Optional[str] = None
    expression: Optional[str] = None
    modifier: Optional[List[str]] = None
    publisher: Optional[str] = None
    multiple_and: Optional[bool] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    derived_from: Optional[str] = None
    purpose: Optional[str] = None
    multiple_or: Optional[bool] = None
    name: str
    use_context: Optional[List[UsageContext]] = None
    xpath: Optional[str] = None
    xpath_usage: Optional[str] = None
    type: str
    experimental: Optional[bool] = None
    component: Optional[List[SearchParameter_Component]] = None
    status: str
    chain: Optional[List[str]] = None
    url: str
    code: str
    comparator: Optional[List[str]] = None
    target: Optional[List[str]] = None
    base: list[str] = []
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = None