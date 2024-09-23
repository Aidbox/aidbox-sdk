from typing import Optional, List
from pydantic import *
from ..base import *

class Questionnaire_Item_EnableWhen(BackboneElement):
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

class Questionnaire_Item_AnswerOption(BackboneElement):
    value_date: Optional[str] = None
    value_time: Optional[str] = None
    value_coding: Optional[Coding] = None
    value_string: Optional[str] = None
    value_integer: Optional[int] = None
    value_reference: Optional[Reference] = None
    initial_selected: Optional[bool] = None

class Questionnaire_Item_Initial(BackboneElement):
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

class Questionnaire_Item(BackboneElement):
    enable_behavior: Optional[str] = None
    definition: Optional[str] = None
    link_id: str
    repeats: Optional[bool] = None
    item: Optional[List[Reference]] = None
    type: str
    enable_when: Optional[List[Questionnaire_Item_EnableWhen]] = None
    answer_option: Optional[List[Questionnaire_Item_AnswerOption]] = None
    prefix: Optional[str] = None
    read_only: Optional[bool] = None
    answer_value_set: Optional[str] = None
    code: Optional[List[Coding]] = None
    initial: Optional[List[Questionnaire_Item_Initial]] = None
    max_length: Optional[int] = None
    required: Optional[bool] = None
    text: Optional[str] = None

class Questionnaire(DomainResource):
    description: Optional[str] = None
    subject_type: Optional[List[str]] = None
    date: Optional[str] = None
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    derived_from: Optional[List[str]] = None
    purpose: Optional[str] = None
    name: Optional[str] = None
    item: Optional[List[Questionnaire_Item]] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    experimental: Optional[bool] = None
    title: Optional[str] = None
    status: str
    url: Optional[str] = None
    code: Optional[List[Coding]] = None
    identifier: Optional[List[Identifier]] = None
    last_review_date: Optional[str] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = None
    effective_period: Optional[Period] = None