from typing import Optional, List
from pydantic import *
from ..base.CodeableConcept import CodeableConcept
from ..base.Quantity import Quantity
from ..base.DomainResource import DomainResource
from ..base.Reference import Reference
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class MolecularSequence_StructureVariant_Inner(BackboneElement):
    end: Optional[int] = None
    start: Optional[int] = None

class MolecularSequence_StructureVariant_Outer(BackboneElement):
    end: Optional[int] = None
    start: Optional[int] = None

class MolecularSequence_StructureVariant(BackboneElement):
    exact: Optional[bool] = None
    inner: Optional[MolecularSequence_StructureVariant_Inner] = None
    outer: Optional[MolecularSequence_StructureVariant_Outer] = None
    length: Optional[int] = None
    variant_type: Optional[CodeableConcept] = None

class MolecularSequence_Repository(BackboneElement):
    url: Optional[str] = None
    name: Optional[str] = None
    type: str
    dataset_id: Optional[str] = None
    readset_id: Optional[str] = None
    variantset_id: Optional[str] = None

class MolecularSequence_Variant(BackboneElement):
    end: Optional[int] = None
    cigar: Optional[str] = None
    start: Optional[int] = None
    observed_allele: Optional[str] = None
    variant_pointer: Optional[Reference] = None
    reference_allele: Optional[str] = None

class MolecularSequence_Quality_Roc(BackboneElement):
    num_f_n: Optional[List[int]] = None
    num_f_p: Optional[List[int]] = None
    num_t_p: Optional[List[int]] = None
    score: Optional[List[int]] = None
    f_measure: Optional[List[float]] = None
    precision: Optional[List[float]] = None
    sensitivity: Optional[List[float]] = None

class MolecularSequence_Quality(BackboneElement):
    truth_t_p: Optional[float] = None
    f_score: Optional[float] = None
    truth_f_n: Optional[float] = None
    query_f_p: Optional[float] = None
    method: Optional[CodeableConcept] = None
    precision: Optional[float] = None
    start: Optional[int] = None
    query_t_p: Optional[float] = None
    type: str
    recall: Optional[float] = None
    roc: Optional[MolecularSequence_Quality_Roc] = None
    score: Optional[Quantity] = None
    end: Optional[int] = None
    standard_sequence: Optional[CodeableConcept] = None
    gt_f_p: Optional[float] = None

class MolecularSequence_ReferenceSeq(BackboneElement):
    chromosome: Optional[CodeableConcept] = None
    reference_seq_id: Optional[CodeableConcept] = None
    window_end: Optional[int] = None
    strand: Optional[str] = None
    genome_build: Optional[str] = None
    orientation: Optional[str] = None
    reference_seq_pointer: Optional[Reference] = None
    reference_seq_string: Optional[str] = None
    window_start: Optional[int] = None

class MolecularSequence(DomainResource):
    patient: Optional[Reference] = None
    structure_variant: Optional[List[MolecularSequence_StructureVariant]] = None
    repository: Optional[List[MolecularSequence_Repository]] = None
    variant: Optional[List[MolecularSequence_Variant]] = None
    specimen: Optional[Reference] = None
    type: Optional[str] = None
    pointer: Optional[List[Reference]] = None
    observed_seq: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    quality: Optional[List[MolecularSequence_Quality]] = None
    device: Optional[Reference] = None
    quantity: Optional[Quantity] = None
    coordinate_system: int
    reference_seq: Optional[MolecularSequence_ReferenceSeq] = None
    performer: Optional[Reference] = None
    read_coverage: Optional[int] = None