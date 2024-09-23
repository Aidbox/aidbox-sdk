from typing import Optional, List
from pydantic import *
from ..base.CodeableConcept import CodeableConcept
from ..base.Quantity import Quantity
from ..base.Duration import Duration
from ..base.DomainResource import DomainResource
from ..base.Ratio import Ratio
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class MedicinalProductPharmaceutical_Characteristics(BackboneElement):
    code: CodeableConcept
    status: Optional[CodeableConcept] = None

class MedicinalProductPharmaceutical_RouteOfAdministration_TargetSpecies_WithdrawalPeriod(BackboneElement):
    value: Quantity
    tissue: CodeableConcept
    supporting_information: Optional[str] = None

class MedicinalProductPharmaceutical_RouteOfAdministration_TargetSpecies(BackboneElement):
    code: CodeableConcept
    withdrawal_period: Optional[List[MedicinalProductPharmaceutical_RouteOfAdministration_TargetSpecies_WithdrawalPeriod]] = None

class MedicinalProductPharmaceutical_RouteOfAdministration(BackboneElement):
    code: CodeableConcept
    first_dose: Optional[Quantity] = None
    max_dose_per_day: Optional[Quantity] = None
    max_single_dose: Optional[Quantity] = None
    target_species: Optional[List[MedicinalProductPharmaceutical_RouteOfAdministration_TargetSpecies]] = None
    max_treatment_period: Optional[Duration] = None
    max_dose_per_treatment_period: Optional[Ratio] = None

class MedicinalProductPharmaceutical(DomainResource):
    device: Optional[List[Reference]] = None
    identifier: Optional[List[Identifier]] = None
    ingredient: Optional[List[Reference]] = None
    characteristics: Optional[List[MedicinalProductPharmaceutical_Characteristics]] = None
    unit_of_presentation: Optional[CodeableConcept] = None
    administrable_dose_form: CodeableConcept
    route_of_administration: list[MedicinalProductPharmaceutical_RouteOfAdministration] = []