import { CodeableConcept } from "./CodeableConcept";
import { Range } from "./Range";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type ObservationDefinitionQuantitativeDetails = BackboneElement & {
    unit?: CodeableConcept;
    customaryUnit?: CodeableConcept;
    conversionFactor?: number;
    decimalPrecision?: number;
};

export type ObservationDefinitionQualifiedInterval = BackboneElement & {
    age?: Range;
    range?: Range;
    gender?: string;
    context?: CodeableConcept;
    category?: string;
    appliesTo?: CodeableConcept[];
    condition?: string;
    gestationalAge?: Range;
};

export type ObservationDefinition = DomainResource & {
    quantitativeDetails?: ObservationDefinitionQuantitativeDetails;
    category?: CodeableConcept[];
    method?: CodeableConcept;
    validCodedValueSet?: Reference;
    qualifiedInterval?: ObservationDefinitionQualifiedInterval[];
    abnormalCodedValueSet?: Reference;
    code: CodeableConcept;
    identifier?: Identifier[];
    permittedDataType?: string[];
    multipleResultsAllowed?: boolean;
    normalCodedValueSet?: Reference;
    preferredReportName?: string;
    criticalCodedValueSet?: Reference;
};