from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ExampleScenarioInstanceVersion(BackboneElement):
    version_id: str
    description: str

@dataclass(kw_only=True)
class ExampleScenarioInstanceContainedInstance(BackboneElement):
    version_id: Optional[str] = None
    resource_id: str

@dataclass(kw_only=True)
class ExampleScenarioInstance(BackboneElement):
    name: Optional[str] = None
    version: Optional[List[ExampleScenarioInstanceVersion]] = field(default_factory=list)
    resource_id: str
    description: Optional[str] = None
    resource_type: str
    contained_instance: Optional[List[ExampleScenarioInstanceContainedInstance]] = field(default_factory=list)

@dataclass(kw_only=True)
class ExampleScenarioProcessStepOperation(BackboneElement):
    response: Optional[Reference] = None
    description: Optional[str] = None
    request: Optional[Reference] = None
    number: str
    name: Optional[str] = None
    initiator: Optional[str] = None
    type: Optional[str] = None
    receiver_active: Optional[bool] = None
    initiator_active: Optional[bool] = None
    receiver: Optional[str] = None

@dataclass(kw_only=True)
class ExampleScenarioProcessStepAlternative(BackboneElement):
    step: Optional[List[Reference]] = field(default_factory=list)
    title: str
    description: Optional[str] = None

@dataclass(kw_only=True)
class ExampleScenarioProcessStep(BackboneElement):
    pause: Optional[bool] = None
    process: Optional[List[Reference]] = field(default_factory=list)
    operation: Optional[ExampleScenarioProcessStepOperation] = None
    alternative: Optional[List[ExampleScenarioProcessStepAlternative]] = field(default_factory=list)

@dataclass(kw_only=True)
class ExampleScenarioProcess(BackboneElement):
    step: Optional[List[ExampleScenarioProcessStep]] = field(default_factory=list)
    title: str
    description: Optional[str] = None
    pre_conditions: Optional[str] = None
    post_conditions: Optional[str] = None

@dataclass(kw_only=True)
class ExampleScenarioActor(BackboneElement):
    name: Optional[str] = None
    type: str
    actor_id: str
    description: Optional[str] = None

@dataclass(kw_only=True)
class ExampleScenario(DomainResource):
    date: Optional[str] = None
    publisher: Optional[str] = None
    instance: Optional[List[ExampleScenarioInstance]] = field(default_factory=list)
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    purpose: Optional[str] = None
    name: Optional[str] = None
    process: Optional[List[ExampleScenarioProcess]] = field(default_factory=list)
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    workflow: Optional[List[str]] = field(default_factory=list)
    status: str
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    actor: Optional[List[ExampleScenarioActor]] = field(default_factory=list)