from typing import Optional, List
from dataclasses import dataclass, field
from base import Annotation
from base import Period
from base import ContactDetail
from base import CodeableConcept
from base import RelatedArtifact
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

@dataclass(kw_only=True)
class ResearchStudyArm(BackboneElement):
    name: str
    type: Optional[CodeableConcept] = None
    description: Optional[str] = None

@dataclass(kw_only=True)
class ResearchStudyObjective(BackboneElement):
    name: Optional[str] = None
    type: Optional[CodeableConcept] = None

@dataclass(kw_only=True)
class ResearchStudy(DomainResource):
    description: Optional[str] = None
    category: Optional[List[CodeableConcept]] = field(default_factory=list)
    enrollment: Optional[List[Reference]] = field(default_factory=list)
    arm: Optional[List[ResearchStudyArm]] = field(default_factory=list)
    site: Optional[List[Reference]] = field(default_factory=list)
    protocol: Optional[List[Reference]] = field(default_factory=list)
    principal_investigator: Optional[Reference] = None
    phase: Optional[CodeableConcept] = None
    reason_stopped: Optional[CodeableConcept] = None
    title: Optional[str] = None
    note: Optional[List[Annotation]] = field(default_factory=list)
    keyword: Optional[List[CodeableConcept]] = field(default_factory=list)
    status: str
    condition: Optional[List[CodeableConcept]] = field(default_factory=list)
    identifier: Optional[List[Identifier]] = field(default_factory=list)
    primary_purpose_type: Optional[CodeableConcept] = None
    focus: Optional[List[CodeableConcept]] = field(default_factory=list)
    objective: Optional[List[ResearchStudyObjective]] = field(default_factory=list)
    period: Optional[Period] = None
    part_of: Optional[List[Reference]] = field(default_factory=list)
    related_artifact: Optional[List[RelatedArtifact]] = field(default_factory=list)
    location: Optional[List[CodeableConcept]] = field(default_factory=list)
    contact: Optional[List[ContactDetail]] = field(default_factory=list)
    sponsor: Optional[Reference] = None