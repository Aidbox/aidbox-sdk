from typing import Optional, List
from pydantic import *
from ..base.CodeableConcept import CodeableConcept
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier

class Basic(DomainResource):
    code: CodeableConcept
    author: Optional[Reference] = None
    created: Optional[str] = None
    subject: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = None