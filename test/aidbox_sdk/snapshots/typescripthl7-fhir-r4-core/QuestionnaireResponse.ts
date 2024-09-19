import { Attachment } from "./Attachment";
import { Coding } from "./Coding";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type QuestionnaireResponseItemAnswer = BackboneElement & {
    value?: Reference | string | number | Quantity | boolean | Coding | Attachment;
    item?: Reference[];
};

export type QuestionnaireResponseItem = BackboneElement & {
    item?: Reference[];
    text?: string;
    answer?: QuestionnaireResponseItemAnswer[];
    linkId: string;
    definition?: string;
};

export type QuestionnaireResponse = DomainResource & {
    questionnaire?: string;
    encounter?: Reference;
    item?: QuestionnaireResponseItem[];
    source?: Reference;
    author?: Reference;
    status: string;
    identifier?: Identifier;
    basedOn?: Reference[];
    authored?: string;
    partOf?: Reference[];
    subject?: Reference;
};