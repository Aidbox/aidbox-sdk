from typing import Optional, List
from pydantic import *
from base.CodeableConcept import CodeableConcept
from base.MarketingStatus import MarketingStatus
from base.Coding import Coding
from base.DomainResource import DomainResource
from base.Reference import Reference
from base.Identifier import Identifier
from base.BackboneElement import BackboneElement

class MedicinalProduct_ManufacturingBusinessOperation(BackboneElement):
    regulator: Optional[Reference] = None
    manufacturer: Optional[List[Reference]] = None
    effective_date: Optional[str] = None
    operation_type: Optional[CodeableConcept] = None
    confidentiality_indicator: Optional[CodeableConcept] = None
    authorisation_reference_number: Optional[Identifier] = None

class MedicinalProduct_Name_NamePart(BackboneElement):
    part: str
    type: Coding

class MedicinalProduct_Name_CountryLanguage(BackboneElement):
    country: CodeableConcept
    language: CodeableConcept
    jurisdiction: Optional[CodeableConcept] = None

class MedicinalProduct_Name(BackboneElement):
    name_part: Optional[List[MedicinalProduct_Name_NamePart]] = None
    product_name: str
    country_language: Optional[List[MedicinalProduct_Name_CountryLanguage]] = None

class MedicinalProduct_SpecialDesignation(BackboneElement):
    date: Optional[str] = None
    species: Optional[CodeableConcept] = None
    type: Optional[CodeableConcept] = None
    intended_use: Optional[CodeableConcept] = None
    status: Optional[CodeableConcept] = None
    identifier: Optional[List[Identifier]] = None
    indication_codeable_concept: Optional[CodeableConcept] = None
    indication_reference: Optional[Reference] = None

class MedicinalProduct(DomainResource):
    additional_monitoring_indicator: Optional[CodeableConcept] = None
    manufacturing_business_operation: Optional[List[MedicinalProduct_ManufacturingBusinessOperation]] = None
    combined_pharmaceutical_dose_form: Optional[CodeableConcept] = None
    clinical_trial: Optional[List[Reference]] = None
    product_classification: Optional[List[CodeableConcept]] = None
    name: list[MedicinalProduct_Name] = []
    master_file: Optional[List[Reference]] = None
    pharmaceutical_product: Optional[List[Reference]] = None
    type: Optional[CodeableConcept] = None
    marketing_status: Optional[List[MarketingStatus]] = None
    special_measures: Optional[List[str]] = None
    special_designation: Optional[List[MedicinalProduct_SpecialDesignation]] = None
    packaged_medicinal_product: Optional[List[Reference]] = None
    identifier: Optional[List[Identifier]] = None
    cross_reference: Optional[List[Identifier]] = None
    attached_document: Optional[List[Reference]] = None
    domain: Optional[Coding] = None
    legal_status_of_supply: Optional[CodeableConcept] = None
    paediatric_use_indicator: Optional[CodeableConcept] = None
    contact: Optional[List[Reference]] = None