from typing import Optional, List
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

class AdverseEvent_SuspectEntity_Causality(BackboneElement):
    author: Optional[Reference] = None
    method: Optional[CodeableConcept] = None
    assessment: Optional[CodeableConcept] = None
    product_relatedness: Optional[str] = None

class AdverseEvent_SuspectEntity(BackboneElement):
    instance: Reference
    causality: Optional[List[AdverseEvent_SuspectEntity_Causality]] = None

class AdverseEvent(DomainResource):
    category: Optional[List[CodeableConcept]] = None
    actuality: str
    date: Optional[str] = None
    study: Optional[List[Reference]] = None
    encounter: Optional[Reference] = None
    suspect_entity: Optional[List[AdverseEvent_SuspectEntity]] = None
    reference_document: Optional[List[Reference]] = None
    outcome: Optional[CodeableConcept] = None
    recorded_date: Optional[str] = None
    event: Optional[CodeableConcept] = None
    contributor: Optional[List[Reference]] = None
    subject_medical_history: Optional[List[Reference]] = None
    recorder: Optional[Reference] = None
    seriousness: Optional[CodeableConcept] = None
    severity: Optional[CodeableConcept] = None
    identifier: Optional[Identifier] = None
    detected: Optional[str] = None
    location: Optional[Reference] = None
    subject: Reference
    resulting_condition: Optional[List[Reference]] = None