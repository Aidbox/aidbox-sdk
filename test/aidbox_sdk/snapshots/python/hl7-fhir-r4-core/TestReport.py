from typing import Optional, List
from pydantic import *
from ..base import *

class TestReport_Participant(BackboneElement):
    uri: str
    type: str
    display: Optional[str] = None

class TestReport_Setup_Action_Assert(BackboneElement):
    detail: Optional[str] = None
    result: str
    message: Optional[str] = None

class TestReport_Setup_Action_Operation(BackboneElement):
    detail: Optional[str] = None
    result: str
    message: Optional[str] = None

class TestReport_Setup_Action(BackboneElement):
    assert: Optional[TestReport_Setup_Action_Assert_] = None
    operation: Optional[TestReport_Setup_Action_Operation] = None

class TestReport_Setup(BackboneElement):
    action: list[TestReport_Setup_Action] = []

class TestReport_Teardown_Action(BackboneElement):
    operation: Reference

class TestReport_Teardown(BackboneElement):
    action: list[TestReport_Teardown_Action] = []

class TestReport_Test_Action(BackboneElement):
    assert: Optional[Reference] = None
    operation: Optional[Reference] = None

class TestReport_Test(BackboneElement):
    name: Optional[str] = None
    action: list[TestReport_Test_Action] = []
    description: Optional[str] = None

class TestReport(DomainResource):
    tester: Optional[str] = None
    name: Optional[str] = None
    test_script: Reference
    participant: Optional[List[TestReport_Participant]] = None
    setup: Optional[TestReport_Setup] = None
    status: str
    result: str
    score: Optional[float] = None
    identifier: Optional[Identifier] = None
    issued: Optional[str] = None
    teardown: Optional[TestReport_Teardown] = None
    test: Optional[List[TestReport_Test]] = None