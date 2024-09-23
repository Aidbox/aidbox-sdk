from typing import Optional, List
from pydantic import *
from ..base.CodeableConcept import CodeableConcept
from ..base.Range import Range
from ..base.Quantity import Quantity
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class SubstanceReferenceInformation_Gene(BackboneElement):
    gene: Optional[CodeableConcept] = None
    source: Optional[List[Reference]] = None
    gene_sequence_origin: Optional[CodeableConcept] = None

class SubstanceReferenceInformation_Target(BackboneElement):
    organism: Optional[CodeableConcept] = None
    organism_type: Optional[CodeableConcept] = None
    amount_type: Optional[CodeableConcept] = None
    type: Optional[CodeableConcept] = None
    interaction: Optional[CodeableConcept] = None
    source: Optional[List[Reference]] = None
    amount_quantity: Optional[Quantity] = None
    amount_string: Optional[str] = None
    target: Optional[Identifier] = None
    amount_range: Optional[Range] = None

class SubstanceReferenceInformation_GeneElement(BackboneElement):
    type: Optional[CodeableConcept] = None
    source: Optional[List[Reference]] = None
    element: Optional[Identifier] = None

class SubstanceReferenceInformation_Classification(BackboneElement):
    domain: Optional[CodeableConcept] = None
    source: Optional[List[Reference]] = None
    subtype: Optional[List[CodeableConcept]] = None
    classification: Optional[CodeableConcept] = None

class SubstanceReferenceInformation(DomainResource):
    gene: Optional[List[SubstanceReferenceInformation_Gene]] = None
    target: Optional[List[SubstanceReferenceInformation_Target]] = None
    comment: Optional[str] = None
    gene_element: Optional[List[SubstanceReferenceInformation_GeneElement]] = None
    classification: Optional[List[SubstanceReferenceInformation_Classification]] = None