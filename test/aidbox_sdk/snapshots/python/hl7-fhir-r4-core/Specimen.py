from pydantic import *
from typing import Optional, List
from ..base import *

class Specimen_Processing(BackboneElement):
    additive: Optional[List[Reference]] = None
    procedure: Optional[CodeableConcept] = None
    time_period: Optional[Period] = None
    description: Optional[str] = None
    time_date_time: Optional[str] = None

class Specimen_Container(BackboneElement):
    type: Optional[CodeableConcept] = None
    capacity: Optional[Quantity] = None
    identifier: Optional[List[Identifier]] = None
    description: Optional[str] = None
    specimen_quantity: Optional[Quantity] = None
    additive_reference: Optional[Reference] = None
    additive_codeable_concept: Optional[CodeableConcept] = None

class Specimen_Collection(BackboneElement):
    collected_date_time: Optional[str] = None
    fasting_status_codeable_concept: Optional[CodeableConcept] = None
    method: Optional[CodeableConcept] = None
    fasting_status_duration: Optional[Duration] = None
    duration: Optional[Duration] = None
    collector: Optional[Reference] = None
    body_site: Optional[CodeableConcept] = None
    quantity: Optional[Quantity] = None
    collected_period: Optional[Period] = None

class Specimen(DomainResource):
    request: Optional[List[Reference]] = None
    received_time: Optional[str] = None
    processing: Optional[List[Specimen_Processing]] = None
    parent: Optional[List[Reference]] = None
    type: Optional[CodeableConcept] = None
    note: Optional[List[Annotation]] = None
    status: Optional[str] = None
    condition: Optional[List[CodeableConcept]] = None
    container: Optional[List[Specimen_Container]] = None
    identifier: Optional[List[Identifier]] = None
    accession_identifier: Optional[Identifier] = None
    collection: Optional[Specimen_Collection] = None
    subject: Optional[Reference] = None