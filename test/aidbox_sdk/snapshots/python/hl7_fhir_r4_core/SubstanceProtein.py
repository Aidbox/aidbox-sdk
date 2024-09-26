from typing import Optional, List
from dataclasses import dataclass, field
from base import Attachment
from base import CodeableConcept
from base import DomainResource
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class SubstanceProteinSubunit(BackboneElement):
    length: Optional[int] = None
    subunit: Optional[int] = None
    sequence: Optional[str] = None
    sequence_attachment: Optional[Attachment] = None
    c_terminal_modification: Optional[str] = None
    n_terminal_modification: Optional[str] = None
    c_terminal_modification_id: Optional[Identifier] = None
    n_terminal_modification_id: Optional[Identifier] = None

@dataclass(kw_only=True)
class SubstanceProtein(DomainResource):
    subunit: Optional[List[SubstanceProteinSubunit]] = field(default_factory=list)
    sequence_type: Optional[CodeableConcept] = None
    disulfide_linkage: Optional[List[str]] = field(default_factory=list)
    number_of_subunits: Optional[int] = None