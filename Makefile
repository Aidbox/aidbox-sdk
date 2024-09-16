build-jar:
	clj -T:build uberjar

.PHONY: test
test:
	clj -M:test -m kaocha.runner --skip-meta :snapshot

test-snapshots:
	clj -M:test -m kaocha.runner --focus-meta :snapshot

PATH_TO_JAR := $(project_dir)/$(jar_path)

AGENT_OPTS := caller-filter-file=$(project_dir)/trace-filter.json,config-output-dir=$(project_dir)/META
generate-reflect-config:
	java -agentlib:native-image-agent=$(AGENT_OPTS) -jar $(PATH_TO_JAR) generate dotnet $(project_dir)/resources/schemas --output-dir $(project_dir)/out


COMPILE_OPTS := \
  --no-fallback \
  --features=clj_easy.graal_build_time.InitClojureClasses \
	--enable-url-protocols=http,https \
  -H:ReflectionConfigurationFiles=$(project_dir)/META/reflect-config.json \
  -H:Name=aidbox-sdk
compile-native-image: generate-reflect-config
	native-image -jar $(PATH_TO_JAR) $(COMPILE_OPTS) $(image_name)

repl:
	clj -Mtest:nrepl
