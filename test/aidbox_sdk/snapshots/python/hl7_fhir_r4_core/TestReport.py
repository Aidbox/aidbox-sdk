from typing import Optional, List
from dataclasses import dataclass, field
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class TestReportParticipant(BackboneElement):
    uri: str
    type: str
    display: Optional[str] = None

@dataclass(kw_only=True)
class TestReportSetupActionAssert(BackboneElement):
    detail: Optional[str] = None
    result: str
    message: Optional[str] = None

@dataclass(kw_only=True)
class TestReportSetupActionOperation(BackboneElement):
    detail: Optional[str] = None
    result: str
    message: Optional[str] = None

@dataclass(kw_only=True)
class TestReportSetupAction(BackboneElement):
    assert_: Optional[TestReportSetupActionAssert] = None
    operation: Optional[TestReportSetupActionOperation] = None

@dataclass(kw_only=True)
class TestReportSetup(BackboneElement):
    action: list[TestReportSetupAction] = field(default_factory=list)

@dataclass(kw_only=True)
class TestReportTeardownAction(BackboneElement):
    operation: Reference

@dataclass(kw_only=True)
class TestReportTeardown(BackboneElement):
    action: list[TestReportTeardownAction] = field(default_factory=list)

@dataclass(kw_only=True)
class TestReportTestAction(BackboneElement):
    assert_: Optional[Reference] = None
    operation: Optional[Reference] = None

@dataclass(kw_only=True)
class TestReportTest(BackboneElement):
    name: Optional[str] = None
    action: list[TestReportTestAction] = field(default_factory=list)
    description: Optional[str] = None

@dataclass(kw_only=True)
class TestReport(DomainResource):
    tester: Optional[str] = None
    name: Optional[str] = None
    test_script: Reference
    participant: Optional[List[TestReportParticipant]] = field(default_factory=list)
    setup: Optional[TestReportSetup] = None
    status: str
    result: str
    score: Optional[float] = None
    identifier: Optional[Identifier] = None
    issued: Optional[str] = None
    teardown: Optional[TestReportTeardown] = None
    test: Optional[List[TestReportTest]] = field(default_factory=list)