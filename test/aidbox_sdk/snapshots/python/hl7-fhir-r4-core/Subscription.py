from pydantic import *
from typing import Optional, List
from ..base import *

class Subscription_Channel(BackboneElement):
    type: str
    header: Optional[List[str]] = None
    payload: Optional[str] = None
    endpoint: Optional[str] = None

class Subscription(DomainResource):
    end: Optional[str] = None
    error: Optional[str] = None
    reason: str
    status: str
    channel: Subscription_Channel
    contact: Optional[List[ContactPoint]] = None
    criteria: str