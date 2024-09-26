from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement
from base import Narrative

@dataclass(kw_only=True)
class CompositionSection(BackboneElement):
    ordered_by: Optional[CodeableConcept] = None
    section: Optional[List[Reference]] = field(default_factory=list)
    mode: Optional[str] = None
    title: Optional[str] = None
    empty_reason: Optional[CodeableConcept] = None
    author: Optional[List[Reference]] = field(default_factory=list)
    code: Optional[CodeableConcept] = None
    focus: Optional[Reference] = None
    entry: Optional[List[Reference]] = field(default_factory=list)
    text: Optional[Narrative] = None

@dataclass(kw_only=True)
class CompositionAttester(BackboneElement):
    mode: str
    time: Optional[str] = None
    party: Optional[Reference] = None

@dataclass(kw_only=True)
class CompositionEvent(BackboneElement):
    code: Optional[List[CodeableConcept]] = field(default_factory=list)
    detail: Optional[List[Reference]] = field(default_factory=list)
    period: Optional[Period] = None

@dataclass(kw_only=True)
class CompositionRelatesTo(BackboneElement):
    code: str
    target_reference: Optional[Reference] = None
    target_identifier: Optional[Identifier] = None

@dataclass(kw_only=True)
class Composition(DomainResource):
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    date: str
    encounter: Optional[Reference] = None
    section: Optional[List[CompositionSection]] = field(default_factory=list)
    attester: Optional[List[CompositionAttester]] = field(default_factory=list)
    type: CodeableConcept
    title: str
    author: list[Reference] = field(default_factory=list)
    event: Optional[List[CompositionEvent]] = field(default_factory=list)
    custodian: Optional[Reference] = None
    status: str
    identifier: Optional[Identifier] = None
    relates_to: Optional[List[CompositionRelatesTo]] = field(default_factory=list)
    subject: Optional[Reference] = None
    confidentiality: Optional[str] = None