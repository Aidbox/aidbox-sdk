from typing import Optional, List
from pydantic import *
from ..base.Attachment import Attachment
from ..base.CodeableConcept import CodeableConcept
from ..base.DomainResource import DomainResource
from ..base.Identifier import Identifier
from ..base.BackboneElement import BackboneElement

class SubstanceProtein_Subunit(BackboneElement):
    length: Optional[int] = None
    subunit: Optional[int] = None
    sequence: Optional[str] = None
    sequence_attachment: Optional[Attachment] = None
    c_terminal_modification: Optional[str] = None
    n_terminal_modification: Optional[str] = None
    c_terminal_modification_id: Optional[Identifier] = None
    n_terminal_modification_id: Optional[Identifier] = None

class SubstanceProtein(DomainResource):
    subunit: Optional[List[SubstanceProtein_Subunit]] = None
    sequence_type: Optional[CodeableConcept] = None
    disulfide_linkage: Optional[List[str]] = None
    number_of_subunits: Optional[int] = None