from typing import Optional, List
from pydantic import *
from ..base.Annotation import Annotation
from ..base.Attachment import Attachment
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.Coding import Coding
from ..base.Signature import Signature
from ..base.Timing import Timing
from ..base.Quantity import Quantity
from ..base.DomainResource import DomainResource
from ..base.Money import Money
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class Contract_Rule(BackboneElement):
    content_reference: Optional[Reference] = None
    content_attachment: Optional[Attachment] = None

class Contract_Legal(BackboneElement):
    content_reference: Optional[Reference] = None
    content_attachment: Optional[Attachment] = None

class Contract_ContentDefinition(BackboneElement):
    type: CodeableConcept
    sub_type: Optional[CodeableConcept] = None
    copyright: Optional[str] = None
    publisher: Optional[Reference] = None
    publication_date: Optional[str] = None
    publication_status: str

class Contract_Signer(BackboneElement):
    type: Coding
    party: Reference
    signature: list[Signature] = []

class Contract_Term_Offer_Party(BackboneElement):
    role: CodeableConcept
    reference: list[Reference] = []

class Contract_Term_Offer_Answer(BackboneElement):
    value_reference: Optional[Reference] = None
    value_uri: Optional[str] = None
    value_time: Optional[str] = None
    value_decimal: Optional[float] = None
    value_quantity: Optional[Quantity] = None
    value_string: Optional[str] = None
    value_boolean: Optional[bool] = None
    value_date_time: Optional[str] = None
    value_date: Optional[str] = None
    value_coding: Optional[Coding] = None
    value_integer: Optional[int] = None
    value_attachment: Optional[Attachment] = None

class Contract_Term_Offer(BackboneElement):
    party: Optional[List[Contract_Term_Offer_Party]] = None
    link_id: Optional[List[str]] = None
    decision_mode: Optional[List[CodeableConcept]] = None
    type: Optional[CodeableConcept] = None
    topic: Optional[Reference] = None
    security_label_number: Optional[List[int]] = None
    answer: Optional[List[Contract_Term_Offer_Answer]] = None
    identifier: Optional[List[Identifier]] = None
    decision: Optional[CodeableConcept] = None
    text: Optional[str] = None

class Contract_Term_Action_Subject(BackboneElement):
    role: Optional[CodeableConcept] = None
    reference: list[Reference] = []

class Contract_Term_Action(BackboneElement):
    requester_link_id: Optional[List[str]] = None
    performer_type: Optional[List[CodeableConcept]] = None
    link_id: Optional[List[str]] = None
    performer_role: Optional[CodeableConcept] = None
    reason_link_id: Optional[List[str]] = None
    reason_code: Optional[List[CodeableConcept]] = None
    type: CodeableConcept
    occurrence_timing: Optional[Timing] = None
    note: Optional[List[Annotation]] = None
    reason: Optional[List[str]] = None
    requester: Optional[List[Reference]] = None
    security_label_number: Optional[List[int]] = None
    occurrence_period: Optional[Period] = None
    status: CodeableConcept
    do_not_perform: Optional[bool] = None
    context: Optional[Reference] = None
    intent: CodeableConcept
    performer_link_id: Optional[List[str]] = None
    occurrence_date_time: Optional[str] = None
    subject: Optional[List[Contract_Term_Action_Subject]] = None
    performer: Optional[Reference] = None
    context_link_id: Optional[List[str]] = None
    reason_reference: Optional[List[Reference]] = None

class Contract_Term_SecurityLabel(BackboneElement):
    number: Optional[List[int]] = None
    control: Optional[List[Coding]] = None
    category: Optional[List[Coding]] = None
    classification: Coding

class Contract_Term_Asset_Context(BackboneElement):
    code: Optional[List[CodeableConcept]] = None
    text: Optional[str] = None
    reference: Optional[Reference] = None

class Contract_Term_Asset_ValuedItem(BackboneElement):
    link_id: Optional[List[str]] = None
    payment: Optional[str] = None
    recipient: Optional[Reference] = None
    net: Optional[Money] = None
    points: Optional[float] = None
    responsible: Optional[Reference] = None
    security_label_number: Optional[List[int]] = None
    factor: Optional[float] = None
    payment_date: Optional[str] = None
    entity_codeable_concept: Optional[CodeableConcept] = None
    identifier: Optional[Identifier] = None
    effective_time: Optional[str] = None
    quantity: Optional[Quantity] = None
    unit_price: Optional[Money] = None
    entity_reference: Optional[Reference] = None

class Contract_Term_Asset(BackboneElement):
    period_type: Optional[List[CodeableConcept]] = None
    use_period: Optional[List[Period]] = None
    link_id: Optional[List[str]] = None
    relationship: Optional[Coding] = None
    type: Optional[List[CodeableConcept]] = None
    scope: Optional[CodeableConcept] = None
    security_label_number: Optional[List[int]] = None
    type_reference: Optional[List[Reference]] = None
    condition: Optional[str] = None
    answer: Optional[List[Reference]] = None
    context: Optional[List[Contract_Term_Asset_Context]] = None
    period: Optional[List[Period]] = None
    valued_item: Optional[List[Contract_Term_Asset_ValuedItem]] = None
    subtype: Optional[List[CodeableConcept]] = None
    text: Optional[str] = None

class Contract_Term(BackboneElement):
    group: Optional[List[Reference]] = None
    applies: Optional[Period] = None
    offer: Contract_Term_Offer
    type: Optional[CodeableConcept] = None
    topic_codeable_concept: Optional[CodeableConcept] = None
    topic_reference: Optional[Reference] = None
    identifier: Optional[Identifier] = None
    action: Optional[List[Contract_Term_Action]] = None
    issued: Optional[str] = None
    sub_type: Optional[CodeableConcept] = None
    security_label: Optional[List[Contract_Term_SecurityLabel]] = None
    asset: Optional[List[Contract_Term_Asset]] = None
    text: Optional[str] = None

class Contract_Friendly(BackboneElement):
    content_reference: Optional[Reference] = None
    content_attachment: Optional[Attachment] = None

class Contract(DomainResource):
    legally_binding_attachment: Optional[Attachment] = None
    instantiates_canonical: Optional[Reference] = None
    instantiates_uri: Optional[str] = None
    legally_binding_reference: Optional[Reference] = None
    site: Optional[List[Reference]] = None
    relevant_history: Optional[List[Reference]] = None
    supporting_info: Optional[List[Reference]] = None
    applies: Optional[Period] = None
    name: Optional[str] = None
    authority: Optional[List[Reference]] = None
    rule: Optional[List[Contract_Rule]] = None
    type: Optional[CodeableConcept] = None
    legal: Optional[List[Contract_Legal]] = None
    content_derivative: Optional[CodeableConcept] = None
    topic_codeable_concept: Optional[CodeableConcept] = None
    legal_state: Optional[CodeableConcept] = None
    content_definition: Optional[Contract_ContentDefinition] = None
    scope: Optional[CodeableConcept] = None
    title: Optional[str] = None
    signer: Optional[List[Contract_Signer]] = None
    author: Optional[Reference] = None
    term: Optional[List[Contract_Term]] = None
    friendly: Optional[List[Contract_Friendly]] = None
    alias: Optional[List[str]] = None
    status: Optional[str] = None
    subtitle: Optional[str] = None
    topic_reference: Optional[Reference] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    expiration_type: Optional[CodeableConcept] = None
    issued: Optional[str] = None
    domain: Optional[List[Reference]] = None
    sub_type: Optional[List[CodeableConcept]] = None
    version: Optional[str] = None
    subject: Optional[List[Reference]] = None