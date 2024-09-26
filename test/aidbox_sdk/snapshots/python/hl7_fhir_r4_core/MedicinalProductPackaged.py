from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import MarketingStatus
from base import ProdCharacteristic
from base import Quantity
from base import DomainResource
from base import ProductShelfLife
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class MedicinalProductPackagedBatchIdentifier(BackboneElement):
    outer_packaging: Identifier
    immediate_packaging: Optional[Identifier] = None

@dataclass(kw_only=True)
class MedicinalProductPackagedPackageItem(BackboneElement):
    manufactured_item: Optional[List[Reference]] = field(default_factory=list)
    other_characteristics: Optional[List[CodeableConcept]] = field(default_factory=list)
    shelf_life_storage: Optional[List[ProductShelfLife]] = field(default_factory=list)
    alternate_material: Optional[List[CodeableConcept]] = field(default_factory=list)
    type: CodeableConcept
    material: Optional[List[CodeableConcept]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    manufacturer: Optional[List[Reference]] = field(default_factory=list)
    device: Optional[List[Reference]] = field(default_factory=list)
    quantity: Quantity
    physical_characteristics: Optional[ProdCharacteristic] = None
    package_item: Optional[List[Reference]] = field(default_factory=list)

@dataclass(kw_only=True)
class MedicinalProductPackaged(DomainResource):
    description: Optional[str] = None
    marketing_status: Optional[List[MarketingStatus]] = field(default_factory=list)
    marketing_authorization: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    manufacturer: Optional[List[Reference]] = field(default_factory=list)
    legal_status_of_supply: Optional[CodeableConcept] = None
    batch_identifier: Optional[List[MedicinalProductPackagedBatchIdentifier]] = field(default_factory=list)
    subject: Optional[List[Reference]] = field(default_factory=list)
    package_item: list[MedicinalProductPackagedPackageItem] = field(default_factory=list)