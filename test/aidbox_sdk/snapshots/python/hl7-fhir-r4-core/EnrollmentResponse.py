from typing import Optional, List
from pydantic import *
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier

class EnrollmentResponse(DomainResource):
    status: Optional[str] = None
    created: Optional[str] = None
    outcome: Optional[str] = None
    request: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = None
    disposition: Optional[str] = None
    organization: Optional[Reference] = None
    request_provider: Optional[Reference] = None