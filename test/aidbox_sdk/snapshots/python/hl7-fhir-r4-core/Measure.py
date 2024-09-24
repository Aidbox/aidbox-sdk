from typing import Optional, List
from base import UsageContext
from base import Period
from base import ContactDetail
from base import CodeableConcept
from base import Expression
from base import RelatedArtifact
from base import DomainResource
from base import Reference
from base import Identifier
from base import BackboneElement

class Measure_Group_Population(BackboneElement):
    code: Optional[CodeableConcept] = None
    criteria: Expression
    description: Optional[str] = None

class Measure_Group_Stratifier_Component(BackboneElement):
    code: Optional[CodeableConcept] = None
    criteria: Expression
    description: Optional[str] = None

class Measure_Group_Stratifier(BackboneElement):
    code: Optional[CodeableConcept] = None
    criteria: Optional[Expression] = None
    component: Optional[List[Measure_Group_Stratifier_Component]] = None
    description: Optional[str] = None

class Measure_Group(BackboneElement):
    code: Optional[CodeableConcept] = None
    population: Optional[List[Measure_Group_Population]] = None
    stratifier: Optional[List[Measure_Group_Stratifier]] = None
    description: Optional[str] = None

class Measure_SupplementalData(BackboneElement):
    code: Optional[CodeableConcept] = None
    usage: Optional[List[CodeableConcept]] = None
    criteria: Expression
    description: Optional[str] = None

class Measure(DomainResource):
    description: Optional[str] = None
    definition: Optional[List[str]] = None
    date: Optional[str] = None
    group: Optional[List[Measure_Group]] = None
    endorser: Optional[List[ContactDetail]] = None
    publisher: Optional[str] = None
    approval_date: Optional[str] = None
    composite_scoring: Optional[CodeableConcept] = None
    disclaimer: Optional[str] = None
    jurisdiction: Optional[List[CodeableConcept]] = None
    purpose: Optional[str] = None
    subject_codeable_concept: Optional[CodeableConcept] = None
    name: Optional[str] = None
    use_context: Optional[List[UsageContext]] = None
    copyright: Optional[str] = None
    guidance: Optional[str] = None
    type: Optional[List[CodeableConcept]] = None
    experimental: Optional[bool] = None
    topic: Optional[List[CodeableConcept]] = None
    title: Optional[str] = None
    supplemental_data: Optional[List[Measure_SupplementalData]] = None
    library: Optional[List[str]] = None
    author: Optional[List[ContactDetail]] = None
    usage: Optional[str] = None
    rationale: Optional[str] = None
    status: str
    subtitle: Optional[str] = None
    url: Optional[str] = None
    identifier: Optional[List[Identifier]] = None
    last_review_date: Optional[str] = None
    editor: Optional[List[ContactDetail]] = None
    risk_adjustment: Optional[str] = None
    scoring: Optional[CodeableConcept] = None
    reviewer: Optional[List[ContactDetail]] = None
    version: Optional[str] = None
    related_artifact: Optional[List[RelatedArtifact]] = None
    contact: Optional[List[ContactDetail]] = None
    subject_reference: Optional[Reference] = None
    improvement_notation: Optional[CodeableConcept] = None
    rate_aggregation: Optional[str] = None
    effective_period: Optional[Period] = None
    clinical_recommendation_statement: Optional[str] = None