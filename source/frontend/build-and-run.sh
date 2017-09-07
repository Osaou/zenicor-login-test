#!/bin/bash

# build jar file
./gradlew build

# build and run docker image
docker build -t zenicor-frontend .
docker run -d --rm -p 8080:8080 --name web --link api:api zenicor-frontend
