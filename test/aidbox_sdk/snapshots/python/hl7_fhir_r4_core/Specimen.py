from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Period
from base import CodeableConcept
from base import Quantity
from base import Duration
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class SpecimenProcessing(BackboneElement):
    additive: Optional[List[Reference]] = field(default_factory=list)
    procedure: Optional[CodeableConcept] = None
    time_period: Optional[Period] = None
    description: Optional[str] = None
    time_date_time: Optional[str] = None

@dataclass(kw_only=True)
class SpecimenContainer(BackboneElement):
    type: Optional[CodeableConcept] = None
    capacity: Optional[Quantity] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    description: Optional[str] = None
    specimen_quantity: Optional[Quantity] = None
    additive_reference: Optional[Reference] = None
    additive_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class SpecimenCollection(BackboneElement):
    collected_date_time: Optional[str] = None
    fasting_status_codeable_concept: Optional[CodeableConcept] = None
    method: Optional[CodeableConcept] = None
    fasting_status_duration: Optional[Duration] = None
    duration: Optional[Duration] = None
    collector: Optional[Reference] = None
    body_site: Optional[CodeableConcept] = None
    quantity: Optional[Quantity] = None
    collected_period: Optional[Period] = None

@dataclass(kw_only=True)
class Specimen(DomainResource):
    request: Optional[List[Reference]] = field(default_factory=list)
    received_time: Optional[str] = None
    processing: Optional[List[SpecimenProcessing]] = field(default_factory=list)
    parent: Optional[List[Reference]] = field(default_factory=list)
    type: Optional[CodeableConcept] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    status: Optional[str] = None
    condition: Optional[List[CodeableConcept]] = field(default_factory=list)
    container: Optional[List[SpecimenContainer]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    accession_identifier: Optional[Identifier] = None
    collection: Optional[SpecimenCollection] = None
    subject: Optional[Reference] = None