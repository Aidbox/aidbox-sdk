from typing import Optional, List
from pydantic import *
from base.Period import Period
from base.CodeableConcept import CodeableConcept
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier
from base.BackboneElement import BackboneElement

class BiologicallyDerivedProduct_Processing(BackboneElement):
    additive: Optional[Reference] = None
    procedure: Optional[CodeableConcept] = None
    time_period: Optional[Period] = None
    description: Optional[str] = None
    time_date_time: Optional[str] = None

class BiologicallyDerivedProduct_Storage(BackboneElement):
    scale: Optional[str] = None
    duration: Optional[Period] = None
    description: Optional[str] = None
    temperature: Optional[float] = None

class BiologicallyDerivedProduct_Manipulation(BackboneElement):
    time_period: Optional[Period] = None
    description: Optional[str] = None
    time_date_time: Optional[str] = None

class BiologicallyDerivedProduct_Collection(BackboneElement):
    source: Optional[Reference] = None
    collector: Optional[Reference] = None
    collected_period: Optional[Period] = None
    collected_date_time: Optional[str] = None

class BiologicallyDerivedProduct(DomainResource):
    request: Optional[List[Reference]] = None
    processing: Optional[List[BiologicallyDerivedProduct_Processing]] = None
    parent: Optional[List[Reference]] = None
    status: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    product_code: Optional[CodeableConcept] = None
    storage: Optional[List[BiologicallyDerivedProduct_Storage]] = None
    quantity: Optional[int] = None
    product_category: Optional[str] = None
    manipulation: Optional[BiologicallyDerivedProduct_Manipulation] = None
    collection: Optional[BiologicallyDerivedProduct_Collection] = None