import { UsageContext } from "./UsageContext";
import { ContactDetail } from "./ContactDetail";
import { DomainResource } from "./DomainResource";
import { BackboneElement } from "./BackboneElement";

export type CompartmentDefinitionResource = BackboneElement & {
    code: string;
    param?: string[];
    documentation?: string;
};

export type CompartmentDefinition = DomainResource & {
    description?: string;
    date?: string;
    publisher?: string;
    purpose?: string;
    name: string;
    useContext?: UsageContext[];
    experimental?: boolean;
    search: boolean;
    status: string;
    resource?: CompartmentDefinitionResource[];
    url: string;
    code: string;
    version?: string;
    contact?: ContactDetail[];
};