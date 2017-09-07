#!/bin/bash

# build jar file
./gradlew build

# build and run docker image
docker build -t zenicor-backend .
docker run -d --rm -p 7070:7070 --name api --link mysql:mysql zenicor-backend
