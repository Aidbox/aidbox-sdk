from typing import Optional, List
from base import CodeableConcept
from base import Range
from base import Quantity
from base import Duration
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

class SpecimenDefinition_TypeTested_Handling(BackboneElement):
    instruction: Optional[str] = None
    max_duration: Optional[Duration] = None
    temperature_range: Optional[Range] = None
    temperature_qualifier: Optional[CodeableConcept] = None

class SpecimenDefinition_TypeTested_Container_Additive(BackboneElement):
    additive_reference: Optional[Reference] = None
    additive_codeable_concept: Optional[CodeableConcept] = None

class SpecimenDefinition_TypeTested_Container(BackboneElement):
    description: Optional[str] = None
    capacity: Optional[Quantity] = None
    minimum_volume_quantity: Optional[Quantity] = None
    type: Optional[CodeableConcept] = None
    cap: Optional[CodeableConcept] = None
    preparation: Optional[str] = None
    material: Optional[CodeableConcept] = None
    additive: Optional[List[SpecimenDefinition_TypeTested_Container_Additive]] = None
    minimum_volume_string: Optional[str] = None

class SpecimenDefinition_TypeTested(BackboneElement):
    type: Optional[CodeableConcept] = None
    handling: Optional[List[SpecimenDefinition_TypeTested_Handling]] = None
    container: Optional[SpecimenDefinition_TypeTested_Container] = None
    is_derived: Optional[bool] = None
    preference: str
    requirement: Optional[str] = None
    retention_time: Optional[Duration] = None
    rejection_criterion: Optional[List[CodeableConcept]] = None

class SpecimenDefinition(DomainResource):
    collection: Optional[List[CodeableConcept]] = None
    identifier: Optional[Identifier] = None
    time_aspect: Optional[str] = None
    type_tested: Optional[List[SpecimenDefinition_TypeTested]] = None
    type_collected: Optional[CodeableConcept] = None
    patient_preparation: Optional[List[CodeableConcept]] = None