import { UsageContext } from "./UsageContext";
import { Period } from "./Period";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";
import { BackboneElement } from "./BackboneElement";

export type NamingSystemUniqueId = BackboneElement & {
    type: string;
    value: string;
    period?: Period;
    comment?: string;
    preferred?: boolean;
};

export type NamingSystem = DomainResource & {
    description?: string;
    date: string;
    publisher?: string;
    jurisdiction?: CodeableConcept[];
    name: string;
    useContext?: UsageContext[];
    type?: CodeableConcept;
    responsible?: string;
    usage?: string;
    status: string;
    kind: string;
    uniqueId: NamingSystemUniqueId[];
    contact?: ContactDetail[];
};