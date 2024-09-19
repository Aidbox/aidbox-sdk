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

export type StructureMapGroupRuleSource = BackboneElement & {
    min?: number;
    variable?: string;
    element?: string;
    check?: string;
    type?: string;
    logMessage?: string;
    max?: string;
    condition?: string;
    context: string;
    listMode?: string;
    defaultValue?: string | DataRequirement | Money | ContactPoint | Meta | Coding | SampledData | HumanName | Duration | number | Quantity | Count | ContactDetail | boolean | Period | TriggerDefinition | Reference | Dosage | Range | Attachment | Distance | Contributor | Ratio | Expression | Signature | Annotation | Address | Age | UsageContext | ParameterDefinition | Timing | RelatedArtifact | Identifier | CodeableConcept;
};

export type StructureMapGroupRuleTargetParameter = BackboneElement & {
    value?: string | boolean | number;
};

export type StructureMapGroupRuleTarget = BackboneElement & {
    context?: string;
    element?: string;
    listMode?: string[];
    variable?: string;
    parameter?: StructureMapGroupRuleTargetParameter[];
    transform?: string;
    listRuleId?: string;
    contextType?: string;
};

export type StructureMapGroupRuleDependent = BackboneElement & {
    name: string;
    variable: string[];
};

export type StructureMapGroupRule = BackboneElement & {
    name: string;
    rule?: Reference[];
    source: StructureMapGroupRuleSource[];
    target?: StructureMapGroupRuleTarget[];
    dependent?: StructureMapGroupRuleDependent[];
    documentation?: string;
};

export type StructureMapGroupInput = BackboneElement & {
    mode: string;
    name: string;
    type?: string;
    documentation?: string;
};

export type StructureMapGroup = BackboneElement & {
    name: string;
    rule: StructureMapGroupRule[];
    input: StructureMapGroupInput[];
    extends?: string;
    typeMode: string;
    documentation?: string;
};

export type StructureMapStructure = BackboneElement & {
    url: string;
    mode: string;
    alias?: string;
    documentation?: string;
};

export type StructureMap = DomainResource & {
    description?: string;
    date?: string;
    group: StructureMapGroup[];
    publisher?: string;
    jurisdiction?: CodeableConcept[];
    purpose?: string;
    name: string;
    useContext?: UsageContext[];
    copyright?: string;
    experimental?: boolean;
    title?: string;
    structure?: StructureMapStructure[];
    status: string;
    url: string;
    identifier?: Identifier[];
    version?: string;
    import_?: string[];
    contact?: ContactDetail[];
};