import { Annotation } from "./Annotation";
import { CodeableConcept } from "./CodeableConcept";
import { Range } from "./Range";
import { Quantity } from "./Quantity";
import { Duration } from "./Duration";
import { DomainResource } from "./DomainResource";
import { Ratio } from "./Ratio";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type GoalTarget = BackboneElement & {
    measure?: CodeableConcept;
    due?: string | Duration;
    detail?: Range | Quantity | number | string | Ratio | CodeableConcept | boolean;
};

export type Goal = DomainResource & {
    description: CodeableConcept;
    category?: CodeableConcept[];
    addresses?: Reference[];
    expressedBy?: Reference;
    start?: string | CodeableConcept;
    achievementStatus?: CodeableConcept;
    statusReason?: string;
    note?: Annotation[];
    priority?: CodeableConcept;
    outcomeCode?: CodeableConcept[];
    identifier?: Identifier[];
    statusDate?: string;
    target?: GoalTarget[];
    outcomeReference?: Reference[];
    subject: Reference;
    lifecycleStatus: string;
};