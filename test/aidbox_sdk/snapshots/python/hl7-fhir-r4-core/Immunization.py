from typing import Optional, List
from base import Annotation
from base import CodeableConcept
from base import Quantity
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

class Immunization_ProtocolApplied(BackboneElement):
    series_doses_positive_int: Optional[int] = None
    dose_number_positive_int: Optional[int] = None
    series: Optional[str] = None
    authority: Optional[Reference] = None
    dose_number_string: Optional[str] = None
    series_doses_string: Optional[str] = None
    target_disease: Optional[List[CodeableConcept]] = None

class Immunization_Education(BackboneElement):
    reference: Optional[str] = None
    document_type: Optional[str] = None
    publication_date: Optional[str] = None
    presentation_date: Optional[str] = None

class Immunization_Reaction(BackboneElement):
    date: Optional[str] = None
    detail: Optional[Reference] = None
    reported: Optional[bool] = None

class Immunization_Performer(BackboneElement):
    actor: Reference
    function: Optional[CodeableConcept] = None

class Immunization(DomainResource):
    patient: Reference
    is_subpotent: Optional[bool] = None
    report_origin: Optional[CodeableConcept] = None
    protocol_applied: Optional[List[Immunization_ProtocolApplied]] = None
    site: Optional[CodeableConcept] = None
    encounter: Optional[Reference] = None
    vaccine_code: CodeableConcept
    dose_quantity: Optional[Quantity] = None
    reason_code: Optional[List[CodeableConcept]] = None
    status_reason: Optional[CodeableConcept] = None
    route: Optional[CodeableConcept] = None
    recorded: Optional[str] = None
    program_eligibility: Optional[List[CodeableConcept]] = None
    note: Optional[List[Annotation]] = None
    primary_source: Optional[bool] = None
    status: str
    lot_number: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    manufacturer: Optional[Reference] = None
    education: Optional[List[Immunization_Education]] = None
    occurrence_string: Optional[str] = None
    reaction: Optional[List[Immunization_Reaction]] = None
    location: Optional[Reference] = None
    occurrence_date_time: Optional[str] = None
    funding_source: Optional[CodeableConcept] = None
    subpotent_reason: Optional[List[CodeableConcept]] = None
    expiration_date: Optional[str] = None
    performer: Optional[List[Immunization_Performer]] = None
    reason_reference: Optional[List[Reference]] = None