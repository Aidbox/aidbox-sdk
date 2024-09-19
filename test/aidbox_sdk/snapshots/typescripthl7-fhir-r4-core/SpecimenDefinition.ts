import { CodeableConcept } from "./CodeableConcept";
import { Range } from "./Range";
import { Quantity } from "./Quantity";
import { Duration } from "./Duration";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type SpecimenDefinitionTypeTestedHandling = BackboneElement & {
    instruction?: string;
    maxDuration?: Duration;
    temperatureRange?: Range;
    temperatureQualifier?: CodeableConcept;
};

export type SpecimenDefinitionTypeTestedContainerAdditive = BackboneElement & {
    additive?: Reference | CodeableConcept;
};

export type SpecimenDefinitionTypeTestedContainer = BackboneElement & {
    description?: string;
    capacity?: Quantity;
    type?: CodeableConcept;
    cap?: CodeableConcept;
    preparation?: string;
    minimumVolume?: Quantity | string;
    material?: CodeableConcept;
    additive?: SpecimenDefinitionTypeTestedContainerAdditive[];
};

export type SpecimenDefinitionTypeTested = BackboneElement & {
    type?: CodeableConcept;
    handling?: SpecimenDefinitionTypeTestedHandling[];
    container?: SpecimenDefinitionTypeTestedContainer;
    isDerived?: boolean;
    preference: string;
    requirement?: string;
    retentionTime?: Duration;
    rejectionCriterion?: CodeableConcept[];
};

export type SpecimenDefinition = DomainResource & {
    collection?: CodeableConcept[];
    identifier?: Identifier;
    timeAspect?: string;
    typeTested?: SpecimenDefinitionTypeTested[];
    typeCollected?: CodeableConcept;
    patientPreparation?: CodeableConcept[];
};