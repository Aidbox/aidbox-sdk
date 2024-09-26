from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import CodeableConcept
from base import DomainResource
from base import Money
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class InvoiceParticipant(BackboneElement):
    role: Optional[CodeableConcept] = None
    actor: Reference

@dataclass(kw_only=True)
class InvoiceLineItemPriceComponent(BackboneElement):
    code: Optional[CodeableConcept] = None
    type: str
    amount: Optional[Money] = None
    factor: Optional[float] = None

@dataclass(kw_only=True)
class InvoiceLineItem(BackboneElement):
    sequence: Optional[int] = None
    price_component: Optional[List[InvoiceLineItemPriceComponent]] = field(default_factory=list)
    charge_item_reference: Optional[Reference] = None
    charge_item_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class Invoice(DomainResource):
    date: Optional[str] = None
    total_net: Optional[Money] = None
    recipient: Optional[Reference] = None
    total_price_component: Optional[List[Reference]] = field(default_factory=list)
    type: Optional[CodeableConcept] = None
    total_gross: Optional[Money] = None
    participant: Optional[List[InvoiceParticipant]] = field(default_factory=list)
    note: Optional[List[Annotation]] = field(default_factory=list)
    account: Optional[Reference] = None
    status: str
    line_item: Optional[List[InvoiceLineItem]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    issuer: Optional[Reference] = None
    cancelled_reason: Optional[str] = None
    payment_terms: Optional[str] = None
    subject: Optional[Reference] = None