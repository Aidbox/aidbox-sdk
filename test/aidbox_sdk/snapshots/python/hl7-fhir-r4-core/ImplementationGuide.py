from typing import Optional, List
from pydantic import *
from base.UsageContext import UsageContext
from base.ContactDetail import ContactDetail
from base.CodeableConcept import CodeableConcept
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.BackboneElement import BackboneElement

class ImplementationGuide_Definition_Page(BackboneElement):
    page: Optional[List[Reference]] = None
    title: str
    name_url: Optional[str] = None
    generation: str
    name_reference: Optional[Reference] = None

class ImplementationGuide_Definition_Grouping(BackboneElement):
    name: str
    description: Optional[str] = None

class ImplementationGuide_Definition_Resource(BackboneElement):
    name: Optional[str] = None
    reference: Reference
    grouping_id: Optional[str] = None
    description: Optional[str] = None
    fhir_version: Optional[List[str]] = None
    example_boolean: Optional[bool] = None
    example_canonical: Optional[str] = None

class ImplementationGuide_Definition_Template(BackboneElement):
    code: str
    scope: Optional[str] = None
    source: str

class ImplementationGuide_Definition_Parameter(BackboneElement):
    code: str
    value: str

class ImplementationGuide_Definition(BackboneElement):
    page: Optional[ImplementationGuide_Definition_Page] = None
    grouping: Optional[List[ImplementationGuide_Definition_Grouping]] = None
    resource: list[ImplementationGuide_Definition_Resource] = []
    template: Optional[List[ImplementationGuide_Definition_Template]] = None
    parameter: Optional[List[ImplementationGuide_Definition_Parameter]] = None

class ImplementationGuide_Global(BackboneElement):
    type: str
    profile: str

class ImplementationGuide_DependsOn(BackboneElement):
    uri: str
    version: Optional[str] = None
    package_id: Optional[str] = None

class ImplementationGuide_Manifest_Page(BackboneElement):
    name: str
    title: Optional[str] = None
    anchor: Optional[List[str]] = None

class ImplementationGuide_Manifest_Resource(BackboneElement):
    reference: Reference
    relative_path: Optional[str] = None
    example_boolean: Optional[bool] = None
    example_canonical: Optional[str] = None

class ImplementationGuide_Manifest(BackboneElement):
    page: Optional[List[ImplementationGuide_Manifest_Page]] = None
    image: Optional[List[str]] = None
    other: Optional[List[str]] = None
    resource: list[ImplementationGuide_Manifest_Resource] = []
    rendering: Optional[str] = None

class ImplementationGuide(DomainResource):
    description: Optional[str] = None
    definition: Optional[ImplementationGuide_Definition] = None
    date: Optional[str] = None
    publisher: Optional[str] = None
    fhir_version: list[str] = []
    license: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    global: Optional[List[ImplementationGuide_Global_]] = None
    depends_on: Optional[List[ImplementationGuide_DependsOn]] = None
    name: str
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    manifest: Optional[ImplementationGuide_Manifest] = None
    title: Optional[str] = None
    status: str
    url: str
    version: Optional[str] = None
    package_id: str
    contact: Optional[List[ContactDetail]] = None