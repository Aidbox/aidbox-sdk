from typing import Optional, List
from pydantic import *
from ..base.UsageContext import UsageContext
from ..base.ContactDetail import ContactDetail
from ..base.CodeableConcept import CodeableConcept
from ..base.Coding import Coding
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class TestScript_Variable(BackboneElement):
    hint: Optional[str] = None
    name: str
    path: Optional[str] = None
    source_id: Optional[str] = None
    expression: Optional[str] = None
    description: Optional[str] = None
    header_field: Optional[str] = None
    default_value: Optional[str] = None

class TestScript_Setup_Action_Assert(BackboneElement):
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

class TestScript_Setup_Action_Operation_RequestHeader(BackboneElement):
    field: str
    value: str

class TestScript_Setup_Action_Operation(BackboneElement):
    description: Optional[str] = None
    method: Optional[str] = None
    target_id: Optional[str] = None
    request_header: Optional[List[TestScript_Setup_Action_Operation_RequestHeader]] = None
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

class TestScript_Setup_Action(BackboneElement):
    assert_: Optional[TestScript_Setup_Action_Assert_] = None
    operation: Optional[TestScript_Setup_Action_Operation] = None

class TestScript_Setup(BackboneElement):
    action: list[TestScript_Setup_Action] = []

class TestScript_Origin(BackboneElement):
    index: int
    profile: Coding

class TestScript_Fixture(BackboneElement):
    resource: Optional[Reference] = None
    autocreate: bool
    autodelete: bool

class TestScript_Teardown_Action(BackboneElement):
    operation: Reference

class TestScript_Teardown(BackboneElement):
    action: list[TestScript_Teardown_Action] = []

class TestScript_Metadata_Link(BackboneElement):
    url: str
    description: Optional[str] = None

class TestScript_Metadata_Capability(BackboneElement):
    link: Optional[List[str]] = None
    origin: Optional[List[int]] = None
    required: bool
    validated: bool
    description: Optional[str] = None
    destination: Optional[int] = None
    capabilities: str

class TestScript_Metadata(BackboneElement):
    link: Optional[List[TestScript_Metadata_Link]] = None
    capability: list[TestScript_Metadata_Capability] = []

class TestScript_Destination(BackboneElement):
    index: int
    profile: Coding

class TestScript_Test_Action(BackboneElement):
    assert_: Optional[Reference] = None
    operation: Optional[Reference] = None

class TestScript_Test(BackboneElement):
    name: Optional[str] = None
    action: list[TestScript_Test_Action] = []
    description: Optional[str] = None

class TestScript(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    variable: Optional[List[TestScript_Variable]] = None
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    purpose: Optional[str] = None
    name: str
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    title: Optional[str] = None
    setup: Optional[TestScript_Setup] = None
    status: str
    url: str
    identifier: Optional[Identifier] = None
    origin: Optional[List[TestScript_Origin]] = None
    fixture: Optional[List[TestScript_Fixture]] = None
    version: Optional[str] = None
    teardown: Optional[TestScript_Teardown] = None
    contact: Optional[List[ContactDetail]] = None
    metadata: Optional[TestScript_Metadata] = None
    destination: Optional[List[TestScript_Destination]] = None
    test: Optional[List[TestScript_Test]] = None
    profile: Optional[List[Reference]] = None