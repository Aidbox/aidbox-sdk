from typing import Optional, List
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier

class Basic(DomainResource):
    code: CodeableConcept
    author: Optional[Reference] = None
    created: Optional[str] = None
    subject: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = None