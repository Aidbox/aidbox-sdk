from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import Range
from base import Quantity
from base import Duration
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class SpecimenDefinitionTypeTestedHandling(BackboneElement):
    instruction: Optional[str] = None
    max_duration: Optional[Duration] = None
    temperature_range: Optional[Range] = None
    temperature_qualifier: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class SpecimenDefinitionTypeTestedContainerAdditive(BackboneElement):
    additive_reference: Optional[Reference] = None
    additive_codeable_concept: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class SpecimenDefinitionTypeTestedContainer(BackboneElement):
    description: Optional[str] = None
    capacity: Optional[Quantity] = None
    minimum_volume_quantity: Optional[Quantity] = None
    type: Optional[CodeableConcept] = None
    cap: Optional[CodeableConcept] = None
    preparation: Optional[str] = None
    material: Optional[CodeableConcept] = None
    additive: Optional[List[SpecimenDefinitionTypeTestedContainerAdditive]] = field(default_factory=list)
    minimum_volume_string: Optional[str] = None

@dataclass(kw_only=True)
class SpecimenDefinitionTypeTested(BackboneElement):
    type: Optional[CodeableConcept] = None
    handling: Optional[List[SpecimenDefinitionTypeTestedHandling]] = field(default_factory=list)
    container: Optional[SpecimenDefinitionTypeTestedContainer] = None
    is_derived: Optional[bool] = None
    preference: str
    requirement: Optional[str] = None
    retention_time: Optional[Duration] = None
    rejection_criterion: Optional[List[CodeableConcept]] = field(default_factory=list)

@dataclass(kw_only=True)
class SpecimenDefinition(DomainResource):
    collection: Optional[List[CodeableConcept]] = field(default_factory=list)
    identifier: Optional[Identifier] = None
    time_aspect: Optional[str] = None
    type_tested: Optional[List[SpecimenDefinitionTypeTested]] = field(default_factory=list)
    type_collected: Optional[CodeableConcept] = None
    patient_preparation: Optional[List[CodeableConcept]] = field(default_factory=list)