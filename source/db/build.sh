#!/bin/bash

#docker rm $(docker ps --filter "status=exited" | grep "mysql" | awk '{print $1}')

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
echo $DIR
docker run --name mysql -v $DIR/create-db:/docker-entrypoint-initdb.d -e MYSQL_ROOT_PASSWORD=s3cret mysql:5.7
#docker run --name mysql -e MYSQL_ROOT_PASSWORD=s3cret -d mysql:5.7
