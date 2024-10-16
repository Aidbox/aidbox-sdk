from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import Attachment
from base import Period
from base import ContactDetail
from base import CodeableConcept
from base import Coding
from base import Quantity
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class QuestionnaireItemEnableWhen(BackboneElement):
    answer_quantity: Optional[Quantity] = None
    answer_decimal: Optional[float] = None
    answer_date: Optional[str] = None
    answer_reference: Optional[Reference] = None
    answer_integer: Optional[int] = None
    question: str
    answer_date_time: Optional[str] = None
    answer_string: Optional[str] = None
    operator: str
    answer_boolean: Optional[bool] = None
    answer_coding: Optional[Coding] = None
    answer_time: Optional[str] = None

@dataclass(kw_only=True)
class QuestionnaireItemAnswerOption(BackboneElement):
    value_date: Optional[str] = None
    value_time: Optional[str] = None
    value_coding: Optional[Coding] = None
    value_string: Optional[str] = None
    value_integer: Optional[int] = None
    value_reference: Optional[Reference] = None
    initial_selected: Optional[bool] = None

@dataclass(kw_only=True)
class QuestionnaireItemInitial(BackboneElement):
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
class QuestionnaireItem(BackboneElement):
    enable_behavior: Optional[str] = None
    definition: Optional[str] = None
    link_id: str
    repeats: Optional[bool] = None
    item: Optional[List[Reference]] = field(default_factory=list)
    type: str
    enable_when: Optional[List[QuestionnaireItemEnableWhen]] = field(default_factory=list)
    answer_option: Optional[List[QuestionnaireItemAnswerOption]] = field(default_factory=list)
    prefix: Optional[str] = None
    read_only: Optional[bool] = None
    answer_value_set: Optional[str] = None
    code: Optional[List[Coding]] = field(default_factory=list)
    initial: Optional[List[QuestionnaireItemInitial]] = field(default_factory=list)
    max_length: Optional[int] = None
    required: Optional[bool] = None
    text: Optional[str] = None

@dataclass(kw_only=True)
class Questionnaire(DomainResource):
    description: Optional[str] = None
    subject_type: Optional[List[str]] = field(default_factory=list)
    date: Optional[str] = None
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    derived_from: Optional[List[str]] = field(default_factory=list)
    purpose: Optional[str] = None
    name: Optional[str] = None
    item: Optional[List[QuestionnaireItem]] = field(default_factory=list)
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    title: Optional[str] = None
    status: str
    url: Optional[str] = None
    code: Optional[List[Coding]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    last_review_date: Optional[str] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    effective_period: Optional[Period] = None