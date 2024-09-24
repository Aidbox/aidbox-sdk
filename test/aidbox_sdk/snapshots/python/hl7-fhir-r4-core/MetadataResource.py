from typing import Optional, List
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import DomainResource

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