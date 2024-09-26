from typing import Optional, List
from dataclasses import dataclass, field
from base import ContactPoint
from base import DomainResource
from base import BackboneElement

@dataclass(kw_only=True)
class SubscriptionChannel(BackboneElement):
    type: str
    header: Optional[List[str]] = field(default_factory=list)
    payload: Optional[str] = None
    endpoint: Optional[str] = None

@dataclass(kw_only=True)
class Subscription(DomainResource):
    end: Optional[str] = None
    error: Optional[str] = None
    reason: str
    status: str
    channel: SubscriptionChannel
    contact: Optional[List[ContactPoint]] = field(default_factory=list)
    criteria: str