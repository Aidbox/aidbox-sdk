from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import CodeableConcept
from base import Quantity
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ImmunizationProtocolApplied(BackboneElement):
    series_doses_positive_int: Optional[int] = None
    dose_number_positive_int: Optional[int] = None
    series: Optional[str] = None
    authority: Optional[Reference] = None
    dose_number_string: Optional[str] = None
    series_doses_string: Optional[str] = None
    target_disease: Optional[List[CodeableConcept]] = field(default_factory=list)

@dataclass(kw_only=True)
class ImmunizationEducation(BackboneElement):
    reference: Optional[str] = None
    document_type: Optional[str] = None
    publication_date: Optional[str] = None
    presentation_date: Optional[str] = None

@dataclass(kw_only=True)
class ImmunizationReaction(BackboneElement):
    date: Optional[str] = None
    detail: Optional[Reference] = None
    reported: Optional[bool] = None

@dataclass(kw_only=True)
class ImmunizationPerformer(BackboneElement):
    actor: Reference
    function: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class Immunization(DomainResource):
    patient: Reference
    is_subpotent: Optional[bool] = None
    report_origin: Optional[CodeableConcept] = None
    protocol_applied: Optional[List[ImmunizationProtocolApplied]] = field(default_factory=list)
    site: Optional[CodeableConcept] = None
    encounter: Optional[Reference] = None
    vaccine_code: CodeableConcept
    dose_quantity: Optional[Quantity] = None
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    status_reason: Optional[CodeableConcept] = None
    route: Optional[CodeableConcept] = None
    recorded: Optional[str] = None
    program_eligibility: Optional[List[CodeableConcept]] = field(default_factory=list)
    note: Optional[List[Annotation]] = field(default_factory=list)
    primary_source: Optional[bool] = None
    status: str
    lot_number: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    manufacturer: Optional[Reference] = None
    education: Optional[List[ImmunizationEducation]] = field(default_factory=list)
    occurrence_string: Optional[str] = None
    reaction: Optional[List[ImmunizationReaction]] = field(default_factory=list)
    location: Optional[Reference] = None
    occurrence_date_time: Optional[str] = None
    funding_source: Optional[CodeableConcept] = None
    subpotent_reason: Optional[List[CodeableConcept]] = field(default_factory=list)
    expiration_date: Optional[str] = None
    performer: Optional[List[ImmunizationPerformer]] = field(default_factory=list)
    reason_reference: Optional[List[Reference]] = field(default_factory=list)