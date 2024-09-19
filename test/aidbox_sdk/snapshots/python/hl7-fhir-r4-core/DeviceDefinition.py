from pydantic import *
from typing import Optional, List
from ..base import *

class DeviceDefinition_DeviceName(BackboneElement):
    name: str
    type: str

class DeviceDefinition_Property(BackboneElement):
    type: CodeableConcept
    value_code: Optional[List[CodeableConcept]] = None
    value_quantity: Optional[List[Quantity]] = None

class DeviceDefinition_UdiDeviceIdentifier(BackboneElement):
    issuer: str
    jurisdiction: str
    device_identifier: str

class DeviceDefinition_Capability(BackboneElement):
    type: CodeableConcept
    description: Optional[List[CodeableConcept]] = None

class DeviceDefinition_Specialization(BackboneElement):
    version: Optional[str] = None
    system_type: str

class DeviceDefinition_Material(BackboneElement):
    alternate: Optional[bool] = None
    substance: CodeableConcept
    allergenic_indicator: Optional[bool] = None

class DeviceDefinition(DomainResource):
    device_name: Optional[List[DeviceDefinition_DeviceName]] = None
    shelf_life_storage: Optional[List[ProductShelfLife]] = None
    property: Optional[List[DeviceDefinition_Property]] = None
    manufacturer_string: Optional[str] = None
    model_number: Optional[str] = None
    udi_device_identifier: Optional[List[DeviceDefinition_UdiDeviceIdentifier]] = None
    type: Optional[CodeableConcept] = None
    manufacturer_reference: Optional[Reference] = None
    capability: Optional[List[DeviceDefinition_Capability]] = None
    specialization: Optional[List[DeviceDefinition_Specialization]] = None
    parent_device: Optional[Reference] = None
    note: Optional[List[Annotation]] = None
    language_code: Optional[List[CodeableConcept]] = None
    safety: Optional[List[CodeableConcept]] = None
    material: Optional[List[DeviceDefinition_Material]] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    quantity: Optional[Quantity] = None
    version: Optional[List[str]] = None
    contact: Optional[List[ContactPoint]] = None
    owner: Optional[Reference] = None
    online_information: Optional[str] = None
    physical_characteristics: Optional[ProdCharacteristic] = None