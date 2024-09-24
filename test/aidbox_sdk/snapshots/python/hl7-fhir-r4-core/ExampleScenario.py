from typing import Optional, List
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

class ExampleScenario_Instance_Version(BackboneElement):
    version_id: str
    description: str

class ExampleScenario_Instance_ContainedInstance(BackboneElement):
    version_id: Optional[str] = None
    resource_id: str

class ExampleScenario_Instance(BackboneElement):
    name: Optional[str] = None
    version: Optional[List[ExampleScenario_Instance_Version]] = None
    resource_id: str
    description: Optional[str] = None
    resource_type: str
    contained_instance: Optional[List[ExampleScenario_Instance_ContainedInstance]] = None

class ExampleScenario_Process_Step_Operation(BackboneElement):
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

class ExampleScenario_Process_Step_Alternative(BackboneElement):
    step: Optional[List[Reference]] = None
    title: str
    description: Optional[str] = None

class ExampleScenario_Process_Step(BackboneElement):
    pause: Optional[bool] = None
    process: Optional[List[Reference]] = None
    operation: Optional[ExampleScenario_Process_Step_Operation] = None
    alternative: Optional[List[ExampleScenario_Process_Step_Alternative]] = None

class ExampleScenario_Process(BackboneElement):
    step: Optional[List[ExampleScenario_Process_Step]] = None
    title: str
    description: Optional[str] = None
    pre_conditions: Optional[str] = None
    post_conditions: Optional[str] = None

class ExampleScenario_Actor(BackboneElement):
    name: Optional[str] = None
    type: str
    actor_id: str
    description: Optional[str] = None

class ExampleScenario(DomainResource):
    date: Optional[str] = None
    publisher: Optional[str] = None
    instance: Optional[List[ExampleScenario_Instance]] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    purpose: Optional[str] = None
    name: Optional[str] = None
    process: Optional[List[ExampleScenario_Process]] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    workflow: Optional[List[str]] = None
    status: str
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = None
    actor: Optional[List[ExampleScenario_Actor]] = None