from typing import Optional, List
from pydantic import *
from ..base.Period import Period
from ..base.CodeableConcept import CodeableConcept
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier

class Flag(DomainResource):
    code: CodeableConcept
    author: Optional[Reference] = None
    period: Optional[Period] = None
    status: str
    subject: Reference
    category: Optional[List[CodeableConcept]] = None
    encounter: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = None