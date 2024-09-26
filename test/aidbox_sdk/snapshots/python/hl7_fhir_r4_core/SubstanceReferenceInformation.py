from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import Range
from base import Quantity
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class SubstanceReferenceInformationGene(BackboneElement):
    gene: Optional[CodeableConcept] = None
    source: Optional[List[Reference]] = field(default_factory=list)
    gene_sequence_origin: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class SubstanceReferenceInformationTarget(BackboneElement):
    organism: Optional[CodeableConcept] = None
    organism_type: Optional[CodeableConcept] = None
    amount_type: Optional[CodeableConcept] = None
    type: Optional[CodeableConcept] = None
    interaction: Optional[CodeableConcept] = None
    source: Optional[List[Reference]] = field(default_factory=list)
    amount_quantity: Optional[Quantity] = None
    amount_string: Optional[str] = None
    target: Optional[Identifier] = None
    amount_range: Optional[Range] = None

@dataclass(kw_only=True)
class SubstanceReferenceInformationGeneElement(BackboneElement):
    type: Optional[CodeableConcept] = None
    source: Optional[List[Reference]] = field(default_factory=list)
    element: Optional[Identifier] = None

@dataclass(kw_only=True)
class SubstanceReferenceInformationClassification(BackboneElement):
    domain: Optional[CodeableConcept] = None
    source: Optional[List[Reference]] = field(default_factory=list)
    subtype: Optional[List[CodeableConcept]] = field(default_factory=list)
    classification: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class SubstanceReferenceInformation(DomainResource):
    gene: Optional[List[SubstanceReferenceInformationGene]] = field(default_factory=list)
    target: Optional[List[SubstanceReferenceInformationTarget]] = field(default_factory=list)
    comment: Optional[str] = None
    gene_element: Optional[List[SubstanceReferenceInformationGeneElement]] = field(default_factory=list)
    classification: Optional[List[SubstanceReferenceInformationClassification]] = field(default_factory=list)