from typing import Optional, List
from dataclasses import dataclass, field
from base import Period
from base import CodeableConcept
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class BiologicallyDerivedProductProcessing(BackboneElement):
    additive: Optional[Reference] = None
    procedure: Optional[CodeableConcept] = None
    time_period: Optional[Period] = None
    description: Optional[str] = None
    time_date_time: Optional[str] = None

@dataclass(kw_only=True)
class BiologicallyDerivedProductStorage(BackboneElement):
    scale: Optional[str] = None
    duration: Optional[Period] = None
    description: Optional[str] = None
    temperature: Optional[float] = None

@dataclass(kw_only=True)
class BiologicallyDerivedProductManipulation(BackboneElement):
    time_period: Optional[Period] = None
    description: Optional[str] = None
    time_date_time: Optional[str] = None

@dataclass(kw_only=True)
class BiologicallyDerivedProductCollection(BackboneElement):
    source: Optional[Reference] = None
    collector: Optional[Reference] = None
    collected_period: Optional[Period] = None
    collected_date_time: Optional[str] = None

@dataclass(kw_only=True)
class BiologicallyDerivedProduct(DomainResource):
    request: Optional[List[Reference]] = field(default_factory=list)
    processing: Optional[List[BiologicallyDerivedProductProcessing]] = field(default_factory=list)
    parent: Optional[List[Reference]] = field(default_factory=list)
    status: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    product_code: Optional[CodeableConcept] = None
    storage: Optional[List[BiologicallyDerivedProductStorage]] = field(default_factory=list)
    quantity: Optional[int] = None
    product_category: Optional[str] = None
    manipulation: Optional[BiologicallyDerivedProductManipulation] = None
    collection: Optional[BiologicallyDerivedProductCollection] = None