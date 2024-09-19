import { Address } from "./Address";
import { UsageContext } from "./UsageContext";
import { Annotation } from "./Annotation";
import { Age } from "./Age";
import { Attachment } from "./Attachment";
import { Period } from "./Period";
import { ContactDetail } from "./ContactDetail";
import { DataRequirement } from "./DataRequirement";
import { CodeableConcept } from "./CodeableConcept";
import { TriggerDefinition } from "./TriggerDefinition";
import { Count } from "./Count";
import { Expression } from "./Expression";
import { Coding } from "./Coding";
import { Dosage } from "./Dosage";
import { Range } from "./Range";
import { ContactPoint } from "./ContactPoint";
import { Signature } from "./Signature";
import { RelatedArtifact } from "./RelatedArtifact";
import { Timing } from "./Timing";
import { Meta } from "./Meta";
import { Quantity } from "./Quantity";
import { Distance } from "./Distance";
import { HumanName } from "./HumanName";
import { Duration } from "./Duration";
import { DomainResource } from "./DomainResource";
import { Money } from "./Money";
import { SampledData } from "./SampledData";
import { Ratio } from "./Ratio";
import { ParameterDefinition } from "./ParameterDefinition";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";
import { Contributor } from "./Contributor";

export type TaskRestriction = BackboneElement & {
    period?: Period;
    recipient?: Reference[];
    repetitions?: number;
};

export type TaskOutput = BackboneElement & {
    value?: string | Age | ParameterDefinition | Timing | Reference | Contributor | ContactDetail | UsageContext | number | Identifier | TriggerDefinition | Quantity | Count | Ratio | boolean | Duration | DataRequirement | Meta | Money | Coding | Expression | SampledData | Dosage | ContactPoint | CodeableConcept | Annotation | Period | Distance | Range | Signature | HumanName | Attachment | Address | RelatedArtifact;
    type: CodeableConcept;
};

export type TaskInput = BackboneElement & {
    value?: string | Age | ParameterDefinition | Timing | Reference | Contributor | ContactDetail | UsageContext | number | Identifier | TriggerDefinition | Quantity | Count | Ratio | boolean | Duration | DataRequirement | Meta | Money | Coding | Expression | SampledData | Dosage | ContactPoint | CodeableConcept | Annotation | Period | Distance | Range | Signature | HumanName | Attachment | Address | RelatedArtifact;
    type: CodeableConcept;
};

export type Task = DomainResource & {
    restriction?: TaskRestriction;
    description?: string;
    performerType?: CodeableConcept[];
    executionPeriod?: Period;
    insurance?: Reference[];
    instantiatesCanonical?: string;
    instantiatesUri?: string;
    relevantHistory?: Reference[];
    encounter?: Reference;
    reasonCode?: CodeableConcept;
    statusReason?: CodeableConcept;
    authoredOn?: string;
    output?: TaskOutput[];
    businessStatus?: CodeableConcept;
    note?: Annotation[];
    for_?: Reference;
    requester?: Reference;
    lastModified?: string;
    priority?: string;
    status: string;
    groupIdentifier?: Identifier;
    code?: CodeableConcept;
    identifier?: Identifier[];
    intent: string;
    focus?: Reference;
    input?: TaskInput[];
    basedOn?: Reference[];
    partOf?: Reference[];
    location?: Reference;
    owner?: Reference;
    reasonReference?: Reference;
};