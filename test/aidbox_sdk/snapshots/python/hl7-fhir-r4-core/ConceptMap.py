from typing import Optional, List
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

class ConceptMap_Group_Element_Target_DependsOn(BackboneElement):
    value: str
    system: Optional[str] = None
    display: Optional[str] = None
    property: str

class ConceptMap_Group_Element_Target(BackboneElement):
    code: Optional[str] = None
    comment: Optional[str] = None
    display: Optional[str] = None
    product: Optional[List[Reference]] = None
    depends_on: Optional[List[ConceptMap_Group_Element_Target_DependsOn]] = None
    equivalence: str

class ConceptMap_Group_Element(BackboneElement):
    code: Optional[str] = None
    target: Optional[List[ConceptMap_Group_Element_Target]] = None
    display: Optional[str] = None

class ConceptMap_Group_Unmapped(BackboneElement):
    url: Optional[str] = None
    code: Optional[str] = None
    mode: str
    display: Optional[str] = None

class ConceptMap_Group(BackboneElement):
    source: Optional[str] = None
    target: Optional[str] = None
    element: list[ConceptMap_Group_Element] = []
    unmapped: Optional[ConceptMap_Group_Unmapped] = None
    source_version: Optional[str] = None
    target_version: Optional[str] = None

class ConceptMap(DomainResource):
    description: Optional[str] = None
    source_canonical: Optional[str] = None
    date: Optional[str] = None
    target_uri: Optional[str] = None
    group: Optional[List[ConceptMap_Group]] = None
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    purpose: Optional[str] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    title: Optional[str] = None
    target_canonical: Optional[str] = None
    status: str
    source_uri: Optional[str] = None
    url: Optional[str] = None
    identifier: Optional[Identifier] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = None