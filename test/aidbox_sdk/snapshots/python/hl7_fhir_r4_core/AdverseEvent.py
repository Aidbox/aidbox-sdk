from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class AdverseEventSuspectEntityCausality(BackboneElement):
    author: Optional[Reference] = None
    method: Optional[CodeableConcept] = None
    assessment: Optional[CodeableConcept] = None
    product_relatedness: Optional[str] = None

@dataclass(kw_only=True)
class AdverseEventSuspectEntity(BackboneElement):
    instance: Reference
    causality: Optional[List[AdverseEventSuspectEntityCausality]] = field(default_factory=list)

@dataclass(kw_only=True)
class AdverseEvent(DomainResource):
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    actuality: str
    date: Optional[str] = None
    study: Optional[List[Reference]] = field(default_factory=list)
    encounter: Optional[Reference] = None
    suspect_entity: Optional[List[AdverseEventSuspectEntity]] = field(default_factory=list)
    reference_document: Optional[List[Reference]] = field(default_factory=list)
    outcome: Optional[CodeableConcept] = None
    recorded_date: Optional[str] = None
    event: Optional[CodeableConcept] = None
    contributor: Optional[List[Reference]] = field(default_factory=list)
    subject_medical_history: Optional[List[Reference]] = field(default_factory=list)
    recorder: Optional[Reference] = None
    seriousness: Optional[CodeableConcept] = None
    severity: Optional[CodeableConcept] = None
    identifier: Optional[Identifier] = None
    detected: Optional[str] = None
    location: Optional[Reference] = None
    subject: Reference
    resulting_condition: Optional[List[Reference]] = field(default_factory=list)