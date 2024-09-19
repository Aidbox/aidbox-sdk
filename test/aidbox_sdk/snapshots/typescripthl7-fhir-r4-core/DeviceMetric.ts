import { CodeableConcept } from "./CodeableConcept";
import { Timing } from "./Timing";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type DeviceMetricCalibration = BackboneElement & {
    time?: string;
    type?: string;
    state?: string;
};

export type DeviceMetric = DomainResource & {
    category: string;
    measurementPeriod?: Timing;
    color?: string;
    parent?: Reference;
    unit?: CodeableConcept;
    type: CodeableConcept;
    source?: Reference;
    identifier?: Identifier[];
    calibration?: DeviceMetricCalibration[];
    operationalStatus?: string;
};