![](https://github.com/aidbox/aidbox-sdk/actions/workflows/build.yaml/badge.svg)

# Aidbox SDK Generator

A CLI tool to generate Aidbox SDKs for various programming languages from FHIR schema definitions.


## Getting Started

### Prerequisites

- Ensure you have a working instance of Aibox to retrieve the FHIR Schemas.

- Ensure that Aidbox security policies allow access to `/api/sdk/fhir-packages` endpoint. For a simple setup, you can add a client and configure basic authentication as described [here](https://docs.aidbox.app/modules-1/security-and-access-control/auth/basic-auth#register-client)
- Use your Aidbox client's username and password to generate a token for the aidbox SDK generator using the following formula:
  `base64(user:password)`

### Installation

Download latest version from [the release page](https://github.com/Aidbox/aidbox-sdk/releases). 

### Usage

You have two options for generating an SDK: using the precompiled binary files or the Java version with the JAR file.

To generate an SDK with the binary files version, use the following command:

```bash
aidbox-sdk generate <target-language> <input-source> --auth-token <aidbox-client-token>
```

Example:

```bash
aidbox-sdk generate dotnet http://localhost:8765/api/sdk/fhir-packages \
--auth-token YmFzaWM6c2VjcmV0 \
--output-dir aidbox-sdk-dotnet
```



### Options

- `--help`: Display help information
- `--output-dir <directory>` : Directory to ouput the generated SDK.
- `--auth-token <token>` : Provide and authentication token





