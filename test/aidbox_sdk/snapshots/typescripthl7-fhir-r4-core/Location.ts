import { Address } from "./Address";
import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { ContactPoint } from "./ContactPoint";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type LocationHoursOfOperation = BackboneElement & {
    allDay?: boolean;
    daysOfWeek?: string[];
    closingTime?: string;
    openingTime?: string;
};

export type LocationPosition = BackboneElement & {
    altitude?: number;
    latitude: number;
    longitude: number;
};

export type Location = DomainResource & {
    description?: string;
    address?: Address;
    managingOrganization?: Reference;
    name?: string;
    mode?: string;
    type?: CodeableConcept[];
    alias?: string[];
    status?: string;
    identifier?: Identifier[];
    hoursOfOperation?: LocationHoursOfOperation[];
    availabilityExceptions?: string;
    position?: LocationPosition;
    telecom?: ContactPoint[];
    operationalStatus?: Coding;
    partOf?: Reference;
    physicalType?: CodeableConcept;
    endpoint?: Reference[];
};