build-jar:
	clj -T:build uberjar

run-tests:
	clj -M:test -m kaocha.runner

PATH_TO_JAR := $(project_dir)/$(jar_path)

AGENT_OPTS := caller-filter-file=$(project_dir)/trace-filter.json,config-output-dir=$(project_dir)/META
generate_reflect_config:
	java -agentlib:native-image-agent=$(AGENT_OPTS) -jar $(PATH_TO_JAR) $(project_dir)/resources/schemas $(project_dir)/out


COMPILE_OPTS := \
  --no-fallback \
  --features=clj_easy.graal_build_time.InitClojureClasses \
  -H:ReflectionConfigurationFiles=$(project_dir)/META/reflect-config.json \
  -H:Name=aidbox-sdk
compile_native_image: generate_reflect_config
	native-image -jar $(PATH_TO_JAR) $(COMPILE_OPTS) $(image_name)
