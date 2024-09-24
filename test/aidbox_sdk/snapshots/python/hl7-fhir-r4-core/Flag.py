from typing import Optional, List
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier

class Flag(DomainResource):
    code: CodeableConcept
    author: Optional[Reference] = None
    period: Optional[Period] = None
    status: str
    subject: Reference
    category: Optional[List[CodeableConcept]] = None
    encounter: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = None