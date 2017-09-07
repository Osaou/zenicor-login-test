# Zenicor work test, September 2017

## Requirements to build
- Java SDK 1.8+
- Gradle
- Docker

## How to build and run
Run `build-and-run.sh` in *db*, *backend* and *frontend* folders, one at a time, waiting approx. 10sec between each.
After that, open `http://localhost:8080/login` in a browser.

## Tear it all down
Run `docker stop web && docker stop api && docker stop mysql`.
