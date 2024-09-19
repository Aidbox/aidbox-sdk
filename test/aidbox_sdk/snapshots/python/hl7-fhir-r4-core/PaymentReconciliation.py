from pydantic import *
from typing import Optional, List
from ..base import *

class PaymentReconciliation_ProcessNote(BackboneElement):
    text: Optional[str] = None
    type: Optional[str] = None

class PaymentReconciliation_Detail(BackboneElement):
    response: Optional[Reference] = None
    amount: Optional[Money] = None
    date: Optional[str] = None
    request: Optional[Reference] = None
    type: CodeableConcept
    responsible: Optional[Reference] = None
    payee: Optional[Reference] = None
    predecessor: Optional[Identifier] = None
    identifier: Optional[Identifier] = None
    submitter: Optional[Reference] = None

class PaymentReconciliation(DomainResource):
    requestor: Optional[Reference] = None
    request: Optional[Reference] = None
    payment_amount: Money
    process_note: Optional[List[PaymentReconciliation_ProcessNote]] = None
    created: str
    outcome: Optional[str] = None
    disposition: Optional[str] = None
    payment_identifier: Optional[Identifier] = None
    status: str
    payment_date: str
    identifier: Optional[List[Identifier]] = None
    period: Optional[Period] = None
    payment_issuer: Optional[Reference] = None
    form_code: Optional[CodeableConcept] = None
    detail: Optional[List[PaymentReconciliation_Detail]] = None