from pydantic import *
from typing import Optional, List
from ..base import *

class Endpoint(DomainResource):
    connection_type: Coding
    address: str
    managing_organization: Optional[Reference] = None
    name: Optional[str] = None
    payload_mime_type: Optional[List[str]] = None
    payload_type: list[CodeableConcept] = []
    header: Optional[List[str]] = None
    status: str
    identifier: Optional[List[Identifier]] = None
    period: Optional[Period] = None
    contact: Optional[List[ContactPoint]] = None