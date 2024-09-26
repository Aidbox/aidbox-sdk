from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import Coding
from base import DomainResource
from base import Reference
from base import BackboneElement

@dataclass(kw_only=True)
class CapabilityStatementDocument(BackboneElement):
    mode: str
    profile: str
    documentation: Optional[str] = None

@dataclass(kw_only=True)
class CapabilityStatementMessagingEndpoint(BackboneElement):
    address: str
    protocol: Coding

@dataclass(kw_only=True)
class CapabilityStatementMessagingSupportedMessage(BackboneElement):
    mode: str
    definition: str

@dataclass(kw_only=True)
class CapabilityStatementMessaging(BackboneElement):
    endpoint: Optional[List[CapabilityStatementMessagingEndpoint]] = field(default_factory=list)
    documentation: Optional[str] = None
    reliable_cache: Optional[int] = None
    supported_message: Optional[List[CapabilityStatementMessagingSupportedMessage]] = field(default_factory=list)

@dataclass(kw_only=True)
class CapabilityStatementSoftware(BackboneElement):
    name: str
    version: Optional[str] = None
    release_date: Optional[str] = None

@dataclass(kw_only=True)
class CapabilityStatementImplementation(BackboneElement):
    url: Optional[str] = None
    custodian: Optional[Reference] = None
    description: str

@dataclass(kw_only=True)
class CapabilityStatementRestResourceSearchParam(BackboneElement):
    name: str
    type: str
    definition: Optional[str] = None
    documentation: Optional[str] = None

@dataclass(kw_only=True)
class CapabilityStatementRestResourceOperation(BackboneElement):
    name: str
    definition: str
    documentation: Optional[str] = None

@dataclass(kw_only=True)
class CapabilityStatementRestResourceInteraction(BackboneElement):
    code: str
    documentation: Optional[str] = None

@dataclass(kw_only=True)
class CapabilityStatementRestResource(BackboneElement):
    search_rev_include: Optional[List[str]] = field(default_factory=list)
    search_param: Optional[List[CapabilityStatementRestResourceSearchParam]] = field(default_factory=list)
    conditional_update: Optional[bool] = None
    conditional_read: Optional[str] = None
    operation: Optional[List[CapabilityStatementRestResourceOperation]] = field(default_factory=list)
    reference_policy: Optional[List[str]] = field(default_factory=list)
    read_history: Optional[bool] = None
    type: str
    interaction: Optional[List[CapabilityStatementRestResourceInteraction]] = field(default_factory=list)
    documentation: Optional[str] = None
    update_create: Optional[bool] = None
    conditional_create: Optional[bool] = None
    supported_profile: Optional[List[str]] = field(default_factory=list)
    search_include: Optional[List[str]] = field(default_factory=list)
    versioning: Optional[str] = None
    profile: Optional[str] = None
    conditional_delete: Optional[str] = None

@dataclass(kw_only=True)
class CapabilityStatementRestSecurity(BackboneElement):
    cors: Optional[bool] = None
    service: Optional[List[CodeableConcept]] = field(default_factory=list)
    description: Optional[str] = None

@dataclass(kw_only=True)
class CapabilityStatementRestInteraction(BackboneElement):
    code: str
    documentation: Optional[str] = None

@dataclass(kw_only=True)
class CapabilityStatementRest(BackboneElement):
    mode: str
    resource: Optional[List[CapabilityStatementRestResource]] = field(default_factory=list)
    security: Optional[CapabilityStatementRestSecurity] = None
    operation: Optional[List[Reference]] = field(default_factory=list)
    compartment: Optional[List[str]] = field(default_factory=list)
    interaction: Optional[List[CapabilityStatementRestInteraction]] = field(default_factory=list)
    search_param: Optional[List[Reference]] = field(default_factory=list)
    documentation: Optional[str] = None

@dataclass(kw_only=True)
class CapabilityStatement(DomainResource):
    description: Optional[str] = None
    format: list[str] = field(default_factory=list)
    date: str
    publisher: Optional[str] = None
    patch_format: Optional[List[str]] = field(default_factory=list)
    fhir_version: str
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    instantiates: Optional[List[str]] = field(default_factory=list)
    purpose: Optional[str] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    imports: Optional[List[str]] = field(default_factory=list)
    title: Optional[str] = None
    document: Optional[List[CapabilityStatementDocument]] = field(default_factory=list)
    status: str
    messaging: Optional[List[CapabilityStatementMessaging]] = field(default_factory=list)
    kind: str
    implementation_guide: Optional[List[str]] = field(default_factory=list)
    url: Optional[str] = None
    software: Optional[CapabilityStatementSoftware] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    implementation: Optional[CapabilityStatementImplementation] = None
    rest: Optional[List[CapabilityStatementRest]] = field(default_factory=list)