from pydantic import *
from typing import Optional, List
from ..base import *

class PaymentNotice(DomainResource):
    response: Optional[Reference] = None
    amount: Money
    request: Optional[Reference] = None
    payment: Reference
    recipient: Reference
    created: str
    payment_status: Optional[CodeableConcept] = None
    status: str
    payee: Optional[Reference] = None
    payment_date: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    provider: Optional[Reference] = None