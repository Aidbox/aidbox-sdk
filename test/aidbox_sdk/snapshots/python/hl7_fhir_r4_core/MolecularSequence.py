from typing import Optional, List
from dataclasses import dataclass, field
from base import CodeableConcept
from base import Quantity
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class MolecularSequenceStructureVariantInner(BackboneElement):
    end: Optional[int] = None
    start: Optional[int] = None

@dataclass(kw_only=True)
class MolecularSequenceStructureVariantOuter(BackboneElement):
    end: Optional[int] = None
    start: Optional[int] = None

@dataclass(kw_only=True)
class MolecularSequenceStructureVariant(BackboneElement):
    exact: Optional[bool] = None
    inner: Optional[MolecularSequenceStructureVariantInner] = None
    outer: Optional[MolecularSequenceStructureVariantOuter] = None
    length: Optional[int] = None
    variant_type: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class MolecularSequenceRepository(BackboneElement):
    url: Optional[str] = None
    name: Optional[str] = None
    type: str
    dataset_id: Optional[str] = None
    readset_id: Optional[str] = None
    variantset_id: Optional[str] = None

@dataclass(kw_only=True)
class MolecularSequenceVariant(BackboneElement):
    end: Optional[int] = None
    cigar: Optional[str] = None
    start: Optional[int] = None
    observed_allele: Optional[str] = None
    variant_pointer: Optional[Reference] = None
    reference_allele: Optional[str] = None

@dataclass(kw_only=True)
class MolecularSequenceQualityRoc(BackboneElement):
    num_f_n: Optional[List[int]] = field(default_factory=list)
    num_f_p: Optional[List[int]] = field(default_factory=list)
    num_t_p: Optional[List[int]] = field(default_factory=list)
    score: Optional[List[int]] = field(default_factory=list)
    f_measure: Optional[List[float]] = field(default_factory=list)
    precision: Optional[List[float]] = field(default_factory=list)
    sensitivity: Optional[List[float]] = field(default_factory=list)

@dataclass(kw_only=True)
class MolecularSequenceQuality(BackboneElement):
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
    roc: Optional[MolecularSequenceQualityRoc] = None
    score: Optional[Quantity] = None
    end: Optional[int] = None
    standard_sequence: Optional[CodeableConcept] = None
    gt_f_p: Optional[float] = None

@dataclass(kw_only=True)
class MolecularSequenceReferenceSeq(BackboneElement):
    chromosome: Optional[CodeableConcept] = None
    reference_seq_id: Optional[CodeableConcept] = None
    window_end: Optional[int] = None
    strand: Optional[str] = None
    genome_build: Optional[str] = None
    orientation: Optional[str] = None
    reference_seq_pointer: Optional[Reference] = None
    reference_seq_string: Optional[str] = None
    window_start: Optional[int] = None

@dataclass(kw_only=True)
class MolecularSequence(DomainResource):
    patient: Optional[Reference] = None
    structure_variant: Optional[List[MolecularSequenceStructureVariant]] = field(default_factory=list)
    repository: Optional[List[MolecularSequenceRepository]] = field(default_factory=list)
    variant: Optional[List[MolecularSequenceVariant]] = field(default_factory=list)
    specimen: Optional[Reference] = None
    type: Optional[str] = None
    pointer: Optional[List[Reference]] = field(default_factory=list)
    observed_seq: Optional[str] = None
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    quality: Optional[List[MolecularSequenceQuality]] = field(default_factory=list)
    device: Optional[Reference] = None
    quantity: Optional[Quantity] = None
    coordinate_system: int
    reference_seq: Optional[MolecularSequenceReferenceSeq] = None
    performer: Optional[Reference] = None
    read_coverage: Optional[int] = None