import { UsageContext } from "./UsageContext";
import { Attachment } from "./Attachment";
import { Period } from "./Period";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type QuestionnaireItemEnableWhen = BackboneElement & {
    question: string;
    answer?: Quantity | number | string | Reference | boolean | Coding;
    operator: string;
};

export type QuestionnaireItemAnswerOption = BackboneElement & {
    value?: string | Coding | number | Reference;
    initialSelected?: boolean;
};

export type QuestionnaireItemInitial = BackboneElement & {
    value?: Reference | string | number | Quantity | boolean | Coding | Attachment;
};

export type QuestionnaireItem = BackboneElement & {
    enableBehavior?: string;
    definition?: string;
    linkId: string;
    repeats?: boolean;
    item?: Reference[];
    type: string;
    enableWhen?: QuestionnaireItemEnableWhen[];
    answerOption?: QuestionnaireItemAnswerOption[];
    prefix?: string;
    readOnly?: boolean;
    answerValueSet?: string;
    code?: Coding[];
    initial?: QuestionnaireItemInitial[];
    maxLength?: number;
    required?: boolean;
    text?: string;
};

export type Questionnaire = DomainResource & {
    description?: string;
    subjectType?: string[];
    date?: string;
    publisher?: string;
    approvalDate?: string;
    jurisdiction?: CodeableConcept[];
    derivedFrom?: string[];
    purpose?: string;
    name?: string;
    item?: QuestionnaireItem[];
    useContext?: UsageContext[];
    copyright?: string;
    experimental?: boolean;
    title?: string;
    status: string;
    url?: string;
    code?: Coding[];
    identifier?: Identifier[];
    lastReviewDate?: string;
    version?: string;
    contact?: ContactDetail[];
    effectivePeriod?: Period;
};