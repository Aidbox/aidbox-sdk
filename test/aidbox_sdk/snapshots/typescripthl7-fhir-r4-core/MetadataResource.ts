import { UsageContext } from "./UsageContext";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { DomainResource } from "./DomainResource";

export type MetadataResource = DomainResource & {
    description?: string;
    date?: string;
    publisher?: string;
    jurisdiction?: CodeableConcept[];
    name?: string;
    useContext?: UsageContext[];
    experimental?: boolean;
    title?: string;
    status: string;
    url?: string;
    version?: string;
    contact?: ContactDetail[];
};