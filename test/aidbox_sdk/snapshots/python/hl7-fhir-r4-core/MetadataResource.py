from typing import Optional, List
from pydantic import *
from ..base.UsageContext import UsageContext
from ..base.ContactDetail import ContactDetail
from ..base.CodeableConcept import CodeableConcept
from ..base.DomainResource import DomainResource

class MetadataResource(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = None
    experimental: Optional[bool] = None
    title: Optional[str] = None
    status: str
    url: Optional[str] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = None