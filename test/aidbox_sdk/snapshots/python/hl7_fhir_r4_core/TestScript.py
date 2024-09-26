from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import Coding
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class TestScriptVariable(BackboneElement):
    hint: Optional[str] = None
    name: str
    path: Optional[str] = None
    source_id: Optional[str] = None
    expression: Optional[str] = None
    description: Optional[str] = None
    header_field: Optional[str] = None
    default_value: Optional[str] = None

@dataclass(kw_only=True)
class TestScriptSetupActionAssert(BackboneElement):
    response: Optional[str] = None
    description: Optional[str] = None
    path: Optional[str] = None
    header_field: Optional[str] = None
    compare_to_source_id: Optional[str] = None
    expression: Optional[str] = None
    value: Optional[str] = None
    warning_only: bool
    compare_to_source_expression: Optional[str] = None
    label: Optional[str] = None
    resource: Optional[str] = None
    response_code: Optional[str] = None
    minimum_id: Optional[str] = None
    operator: Optional[str] = None
    content_type: Optional[str] = None
    compare_to_source_path: Optional[str] = None
    validate_profile_id: Optional[str] = None
    source_id: Optional[str] = None
    request_method: Optional[str] = None
    request_u_r_l: Optional[str] = None
    direction: Optional[str] = None
    navigation_links: Optional[bool] = None

@dataclass(kw_only=True)
class TestScriptSetupActionOperationRequestHeader(BackboneElement):
    field: str
    value: str

@dataclass(kw_only=True)
class TestScriptSetupActionOperation(BackboneElement):
    description: Optional[str] = None
    method: Optional[str] = None
    target_id: Optional[str] = None
    request_header: Optional[List[TestScriptSetupActionOperationRequestHeader]] = field(default_factory=list)
    params: Optional[str] = None
    type: Optional[Coding] = None
    request_id: Optional[str] = None
    encode_request_url: bool
    label: Optional[str] = None
    resource: Optional[str] = None
    url: Optional[str] = None
    origin: Optional[int] = None
    content_type: Optional[str] = None
    source_id: Optional[str] = None
    response_id: Optional[str] = None
    destination: Optional[int] = None
    accept: Optional[str] = None

@dataclass(kw_only=True)
class TestScriptSetupAction(BackboneElement):
    assert_: Optional[TestScriptSetupActionAssert] = None
    operation: Optional[TestScriptSetupActionOperation] = None

@dataclass(kw_only=True)
class TestScriptSetup(BackboneElement):
    action: list[TestScriptSetupAction] = field(default_factory=list)

@dataclass(kw_only=True)
class TestScriptOrigin(BackboneElement):
    index: int
    profile: Coding

@dataclass(kw_only=True)
class TestScriptFixture(BackboneElement):
    resource: Optional[Reference] = None
    autocreate: bool
    autodelete: bool

@dataclass(kw_only=True)
class TestScriptTeardownAction(BackboneElement):
    operation: Reference

@dataclass(kw_only=True)
class TestScriptTeardown(BackboneElement):
    action: list[TestScriptTeardownAction] = field(default_factory=list)

@dataclass(kw_only=True)
class TestScriptMetadataLink(BackboneElement):
    url: str
    description: Optional[str] = None

@dataclass(kw_only=True)
class TestScriptMetadataCapability(BackboneElement):
    link: Optional[List[str]] = field(default_factory=list)
    origin: Optional[List[int]] = field(default_factory=list)
    required: bool
    validated: bool
    description: Optional[str] = None
    destination: Optional[int] = None
    capabilities: str

@dataclass(kw_only=True)
class TestScriptMetadata(BackboneElement):
    link: Optional[List[TestScriptMetadataLink]] = field(default_factory=list)
    capability: list[TestScriptMetadataCapability] = field(default_factory=list)

@dataclass(kw_only=True)
class TestScriptDestination(BackboneElement):
    index: int
    profile: Coding

@dataclass(kw_only=True)
class TestScriptTestAction(BackboneElement):
    assert_: Optional[Reference] = None
    operation: Optional[Reference] = None

@dataclass(kw_only=True)
class TestScriptTest(BackboneElement):
    name: Optional[str] = None
    action: list[TestScriptTestAction] = field(default_factory=list)
    description: Optional[str] = None

@dataclass(kw_only=True)
class TestScript(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    variable: Optional[List[TestScriptVariable]] = field(default_factory=list)
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    purpose: Optional[str] = None
    name: str
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    title: Optional[str] = None
    setup: Optional[TestScriptSetup] = None
    status: str
    url: str
    identifier: Optional[Identifier] = None
    origin: Optional[List[TestScriptOrigin]] = field(default_factory=list)
    fixture: Optional[List[TestScriptFixture]] = field(default_factory=list)
    version: Optional[str] = None
    teardown: Optional[TestScriptTeardown] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    metadata: Optional[TestScriptMetadata] = None
    destination: Optional[List[TestScriptDestination]] = field(default_factory=list)
    test: Optional[List[TestScriptTest]] = field(default_factory=list)
    profile: Optional[List[Reference]] = field(default_factory=list)