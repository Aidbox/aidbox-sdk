from typing import Optional, List
from dataclasses import dataclass, field
from base import UsageContext
from base import ContactDetail
from base import CodeableConcept
from base import DomainResource

@dataclass(kw_only=True)
class MetadataResource(DomainResource):
    description: Optional[str] = None
    date: Optional[str] = None
    publisher: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = field(default_factory=list)
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = field(default_factory=list)
    experimental: Optional[bool] = None
    title: Optional[str] = None
    status: str
    url: Optional[str] = None
    version: Optional[str] = None
    contact: Optional[List[ContactDetail]] = field(default_factory=list)