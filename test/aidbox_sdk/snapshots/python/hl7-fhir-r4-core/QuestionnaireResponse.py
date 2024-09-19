from pydantic import *
from typing import Optional, List
from ..base import *

class QuestionnaireResponse_Item_Answer(BackboneElement):
    value_reference: Optional[Reference] = None
    value_uri: Optional[str] = None
    value_time: Optional[str] = None
    value_decimal: Optional[float] = None
    value_quantity: Optional[Quantity] = None
    item: Optional[List[Reference]] = None
    value_string: Optional[str] = None
    value_boolean: Optional[bool] = None
    value_date_time: Optional[str] = None
    value_date: Optional[str] = None
    value_coding: Optional[Coding] = None
    value_integer: Optional[int] = None
    value_attachment: Optional[Attachment] = None

class QuestionnaireResponse_Item(BackboneElement):
    item: Optional[List[Reference]] = None
    text: Optional[str] = None
    answer: Optional[List[QuestionnaireResponse_Item_Answer]] = None
    link_id: str
    definition: Optional[str] = None

class QuestionnaireResponse(DomainResource):
    questionnaire: Optional[str] = None
    encounter: Optional[Reference] = None
    item: Optional[List[QuestionnaireResponse_Item]] = None
    source: Optional[Reference] = None
    author: Optional[Reference] = None
    status: str
    identifier: Optional[Identifier] = None
    based_on: Optional[List[Reference]] = None
    authored: Optional[str] = None
    part_of: Optional[List[Reference]] = None
    subject: Optional[Reference] = None