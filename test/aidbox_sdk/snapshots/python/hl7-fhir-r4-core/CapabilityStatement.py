from typing import Optional, List
from pydantic import *
from base.UsageContext import UsageContext
from base.ContactDetail import ContactDetail
from base.CodeableConcept import CodeableConcept
from base.Coding import Coding
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.BackboneElement import BackboneElement

class CapabilityStatement_Document(BackboneElement):
    mode: str
    profile: str
    documentation: Optional[str] = None

class CapabilityStatement_Messaging_Endpoint(BackboneElement):
    address: str
    protocol: Coding

class CapabilityStatement_Messaging_SupportedMessage(BackboneElement):
    mode: str
    definition: str

class CapabilityStatement_Messaging(BackboneElement):
    endpoint: Optional[List[CapabilityStatement_Messaging_Endpoint]] = None
    documentation: Optional[str] = None
    reliable_cache: Optional[int] = None
    supported_message: Optional[List[CapabilityStatement_Messaging_SupportedMessage]] = None

class CapabilityStatement_Software(BackboneElement):
    name: str
    version: Optional[str] = None
    release_date: Optional[str] = None

class CapabilityStatement_Implementation(BackboneElement):
    url: Optional[str] = None
    custodian: Optional[Reference] = None
    description: str

class CapabilityStatement_Rest_Resource_SearchParam(BackboneElement):
    name: str
    type: str
    definition: Optional[str] = None
    documentation: Optional[str] = None

class CapabilityStatement_Rest_Resource_Operation(BackboneElement):
    name: str
    definition: str
    documentation: Optional[str] = None

class CapabilityStatement_Rest_Resource_Interaction(BackboneElement):
    code: str
    documentation: Optional[str] = None

class CapabilityStatement_Rest_Resource(BackboneElement):
    search_rev_include: Optional[List[str]] = None
    search_param: Optional[List[CapabilityStatement_Rest_Resource_SearchParam]] = None
    conditional_update: Optional[bool] = None
    conditional_read: Optional[str] = None
    operation: Optional[List[CapabilityStatement_Rest_Resource_Operation]] = None
    reference_policy: Optional[List[str]] = None
    read_history: Optional[bool] = None
    type: str
    interaction: Optional[List[CapabilityStatement_Rest_Resource_Interaction]] = None
    documentation: Optional[str] = None
    update_create: Optional[bool] = None
    conditional_create: Optional[bool] = None
    supported_profile: Optional[List[str]] = None
    search_include: Optional[List[str]] = None
    versioning: Optional[str] = None
    profile: Optional[str] = None
    conditional_delete: Optional[str] = None

class CapabilityStatement_Rest_Security(BackboneElement):
    cors: Optional[bool] = None
    service: Optional[List[CodeableConcept]] = None
    description: Optional[str] = None

class CapabilityStatement_Rest_Interaction(BackboneElement):
    code: str
    documentation: Optional[str] = None

class CapabilityStatement_Rest(BackboneElement):
    mode: str
    resource: Optional[List[CapabilityStatement_Rest_Resource]] = None
    security: Optional[CapabilityStatement_Rest_Security] = None
    operation: Optional[List[Reference]] = None
    compartment: Optional[List[str]] = None
    interaction: Optional[List[CapabilityStatement_Rest_Interaction]] = None
    search_param: Optional[List[Reference]] = None
    documentation: Optional[str] = None

class CapabilityStatement(DomainResource):
    description: Optional[str] = None
    format: list[str] = []
    date: str
    publisher: Optional[str] = None
    patch_format: Optional[List[str]] = None
    fhir_version: str
    jurisdiction: Optional[List[CodeableConcept]] = None
    instantiates: Optional[List[str]] = None
    purpose: Optional[str] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    imports: Optional[List[str]] = None
    title: Optional[str] = None
    document: Optional[List[CapabilityStatement_Document]] = None
    status: str
    messaging: Optional[List[CapabilityStatement_Messaging]] = None
    kind: str
    implementation_guide: Optional[List[str]] = None
    url: Optional[str] = None
    software: Optional[CapabilityStatement_Software] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = None
    implementation: Optional[CapabilityStatement_Implementation] = None
    rest: Optional[List[CapabilityStatement_Rest]] = None