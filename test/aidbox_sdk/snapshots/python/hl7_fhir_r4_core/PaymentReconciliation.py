from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Money
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class PaymentReconciliationProcessNote(BackboneElement):
    text: Optional[str] = None
    type: Optional[str] = None

@dataclass(kw_only=True)
class PaymentReconciliationDetail(BackboneElement):
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

@dataclass(kw_only=True)
class PaymentReconciliation(DomainResource):
    requestor: Optional[Reference] = None
    request: Optional[Reference] = None
    payment_amount: Money
    process_note: Optional[List[PaymentReconciliationProcessNote]] = field(default_factory=list)
    created: str
    outcome: Optional[str] = None
    disposition: Optional[str] = None
    payment_identifier: Optional[Identifier] = None
    status: str
    payment_date: str
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    period: Optional[Period] = None
    payment_issuer: Optional[Reference] = None
    form_code: Optional[CodeableConcept] = None
    detail: Optional[List[PaymentReconciliationDetail]] = field(default_factory=list)