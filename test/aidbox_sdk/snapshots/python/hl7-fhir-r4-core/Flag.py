from typing import Optional, List
from pydantic import *
from ..base import *

class Flag(DomainResource):
    code: CodeableConcept
    author: Optional[Reference] = None
    period: Optional[Period] = None
    status: str
    subject: Reference
    category: Optional[List[CodeableConcept]] = None
    encounter: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = None