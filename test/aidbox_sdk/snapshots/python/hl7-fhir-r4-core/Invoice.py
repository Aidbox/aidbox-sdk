from typing import Optional, List
from pydantic import *
from base.Annotation import Annotation
from base.CodeableConcept import CodeableConcept
from base.DomainResource import DomainResource
from base.Money import Money
from base.Reference import Reference
from base.Identifier import Identifier
from base.BackboneElement import BackboneElement

class Invoice_Participant(BackboneElement):
    role: Optional[CodeableConcept] = None
    actor: Reference

class Invoice_LineItem_PriceComponent(BackboneElement):
    code: Optional[CodeableConcept] = None
    type: str
    amount: Optional[Money] = None
    factor: Optional[float] = None

class Invoice_LineItem(BackboneElement):
    sequence: Optional[int] = None
    price_component: Optional[List[Invoice_LineItem_PriceComponent]] = None
    charge_item_reference: Optional[Reference] = None
    charge_item_codeable_concept: Optional[CodeableConcept] = None

class Invoice(DomainResource):
    date: Optional[str] = None
    total_net: Optional[Money] = None
    recipient: Optional[Reference] = None
    total_price_component: Optional[List[Reference]] = None
    type: Optional[CodeableConcept] = None
    total_gross: Optional[Money] = None
    participant: Optional[List[Invoice_Participant]] = None
    note: Optional[List[Annotation]] = None
    account: Optional[Reference] = None
    status: str
    line_item: Optional[List[Invoice_LineItem]] = None
    identifier: Optional[List[Identifier]] = None
    issuer: Optional[Reference] = None
    cancelled_reason: Optional[str] = None
    payment_terms: Optional[str] = None
    subject: Optional[Reference] = None