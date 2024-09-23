from typing import Optional, List
from pydantic import *
from ..base import *

class CoverageEligibilityRequest_Insurance(BackboneElement):
    focal: Optional[bool] = None
    coverage: Reference
    business_arrangement: Optional[str] = None

class CoverageEligibilityRequest_SupportingInfo(BackboneElement):
    sequence: int
    information: Reference
    applies_to_all: Optional[bool] = None

class CoverageEligibilityRequest_Item_Diagnosis(BackboneElement):
    diagnosis_reference: Optional[Reference] = None
    diagnosis_codeable_concept: Optional[CodeableConcept] = None

class CoverageEligibilityRequest_Item(BackboneElement):
    category: Optional[CodeableConcept] = None
    facility: Optional[Reference] = None
    diagnosis: Optional[List[CoverageEligibilityRequest_Item_Diagnosis]] = None
    modifier: Optional[List[CodeableConcept]] = None
    product_or_service: Optional[CodeableConcept] = None
    quantity: Optional[Quantity] = None
    provider: Optional[Reference] = None
    supporting_info_sequence: Optional[List[int]] = None
    unit_price: Optional[Money] = None
    detail: Optional[List[Reference]] = None

class CoverageEligibilityRequest(DomainResource):
    patient: Reference
    insurance: Optional[List[CoverageEligibilityRequest_Insurance]] = None
    facility: Optional[Reference] = None
    enterer: Optional[Reference] = None
    supporting_info: Optional[List[CoverageEligibilityRequest_SupportingInfo]] = None
    purpose: list[str] = []
    item: Optional[List[CoverageEligibilityRequest_Item]] = None
    created: str
    insurer: Reference
    priority: Optional[CodeableConcept] = None
    status: str
    serviced_date: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    provider: Optional[Reference] = None
    serviced_period: Optional[Period] = None