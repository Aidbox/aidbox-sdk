from typing import Optional, List
from pydantic import *
from ..base import *

class ResearchSubject(DomainResource):
    study: Reference
    period: Optional[Period] = None
    status: str
    consent: Optional[Reference] = None
    actual_arm: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    individual: Reference
    assigned_arm: Optional[str] = None