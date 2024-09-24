from typing import Optional, List
from base import DomainResource
from base import Reference
from base import Identifier

class EnrollmentResponse(DomainResource):
    status: Optional[str] = None
    created: Optional[str] = None
    outcome: Optional[str] = None
    request: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = None
    disposition: Optional[str] = None
    organization: Optional[Reference] = None
    request_provider: Optional[Reference] = None