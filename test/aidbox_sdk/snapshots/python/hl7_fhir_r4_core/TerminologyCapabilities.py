from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import DomainResource
from base import BackboneElement

@dataclass(kw_only=True)
class TerminologyCapabilitiesExpansionParameter(BackboneElement):
    name: str
    documentation: Optional[str] = None

@dataclass(kw_only=True)
class TerminologyCapabilitiesExpansion(BackboneElement):
    paging: Optional[bool] = None
    parameter: Optional[List[TerminologyCapabilitiesExpansionParameter]] = field(default_factory=list)
    incomplete: Optional[bool] = None
    text_filter: Optional[str] = None
    hierarchical: Optional[bool] = None

@dataclass(kw_only=True)
class TerminologyCapabilitiesValidateCode(BackboneElement):
    translations: bool

@dataclass(kw_only=True)
class TerminologyCapabilitiesTranslation(BackboneElement):
    needs_map: bool

@dataclass(kw_only=True)
class TerminologyCapabilitiesCodeSystemVersionFilter(BackboneElement):
    op: list[str] = field(default_factory=list)
    code: str

@dataclass(kw_only=True)
class TerminologyCapabilitiesCodeSystemVersion(BackboneElement):
    code: Optional[str] = None
    filter: Optional[List[TerminologyCapabilitiesCodeSystemVersionFilter]] = field(default_factory=list)
    language: Optional[List[str]] = field(default_factory=list)
    property: Optional[List[str]] = field(default_factory=list)
    is_default: Optional[bool] = None
    compositional: Optional[bool] = None

@dataclass(kw_only=True)
class TerminologyCapabilitiesCodeSystem(BackboneElement):
    uri: Optional[str] = None
    version: Optional[List[TerminologyCapabilitiesCodeSystemVersion]] = field(default_factory=list)
    subsumption: Optional[bool] = None

@dataclass(kw_only=True)
class TerminologyCapabilitiesSoftware(BackboneElement):
    name: str
    version: Optional[str] = None

@dataclass(kw_only=True)
class TerminologyCapabilitiesImplementation(BackboneElement):
    url: Optional[str] = None
    description: str

@dataclass(kw_only=True)
class TerminologyCapabilitiesClosure(BackboneElement):
    translation: Optional[bool] = None

@dataclass(kw_only=True)
class TerminologyCapabilities(DomainResource):
    description: Optional[str] = None
    date: str
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    purpose: Optional[str] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    expansion: Optional[TerminologyCapabilitiesExpansion] = None
    title: Optional[str] = None
    status: str
    validate_code: Optional[TerminologyCapabilitiesValidateCode] = None
    kind: str
    translation: Optional[TerminologyCapabilitiesTranslation] = None
    url: Optional[str] = None
    code_system: Optional[List[TerminologyCapabilitiesCodeSystem]] = field(default_factory=list)
    software: Optional[TerminologyCapabilitiesSoftware] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    implementation: Optional[TerminologyCapabilitiesImplementation] = None
    code_search: Optional[str] = None
    locked_date: Optional[bool] = None
    closure: Optional[TerminologyCapabilitiesClosure] = None