from typing import Optional, List
from pydantic import *
from ..base.CodeableConcept import CodeableConcept
from ..base.DomainResource import DomainResource
from ..base.Money import Money
from ..base.Reference import Reference
from ..base.Identifier import Identifier

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