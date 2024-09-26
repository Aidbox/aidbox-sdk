from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import Quantity
from base import Duration
from base import DomainResource
from base import Ratio
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class MedicinalProductPharmaceuticalCharacteristics(BackboneElement):
    code: CodeableConcept
    status: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriod(BackboneElement):
    value: Quantity
    tissue: CodeableConcept
    supporting_information: Optional[str] = None

@dataclass(kw_only=True)
class MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpecies(BackboneElement):
    code: CodeableConcept
    withdrawal_period: Optional[List[MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriod]] = field(default_factory=list)

@dataclass(kw_only=True)
class MedicinalProductPharmaceuticalRouteOfAdministration(BackboneElement):
    code: CodeableConcept
    first_dose: Optional[Quantity] = None
    max_dose_per_day: Optional[Quantity] = None
    max_single_dose: Optional[Quantity] = None
    target_species: Optional[List[MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpecies]] = field(default_factory=list)
    max_treatment_period: Optional[Duration] = None
    max_dose_per_treatment_period: Optional[Ratio] = None

@dataclass(kw_only=True)
class MedicinalProductPharmaceutical(DomainResource):
    device: Optional[List[Reference]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    ingredient: Optional[List[Reference]] = field(default_factory=list)
    characteristics: Optional[List[MedicinalProductPharmaceuticalCharacteristics]] = field(default_factory=list)
    unit_of_presentation: Optional[CodeableConcept] = None
    administrable_dose_form: CodeableConcept
    route_of_administration: list[MedicinalProductPharmaceuticalRouteOfAdministration] = field(default_factory=list)