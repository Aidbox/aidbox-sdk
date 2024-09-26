from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import CodeableConcept
from base import ContactPoint
from base import Quantity
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class DeviceDeviceName(BackboneElement):
    name: str
    type: str

@dataclass(kw_only=True)
class DeviceProperty(BackboneElement):
    type: CodeableConcept
    value_code: Optional[List[CodeableConcept]] = field(default_factory=list)
    value_quantity: Optional[List[Quantity]] = field(default_factory=list)

@dataclass(kw_only=True)
class DeviceSpecialization(BackboneElement):
    version: Optional[str] = None
    system_type: CodeableConcept

@dataclass(kw_only=True)
class DeviceVersion(BackboneElement):
    type: Optional[CodeableConcept] = None
    value: str
    component: Optional[Identifier] = None

@dataclass(kw_only=True)
class DeviceUdiCarrier(BackboneElement):
    issuer: Optional[str] = None
    entry_type: Optional[str] = None
    carrier_h_r_f: Optional[str] = None
    carrier_a_i_d_c: Optional[str] = None
    jurisdiction: Optional[str] = None
    device_identifier: Optional[str] = None

@dataclass(kw_only=True)
class Device(DomainResource):
    patient: Optional[Reference] = None
    definition: Optional[Reference] = None
    serial_number: Optional[str] = None
    parent: Optional[Reference] = None
    device_name: Optional[List[DeviceDeviceName]] = field(default_factory=list)
    property: Optional[List[DeviceProperty]] = field(default_factory=list)
    part_number: Optional[str] = None
    model_number: Optional[str] = None
    type: Optional[CodeableConcept] = None
    status_reason: Optional[List[CodeableConcept]] = field(default_factory=list)
    specialization: Optional[List[DeviceSpecialization]] = field(default_factory=list)
    distinct_identifier: Optional[str] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    status: Optional[str] = None
    safety: Optional[List[CodeableConcept]] = field(default_factory=list)
    lot_number: Optional[str] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    manufacturer: Optional[str] = None
    version: Optional[List[DeviceVersion]] = field(default_factory=list)
    location: Optional[Reference] = None
    contact: Optional[List[ContactPoint]] = field(default_factory=list)
    manufacture_date: Optional[str] = None
    owner: Optional[Reference] = None
    expiration_date: Optional[str] = None
    udi_carrier: Optional[List[DeviceUdiCarrier]] = field(default_factory=list)