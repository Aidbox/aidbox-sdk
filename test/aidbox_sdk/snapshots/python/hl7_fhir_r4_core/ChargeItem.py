from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Period
from base import CodeableConcept
from base import Timing
from base import Quantity
from base import DomainResource
from base import Money
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ChargeItemPerformer(BackboneElement):
    actor: Reference
    function: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class ChargeItem(DomainResource):
    service: Optional[List[Reference]] = field(default_factory=list)
    definition_uri: Optional[List[str]] = field(default_factory=list)
    enterer: Optional[Reference] = None
    requesting_organization: Optional[Reference] = None
    product_codeable_concept: Optional[CodeableConcept] = None
    product_reference: Optional[Reference] = None
    definition_canonical: Optional[List[str]] = field(default_factory=list)
    bodysite: Optional[List[CodeableConcept]] = field(default_factory=list)
    occurrence_timing: Optional[Timing] = None
    cost_center: Optional[Reference] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    account: Optional[List[Reference]] = field(default_factory=list)
    reason: Optional[List[CodeableConcept]] = field(default_factory=list)
    supporting_information: Optional[List[Reference]] = field(default_factory=list)
    occurrence_period: Optional[Period] = None
    status: str
    code: CodeableConcept
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    context: Optional[Reference] = None
    quantity: Optional[Quantity] = None
    part_of: Optional[List[Reference]] = field(default_factory=list)
    price_override: Optional[Money] = None
    entered_date: Optional[str] = None
    occurrence_date_time: Optional[str] = None
    override_reason: Optional[str] = None
    performing_organization: Optional[Reference] = None
    subject: Reference
    factor_override: Optional[float] = None
    performer: Optional[List[ChargeItemPerformer]] = field(default_factory=list)