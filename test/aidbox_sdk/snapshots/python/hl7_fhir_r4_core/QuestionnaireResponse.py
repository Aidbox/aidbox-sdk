from typing import Optional, List
from dataclasses import dataclass, field
from base import Attachment
from base import Coding
from base import Quantity
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class QuestionnaireResponseItemAnswer(BackboneElement):
    value_reference: Optional[Reference] = None
    value_uri: Optional[str] = None
    value_time: Optional[str] = None
    value_decimal: Optional[float] = None
    value_quantity: Optional[Quantity] = None
    item: Optional[List[Reference]] = field(default_factory=list)
    value_string: Optional[str] = None
    value_boolean: Optional[bool] = None
    value_date_time: Optional[str] = None
    value_date: Optional[str] = None
    value_coding: Optional[Coding] = None
    value_integer: Optional[int] = None
    value_attachment: Optional[Attachment] = None

@dataclass(kw_only=True)
class QuestionnaireResponseItem(BackboneElement):
    item: Optional[List[Reference]] = field(default_factory=list)
    text: Optional[str] = None
    answer: Optional[List[QuestionnaireResponseItemAnswer]] = field(default_factory=list)
    link_id: str
    definition: Optional[str] = None

@dataclass(kw_only=True)
class QuestionnaireResponse(DomainResource):
    questionnaire: Optional[str] = None
    encounter: Optional[Reference] = None
    item: Optional[List[QuestionnaireResponseItem]] = field(default_factory=list)
    source: Optional[Reference] = None
    author: Optional[Reference] = None
    status: str
    identifier: Optional[Identifier] = None
    based_on: Optional[List[Reference]] = field(default_factory=list)
    authored: Optional[str] = None
    part_of: Optional[List[Reference]] = field(default_factory=list)
    subject: Optional[Reference] = None