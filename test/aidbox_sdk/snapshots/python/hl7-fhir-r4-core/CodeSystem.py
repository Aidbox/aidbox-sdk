from typing import Optional, List
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import Coding
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

class CodeSystem_Property(BackboneElement):
    uri: Optional[str] = None
    code: str
    type: str
    description: Optional[str] = None

class CodeSystem_Filter(BackboneElement):
    code: str
    value: str
    operator: list[str] = []
    description: Optional[str] = None

class CodeSystem_Concept_Property(BackboneElement):
    value_code: Optional[str] = None
    value_decimal: Optional[float] = None
    value_string: Optional[str] = None
    value_boolean: Optional[bool] = None
    value_date_time: Optional[str] = None
    value_coding: Optional[Coding] = None
    code: str
    value_integer: Optional[int] = None

class CodeSystem_Concept_Designation(BackboneElement):
    use: Optional[Coding] = None
    value: str
    language: Optional[str] = None

class CodeSystem_Concept(BackboneElement):
    code: str
    concept: Optional[List[Reference]] = None
    display: Optional[str] = None
    property: Optional[List[CodeSystem_Concept_Property]] = None
    definition: Optional[str] = None
    designation: Optional[List[CodeSystem_Concept_Designation]] = None

class CodeSystem(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    version_needed: Optional[bool] = None
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    purpose: Optional[str] = None
    content: str
    property: Optional[List[CodeSystem_Property]] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    title: Optional[str] = None
    filter: Optional[List[CodeSystem_Filter]] = None
    supplements: Optional[str] = None
    compositional: Optional[bool] = None
    status: str
    hierarchy_meaning: Optional[str] = None
    value_set: Optional[str] = None
    count: Optional[int] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    concept: Optional[List[CodeSystem_Concept]] = None
    case_sensitive: Optional[bool] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = None