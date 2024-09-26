from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Attachment
from base import Period
from base import CodeableConcept
from base import Coding
from base import Signature
from base import Timing
from base import Quantity
from base import DomainResource
from base import Money
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ContractRule(BackboneElement):
    content_reference: Optional[Reference] = None
    content_attachment: Optional[Attachment] = None

@dataclass(kw_only=True)
class ContractLegal(BackboneElement):
    content_reference: Optional[Reference] = None
    content_attachment: Optional[Attachment] = None

@dataclass(kw_only=True)
class ContractContentDefinition(BackboneElement):
    type: CodeableConcept
    sub_type: Optional[CodeableConcept] = None
    copyright: Optional[str] = None
    publisher: Optional[Reference] = None
    publication_date: Optional[str] = None
    publication_status: str

@dataclass(kw_only=True)
class ContractSigner(BackboneElement):
    type: Coding
    party: Reference
    signature: list[Signature] = field(default_factory=list)

@dataclass(kw_only=True)
class ContractTermOfferParty(BackboneElement):
    role: CodeableConcept
    reference: list[Reference] = field(default_factory=list)

@dataclass(kw_only=True)
class ContractTermOfferAnswer(BackboneElement):
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

@dataclass(kw_only=True)
class ContractTermOffer(BackboneElement):
    party: Optional[List[ContractTermOfferParty]] = field(default_factory=list)
    link_id: Optional[List[str]] = field(default_factory=list)
    decision_mode: Optional[List[CodeableConcept]] = field(default_factory=list)
    type: Optional[CodeableConcept] = None
    topic: Optional[Reference] = None
    security_label_number: Optional[List[int]] = field(default_factory=list)
    answer: Optional[List[ContractTermOfferAnswer]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    decision: Optional[CodeableConcept] = None
    text: Optional[str] = None

@dataclass(kw_only=True)
class ContractTermActionSubject(BackboneElement):
    role: Optional[CodeableConcept] = None
    reference: list[Reference] = field(default_factory=list)

@dataclass(kw_only=True)
class ContractTermAction(BackboneElement):
    requester_link_id: Optional[List[str]] = field(default_factory=list)
    performer_type: Optional[List[CodeableConcept]] = field(default_factory=list)
    link_id: Optional[List[str]] = field(default_factory=list)
    performer_role: Optional[CodeableConcept] = None
    reason_link_id: Optional[List[str]] = field(default_factory=list)
    reason_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    type: CodeableConcept
    occurrence_timing: Optional[Timing] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    reason: Optional[List[str]] = field(default_factory=list)
    requester: Optional[List[Reference]] = field(default_factory=list)
    security_label_number: Optional[List[int]] = field(default_factory=list)
    occurrence_period: Optional[Period] = None
    status: CodeableConcept
    do_not_perform: Optional[bool] = None
    context: Optional[Reference] = None
    intent: CodeableConcept
    performer_link_id: Optional[List[str]] = field(default_factory=list)
    occurrence_date_time: Optional[str] = None
    subject: Optional[List[ContractTermActionSubject]] = field(default_factory=list)
    performer: Optional[Reference] = None
    context_link_id: Optional[List[str]] = field(default_factory=list)
    reason_reference: Optional[List[Reference]] = field(default_factory=list)

@dataclass(kw_only=True)
class ContractTermSecurityLabel(BackboneElement):
    number: Optional[List[int]] = field(default_factory=list)
    control: Optional[List[Coding]] = field(default_factory=list)
    category: Optional[List[Coding]] = field(default_factory=list)
    classification: Coding

@dataclass(kw_only=True)
class ContractTermAssetContext(BackboneElement):
    code: Optional[List[CodeableConcept]] = field(default_factory=list)
    text: Optional[str] = None
    reference: Optional[Reference] = None

@dataclass(kw_only=True)
class ContractTermAssetValuedItem(BackboneElement):
    link_id: Optional[List[str]] = field(default_factory=list)
    payment: Optional[str] = None
    recipient: Optional[Reference] = None
    net: Optional[Money] = None
    points: Optional[float] = None
    responsible: Optional[Reference] = None
    security_label_number: Optional[List[int]] = field(default_factory=list)
    factor: Optional[float] = None
    payment_date: Optional[str] = None
    entity_codeable_concept: Optional[CodeableConcept] = None
    identifier: Optional[Identifier] = None
    effective_time: Optional[str] = None
    quantity: Optional[Quantity] = None
    unit_price: Optional[Money] = None
    entity_reference: Optional[Reference] = None

@dataclass(kw_only=True)
class ContractTermAsset(BackboneElement):
    period_type: Optional[List[CodeableConcept]] = field(default_factory=list)
    use_period: Optional[List[Period]] = field(default_factory=list)
    link_id: Optional[List[str]] = field(default_factory=list)
    relationship: Optional[Coding] = None
    type: Optional[List[CodeableConcept]] = field(default_factory=list)
    scope: Optional[CodeableConcept] = None
    security_label_number: Optional[List[int]] = field(default_factory=list)
    type_reference: Optional[List[Reference]] = field(default_factory=list)
    condition: Optional[str] = None
    answer: Optional[List[Reference]] = field(default_factory=list)
    context: Optional[List[ContractTermAssetContext]] = field(default_factory=list)
    period: Optional[List[Period]] = field(default_factory=list)
    valued_item: Optional[List[ContractTermAssetValuedItem]] = field(default_factory=list)
    subtype: Optional[List[CodeableConcept]] = field(default_factory=list)
    text: Optional[str] = None

@dataclass(kw_only=True)
class ContractTerm(BackboneElement):
    group: Optional[List[Reference]] = field(default_factory=list)
    applies: Optional[Period] = None
    offer: ContractTermOffer
    type: Optional[CodeableConcept] = None
    topic_codeable_concept: Optional[CodeableConcept] = None
    topic_reference: Optional[Reference] = None
    identifier: Optional[Identifier] = None
    action: Optional[List[ContractTermAction]] = field(default_factory=list)
    issued: Optional[str] = None
    sub_type: Optional[CodeableConcept] = None
    security_label: Optional[List[ContractTermSecurityLabel]] = field(default_factory=list)
    asset: Optional[List[ContractTermAsset]] = field(default_factory=list)
    text: Optional[str] = None

@dataclass(kw_only=True)
class ContractFriendly(BackboneElement):
    content_reference: Optional[Reference] = None
    content_attachment: Optional[Attachment] = None

@dataclass(kw_only=True)
class Contract(DomainResource):
    legally_binding_attachment: Optional[Attachment] = None
    instantiates_canonical: Optional[Reference] = None
    instantiates_uri: Optional[str] = None
    legally_binding_reference: Optional[Reference] = None
    site: Optional[List[Reference]] = field(default_factory=list)
    relevant_history: Optional[List[Reference]] = field(default_factory=list)
    supporting_info: Optional[List[Reference]] = field(default_factory=list)
    applies: Optional[Period] = None
    name: Optional[str] = None
    authority: Optional[List[Reference]] = field(default_factory=list)
    rule: Optional[List[ContractRule]] = field(default_factory=list)
    type: Optional[CodeableConcept] = None
    legal: Optional[List[ContractLegal]] = field(default_factory=list)
    content_derivative: Optional[CodeableConcept] = None
    topic_codeable_concept: Optional[CodeableConcept] = None
    legal_state: Optional[CodeableConcept] = None
    content_definition: Optional[ContractContentDefinition] = None
    scope: Optional[CodeableConcept] = None
    title: Optional[str] = None
    signer: Optional[List[ContractSigner]] = field(default_factory=list)
    author: Optional[Reference] = None
    term: Optional[List[ContractTerm]] = field(default_factory=list)
    friendly: Optional[List[ContractFriendly]] = field(default_factory=list)
    alias: Optional[List[str]] = field(default_factory=list)
    status: Optional[str] = None
    subtitle: Optional[str] = None
    topic_reference: Optional[Reference] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    expiration_type: Optional[CodeableConcept] = None
    issued: Optional[str] = None
    domain: Optional[List[Reference]] = field(default_factory=list)
    sub_type: Optional[List[CodeableConcept]] = field(default_factory=list)
    version: Optional[str] = None
    subject: Optional[List[Reference]] = field(default_factory=list)