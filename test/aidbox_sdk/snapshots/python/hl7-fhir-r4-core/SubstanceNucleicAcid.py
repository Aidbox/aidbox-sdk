from typing import Optional, List
from pydantic import *
from ..base.Attachment import Attachment
from ..base.CodeableConcept import CodeableConcept
from ..base.DomainResource import DomainResource
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class SubstanceNucleicAcid_Subunit_Sugar(BackboneElement):
    name: Optional[str] = None
    identifier: Optional[Identifier] = None
    residue_site: Optional[str] = None

class SubstanceNucleicAcid_Subunit_Linkage(BackboneElement):
    name: Optional[str] = None
    identifier: Optional[Identifier] = None
    residue_site: Optional[str] = None
    connectivity: Optional[str] = None

class SubstanceNucleicAcid_Subunit(BackboneElement):
    sugar: Optional[List[SubstanceNucleicAcid_Subunit_Sugar]] = None
    length: Optional[int] = None
    linkage: Optional[List[SubstanceNucleicAcid_Subunit_Linkage]] = None
    subunit: Optional[int] = None
    sequence: Optional[str] = None
    five_prime: Optional[CodeableConcept] = None
    three_prime: Optional[CodeableConcept] = None
    sequence_attachment: Optional[Attachment] = None

class SubstanceNucleicAcid(DomainResource):
    subunit: Optional[List[SubstanceNucleicAcid_Subunit]] = None
    sequence_type: Optional[CodeableConcept] = None
    number_of_subunits: Optional[int] = None
    area_of_hybridisation: Optional[str] = None
    oligo_nucleotide_type: Optional[CodeableConcept] = None