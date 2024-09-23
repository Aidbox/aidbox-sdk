from typing import Optional, List
from pydantic import *
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement
from ..base.Narrative import Narrative

class Composition_Section(BackboneElement):
    ordered_by: Optional[CodeableConcept] = None
    section: Optional[List[Reference]] = None
    mode: Optional[str] = None
    title: Optional[str] = None
    empty_reason: Optional[CodeableConcept] = None
    author: Optional[List[Reference]] = None
    code: Optional[CodeableConcept] = None
    focus: Optional[Reference] = None
    entry: Optional[List[Reference]] = None
    text: Optional[Narrative] = None

class Composition_Attester(BackboneElement):
    mode: str
    time: Optional[str] = None
    party: Optional[Reference] = None

class Composition_Event(BackboneElement):
    code: Optional[List[CodeableConcept]] = None
    detail: Optional[List[Reference]] = None
    period: Optional[Period] = None

class Composition_RelatesTo(BackboneElement):
    code: str
    target_reference: Optional[Reference] = None
    target_identifier: Optional[Identifier] = None

class Composition(DomainResource):
    category: Optional[List[CodeableConcept]] = None
    date: str
    encounter: Optional[Reference] = None
    section: Optional[List[Composition_Section]] = None
    attester: Optional[List[Composition_Attester]] = None
    type: CodeableConcept
    title: str
    author: list[Reference] = []
    event: Optional[List[Composition_Event]] = None
    custodian: Optional[Reference] = None
    status: str
    identifier: Optional[Identifier] = None
    relates_to: Optional[List[Composition_RelatesTo]] = None
    subject: Optional[Reference] = None
    confidentiality: Optional[str] = None