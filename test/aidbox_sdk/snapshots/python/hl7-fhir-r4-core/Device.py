from typing import Optional, List
from base import Annotation
from base import CodeableConcept
from base import ContactPoint
from base import Quantity
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

class Device_DeviceName(BackboneElement):
    name: str
    type: str

class Device_Property(BackboneElement):
    type: CodeableConcept
    value_code: Optional[List[CodeableConcept]] = None
    value_quantity: Optional[List[Quantity]] = None

class Device_Specialization(BackboneElement):
    version: Optional[str] = None
    system_type: CodeableConcept

class Device_Version(BackboneElement):
    type: Optional[CodeableConcept] = None
    value: str
    component: Optional[Identifier] = None

class Device_UdiCarrier(BackboneElement):
    issuer: Optional[str] = None
    entry_type: Optional[str] = None
    carrier_h_r_f: Optional[str] = None
    carrier_a_i_d_c: Optional[str] = None
    jurisdiction: Optional[str] = None
    device_identifier: Optional[str] = None

class Device(DomainResource):
    patient: Optional[Reference] = None
    definition: Optional[Reference] = None
    serial_number: Optional[str] = None
    parent: Optional[Reference] = None
    device_name: Optional[List[Device_DeviceName]] = None
    property: Optional[List[Device_Property]] = None
    part_number: Optional[str] = None
    model_number: Optional[str] = None
    type: Optional[CodeableConcept] = None
    status_reason: Optional[List[CodeableConcept]] = None
    specialization: Optional[List[Device_Specialization]] = None
    distinct_identifier: Optional[str] = None
    note: Optional[List[Annotation]] = None
    status: Optional[str] = None
    safety: Optional[List[CodeableConcept]] = None
    lot_number: Optional[str] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    manufacturer: Optional[str] = None
    version: Optional[List[Device_Version]] = None
    location: Optional[Reference] = None
    contact: Optional[List[ContactPoint]] = None
    manufacture_date: Optional[str] = None
    owner: Optional[Reference] = None
    expiration_date: Optional[str] = None
    udi_carrier: Optional[List[Device_UdiCarrier]] = None