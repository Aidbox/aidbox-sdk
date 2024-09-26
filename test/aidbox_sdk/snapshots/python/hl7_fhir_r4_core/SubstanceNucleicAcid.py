from typing import Optional, List
from dataclasses import dataclass, field
from base import Attachment
from base import CodeableConcept
from base import DomainResource
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class SubstanceNucleicAcidSubunitSugar(BackboneElement):
    name: Optional[str] = None
    identifier: Optional[Identifier] = None
    residue_site: Optional[str] = None

@dataclass(kw_only=True)
class SubstanceNucleicAcidSubunitLinkage(BackboneElement):
    name: Optional[str] = None
    identifier: Optional[Identifier] = None
    residue_site: Optional[str] = None
    connectivity: Optional[str] = None

@dataclass(kw_only=True)
class SubstanceNucleicAcidSubunit(BackboneElement):
    sugar: Optional[List[SubstanceNucleicAcidSubunitSugar]] = field(default_factory=list)
    length: Optional[int] = None
    linkage: Optional[List[SubstanceNucleicAcidSubunitLinkage]] = field(default_factory=list)
    subunit: Optional[int] = None
    sequence: Optional[str] = None
    five_prime: Optional[CodeableConcept] = None
    three_prime: Optional[CodeableConcept] = None
    sequence_attachment: Optional[Attachment] = None

@dataclass(kw_only=True)
class SubstanceNucleicAcid(DomainResource):
    subunit: Optional[List[SubstanceNucleicAcidSubunit]] = field(default_factory=list)
    sequence_type: Optional[CodeableConcept] = None
    number_of_subunits: Optional[int] = None
    area_of_hybridisation: Optional[str] = None
    oligo_nucleotide_type: Optional[CodeableConcept] = None