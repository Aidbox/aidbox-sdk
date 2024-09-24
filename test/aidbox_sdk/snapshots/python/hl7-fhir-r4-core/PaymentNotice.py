from typing import Optional, List
from base import CodeableConcept
from base import DomainResource
from base import Money
from base import Reference
from base import Identifier

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