from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import BackboneElement

@dataclass(kw_only=True)
class ImplementationGuideDefinitionPage(BackboneElement):
    page: Optional[List[Reference]] = field(default_factory=list)
    title: str
    name_url: Optional[str] = None
    generation: str
    name_reference: Optional[Reference] = None

@dataclass(kw_only=True)
class ImplementationGuideDefinitionGrouping(BackboneElement):
    name: str
    description: Optional[str] = None

@dataclass(kw_only=True)
class ImplementationGuideDefinitionResource(BackboneElement):
    name: Optional[str] = None
    reference: Reference
    grouping_id: Optional[str] = None
    description: Optional[str] = None
    fhir_version: Optional[List[str]] = field(default_factory=list)
    example_boolean: Optional[bool] = None
    example_canonical: Optional[str] = None

@dataclass(kw_only=True)
class ImplementationGuideDefinitionTemplate(BackboneElement):
    code: str
    scope: Optional[str] = None
    source: str

@dataclass(kw_only=True)
class ImplementationGuideDefinitionParameter(BackboneElement):
    code: str
    value: str

@dataclass(kw_only=True)
class ImplementationGuideDefinition(BackboneElement):
    page: Optional[ImplementationGuideDefinitionPage] = None
    grouping: Optional[List[ImplementationGuideDefinitionGrouping]] = field(default_factory=list)
    resource: list[ImplementationGuideDefinitionResource] = field(default_factory=list)
    template: Optional[List[ImplementationGuideDefinitionTemplate]] = field(default_factory=list)
    parameter: Optional[List[ImplementationGuideDefinitionParameter]] = field(default_factory=list)

@dataclass(kw_only=True)
class ImplementationGuideGlobal(BackboneElement):
    type: str
    profile: str

@dataclass(kw_only=True)
class ImplementationGuideDependsOn(BackboneElement):
    uri: str
    version: Optional[str] = None
    package_id: Optional[str] = None

@dataclass(kw_only=True)
class ImplementationGuideManifestPage(BackboneElement):
    name: str
    title: Optional[str] = None
    anchor: Optional[List[str]] = field(default_factory=list)

@dataclass(kw_only=True)
class ImplementationGuideManifestResource(BackboneElement):
    reference: Reference
    relative_path: Optional[str] = None
    example_boolean: Optional[bool] = None
    example_canonical: Optional[str] = None

@dataclass(kw_only=True)
class ImplementationGuideManifest(BackboneElement):
    page: Optional[List[ImplementationGuideManifestPage]] = field(default_factory=list)
    image: Optional[List[str]] = field(default_factory=list)
    other: Optional[List[str]] = field(default_factory=list)
    resource: list[ImplementationGuideManifestResource] = field(default_factory=list)
    rendering: Optional[str] = None

@dataclass(kw_only=True)
class ImplementationGuide(DomainResource):
    description: Optional[str] = None
    definition: Optional[ImplementationGuideDefinition] = None
    date: Optional[str] = None
    publisher: Optional[str] = None
    fhir_version: list[str] = field(default_factory=list)
    license: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    global_: Optional[List[ImplementationGuideGlobal]] = field(default_factory=list)
    depends_on: Optional[List[ImplementationGuideDependsOn]] = field(default_factory=list)
    name: str
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    manifest: Optional[ImplementationGuideManifest] = None
    title: Optional[str] = None
    status: str
    url: str
    version: Optional[str] = None
    package_id: str
    contact: Optional[List[ContactDetail]] = field(default_factory=list)