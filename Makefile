build-jar:
	clj -T:build uberjar

build-bin: build-jar
	native-image -jar target/aidbox-sdk.jar --no-fallback --no-server target/aidbox-sdk
