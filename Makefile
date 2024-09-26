build-jar: ## Build uberjar
	clj -T:build uberjar

.PHONY: test
test: ## Run tests
	clj -M:test -m kaocha.runner --skip-meta :snapshot

test-snapshots: ## Run snapshot tests
	clj -M:test -m kaocha.runner --focus-meta :snapshot

run-mock-server: ## Run mock server
	clj -M -m mock-server.main &

stop-mock-server: ## Stop mock server
	kill -9 `pgrep -f "clojure.main -m mock-server.main"`

PATH_TO_JAR := $(project_dir)/$(jar_path)

AGENT_OPTS := caller-filter-file=$(project_dir)/trace-filter.json,config-output-dir=$(project_dir)/META
generate-reflect-config:
	java -agentlib:native-image-agent=$(AGENT_OPTS) -jar $(PATH_TO_JAR) generate dotnet $(project_dir)/resources/schemas/r5 --output-dir $(project_dir)/out


COMPILE_OPTS := \
  --no-fallback \
  --features=clj_easy.graal_build_time.InitClojureClasses \
	--enable-url-protocols=http,https \
  -H:ReflectionConfigurationFiles=$(project_dir)/META/reflect-config.json \
  -H:Name=aidbox-sdk
compile-native-image: generate-reflect-config ## Compile jar to native binary
	native-image -jar $(PATH_TO_JAR) $(COMPILE_OPTS) $(image_name)

repl: ## Start nREPL
	clj -Mtest:nrepl

.PHONY: help
help: ## Show help
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

.DEFAULT_GOAL := help
