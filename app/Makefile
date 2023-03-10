run-dist:
	@./build/install/app/bin/app ./src/test/resources/testFile1.json  ./src/test/resources/testFile2.json

lint:
	@./gradlew checkstyleMain checkstyleTest
	
test:
	@./gradlew test

build:
	@./gradlew clean build

.PHONY: build
