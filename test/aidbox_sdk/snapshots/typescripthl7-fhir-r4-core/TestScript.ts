import { UsageContext } from "./UsageContext";
import { ContactDetail } from "./ContactDetail";
import { CodeableConcept } from "./CodeableConcept";
import { Coding } from "./Coding";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type TestScriptVariable = BackboneElement & {
    hint?: string;
    name: string;
    path?: string;
    sourceId?: string;
    expression?: string;
    description?: string;
    headerField?: string;
    defaultValue?: string;
};

export type TestScriptSetupActionAssert = BackboneElement & {
    response?: string;
    description?: string;
    path?: string;
    headerField?: string;
    compareToSourceId?: string;
    expression?: string;
    value?: string;
    warningOnly: boolean;
    compareToSourceExpression?: string;
    label?: string;
    resource?: string;
    responseCode?: string;
    minimumId?: string;
    operator?: string;
    contentType?: string;
    compareToSourcePath?: string;
    validateProfileId?: string;
    sourceId?: string;
    requestMethod?: string;
    requestURL?: string;
    direction?: string;
    navigationLinks?: boolean;
};

export type TestScriptSetupActionOperationRequestHeader = BackboneElement & {
    field: string;
    value: string;
};

export type TestScriptSetupActionOperation = BackboneElement & {
    description?: string;
    method?: string;
    targetId?: string;
    requestHeader?: TestScriptSetupActionOperationRequestHeader[];
    params?: string;
    type?: Coding;
    requestId?: string;
    encodeRequestUrl: boolean;
    label?: string;
    resource?: string;
    url?: string;
    origin?: number;
    contentType?: string;
    sourceId?: string;
    responseId?: string;
    destination?: number;
    accept?: string;
};

export type TestScriptSetupAction = BackboneElement & {
    assert_?: TestScriptSetupActionAssert;
    operation?: TestScriptSetupActionOperation;
};

export type TestScriptSetup = BackboneElement & {
    action: TestScriptSetupAction[];
};

export type TestScriptOrigin = BackboneElement & {
    index: number;
    profile: Coding;
};

export type TestScriptFixture = BackboneElement & {
    resource?: Reference;
    autocreate: boolean;
    autodelete: boolean;
};

export type TestScriptTeardownAction = BackboneElement & {
    operation: Reference;
};

export type TestScriptTeardown = BackboneElement & {
    action: TestScriptTeardownAction[];
};

export type TestScriptMetadataLink = BackboneElement & {
    url: string;
    description?: string;
};

export type TestScriptMetadataCapability = BackboneElement & {
    link?: string[];
    origin?: number[];
    required: boolean;
    validated: boolean;
    description?: string;
    destination?: number;
    capabilities: string;
};

export type TestScriptMetadata = BackboneElement & {
    link?: TestScriptMetadataLink[];
    capability: TestScriptMetadataCapability[];
};

export type TestScriptDestination = BackboneElement & {
    index: number;
    profile: Coding;
};

export type TestScriptTestAction = BackboneElement & {
    assert_?: Reference;
    operation?: Reference;
};

export type TestScriptTest = BackboneElement & {
    name?: string;
    action: TestScriptTestAction[];
    description?: string;
};

export type TestScript = DomainResource & {
    description?: string;
    date?: string;
    variable?: TestScriptVariable[];
    publisher?: string;
    jurisdiction?: CodeableConcept[];
    purpose?: string;
    name: string;
    useContext?: UsageContext[];
    copyright?: string;
    experimental?: boolean;
    title?: string;
    setup?: TestScriptSetup;
    status: string;
    url: string;
    identifier?: Identifier;
    origin?: TestScriptOrigin[];
    fixture?: TestScriptFixture[];
    version?: string;
    teardown?: TestScriptTeardown;
    contact?: ContactDetail[];
    metadata?: TestScriptMetadata;
    destination?: TestScriptDestination[];
    test?: TestScriptTest[];
    profile?: Reference[];
};