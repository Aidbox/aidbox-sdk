from typing import Optional, List
from pydantic import *
from ..base import *

class Basic(DomainResource):
    code: CodeableConcept
    author: Optional[Reference] = None
    created: Optional[str] = None
    subject: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = None