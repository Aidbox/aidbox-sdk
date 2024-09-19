import { ContactPoint } from "./ContactPoint";
import { DomainResource } from "./DomainResource";
import { BackboneElement } from "./BackboneElement";

export type SubscriptionChannel = BackboneElement & {
    type: string;
    header?: string[];
    payload?: string;
    endpoint?: string;
};

export type Subscription = DomainResource & {
    end?: string;
    error?: string;
    reason: string;
    status: string;
    channel: SubscriptionChannel;
    contact?: ContactPoint[];
    criteria: string;
};