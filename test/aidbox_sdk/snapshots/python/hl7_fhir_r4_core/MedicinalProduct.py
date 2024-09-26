from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import MarketingStatus
from base import Coding
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class MedicinalProductManufacturingBusinessOperation(BackboneElement):
    regulator: Optional[Reference] = None
    manufacturer: Optional[List[Reference]] = field(default_factory=list)
    effective_date: Optional[str] = None
    operation_type: Optional[CodeableConcept] = None
    confidentiality_indicator: Optional[CodeableConcept] = None
    authorisation_reference_number: Optional[Identifier] = None

@dataclass(kw_only=True)
class MedicinalProductNameNamePart(BackboneElement):
    part: str
    type: Coding

@dataclass(kw_only=True)
class MedicinalProductNameCountryLanguage(BackboneElement):
    country: CodeableConcept
    language: CodeableConcept
    jurisdiction: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class MedicinalProductName(BackboneElement):
    name_part: Optional[List[MedicinalProductNameNamePart]] = field(default_factory=list)
    product_name: str
    country_language: Optional[List[MedicinalProductNameCountryLanguage]] = field(default_factory=list)

@dataclass(kw_only=True)
class MedicinalProductSpecialDesignation(BackboneElement):
    date: Optional[str] = None
    species: Optional[CodeableConcept] = None
    type: Optional[CodeableConcept] = None
    intended_use: Optional[CodeableConcept] = None
    status: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    indication_codeable_concept: Optional[CodeableConcept] = None
    indication_reference: Optional[Reference] = None

@dataclass(kw_only=True)
class MedicinalProduct(DomainResource):
    additional_monitoring_indicator: Optional[CodeableConcept] = None
    manufacturing_business_operation: Optional[List[MedicinalProductManufacturingBusinessOperation]] = field(default_factory=list)
    combined_pharmaceutical_dose_form: Optional[CodeableConcept] = None
    clinical_trial: Optional[List[Reference]] = field(default_factory=list)
    product_classification: Optional[List[CodeableConcept]] = field(default_factory=list)
    name: list[MedicinalProductName] = field(default_factory=list)
    master_file: Optional[List[Reference]] = field(default_factory=list)
    pharmaceutical_product: Optional[List[Reference]] = field(default_factory=list)
    type: Optional[CodeableConcept] = None
    marketing_status: Optional[List[MarketingStatus]] = field(default_factory=list)
    special_measures: Optional[List[str]] = field(default_factory=list)
    special_designation: Optional[List[MedicinalProductSpecialDesignation]] = field(default_factory=list)
    packaged_medicinal_product: Optional[List[Reference]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    cross_reference: Optional[List[Identifier]] = field(default_factory=list)
    attached_document: Optional[List[Reference]] = field(default_factory=list)
    domain: Optional[Coding] = None
    legal_status_of_supply: Optional[CodeableConcept] = None
    paediatric_use_indicator: Optional[CodeableConcept] = None
    contact: Optional[List[Reference]] = field(default_factory=list)