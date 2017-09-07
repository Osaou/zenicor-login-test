#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
echo $DIR
docker run -d --rm --name mysql -v $DIR/create-db:/docker-entrypoint-initdb.d -e MYSQL_ROOT_PASSWORD=s3cret mysql:5.7
