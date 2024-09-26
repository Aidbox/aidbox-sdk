from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import CodeableConcept
from base import ContactPoint
from base import ProdCharacteristic
from base import Quantity
from base import DomainResource
from base import ProductShelfLife
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class DeviceDefinitionDeviceName(BackboneElement):
    name: str
    type: str

@dataclass(kw_only=True)
class DeviceDefinitionProperty(BackboneElement):
    type: CodeableConcept
    value_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    value_quantity: Optional[List[Quantity]] = field(default_factory=list)

@dataclass(kw_only=True)
class DeviceDefinitionUdiDeviceIdentifier(BackboneElement):
    issuer: str
    jurisdiction: str
    device_identifier: str

@dataclass(kw_only=True)
class DeviceDefinitionCapability(BackboneElement):
    type: CodeableConcept
    description: Optional[List[CodeableConcept]] = field(default_factory=list)

@dataclass(kw_only=True)
class DeviceDefinitionSpecialization(BackboneElement):
    version: Optional[str] = None
    system_type: str

@dataclass(kw_only=True)
class DeviceDefinitionMaterial(BackboneElement):
    alternate: Optional[bool] = None
    substance: CodeableConcept
    allergenic_indicator: Optional[bool] = None

@dataclass(kw_only=True)
class DeviceDefinition(DomainResource):
    device_name: Optional[List[DeviceDefinitionDeviceName]] = field(default_factory=list)
    shelf_life_storage: Optional[List[ProductShelfLife]] = field(default_factory=list)
    property: Optional[List[DeviceDefinitionProperty]] = field(default_factory=list)
    manufacturer_string: Optional[str] = None
    model_number: Optional[str] = None
    udi_device_identifier: Optional[List[DeviceDefinitionUdiDeviceIdentifier]] = field(default_factory=list)
    type: Optional[CodeableConcept] = None
    manufacturer_reference: Optional[Reference] = None
    capability: Optional[List[DeviceDefinitionCapability]] = field(default_factory=list)
    specialization: Optional[List[DeviceDefinitionSpecialization]] = field(default_factory=list)
    parent_device: Optional[Reference] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    language_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    safety: Optional[List[CodeableConcept]] = field(default_factory=list)
    material: Optional[List[DeviceDefinitionMaterial]] = field(default_factory=list)
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    quantity: Optional[Quantity] = None
    version: Optional[List[str]] = field(default_factory=list)
    contact: Optional[List[ContactPoint]] = field(default_factory=list)
    owner: Optional[Reference] = None
    online_information: Optional[str] = None
    physical_characteristics: Optional[ProdCharacteristic] = None