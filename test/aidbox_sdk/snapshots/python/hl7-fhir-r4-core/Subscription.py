from typing import Optional, List
from pydantic import *
from ..base.ContactPoint import ContactPoint
from ..base.DomainResource import DomainResource
from ..base.BackboneElement import BackboneElement

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