from typing import Optional, List
from pydantic import *
from ..base.CodeableConcept import CodeableConcept
from ..base.MarketingStatus import MarketingStatus
from ..base.ProdCharacteristic import ProdCharacteristic
from ..base.Quantity import Quantity
from ..base.DomainResource import DomainResource
from ..base.ProductShelfLife import ProductShelfLife
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class MedicinalProductPackaged_BatchIdentifier(BackboneElement):
    outer_packaging: Identifier
    immediate_packaging: Optional[Identifier] = None

class MedicinalProductPackaged_PackageItem(BackboneElement):
    manufactured_item: Optional[List[Reference]] = None
    other_characteristics: Optional[List[CodeableConcept]] = None
    shelf_life_storage: Optional[List[ProductShelfLife]] = None
    alternate_material: Optional[List[CodeableConcept]] = None
    type: CodeableConcept
    material: Optional[List[CodeableConcept]] = None
    identifier: Optional[List[Identifier]] = None
    manufacturer: Optional[List[Reference]] = None
    device: Optional[List[Reference]] = None
    quantity: Quantity
    physical_characteristics: Optional[ProdCharacteristic] = None
    package_item: Optional[List[Reference]] = None

class MedicinalProductPackaged(DomainResource):
    description: Optional[str] = None
    marketing_status: Optional[List[MarketingStatus]] = None
    marketing_authorization: Optional[Reference] = None
    identifier: Optional[List[Identifier]] = None
    manufacturer: Optional[List[Reference]] = None
    legal_status_of_supply: Optional[CodeableConcept] = None
    batch_identifier: Optional[List[MedicinalProductPackaged_BatchIdentifier]] = None
    subject: Optional[List[Reference]] = None
    package_item: list[MedicinalProductPackaged_PackageItem] = []