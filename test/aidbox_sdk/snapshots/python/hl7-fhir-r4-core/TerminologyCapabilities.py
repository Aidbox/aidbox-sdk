from typing import Optional, List
from pydantic import *
from ..base.UsageContext import UsageContext
from ..base.ContactDetail import ContactDetail
from ..base.CodeableConcept import CodeableConcept
from ..base.DomainResource import DomainResource
from ..base.BackboneElement import BackboneElement

class TerminologyCapabilities_Expansion_Parameter(BackboneElement):
    name: str
    documentation: Optional[str] = None

class TerminologyCapabilities_Expansion(BackboneElement):
    paging: Optional[bool] = None
    parameter: Optional[List[TerminologyCapabilities_Expansion_Parameter]] = None
    incomplete: Optional[bool] = None
    text_filter: Optional[str] = None
    hierarchical: Optional[bool] = None

class TerminologyCapabilities_ValidateCode(BackboneElement):
    translations: bool

class TerminologyCapabilities_Translation(BackboneElement):
    needs_map: bool

class TerminologyCapabilities_CodeSystem_Version_Filter(BackboneElement):
    op: list[str] = []
    code: str

class TerminologyCapabilities_CodeSystem_Version(BackboneElement):
    code: Optional[str] = None
    filter: Optional[List[TerminologyCapabilities_CodeSystem_Version_Filter]] = None
    language: Optional[List[str]] = None
    property: Optional[List[str]] = None
    is_default: Optional[bool] = None
    compositional: Optional[bool] = None

class TerminologyCapabilities_CodeSystem(BackboneElement):
    uri: Optional[str] = None
    version: Optional[List[TerminologyCapabilities_CodeSystem_Version]] = None
    subsumption: Optional[bool] = None

class TerminologyCapabilities_Software(BackboneElement):
    name: str
    version: Optional[str] = None

class TerminologyCapabilities_Implementation(BackboneElement):
    url: Optional[str] = None
    description: str

class TerminologyCapabilities_Closure(BackboneElement):
    translation: Optional[bool] = None

class TerminologyCapabilities(DomainResource):
    description: Optional[str] = None
    date: str
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    purpose: Optional[str] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    expansion: Optional[TerminologyCapabilities_Expansion] = None
    title: Optional[str] = None
    status: str
    validate_code: Optional[TerminologyCapabilities_ValidateCode] = None
    kind: str
    translation: Optional[TerminologyCapabilities_Translation] = None
    url: Optional[str] = None
    code_system: Optional[List[TerminologyCapabilities_CodeSystem]] = None
    software: Optional[TerminologyCapabilities_Software] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = None
    implementation: Optional[TerminologyCapabilities_Implementation] = None
    code_search: Optional[str] = None
    locked_date: Optional[bool] = None
    closure: Optional[TerminologyCapabilities_Closure] = None