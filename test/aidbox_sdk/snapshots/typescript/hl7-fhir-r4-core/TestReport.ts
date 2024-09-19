import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type TestReportParticipant = BackboneElement & {
    uri: string;
    type: string;
    display?: string;
};

export type TestReportSetupActionAssert = BackboneElement & {
    detail?: string;
    result: string;
    message?: string;
};

export type TestReportSetupActionOperation = BackboneElement & {
    detail?: string;
    result: string;
    message?: string;
};

export type TestReportSetupAction = BackboneElement & {
    assert_?: TestReportSetupActionAssert;
    operation?: TestReportSetupActionOperation;
};

export type TestReportSetup = BackboneElement & {
    action: TestReportSetupAction[];
};

export type TestReportTeardownAction = BackboneElement & {
    operation: Reference;
};

export type TestReportTeardown = BackboneElement & {
    action: TestReportTeardownAction[];
};

export type TestReportTestAction = BackboneElement & {
    assert_?: Reference;
    operation?: Reference;
};

export type TestReportTest = BackboneElement & {
    name?: string;
    action: TestReportTestAction[];
    description?: string;
};

export type TestReport = DomainResource & {
    tester?: string;
    name?: string;
    testScript: Reference;
    participant?: TestReportParticipant[];
    setup?: TestReportSetup;
    status: string;
    result: string;
    score?: number;
    identifier?: Identifier;
    issued?: string;
    teardown?: TestReportTeardown;
    test?: TestReportTest[];
};