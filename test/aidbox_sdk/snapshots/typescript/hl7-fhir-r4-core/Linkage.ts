import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { BackboneElement } from "./BackboneElement";

export type LinkageItem = BackboneElement & {
    type: string;
    resource: Reference;
};

export type Linkage = DomainResource & {
    item: LinkageItem[];
    active?: boolean;
    author?: Reference;
};