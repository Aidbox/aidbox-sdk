from typing import Optional, List
from pydantic import *
from base.Period import Period
from base.CodeableConcept import CodeableConcept
from base.Coding import Coding
from base.ContactPoint import ContactPoint
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier

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